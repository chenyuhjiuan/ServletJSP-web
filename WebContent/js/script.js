 
		function gotoError(){
				 
				var username=document.forms['myForm']['username'].value; 
				if(username==null || username==''){
				 var text1 = 'Please input the User Name.' ;
				document.getElementById('error1').innerHTML =text1;
				//document.getElementById('username').style.borderColor=red;
				return false;} 
				
				var email=document.forms['myForm']['email'].value; 
				//if(email==null || email==''){
				//var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
				var mailformat = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
				if(!mailformat.test(email)) {
				var text2 = 'Please input a valid Email.' ;
				document.getElementById('error2').innerHTML =text2;
				return false;} 
				 
				var grade=document.forms['myForm']['grade'].value; 
				if(isNaN(grade) || grade > 5 || !grade || grade <=0){
				var text3 = 'Please input a number less than 5, but not including 0 or negtive number.' ;
				document.getElementById('error3').innerHTML =text3;
				return false;} 				
				 
				var passwd=document.forms['myForm']['passwd'].value; 
				if(passwd==null || passwd==''){
				 var text4 = 'Please input the Password.' ;
				document.getElementById('error4').innerHTML =text4;
				return false;} 
				return true;
				
		}
		
		function gotoLogin(){
			var id=document.forms['myForm']['id'].value; 
			if(isNaN(id) || !id || id <=0){
			 var text1 = 'Please input your ID.' ;
			document.getElementById('error1').innerHTML =text1;
			//document.getElementById('username').style.borderColor=red;
			return false;} 
			
			var password=document.forms['myForm']['password'].value; 
			if(password==null || password==''){
			var text2 = 'Please input your password.' ;
			document.getElementById('error2').innerHTML =text2;
			return false;} 
			
			return true;
		}

		/*function gotoUpdate(){
				 
				var username=document.forms['myForm']['username'].value; 
				if(username==null || username==''){
				var text1 = 'Please input the User Name.' ;
				document.getElementById('error1').innerHTML =text1;
				return false;}
				
				var email=document.forms['myForm']['email'].value; 
				if(email==null || email==''){
				var text2 = 'Please input the Email.' ;
				document.getElementById('error2').innerHTML =text2;
				return false;} 
				 
				var grade=document.forms['myForm']['grade'].value; 
				if(isNaN(grade) || grade > 5 || !grade || grade <=0){
				var text3 = 'Please input a number less than 5, but not including 0 or negtive number.' ;
				document.getElementById('error3').innerHTML =text3;
				return false;} 			
				 
				var passwd=document.forms['myForm']['passwd'].value; 
				if(passwd==null || passwd==''){
				var text4 = 'Please input the Password.' ;
				document.getElementById('error4').innerHTML =text4;
				return false;} 
				return true;}*/
 