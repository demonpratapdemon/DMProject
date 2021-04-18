
function sc()
{
  console.log('function calling');
}



var top=1;
function child123(pid)
{

console.log("in the function");

const parent = document.getElementById(pid);
//const lable = document.createElement('lable');

const finput1 = document.createElement('input');

const finput2 = document.createElement('input');

const finput3 = document.createElement('input');



finput1.setAttribute('type','string');
finput1.setAttribute('placeholder','YourTagName');
finput1.setAttribute('name','IIITB');
//finput1.setAttribute('value','Mtech');

finput2.setAttribute('type','string');
finput2.setAttribute('placeholder','rows');
finput2.setAttribute('name','IIITB');

finput3.setAttribute('type','string');
finput3.setAttribute('placeholder','cols');
finput3.setAttribute('name','IIITB');

top++;
const hed = document.createElement('h3')
hed.append("Insert your field name , Attri1 and Attri2 ");

const bre=document.createElement('br');

parent.append(hed);
parent.append(bre);
parent.append(finput1);
parent.append(finput2);
parent.append(finput3);

}
var val;
function fromToXml(form)
{
    var xmldata=['<?xml version="1.0"?>'];
    xmldata.push('<template xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="schema.xsd" name="into">');
    
    var inputs=form.elements;

    console.log(inputs.length);

    for(var i=1;i<inputs.length;i=i+3)
    {
      console.log(i+"<-value of -i");
      if (inputs[i].name){
        console.log(i+"<-value of i");
        var el=document.createElement("SECTION");
        var j = i+1;
        var k = i+2;
        el.setAttribute("name",inputs[i].value);
        el.setAttribute("row",inputs[j].value);
        el.setAttribute("col",inputs[k].value);
        var g = "";
        el.setAttribute("value",g);

        // if(inputs[j].name)
        // el.setAttribute("row",inputs[j].value);
        // else
        // el.setAttribute("row",);
        
        xmldata.push(el.outerHTML);
      
      }

      


    }
    xmldata.push("</template>");
    val = xmldata.join("\n");
    console.log(val);
    return val;
}

function callit2()
{
  console.log("in content.js");
  callit();
}

function saveStaticDataToFile() {
                var blob = new Blob([val],
                    { type: "text/plain;charset=utf-8" });
                saveAs(blob, "template.xml");
                console.log('File_save');

            }

function filesaver()
{
  if(val.length == 0)
  {
    console.log('No Content');
  }

  else
  {
    saveStaticDataToFile(val);
    console.log(filesave);
  }

}

function getXml()
{
  console.log('this is xml');
    var elements = document.forms.myForm.elements;
    var xmlTemplate = '<?xml version="1.0"?> <formData>';
    for(var i =0; i< elements.length; i++){
        var element = elements[i];
        if(element.tagName=="INPUT"){
            xmlTemplate = xmlTemplate + '<'+element.name+'>' + element.value+'</'+element.name+'>';
        }


    }
    xmlTemplate = xmlTemplate +'</formData>';
   
}

// function write(form)
// {
//   document.write(fromToXml(form));
// }



function show(cname,ctype,pid)
{

const parent = document.getElementById(pid);
const div = document.createElement('div');
const tname = document.createElement('p');
const value= document.createElement('p');

tname.innerText=cname;
tname.setAttribute('id',cname)

value.innerText=ctype;
value.setAttribute('id',ctype)

div.append(tname);
div.append(value);
parent.append(div);
}

/*

/*
Graph & DP 
2 pointer 

https://450dsa.com/

https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews
https://www.educative.io/courses/grokking-the-coding-interview

https://www.linkedin.com/in/tusharshaily/


Elements of programming interview. <- It has naming, conventions C++ code for interviews. 

*/
