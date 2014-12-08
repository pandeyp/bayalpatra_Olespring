/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var UserController = function(){
    var nextid=1;

    this.helloworld=function(){
        alert("inside the function");
    }

    this.addNextElement=function(divid){        
        var nextid= document.getElementById("hiddenvalue").value;
        nextid++;
        document.getElementById("hiddenvalue").value=nextid;
        var newTextField = document.createElement('input');
        newTextField.setAttribute('type','text');
        newTextField.setAttribute('name',"serviceattribute");        
        newTextField.setAttribute('id',nextid);
        var li = document.createElement("li");
        var label = document.createElement("label");
        var remove = document.createElement('input');
        remove.setAttribute('type','button');
        remove.setAttribute('name',"removeattribute");
        remove.setAttribute('id',nextid);
        remove.setAttribute('onClick',"user.removeAttributeElement(this);");
        remove.setAttribute('value',"Remove");
        li.appendChild(label)
        li.appendChild(newTextField);
        li.appendChild(remove);
        document.getElementById(divid).appendChild(li);


    }

    this.removeAttributeElement=function(button){
        var element = document.getElementById(button.id);
        element.parentNode.removeChild(element);
        element = document.getElementById(button.id);
        element.parentNode.removeChild(element);
    }

    this.toggleChangePin= function(element){
        var toggle = document.getElementById('togglepin').value;
        if( toggle == '1'){
            document.getElementById('togglepin').value = 0;
            document.getElementById('toggleChangePin').style.display='none';
            document.getElementById('pinsubmit').style.display='none';
            element.childNodes[0].nodeValue = "Change";
        }else if(toggle == '0'){
            document.getElementById('togglepin').value = 1;
            document.getElementById('toggleChangePin').style.display='block';
            document.getElementById('pinsubmit').style.display='block';
            element.childNodes[0].nodeValue = "Hide";
        }
    }

    this.toggleChangeEmail= function(element){
        var toggle = document.getElementById('toggleemail').value;

        if( toggle == '1'){
            document.getElementById('toggleemail').value = '0';
            document.getElementById('toggleChangeEmail').style.display='none';
            document.getElementById('emailsubmit').style.display='none';
            element.childNodes[0].nodeValue = "Change";

        }else if(toggle == '0'){
            document.getElementById('toggleemail').value = '1';
            document.getElementById('toggleChangeEmail').style.display='block';
            document.getElementById('emailsubmit').style.display='block';
            element.childNodes[0].nodeValue = "Hide";

        }
    }

    this.toggleChangeAddress= function(element){
        var toggle = document.getElementById('toggleaddress').value;

        if( toggle == '1'){
            document.getElementById('toggleaddress').value = '0';
            document.getElementById('toggleChangeAddress').style.display='none';
            document.getElementById('addresssubmit').style.display='none';
            element.childNodes[0].nodeValue = "Change";
        }else if(toggle == '0'){
            document.getElementById('toggleaddress').value = '1';
            document.getElementById('toggleChangeAddress').style.display='block';
            document.getElementById('addresssubmit').style.display='block';
            element.childNodes[0].nodeValue = "Hide";
        }
    }

    this.ChangeProfileAddress= function(url,divid,changetype){
        var address = document.getElementById('address').value;

        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'address='+address+'&changetype='+changetype,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });

    }

    this.ChangeProfileEmail= function(url,divid,changetype){
        var email = document.getElementById('email').value;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'email='+email+'&changetype='+changetype,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });

    }

    this.ChangeProfilePin= function(url,divid,changetype){
        var oldPin = document.getElementById('oldPin').value;
        var newPin = document.getElementById('newPin').value;
        var confirmPin = document.getElementById('confirmPin').value;

        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'oldPin='+escape(oldPin)+'&newPin='+escape(newPin)+'&confirmPin='+escape(confirmPin)+'&changetype='+escape(changetype),
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }

    //        this.transactionInformation= function(url,divid,smsInId,smsIn,type,timestamp,sender,receiver,amount,senderCharge,receiverCharge,status,transactionId,username,from,to){
    //
    //            new Ajax.Updater(divid,url,
    //        {
    //            method:'post',
    //            parameters: 'smsInId='+smsInId+'&timestamp='+timestamp+'&sender='+sender+
    //                '&receiver='+receiver+'&amount='+amount+'&senderCharge='+senderCharge+
    //                '&receiverCharge='+receiverCharge+'&status='+status+'&from='+from+'&to='+to+'&username='+username+'&transactionId='+transactionId+'&smsIn='+smsIn+'&type='+type,
    //            onSuccess: function(request){
    //                var response = request.responseText || "no response text";
    //                var content = ParseForError(response);
    //                if(content == null){
    //                    document.getElementById(divid).innerHTML = response;
    //                }else{
    //                   document.getElementById("mainwrapper").innerHTML = response;
    //                }
    //            },
    //            onFailure: function(response){
    //                alert(response.responseText);
    //                alert('Something wrong...')
    //
    //            }
    //         });
    //        }


    this.toggleaddbankadmin= function(){
        if(document.getElementById('type').value=="Bank"){
            document.getElementById('toggleaddbankadmin').style.display='block';
        }else{
            document.getElementById('toggleaddbankadmin').style.display='none';
        }
    }

    this.getFields = function(){
        if(document.getElementById('type').value=="ROLE_BANK"){
            document.getElementById('disableBranch').style.display='none';
            document.getElementById('branchId').disabled = true;
        }else{
            document.getElementById('disableBranch').style.display='block';
            document.getElementById('branchId').disabled = false;
        }

        if(document.getElementById('type').value=="ROLE_BANKTELLER"){
            document.getElementById('banktellerfields').style.display='block';
        }else{
            document.getElementById('banktellerfields').style.display='none';
        }
    }

    this.getServices= function(pageurl,divid){
        var userServiceId = document.getElementById('userServiceId').value;
        url= pageurl;
        if(userServiceId !=0){
            new Ajax.Updater(divid,url,
            {
                method:'post',
                parameters: 'userServiceId='+userServiceId,
                onSuccess: function(request){
                    var response = request.responseText || "no response text";
                    var content = ParseForError(response);
                    if(content == null){
                        document.getElementById(divid).innerHTML = response;
                    }else{
                        document.getElementById("mainwrapper").innerHTML = response;
                    }
                },
                onFailure: function(response){
                    alert(response.responseText);
                    alert('Something wrong...')

                }
            });
        }
    }

    this.getUtilityServices= function(pageurl,divid){
        var searchtype = document.getElementById('searchtype').value;
        var field = document.getElementById('field').value;
        var aftersearch = '1';
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'searchtype='+searchtype+'&field='+field+'&aftersearch='+aftersearch,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }

    this.editUserBankAccount= function(pageurl,divid,accountNo,id,username,branch,primaryAccount){
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'username='+username+'&accountNo='+accountNo+'&branch='+branch+'&id='+id+'&primaryAccount='+primaryAccount,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }

    this.getSmsInForDate = function(pageurl,divid){
        var date = document.getElementById('date').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'date='+date,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }

    this.deleteUserBankAccount= function(pageurl,divid,id){
        var username = document.getElementById('username').value;
        url= pageurl;
        if(window.confirm("Are you sure you want to delete?")){
            new Ajax.Updater(divid,url,
            {
                method:'post',
                parameters: 'id='+id+'&username='+username,
                onSuccess: function(request){
                    var response = request.responseText || "no response text";
                    var content = ParseForError(response);
                    if(content == null){
                        document.getElementById(divid).innerHTML = response;
                    }else{
                        document.getElementById("mainwrapper").innerHTML = response;
                    }
                },
                onFailure: function(response){
                    alert(response.responseText);
                    alert('Something wrong...')

                }
            });
        }else{
    }
    }

    this.editUserBankAccountSubmit= function(element,pageurl,divid){
        element.disabled = true;
        var username = document.getElementById('username').value;
        var oldaccount = document.getElementById('oldaccount').value;
        var account_number = document.getElementById('account_number').value;
        var branch_id = document.getElementById('branchId').value;
        var id = document.getElementById('id').value;
        var primary;
        if(document.getElementById('primary').checked==true || document.getElementById('primary').value=='itIsPrimary'){
            primary = 1;
        }else{
            primary=0;
        }
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'username='+username+'&accountnumber='+account_number+'&id='+id+'&branch='+branch_id+'&primary='+primary+'&oldaccount='+oldaccount,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
                element.disabled = false;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            },

            onLoading: function(response) {
                element.disabled = true;
                document.getElementById('loadingstatus').style.visibility = "visible";
            }
        });


    }

    this.getServicesForUser= function(pageurl,divid){
        var username = document.getElementById('username').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'username='+username,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }

    this.changeStatus= function(pageurl,divid,id, username){
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&username='+username,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }

    this.pagination=function(pageurl,divid,id){
        var branchId=  document.getElementById('select_branches').value;
        var ageGroup = document.getElementById('select_agegroup').value;
        var zoneValue = document.getElementById('select_zone').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        var gender = document.getElementById('select_gender').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&branchId=' + branchId + '&gender=' + gender +'&ageGroup=' + ageGroup + '&zoneValue=' + zoneValue + '&fromDateValue=' + fromDateValue + '&toDateValue=' + toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }




    this.merchantPagination=function(pageurl,divid,id){
        var organizationId = document.getElementById('select_organizations').value;
        var gender = document.getElementById('select_gender').value;
        var branchId=  document.getElementById('select_branches').value;
        var ageGroup = document.getElementById('select_agegroup').value;
        var zoneValue = document.getElementById('select_zone').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&organizationId='+organizationId+'&branchId=' + branchId + '&gender=' + gender +'&ageGroup=' + ageGroup + '&zoneValue=' + zoneValue + '&fromDateValue=' + fromDateValue + '&toDateValue=' + toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }



    this.agentPagination=function(pageurl,divid,id){

        var organizationId = document.getElementById('select_organizations').value;
        var gender = document.getElementById('select_gender').value;
        var branchId=  document.getElementById('select_branches').value;
        var ageGroup = document.getElementById('select_agegroup').value;
        var zoneValue = document.getElementById('select_zone').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        url= pageurl;

        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&organizationId='+organizationId+'&branchId=' + branchId + '&gender=' + gender + '&ageGroup=' + ageGroup + '&zoneValue=' + zoneValue + '&fromDateValue=' + fromDateValue + '&toDateValue=' + toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }

            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }



    this.filterCustomers=function(pageurl,divid){
        var branchId=  document.getElementById('select_branches').value;
        var gender = document.getElementById('select_gender').value;
        var ageGroup = document.getElementById('select_agegroup').value;
        var zoneValue = document.getElementById('select_zone').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        url= pageurl;

        alert(gender);

        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'branchId='+branchId+'&ageGroup='+ageGroup+'&gender=' + gender +'&zoneValue='+zoneValue+'&fromDateValue='+fromDateValue+'&toDateValue='+toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responsseText);
                alert('Something wrong...')
            }
        });
    }


    this.filterMerchants=function(pageurl,divid){
        var organizationId=  document.getElementById('select_organizations').value;
        var branchId=  document.getElementById('select_branches').value;
        var ageGroup = document.getElementById('select_agegroup').value;
        var gender = document.getElementById('select_gender').value;
        var zoneValue = document.getElementById('select_zone').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        url= pageurl;

        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'branchId='+branchId+'&organizationId='+organizationId+'&ageGroup='+ageGroup+'&gender=' + gender +'&zoneValue='+zoneValue+'&fromDateValue='+fromDateValue+'&toDateValue='+toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    /**
     * function for the addition of the bank account
     */
    this.requestbankaccountadd=function(pageUrl,divid){
        var addbankaccount_username = document.getElementById('addbankaccount_username').value;
        var addbankaccount_accountno = document.getElementById('addbankaccount_accountnumber').value;
        var select_adminbranches = document.getElementById('select_adminbranches').value;
        var primary;
        if(document.getElementById('primary').checked==true){
            primary = document.getElementById('primary').value;
        }else{
            primary=0;
        }
        document.getElementById('accountmademessage').innerHTML = "";
        document.getElementById('loadingStatus').style.visibility = "visible";
        new Ajax.Updater(divid,pageUrl,
        {
            method:'post',
            parameters: 'username='+addbankaccount_username+'&accountno='+addbankaccount_accountno+'&select_adminbranches='+select_adminbranches+'&primary='+primary,
            onSuccess: function(request){
                document.getElementById("loadingStatus").style.visibility = "hidden";
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    //logic of the display goes here
                    var arrayOfValues = response.split("::");
                    //                                        var stringValues = null;
                    //                                        for(i=0; i<arrayOfValues.length; i++){
                    //                                            stringValues += arrayOfValues[i];
                    //                                        }
                    //                                        alert(stringValues);
                    var htmlContent = "";
                    htmlContent += arrayOfValues[1]; //if messages
                    if(customTrim(arrayOfValues[3]) == "1" && customTrim(arrayOfValues[4]) == "1"){
                        if(customTrim(arrayOfValues[13]) == "1"){
                            if(customTrim(arrayOfValues[2]) == "1"){
                                if(confirm("This account is already in use by "+customTrim(arrayOfValues[14])+". Are you sure you want to share it?")){
                                    new Ajax.Request('.././users/performaddbankaccount.html',{
                                        method:'post',
                                        parameters: 'username='+addbankaccount_username+'&accountno='+addbankaccount_accountno+'&select_adminbranches='+select_adminbranches+'&primary='+primary,
                                        onSuccess: function(request){
                                            var response = request.responseText || "no response text";
                                            var content = ParseForError(response);
                                            document.getElementById('accountmademessage').innerHTML = response;
                                        },
                                        onFailure: function(response){
                                            alert(response.responseText);
                                            alert('Something wrong...');
                                        }
                                    });
                                }
                            }
                            else
                            if(confirm("You are going to create a bank account for the user " +customTrim(arrayOfValues[11])+". Are you sure?")){
                                new Ajax.Request('.././users/performaddbankaccount.html',{
                                    method:'post',
                                    parameters: 'username='+addbankaccount_username+'&accountno='+addbankaccount_accountno+'&select_adminbranches='+select_adminbranches+'&primary='+primary,
                                    onSuccess: function(request){
                                        var response = request.responseText || "no response text";
                                        var content = ParseForError(response);
                                        document.getElementById('accountmademessage').innerHTML = response;
                                    },
                                    onFailure: function(response){
                                        alert(response.responseText);
                                        alert('Something wrong...');
                                    }
                                });
                            }
                        }
                        else{
                            htmlContent += '<font class="valid">User is not Enabled yet.</font>';
                        }
                    }
                    else{
                        if(customTrim(arrayOfValues[3]) == "0")
                            htmlContent += '<font class="valid">No User Found With the User Name: ' + customTrim(arrayOfValues[10])+ '</font>';
                        if(customTrim(arrayOfValues[4]) == "0")
                            htmlContent += '<font class="valid">Account number already exists.</font>';

                    }
                    document.getElementById('accountmademessage').innerHTML = htmlContent;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }

            },
            onFailure: function(response){
                alert(response.responseText);
                alert('html load failed......')

            }
        });
    }



    this.filterAgents=function(pageurl,divid){
        var organizationId=  document.getElementById('select_organizations').value;
        var branchId=  document.getElementById('select_branches').value;
        var ageGroup = document.getElementById('select_agegroup').value;
        var gender = document.getElementById('select_gender').value;
        var zoneValue = document.getElementById('select_zone').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        url= pageurl;

        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'branchId='+branchId+'&organizationId='+organizationId+'&ageGroup='+ageGroup+'&gender=' + gender +'&zoneValue='+zoneValue+'&fromDateValue='+fromDateValue+'&toDateValue='+toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.getSearch= function(pageurl,divid){
        var field = document.getElementById('field').value;
        var choice = document.getElementById('choice').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'field='+field+'&choice='+choice,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.mySearch= function(pageurl,divid){
        alert("Inside my Search");
        var field = document.getElementById('field').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'field='+field,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.getSearchForUser= function(pageurl,divid){
        var field = document.getElementById('field').value;
        var value = document.getElementById('value').value;
        var role = document.getElementById('role').value;
        var statusflag = document.getElementById('statusflag').value;
        if(document.getElementById('statusflag').checked==true){
            statusflag = document.getElementById('statusflag').value;
        }else{
            statusflag=1;
        }
        url= pageurl;
       
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'field='+field+'&value='+value+'&role='+role+'&statusflag='+statusflag,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }



    this.toggleAcc= function(){
        if(document.getElementById('choice').checked==true){
            document.getElementById('toggleAcc').style.display='block';
        }else{
            document.getElementById('toggleAcc').style.display='none';
        }
    }

    this.reverse= function(pageurl,divid,id,status,approvalFlag,requestQueueId){
        var username = document.getElementById('username').value;
        var from = document.getElementById('from').value;
        var to = document.getElementById('to').value;
        var amount = document.getElementById('enteredamount').value;
        var type = document.getElementById('type').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'username='+username+'&id='+id+'&from='+from+'&to='+to+'&status='+status+'&amount='+amount+'&type='+type+'&approvalFlag='+approvalFlag+'&requestQueueId='+requestQueueId,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }

    this.regeneratePwApproval= function(pageurl,username){
        url= pageurl;
        var confirm="Are you sure you want to generate a new PIN for the user "+username+"?";
        if(window.confirm(confirm)){
        new Ajax.Updater(username,url,
        {
            method:'post',
            parameters: 'username='+username,

            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById("rpMessage").innerHTML = response;
                }else{
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
        }else{}
    }

    this.regeneratePW=function(pageurl,username){
        url= pageurl;
        var confirm="Are you sure you want to generate a new PIN for the user "+username+"?";
        if(window.confirm(confirm)){
            new Ajax.Updater(username,url,
            {
                method:'post',
                parameters: 'username='+username,

                onSuccess: function(request){
                    var response = request.responseText || "no response text";
                    var content = ParseForError(response);
                    if(content == null){
                        document.getElementById("rpMessage").innerHTML = response;
                    }else{
                        document.getElementById("mainwrapper").innerHTML = response;
                    }
                },
                onFailure: function(response){
                    alert(response.responseText);
                    alert('Something wrong...')

                }
            });
        }
        else{
    }
    }

    this.paging=function(pageurl,divid,id){
        var username=  document.getElementById('username').value;
        var startDate = document.getElementById('startDate').value;
        var endDate = document.getElementById('endDate').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&username='+username+'&startDate='+startDate+'&endDate='+endDate,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.pagingSmsReport=function(pageurl,divid,id){
        var username=  document.getElementById('username').value;
        var startDate = document.getElementById('startDate').value;
        var endDate = document.getElementById('endDate').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&mobileNo='+username+'&startDate='+startDate+'&endDate='+endDate+'&search=search',
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.pagingUserSearch=function(pageurl,divid,id){
        var field = document.getElementById('field').value;
        var value = document.getElementById('value').value;
        var role = document.getElementById('role').value;
        var statusflag = document.getElementById('statusflag').value;
        if(document.getElementById('statusflag').checked==true){
            statusflag = document.getElementById('statusflag').value;
        }else{
            statusflag=1;
        }
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&field='+field+'&value='+value+'&role='+role+'&statusflag='+statusflag,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }
    
    this.pagingTxnReport=function(pageurl,divid,id){
        var username = document.getElementById('username').value;
        var fromDate = document.getElementById('from').value;
        var toDate = document.getElementById('to').value;
        var amount = document.getElementById('amount').value;
        var type = document.getElementById('type').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&username='+username+'&fromDate='+fromDate+'&toDate='+toDate+'&amount='+amount+'&type='+type,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')

            }
        });
    }

    this.pagingReport=function(pageurl,divid,id){
        var startDate=document.getElementById("startDate").value;
        var endDate= document.getElementById("endDate").value;
        var userName=document.getElementById("userName").value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'pageid='+id+'&startDate='+startDate+'&endDate='+endDate+'&userName='+userName,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.pagingPayableReport=function(pageurl,divid,id){
        var startDate=document.getElementById("startDate").value;
        var endDate= document.getElementById("endDate").value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&startDate='+startDate+'&endDate='+endDate+'&export=GenerateReport',
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.pagingCommissionReport=function(pageurl,divid,id){
        var startDate=document.getElementById("startDate").value;
        var endDate= document.getElementById("endDate").value;
        var type=document.getElementById("type").value;

        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'pageid='+id+'&startDate='+startDate+'&endDate='+endDate+'&type='+type,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.pagingPendingTxnReport=function(pageurl,divid,id){
        url=pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'pageId='+id,
            onSuccess: function(request){
                var response=request.responseText || "no response text";
                document.getElementById(divid).innerHTML=response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    
    this.pagingEnrollmentCommissionReport = function(pageurl, divid, id) {
		
        var agent = document.getElementById("agent").value;
        var startDate = document.getElementById("startDate").value;
        var endDate = document.getElementById("endDate").value;
        var status = document.getElementById("status").value;
		
      
        url = pageurl;
        new Ajax.Updater(divid, url, {
            method : 'post',
            parameters : 'pageid=' + id + '&agent=' + agent + '&startDate='
            + startDate + '&endDate=' + endDate + '&status=' + status,
            onSuccess : function(request) {
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure : function(response) {
                alert(response.responseText);
                alert('Something wrong...');
            }
        });
    }

    this.getEnrollmentCommissionPayment = function(pageurl, divid, Agent) {
						 
		
        var pay="pay";
        var agent = document.getElementById("agent").value;
        var startDate = document.getElementById("startDate").value;
        var endDate = document.getElementById("endDate").value;
//        var status = document.getElementById("status").value;
		
      
        url = pageurl;
        new Ajax.Updater(divid, url, {
			
			
            method : 'post',
            parameters : 'Agent=' + Agent + '&agent='+agent+'&startDate='+ startDate + '&endDate=' + endDate +'&pay='+pay,
            onSuccess : function(request) {
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure : function(response) {
                alert(response.responseText);
                alert('Something wrong...');
            }
        });
    }

    this.getAuthorizationShowDecideRequest = function(pageurl, divid, username,approveId,status) {
       
        url = pageurl;
        
        new Ajax.Updater(divid, url, {
            method : 'post',
            parameters : 'username=' + username + '&approveId='+approveId +'&status='+status,
            onSuccess : function(request) {
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure : function(response) {
                alert(response.responseText);
                alert('Something wrong...');
            }
        });
    }


    this.getUsersViewCustomer = function(pageurl, divid, username) {
        url = pageurl;
        new Ajax.Updater(divid, url, {
            method : 'post',
            parameters : 'username=' + username ,
            onSuccess : function(request) {
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure : function(response) {
                alert(response.responseText);
                alert('Something wrong...');
            }
        });
    }

    this.pagingTellerReport=function(pageurl,divid,id){
        var username=document.getElementById("username").value;
        var startDate=document.getElementById("startDate").value;
        var endDate= document.getElementById("endDate").value;

        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'pageid='+id+'&username='+username+'&startDate='+startDate+'&endDate='+endDate+'&search=search',
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert(response.responseText);
                alert('Something wrong...')
            }
        });
    }

    this.pagingUsedCardsReport = function(pageurl, divid, id) {

        var userName=document.getElementById("userName").value;
        var fromDate=document.getElementById("fromDate").value;
        var toDate= document.getElementById("toDate").value;
        var cardType = document.getElementById("cardType").value;
        var amount = document.getElementById("amount").value;

        url = pageurl;
        new Ajax.Updater(divid, url, {
            method : 'post',
            parameters : 'pageid=' + id + '&userName=' + userName + '&fromDate='
            + fromDate + '&toDate=' + toDate + '&cardType=' + cardType + '&cardPrice=' + amount + '&search=search',
            onSuccess : function(request) {
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure : function(response) {
                alert(response.responseText);
                alert('Something wrong...');
            }
        });
    }
    
    this.redirectToUserSummary=function(pageurl,counter){
        //alert(counter);
        var $j=jQuery.noConflict();
        var username=document.getElementById("merchantCode").value;
        var startDate=document.getElementById("startDate").value;
        var endDate=document.getElementById("endDate").value;
        counter = counter.replace(/^[\s]+/,'').replace(/[\s]+$/,'').replace(/[\s]{2,}/,' ');
        url=pageurl;
        //alert(url);
        $j.ajax({
            type: 'POST',
            url: url,
            data: "username="+username+"&fromDate="+startDate+"&toDate="+endDate+"&counter="+counter+"\r\n",
            success: function(request){
                document.write(request);
                document.close();
                return false;
            //alert(request.responseText);
            //window.location = request;
            }
        });
    }

    this.subMerchantReversal=function(pageurl,username,revSrcId){
        var reverseId=revSrcId;
        var $j=jQuery.noConflict();
        //alert(reverseId);
        //var username=document.getElementById("merchantCode").value;
        var startDate=document.getElementById("from").value;
        var endDate=document.getElementById("to").value;
        var counter=document.getElementById("terminal").value;
        //alert(username);
        url=pageurl;
        $j.ajax({
            type: 'POST',
            url: url,
            data: "username="+username+"&fromDate="+startDate+"&toDate="+endDate+"&revSrcId="+reverseId+"&counter="+counter+"\r\n",
            success: function(request){
                document.write(request);
                document.close();
                return false;
            //alert(request.responseText);
            //window.location = request;
            }
        });
    }
    
    this.revertTransaction=function (pageurl,transactionId){
    	var $j=jQuery.noConflict();
    	$j.ajax({
            type: 'POST',
            url: pageurl,
            data: "reverse=true&transactionId="+transactionId,
            success: function(request){
                document.write(request);
                document.close();
                return false;
            }
        });
    }
    
    this.pagingCustomerReport = function(pageurl, divid, id) {

        var agent=document.getElementById("agent").value;
        var fromDate=document.getElementById("fromDate").value;
        var toDate= document.getElementById("toDate").value;
        var customerStatus = document.getElementById("customerStatus").value;

        url = pageurl;
        new Ajax.Updater(divid, url, {
            method : 'post',
            parameters : 'pageid=' + id + '&agent=' + agent + '&fromDate=' + fromDate + '&toDate=' + toDate + '&customerStatus=' + customerStatus +'&search=search',
            onSuccess : function(request) {
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure : function(response) {
                alert(response.responseText);
                alert('Something wrong...');
            }
        });
    }
    
    // paging document incomplete report
    
    this.pagingDocumentIncomplete = function(pageurl, divid, id) {
        var username = document.getElementById("role").value;
        var startDate = document.getElementById("startDate").value;
        var endDate = document.getElementById("endDate").value;
        var branchOrAgent = document.getElementById("idRole").value;
        var branchOrAgentUserName = document.getElementById("branchOrAgent").value;

        url = pageurl;
        new Ajax.Updater(divid, url, {
            method : 'post',
            parameters : 'id=' + id + '&role=' + username + '&startDate=' + startDate + '&endDate=' + endDate + '&idRole=' + branchOrAgent +'&branchOrAgent='+branchOrAgentUserName+'&search=search',
            onSuccess : function(request) {
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure : function(response) {
                alert(response.responseText);
                alert('Something wrong...');
            }
        });
    }
///////////////////////////////////
    
// paging sub agents
    
    this.pagingSubAgents = function(pageurl, divid, id) {
        var username = document.getElementById("userName").value;

        url = pageurl;
        new Ajax.Updater(divid, url, {
            method : 'post',
            parameters : 'id=' + id + '&userName=' + username + '&search=search',
            onSuccess : function(request) {
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure : function(response) {
                alert(response.responseText);
                alert('Something wrong...');
            }
        });
    }
///////////////////////////////////

}


function ParseForError(response){
    var ErrorPageValue = "We\\sare\\sunable\\sto\\sperform\\syour\\srequest";
    var pagecontent = new RegExp(ErrorPageValue);
    var content = pagecontent.exec(response);
    return content;
}

function makeVisible(elem){
    elem.className="show";
}