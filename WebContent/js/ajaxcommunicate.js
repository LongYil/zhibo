	
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