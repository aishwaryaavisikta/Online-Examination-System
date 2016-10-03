<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>

    <!-- Bootstrap CSS -->    
    <link href="css1/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css1/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <link href="css1/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css1/style3.css" rel="stylesheet">
	<script src="js/Login.js"></script>
	<script type="text/javascript">
	function call()
	{
	    var obj;
		var email=document.getElementById("email").value;
		//alert(email);
		var url="CheckEmail?email="+email;
		//alert(url);
	    if(window.XMLHttpRequest)	//except IE
		{
			obj=new XMLHttpRequest();
		}
		else	//IE	
		{
			obj=new ActiveXObject("Microsoft.XMLHTTP");
		}
		obj.open("post",url,true);	//get/post,target(jsp,html,txt,servlet),false-asyncronus
		obj.send();
		obj.onreadystatechange=function()
		{
			if (obj.readyState==4 && obj.status==200)
			{
				document.getElementById("result").innerHTML="Valid User..!!";
			}
			
		} 
	}
	
	</script>
</head>

  <body class="login">
  <div class="text-vertical-center">
    <center><h1>ONLINE EXAMINATION SYSTEM</h1></center>
    <div class="container">

      <form class="login-form"  name="login" id="login" method="post" action="Login" onsubmit="check()">   
      <%String msg=(String)request.getAttribute("msg");
      if(msg!=null)
      {%>  
      <div><h4 align="left"><font face="Monotype Corsiva" color="3300CC"><%=msg %></font></h3></div> 
      <%} %>
        <div class="login-wrap">
            <div class="input-group">
            <h3 align="center"><font face="Monotype Corsiva" color="3300CC">
              <span id="result"></span></font></h3>
              <input type="text" class="form-control" name="email" id="email" placeholder="Email">
            </div>
            <div class="input-group">
                
                <input type="password" class="form-control" name="password" id="password" placeholder="Password" onkeyup="call()">
            </div>
			<div class="input-group">
                <select class="form-control" name="type">
				<option value="SELECT">---SELECT---</option>
				<option value="student">STUDENT</option>
				<option value="manager">MANAGER</option>
				</select>
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">LOGIN</button>
			</form>
			<br>
            <center><a href="signup.jsp"><font size="3px">Signup</font></a></center></br>
            <center><a href="forgetpassword1.jsp"><font size="3px">Forgot Password</font></a></center></br></br>
        </div>
		</div>
     

    </div>


  </body>
</html>
