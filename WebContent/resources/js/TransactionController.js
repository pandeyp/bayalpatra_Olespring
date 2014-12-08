/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var TransactionController = function(){
    
		this.banktransaction=function(pageurl,divid,id){
        var bankamountFilterType = document.getElementById('bankamount_filter').value;
        var bankamountValue = document.getElementById('bankamount').value;
        var bankstatusValue = document.getElementById('bankstatus').value;
        var bankfromDateValue = document.getElementById('bankfrom').value;
        var banktoDateValue = document.getElementById('bankto').value;
        var banktransactiontype= document.getElementById('banktype_filter').value;
        url= pageurl
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&bankamountFilterType='+bankamountFilterType+'&bankamountValue='+bankamountValue+'&bankstatusValue='+bankstatusValue+'&bankfromDateValue='+bankfromDateValue+'&banktoDateValue='+banktoDateValue+'&banktransactiontype='+banktransactiontype,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert('Request could NOT be completed. Please try again.');
            }
        });

    }

    this.pagination=function(pageurl,divid,id){
        var branchid=  document.getElementById('select_adminbranches').value;
        var amountFilterType = document.getElementById('amount_filter').value;
        var amountValue = document.getElementById('amount').value;
        var statusValue = document.getElementById('status').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        url= pageurl
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&branchid='+branchid+'&amountFilterType='+amountFilterType+'&amountValue='+amountValue+'&statusValue='+statusValue+'&fromDateValue='+fromDateValue+'&toDateValue='+toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
                alert('Request could NOT be completed. Please try again.');
            }
        });
    }

    this.showtransaction=function (pageurl,divid) {
        url= pageurl
        var from_date=  document.getElementById('from_date').value;
        var to_date=  document.getElementById('to_date').value;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'from_date='+from_date+'&to_date='+to_date,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });

    }

    this.receivecash=function(pageurl,divid){
        var username=  document.getElementById('to_receiveusername').value;
        var amount=  document.getElementById('to_receiveamount').value;
        url= pageurl;
        document.getElementById(divid).innerHTML = "";
        document.getElementById('cashreceivedmessage').innerHTML = "";
        document.getElementById('submitButton').disabled=true;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'username='+username+'&amount='+amount,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    var arrayOfValues = response.split("::");
                    var htmlContent = "";
                    htmlContent += arrayOfValues[1];
                    if(customTrim(arrayOfValues[2]) == "1"){
                        if(customTrim(arrayOfValues[11]) == "1"){
                            if(confirm("Are you sure you want to transfer Rs." + customTrim(arrayOfValues[12]) + " to " + customTrim(arrayOfValues[13]) + ".")==true){
                                new Ajax.Request('.././transaction/performreceivecash.html',
                                {
                                    method:'post',
                                    parameters: 'username='+username+'&amount='+amount,
                                    onSuccess: function(request){
                                        var response = request.responseText || "no response text";
                                        var content = ParseForError(response);
                                        document.getElementById('cashreceivedmessage').innerHTML = response;
                                        document.getElementById('loadingstatus').style.visibility = "hidden";
                                        document.getElementById('submitButton').disabled=false;
                                        document.getElementById('to_receiveusername').value = '';
                                        document.getElementById('to_receiveamount').value ='';
                                        document.getElementById('submitButton').disabled=false;
                                        document.getElementById('to_receiveamount').disabled = false;
                                        document.getElementById('to_receiveusername').disabled = false;
                                    },
                                    onLoading:function(request){
                                        document.getElementById('submitButton').disabled=true;
                                        document.getElementById('loadingstatus').style.visibility = "visible";
                                        document.getElementById('to_receiveamount').disabled = true;
                                        document.getElementById('to_receiveusername').disabled = true;
                                    },
                                    onFailure: function(response){
                                    	document.getElementById('to_receiveamount').disabled = false;
                                    	document.getElementById('to_receiveusername').disabled = false;
                                    	alert('Request could NOT be completed. Please try again.');
                                    }
                                });
                            }else{
                            	document.getElementById('submitButton').disabled=false;
                            	document.getElementById('to_receiveamount').disabled = false;
                            	document.getElementById('to_receiveusername').disabled = false;
                            }
                        }
                        else{
                            alert("User is not enabled yet.");
                            htmlContent += "<div class='valid'>User is not enabled yet.</div>";
                        }
                    }
                    document.getElementById(divid).innerHTML = htmlContent;
                    document.getElementById('submitButton').disabled=false;
                    document.getElementById('to_receiveamount').disabled = false;
                	document.getElementById('to_receiveusername').disabled = false;
                }else{document.getElementById('submitButton').disabled=false;
                document.getElementById('to_receiveamount').disabled = false;
            	document.getElementById('to_receiveusername').disabled = false;
                    document.getElementById("mainwrapper").innerHTML = response;
                }
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }

    this.receivecashconfirm=function(pageurl,divid){
        var username=  document.getElementById('to_receiveusername').value;
        var amount=  document.getElementById('to_receiveamount').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'username='+username+'&amount='+amount,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
                var texts=document.getElementsByTagName('input');
                for (var i_tem = 0; i_tem < texts.length; i_tem++){
                    if (texts[i_tem].id=='to_receiveusername' || texts[i_tem].id=='to_receiveamount'){
                        texts[i_tem].value='';
                    }
                }
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }

    
    this.paycash=function(pageurl,divid){
        var username=  document.getElementById('from_receiveusername').value;
        var amount=  document.getElementById('from_receiveamount').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'username='+username+'&amount='+amount,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }

    this.filterTransaction=function(pageurl,divid){
        var branchid=  document.getElementById('select_adminbranches').value;
        var amountFilterType = document.getElementById('amount_filter').value;
        var amountValue = document.getElementById('amount').value;
        var statusValue = document.getElementById('status').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'branchid='+branchid+'&amountFilterType='+amountFilterType+'&amountValue='+amountValue+'&statusValue='+statusValue+'&fromDateValue='+fromDateValue+'&toDateValue='+toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }

    this.endDay= function(pageurl,divid){
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }

    this.startDay= function(pageurl,divid){
        var daystartvalue = document.getElementById('daystartdate').value;
        var str1 = document.getElementById("daystartdate").value;
        var str2 = document.getElementById("currentdate").value;
        var dt1  = parseInt(str1.substring(8,10),10);
        var mon1 = parseInt(str1.substring(5,7),10);
        var yr1  = parseInt(str1.substring(0,4),10);
        var dt2  = parseInt(str2.substring(8,10),10);
        var mon2 = parseInt(str2.substring(5,7),10);
        var yr2  = parseInt(str2.substring(0,4),10);
        var date1 = new Date(yr1, mon1-1, dt1);
        var date2 = new Date(yr2, mon2-1, dt2);
        
        if(daystartvalue==""){
            alert("Start date Cannot be blank");
            return;
        }
        
        var mytool_array=daystartvalue.split("-");//splitting the date

        
        var myDate=new Date();
        myDate.setFullYear(mytool_array[0],(mytool_array[1]-1),mytool_array[2]);//-1 because janauary is treated as 0
        
        var today = new Date();//today date


        if (myDate<today)
        {
            alert("Start Date cannot be before current date");
            return;
        }
        if(!(date2 < date1)){
            alert("Day start date has to be greater than previous value date.");
            return;
        }
     
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'daystartdate='+daystartvalue,
            onSuccess: function(request){
                var response = request.responseText || "no  response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
        
    }

    this.filterCustomerTransaction=function(pageurl,divid){
        var amountFilterType = document.getElementById('amount_filter').value;
        var amountValue = document.getElementById('amount').value;
        var statusValue = document.getElementById('status').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'amountFilterType='+amountFilterType+'&amountValue='+amountValue+'&statusValue='+statusValue+'&fromDateValue='+fromDateValue+'&toDateValue='+toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }

    this.customerPagination=function(pageurl,divid,id){
        var amountFilterType = document.getElementById('amount_filter').value;
        var amountValue = document.getElementById('amount').value;
        var statusValue = document.getElementById('status').value;
        var fromDateValue = document.getElementById('from').value;
        var toDateValue = document.getElementById('to').value;
        //        alert(branchid);
        url= pageurl
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'id='+id+'&amountFilterType='+amountFilterType+'&amountValue='+amountValue+'&statusValue='+statusValue+'&fromDateValue='+fromDateValue+'&toDateValue='+toDateValue,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divid).innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }

    this.showadmintransaction=function () {
        url= '.././transaction/viewfiltertransaction.html'
        var from_date=  document.getElementById('from_date').value;
        var to_date=  document.getElementById('to_date').value;
        new Ajax.Updater('whole_transactiondiv',url,
        {
            method:'post',
            parameters: 'from_date='+from_date+'&to_date='+to_date,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById('whole_transactiondiv').innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });

    }
    
    this.setEventsForSupervisor = function(divId){
    	url = '.././transaction/editactionsupervisor.html';
    	var idS = document.getElementById('supervisor');
    	var id = idS.options[idS.selectedIndex].value;
    	new Ajax.Updater(divId, url,
    	{
    		method:'get', 
    		parameters: 'id='+id, 
    		onSuccess: function(request){
    			var response = request.responseText || "no response text";
                document.getElementById(divId).innerHTML = response;
    		},
    		onFailure: function(response){
    			alert('Loading Failed !!');
    		}
    	});
    }

    this.viewUser=function(pageUrl,username,divId){

        new Ajax.Updater(divId,pageUrl,
        {
            method:'post',
            parameters: 'username='+username,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divId).innerHTML = response;
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }


    //this method calls change password method in usercontroller
    this.changePw=function(pageUrl,username,divId){

        new Ajax.Updater(divId,pageUrl,
        {
            method:'post',
            parameters: 'username='+username,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                document.getElementById(divId).innerHTML = response;
                var texts=document.getElementsByTagName('input');
                texts[0].value = '';
            },
            onFailure: function(response){
            	alert('Request could NOT be completed. Please try again.');
            }
        });
    }


    this.payCashConfirmation=function(){
        if(confirm("Are you sure you want to perform pay cash ? ")){
            return true;
        }else
        {
            return false;
        }
    }

    this.deletePayCashConfirmation=function(){

        if(confirm("Are you sure you want to perform delete pay cash request ? ")){
            return true;
        }else
        {
            return false;
        }
    }
}

