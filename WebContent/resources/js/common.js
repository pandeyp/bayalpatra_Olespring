/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function showHideBalance(value){
    if(value=="ROLE_SUPERBANKADMIN"){
        document.getElementById('balance').style.display = 'block';
    }else{
        document.getElementById('balance').style.display = 'none';
    }
}

function alternate(id){
    if(document.getElementsByTagName){
        var table = document.getElementById(id);
        var rows = table.getElementsByTagName("tr");
        for(i = 0; i < rows.length; i++){
            //manipulate rows
            if(i % 2 == 0){
                rows[i].className = "even";
            }else{
                rows[i].className = "odd";
            }
        }
    }
}

