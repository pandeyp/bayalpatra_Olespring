/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var SchemeController = function(){

    this.getChargeItems=function(pageurl,divid){
        var role = document.getElementById('role').value;
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'role='+role,
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

    this.getServices=function(pageurl,divid){
        var utility = document.getElementById('utility').value;
        url= pageurl;
        if(utility !="NULL"){
            new Ajax.Updater(divid,url,
            {
                method:'post',
                parameters: 'utility='+utility,
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

    this.AddNextGeneralSchemeUtility=function(pageurl,divid){
        var utility = document.getElementById('utility').value;
        var role = document.getElementById('role').value;
        var service_id = document.getElementById('service_id').value;
        var from_amount = document.getElementById('from_amount').value;
        var to_amount = document.getElementById('to_amount').value;
        var flat_charge = document.getElementById('flat_charge').value;
        var percentage_charge = document.getElementById('percentage_charge').value;
        var charged_party = document.getElementById('charged_party').value;
        var frmall;        
        if(document.getElementById('frmall').checked==true){
            frmall = document.getElementById('frmall').value;
        }else{
            frmall=0;
        }
        var toall;
        if(document.getElementById('toall').checked==true){
            toall = document.getElementById('toall').value;
        }else{
            toall=0;
        }
        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'role='+role+'&service_id='+service_id+'&from_amount='+from_amount+'&flat_charge='+flat_charge+'&percentage_charge='+percentage_charge+'&to_amount='+to_amount+'&frmall='+frmall+'&toall='+toall+'&utility='+utility+'&charged_party='+charged_party,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                    var texts=document.getElementsByTagName('input');
                    for (var i_tem = 0; i_tem < texts.length; i_tem++){
                        if (texts[i_tem].id=='from_amount' || texts[i_tem].id=='to_amount'){
                            texts[i_tem].value='0';
                        }
                        if (texts[i_tem].id=='flat_charge' || texts[i_tem].id=='percentage_charge'){
                            texts[i_tem].value='0.0';
                        }
                    }
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

    this.deleteGSU=function(pageurl,divid,id){
        var role = document.getElementById('role').value;
        var service_id = document.getElementById('service_id').value;        
        url= pageurl;
        if(window.confirm("Are you sure you want to delete?")){
            new Ajax.Updater(divid,url,
            {
                method:'post',
                parameters: 'id='+id+'&role='+role+'&service_id='+service_id,
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


    this.AddGeneralSchemeBasic=function(pageurl,divid){
        var role=  document.getElementById('role').value;        
        var charge_item=  document.getElementById('charge_item_id').value;
        var from_amt=  document.getElementById('from_amt').value;
        var to_amt=  document.getElementById('to_amt').value;
        var flatCharge=  document.getElementById('flatCharge').value;
        var percentageCharge=  document.getElementById('percentageCharge').value;
        var tax=  document.getElementById('tax').value;
        var receiverShare=  document.getElementById('receiverShare').value;
        var frmall;

        if(document.getElementById('frmall').checked==true){
            frmall = document.getElementById('frmall').value;
        }else{
            frmall=0;
        }
        var toall;
        if(document.getElementById('toall').checked==true){
            toall = document.getElementById('toall').value;
        }else{
            toall=0;
        }

        url= pageurl;
        new Ajax.Updater(divid,url,
        {
            method:'post',
            parameters: 'role='+role+'&charge_item='+charge_item+'&from_amt='+from_amt+'&to_amt='+to_amt+'&flatCharge='+flatCharge+'&percentageCharge='+percentageCharge+'&tax='+tax+'&receiverShare='+receiverShare+'&frmall='+frmall+'&toall='+toall,
            onSuccess: function(request){
                var response = request.responseText || "no response text";
                var content = ParseForError(response);
                if(content == null){
                    document.getElementById(divid).innerHTML = response;
                    var texts=document.getElementsByTagName('input');
                    for (var i_tem = 0; i_tem < texts.length; i_tem++){
                        if (texts[i_tem].id=='flatCharge' || texts[i_tem].id=='percentageCharge' || texts[i_tem].id=='tax' || texts[i_tem].id=='receiverShare'){
                            texts[i_tem].value='0.0';
                        }
                        if (texts[i_tem].id=='from_amt' || texts[i_tem].id=='to_amt'){
                            texts[i_tem].value='0';
                        }
                    }
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

    this.deleteGSB=function(pageurl,divid,id){
        var role = document.getElementById('role').value;
        var charge_item_id = document.getElementById('charge_item_id').value;
        url= pageurl;
        if(window.confirm("Are you sure you want to delete?")){
            new Ajax.Updater(divid,url,
            {
                method:'post',
                parameters: 'id='+id+'&role='+role+'&charge_item_id='+charge_item_id,
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

    this.ServiceChange =function(pageurl,divid){
        var service_id = document.getElementById('service_id').value;
        var role = document.getElementById('role').value;
        url= pageurl;
        if(service_id !="NULL"){
            new Ajax.Updater(divid,url,
            {
                method:'post',
                parameters: 'service_id='+service_id+'&role='+role,
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

    this.ChargeChange =function(pageurl,divid){
        var charge_item = document.getElementById('charge_item_id').value;
        var role = document.getElementById('role').value;
        url= pageurl;
        if(charge_item !="NULL"){
            new Ajax.Updater(divid,url,
            {
                method:'post',
                parameters: 'charge_item='+charge_item+'&role='+role,
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


    this.RoleChange =function(){
        document.getElementById('utility').selectedIndex=0;
        document.getElementById('service_id').selectedIndex=0;
    }


    this.deleteUser=function(pageurl,divid,username){
        url= pageurl;
        var schemeId = document.getElementById("schemeId").value;
        if(window.confirm("Are you sure you want to delete?")){
            new Ajax.Updater(divid,url,
            {
                method:'post',
                parameters: 'username='+username+'&schemeId='+schemeId,
                onSuccess: function(request){
                    var response = request.responseText || "no response text";
                    var content = ParseForError(response);
                    if(content == null){
                        document.getElementById("mainwrapper").innerHTML = response;
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
}
