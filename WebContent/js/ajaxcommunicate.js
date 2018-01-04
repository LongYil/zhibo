	
		var rqt = null;
		
		function ajaxSubmit(url,arg){
			tijiao(url,arg);
			return getresult();
		}
		function tijiao(url,arg){
		if(window.XMLHttpRequest){//非IE浏览器
			rqt = new XMLHttpRequest();
		}else if(window.ActiveXObject){
			try{
				rqt = new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					rqt = new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){		
				}
			}
		}
		rqt.onreadystatechange = getresult;
		rqt.open("POST",url+"?info="+encodeURI(encodeURI(arg)),false);
		rqt.send("");
	   };
	   
	   function getresult(){
		   if(rqt.readyState == 4){
			   if(rqt.status == 200){
				var temp = eval(rqt.responseText);
				return temp;
			   }
			   }
	   }
	   function checkPhone(arg){ 
		    var phone = arg;
		    if(!(/^1[34578]\d{9}$/.test(phone))){  
		        return false; 
		    }else{
		    	return true;
		    }
		}
	    function checkNumber(arg){
	      if(!/^\d+(?=\.{0,1}\d+$|$)/.test(arg)){
	          return false;
	      }else{
	    	  return true;
	      }
	    }
	    function checkEmail(arg) {
	    	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    	    if(!myreg.test(arg)){
    	      return false;
    	    }else{
    		  return true;
    	    }
	    }