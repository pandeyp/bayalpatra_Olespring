/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var DistrictController = function(){


    this.addOption=function(selectbox,text,value )
    {
        var optn = document.createElement("OPTION");
        optn.text = text;
        optn.value = value;
        selectbox.options.add(optn);
    }
    this.changeZone=function(){
        var district = document.getElementById('district');
        district.options.length=null;//clearing the select box
        var zodistrict = new Array();//declaration of the array  
        zodistrict['Bagmati']= new Array("Bhaktapur","Dhading","Kathmandu","Kavrepalanchok","Lalitpur","Nuwakot","Rasuwa","Sindhupalchok");
        zodistrict['Bheri']= new Array("Banke","Bardiya","Dailekh","Jajarkot","Surkhet");
        zodistrict['Dhaulagiri']= new Array("Baglung","Mustang","Myagdi","Parbat");
        zodistrict['Gandaki']= new Array("Gorkha","Kaski","Lamjung","Manang","Syangja","Tanahu");
        zodistrict['Janakpur']= new Array("Dhanusa","Dholkha","Mahottari","Ramechhap","Sarlahi","Sindhuli");
        zodistrict['Karnali']= new Array("Dolpa","Humla","Jumla","Kalikot","Mugu");
        zodistrict['Koshi']= new Array("Bhojpur","Dhankuta","Morang","Sankhuwasabha","Sunsari","Terhathum");        
        zodistrict['Lumbini']= new Array("Arghakhanchi","Gulmi","Kapilvastu","Nawalparasi","Palpa","Rupandehi");
        zodistrict['Mahakali']= new Array("Baitadi","Dadeldhura","Darchula","Kanchanpur");
        zodistrict['Mechi']= new Array("Ilam","Jhapa","Panchthar","Taplejung");
        zodistrict['Narayani']= new Array("Bara","Chitwan","Makwanpur","Parsa","Rautahat");
        zodistrict['Rapti']= new Array("Dang","Pyuthan","Rolpa","Rukum","Salyan");
        zodistrict['Sagarmatha']= new Array("Khotang","Okhaldhunga","Saptari","Siraha","Solukhumbu","Udayapur");
        zodistrict['Seti']= new Array("Achham","Bajhang","Bajura","Doti","Kailali");
        
        var zonename=document.getElementById('zone').value;
        for (var i=0; i < zodistrict[zonename].length;++i){
            this.addOption(district,zodistrict[zonename][i],zodistrict[zonename][i]);
        }

    }



    this.changesZone=function(){
        var district = document.getElementById('district');
        district.options.length=null;//clearing the select box
        var zodistrict = new Array();//declaration of the array
        zodistrict['Bagmati']= new Array("All","Bhaktapur","Dhading","Kathmandu","Kavrepalanchok","Lalitpur","Nuwakot","Rasuwa","Sindhupalchok");
        zodistrict['Bheri']= new Array("All","Banke","Bardiya","Dailekh","Jajarkot","Surkhet");
        zodistrict['Dhaulagiri']= new Array("All","Baglung","Mustang","Myagdi","Parbat");
        zodistrict['Gandaki']= new Array("All","Gorkha","Kaski","Lamjung","Manang","Syangja","Tanahu");
        zodistrict['Janakpur']= new Array("All","Dhanusa","Dholkha","Mahottari","Ramechhap","Sarlahi","Sindhuli");
        zodistrict['Karnali']= new Array("All","Dolpa","Humla","Jumla","Kalikot","Mugu");
        zodistrict['Koshi']= new Array("All","Bhojpur","Dhankuta","Morang","Sankhuwasabha","Sunsari","Terhathum");
        zodistrict['Lumbini']= new Array("All","Arghakhanchi","Gulmi","Kapilvastu","Nawalparasi","Palpa","Rupandehi");
        zodistrict['Mahakali']= new Array("All","Baitadi","Dadeldhura","Darchula","Kanchanpur");
        zodistrict['Mechi']= new Array("All","Ilam","Jhapa","Panchthar","Taplejung");
        zodistrict['Narayani']= new Array("All","Bara","Chitwan","Makwanpur","Parsa","Rautahat");
        zodistrict['Rapti']= new Array("All","Dang","Pyuthan","Rolpa","Rukum","Salyan");
        zodistrict['Sagarmatha']= new Array("All","Khotang","Okhaldhunga","Saptari","Siraha","Solukhumbu","Udayapur");
        zodistrict['Seti']= new Array("All","Achham","Bajhang","Bajura","Doti","Kailali");
        zodistrict[''] = new Array("All");

        var zonename=document.getElementById('zone').value;
        for (var i=0; i < zodistrict[zonename].length;++i){
            this.addOption(district,zodistrict[zonename][i],zodistrict[zonename][i]);
        }

    }
}
