   function isExcel(){
            //set excel value to hidden box
              frm.source.value="excel";
              validate();
        }
        
        function isHtml(){
            //set html value to hidden box
              frm.source.value="html";
              validate();
        }
    
      function validate(){
    	  document.getElementById("categoryErr").innerHTML="";
         if(frm.category.selectedIndex==0){
          document.getElementById("categoryErr").innerHTML="<b> Book category must be selected</b> ";
            return false;
         }
         frm.submit(); // sbumits the request.
         return true;
      }
      
       function doPrint(){
    	   frames.focus();   //frames is  implicit obj i JS
    	   frames.print();
       }