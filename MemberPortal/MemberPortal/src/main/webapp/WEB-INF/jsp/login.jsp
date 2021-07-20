<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
<title>Login form</title>
</head>
<style>
body{
	margin:0;
	padding:0;
	font-family: sans-serif;
	background: url("pp.jpg");
	background-size:cover;
	background-image:url("https://d1kxiaxkq0bgmn.cloudfront.net/wp-content/uploads/2019/11/the-future-of-insurance-claims-management-1.jpg");
   
	
}
.on{
color:white;
text-align:center;
}
.login-box{
	width: 809px;
    height:470px;
    background: rgba(126, 202, 240, 0.6);
    color: #fff;
	position: absolute;
	top:50%;
	left:50%;
	transform: translate(-50%,-50%);
	box-sizing: border-box;
    padding: 70px 30px;
}
    
    
.login-box p{
margin: 0;
    padding: 0;
    font-weight: bold;
}
    .login-box input{
        width: 100%;
        margin-bottom: 20px;
    }
    
    .login-box input[type="text"], input[type="password"]{
        border: none;
        border-bottom: 1px solid #fff;
        background: transparent;
        outline: none;
        height: 40px;
        color: #fff;
        font-size: 16px;
    }
    
    .login-box input[type="submit"]{
        border: none;
        outline: none;
        height: 40px;
        background: #1c8adb;
        color: #fff;
        font-size: 18px;
        border-radius: 20px;
    }
    </style>

<body>



<div class="login-box">
    
<h2><center>LOGIN FORM</center><center></h2>



	<form action="auth" method="POST">
    <p> UserName</p>
        <input type="text" name="userid" id="userid" placeholder=" Userid" autocomplete="off">
        <p>Password</p>
        <input type="password" name="password" id="password" placeholder="password">
        
        <input type="submit" name="submit" value="Login">
       <br>
       <br><div>${message} </div>
       <br><div>${tokenexpired} </div>
        
    </form>
    
    
</div>
</html>