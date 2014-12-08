/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var ReportController = function(){

    this.testfunction=function(){
        alert("hello report");
    }

    this.adminFilterTransaction=function(pageurl,divid,id){
        
        var amountFilterType = document.getElementById('amount_filter').value;
        var amountValue = document.getElementById('amount').value;
        var fromDateValue = document.getElementById('fromdate').value;
        var toDateValue = document.getElementById('todate').value;

        var usertype = document.getElementById('usertype').value;
        var status = document.getElementById('status').value;
        var txntype = document.getElementById('txntype').value;
        var age = document.getElementById('age').value;
        var agevalue = document.getElementById('agevalue').value;
        var gender = document.getElementById('gender').value;
        var nameOfUser = document.getElementById('nameofuser').value;
        //        alert(usertype+amountFilterType+status+txntype+age+agevalue+gender+nameOfUser+toDateValue);

  
        
        url= pageurl
        new Ajax.Updater(divid,url,
        
        {
                method:'post',
                parameters: 'id='+id+'&amountFilterType='+amountFilterType+'&amountValue='+amountValue+'&fromDateValue='+fromDateValue+'&toDateValue='+toDateValue
                +'&usertype='+usertype+'&status='+status+'&txntype='+txntype+'&age='+age+'&agevalue='+agevalue+'&gender='+gender+'&nameOfUser='+nameOfUser,

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

 
}
    

