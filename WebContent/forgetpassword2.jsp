<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>forgetpassword2</title>

    <!-- Bootstrap CSS -->    
    <link href="css1/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css1/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <link href="css1/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css1/style3.css" rel="stylesheet">
	<script src="js/forgotpassword1.js"></script>
</head>

  <body class="login">
  <div class="text-vertical-center">
    <center><h1>ONLINE EXAMINATION SYSTEM</h1></center>
    <div class="container">

      <form class="login-form"  name="forgotpassword1" id="forgotpassword1" method="post" action="index.jsp" onsubmit="return forgotpass1validate()">      
        <div class="login-wrap">
		<div class="input-group">
                <select name="">
				<option value="SELECT">---SELECT---</option>
				<option value="student">STUDENT</option>
				<option value="admin">ADMIN</option>
				</select>
            </div>
            <div class="input-group">
              
              <input type="password" class="form-control" name="newpassword" id="newpassword" placeholder="">
            </div>
            <div class="input-group">
                
                <input type="password" class="form-control" name="confirmpassword" id="confirmpassword" placeholder="">
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">CONFIRM</button>
			</form>
			<br>
            <center><a href="index.jsp"><font size="3px">Login</font></a></center></br>
            <center><a href="signup.jsp"><font size="3px">Signup</font></a></center></br></br>
        </div>
		</div>
     

    </div>


  </body>
</html>
