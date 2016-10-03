<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>forgetpassword1</title>

    <!-- Bootstrap CSS -->    
    <link href="css1/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css1/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <link href="css1/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css1/style3.css" rel="stylesheet">
	<script src="js/forgotpassword3.js"></script>
</head>

  <body class="login">
  <div class="text-vertical-center">
    <center><h1>ONLINE EXAMINATION SYSTEM</h1></center>
    <div class="container">

      <form class="login-form"  name="forgetpassword" id="forgetpassword" method="post" action="ForgetPassword" onsubmit="return forgotpass2validate()">      
        <div class="login-wrap">
          ${param.message}
            <div class="input-group">
            
              <input type="email" class="form-control" name="email" id="email" placeholder="Email">
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">OK</button>
			</form>
			<br>
            <center><a href="index.jsp"><font size="3px">Login</font></a></center></br>
            <center><a href="signup.jsp"><font size="3px">Signup</font></a></center></br></br>
        </div>
		</div>
     

    </div>


  </body>
</html>
