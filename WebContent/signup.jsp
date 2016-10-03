<%@ page session="true" import=" javax.sql.*, java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>signup</title>

    <!-- Bootstrap CSS -->    
    <link href="css1/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css1/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <link href="css1/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css1/style3.css" rel="stylesheet">
	<script src="js/signup.js"></script>
	<script src="js/password.js"></script>
	<script src="js/firstname.js"></script>
	<script src="js/lastname.js"></script>
	<script src="js/email.js"></script>
	<script src="js/phonenumber.js"></script>
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript">
	function call()
	{
	    var obj;
		var email=document.getElementById("email").value;
		if (email=="")
		{
			document.getElementById("result").innerHTML="ENTER YOUR EMAIL";
		}
		else{
		//alert(email);
		var url="check.jsp?email="+email;
		//alert(url);
	    if(window.XMLHttpRequest)	//except IE
		{
			obj=new XMLHttpRequest();
		}
		else	//IE	
		{
			obj=new ActiveXObject("Microsoft.XMLHTTP");
		}
		obj.open("get",url,true);	//get/post,target(jsp,html,txt,servlet),false-asyncronus
		obj.send();
		obj.onreadystatechange=function()
		{
			if (obj.readyState==4 && obj.status==200)
			{
				document.getElementById("result").innerHTML=obj.responseText;
			}
		} 
	}
	}
	
	</script>
</head>
<body class="login">
 <div class="text-vertical-center">
    <h1 align="center">ONLINE EXAMINATION SYSTEM</h1><h4 align="right"><a href="index.jsp"><b><u>LOGIN</u></b></a></h4>
    <div class="container">
      <form class="login-form"  name="registration"  method="post" action="Signup" onsubmit="return signupvalidate()"> 
      <div class="login-wrap"> 
      <%
		/* String msg = null;
		msg = (String)request.getAttribute("msg");
		if(msg != null)
		{ */
	  %>
		<div><h4 align="center"><font face="Monotype Corsiva" color="3300CC"> ${param.msg}</font></h4></div>
	<%	//} %>      
        
            <div class="input-group">
            <span id="result1"></span>
                   <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Firstname">
            </div>
            
			<div class="input-group">
            <span id="result2"></span>
                <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Lastname" onkeyup=" return first()">
            </div>
           
            <div class="input-group">
            <span id="result3"></span>
            <span id="result"></span>
              	<input type="email" class="form-control" name="email" id="email" placeholder="Email" onkeyup="return last()">
            </div>
            <div class="input-group">
              <input type="email" class="form-control" name="email" id="email" placeholder="Retype Email" onKeyup="call()">
            </div>
            <div class="input-group">
            <span id="result4"></span>
                
                <input type="password" class="form-control" name="password" id="password" placeholder="Password" onkeyup="return emailfun()">
            </div>
			<div class="input-group">
                
                <input type="password" class="form-control" name="confirmpassword" id="confirmpassword" placeholder="ConfirmPassword">
            </div>
			<div class="input-group">
            <span id="result5"></span>
               	<input type="number" class="form-control" name="phoneno" id="phonenumber" placeholder="Phonenumber" onKeyup="return pass()">
            </div>
			<div class="input-group">
            <select class="form-control" name="batch" id="batch" onmouseup="return phone()" >
            <script type="text/javascript">
				for(var i=2008;i<=2050;i++ )
					{ 
						document.write('<option value=' + i + '>' + i + '</option>');
					}      
			</script>
			</select>
			</div>
			<div class="input-group">
            <select class="form-control" name="type" id="type" >
         			<option value="student">student</option>      
			</select>
            </div>
			<div class="input-group">
            <select class="form-control" name="branch" id="branch" >
            <%
			 Connection con;
			 String url;
			ResultSet rs=null;
			 Statement st=null;
			
			try
			{
				url="jdbc:mysql://localhost/oes";
				Class.forName("com.mysql.jdbc.Driver");
				
				try
				{
					con=DriverManager.getConnection(url,"root","root");
					//System.out.println("CONNECTED");
					st=con.createStatement();
					String qry="select * from branch";
					System.out.println(qry);
					           rs=st.executeQuery(qry);  
					           
					           while(rs.next())
					           {
					        	   int branchid=rs.getInt("branchid");
					        	   String branchname=rs.getString("branchname");
					        	  
									%>
									<option value="<%=branchname%>"><%=branchname%></option>
									<%}
														           }catch(Exception e)
					           {
					           }
			}catch(Exception e)
			{
				
			}
					           %>
</select>
                
                
            </div>
			<b><font color="black">Gender:</font></b>
			<b><font color="black">Male</font></b><input name="gender" type="radio" style="width: 20px;height: 20px;" value="Male" checked="checked">
		  <b><font color="black">Female</font></b><input name="gender" type="radio" style="width: 20px;height: 20px;" value="Female">
									
				
            <button class="btn btn-info btn-lg btn-block" type="submit">Signup</button>
        </div>
		</div>
      </form>

    </div>


  </body>
</html>
