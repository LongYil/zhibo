window.onload=function(){ 
	var linkbt1=document.getElementById("linkbt1"); 
	var light1=document.getElementById('light1'); 
	var fade1=document.getElementById('fade1'); 
	var closebt1=document.getElementById("closebt1"); 
	var linkbt2=document.getElementById("linkbt2"); 
	var light2=document.getElementById('light2'); 
	var fade2=document.getElementById('fade2'); 
	var closebt2=document.getElementById("closebt2");
	var turn1=document.getElementById("turn1")
	var turn2=document.getElementById("turn2")
		linkbt1.onclick=function(){ 
			light1.style.display='block'; 
			fade1.style.display='block'; 
			} 
		closebt1.onclick=function(){
			light1.style.display='none'; 
			light2.style.display='none'; 
			fade1.style.display='none'; 
		} 
		turn2.onclick=function(){
			fade2.style.display='block';
			fade1.style.display='none';
		}

		linkbt2.onclick=function(){ 
			light2.style.display='block'; 
			fade2.style.display='block';
			} 
		closebt2.onclick=function(){ 
			light2.style.display='none'; 
			light1.style.display='none'; 
			fade2.style.display='none';
		} 
		turn1.onclick=function(){
			fade1.style.display='block';
			fade2.style.display='none';
		}
}


// $(#hide).click(function(){
// $('div','live-rigthside').hide(1000,id='rightside-h');
// });
 
// $(#show).click(function(){
// $('div','live-rigthside').show(1000,id='rightside-s');
// });