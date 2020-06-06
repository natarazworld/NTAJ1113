      function   validate(frm){
    	  
    	  //read form data
    	  let name=frm.pname.value;
    	  let age=frm.page.value;
    	  let flag=true;
    	  
    	  // empty validation error messages
    	   document.getElementById("pnameErr").innerHTML="";
    	   document.getElementById("pageErr").innerHTML="";
     	  
    	  //write client side form validation logic
    	  if(name==""){  //required rule
    		  document.getElementById("pnameErr").innerHTML="<b>person name is required</b>";
    		  frm.pname.focus();
    		   	  flag=false;
    	  }
    	  else if(name.length<5 || name.length>15){   // min ,max length rule
    		  document.getElementById("pnameErr").innerHTML="person name must have min 5 chars and max 15 chars ";
    		  frm.pname.focus();
    		  flag=false;
    	  }
    		  
    	   if(age==""){   //required rule
    		   document.getElementById("pageErr").innerHTML="person age is required";
    		  frm.page.focus();
    		  flag=false;
    	  }
    	   else if(isNaN(age)){
    		   document.getElementById("pageErr").innerHTML="person age must be numeric value";
    		   frm.page.focus();
     		    frm.page.value="";
     		  flag=false;
    	   }
    	   else if(age<1 || age>125){
    		   document.getElementById("pageErr").innerHTML="person age must be there 1 through 125";
      		    frm.page.focus();
      		    frm.page.value="";
    		   flag=false;
    	   }
    	   //change hidden box (vflag) value to "yes"  indicating client side form validations are done
    	 alert("client side java script");
    	   frm.vflag.value="yes";
    	  return flag;
    	      	  
      }//function
  
