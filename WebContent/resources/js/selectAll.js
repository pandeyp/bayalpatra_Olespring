var allSelectToogle = function(){
    var universalSelector=document.getElementById("selectAll");
    var form=document.forms[0];
    if(universalSelector.checked){
        for(var ele=0;ele<form.elements.length;ele++){
            var element=form.elements[ele];
            if(element.type=="checkbox"){
                element.checked=true;
            }
        }
    }else{
        for(var ele=0;ele<form.elements.length;ele++){
            var element=form.elements[ele];
            if(element.type=="checkbox"){
                element.checked=false;
            }
        }
    }
// alert("Universal: "+universalSelector.className);
//    var allInputs=document.getElementsByTagName("input");
//    if(universalSelector.checked){
//        for(var i in allInputs){
//          //  if (/checkMark/.test(i.className)){
//         //          i.checked="checked";
//                alert(i.className);
//            //}
//        }
//    }else{
//        for(var i in allInputs){
//            if (i.className=="checkMark"){
//               //    i.checked="";
//
//            }
//        }
//    }
}