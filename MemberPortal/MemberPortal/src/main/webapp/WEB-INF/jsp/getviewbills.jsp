<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
<title>Get Bills</title>
</head>
<style>
body{
	margin:0;
	padding:0;
	font-family: sans-serif;
	background: url("pp.jpg");
	background-size:cover;
    background-image:url("https://i.pinimg.com/originals/11/91/7e/11917ed32717d3e51a2c5fb6ef1fa714.jpg");
   
   
	
}
.on{
color:white;
text-align:center;
}
.login-box{
	
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
    ul {
  list-style-type: none;
  margin: 0;
  padding: 10;
  overflow: hidden;
  background-color: #C0C0C0;
}
li {
  float: left;
}
li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
li a:hover:not(.active) {
  background-color: #F0F0F0;
}
.active {
  background-color: #C0C0C0;
}
    </style>

<body>

<div class="login-box">
   
<center><h3>Check Bills</h3></center>

	<form action="viewbills" method="GET">
    <p>Policy Id</p>
        <input type="number" id="policyId" name="policyId" placeholder="Enter the policy id">
    <p>Member Id</p>
        <input type="text" id="memberId" name="memberId" placeholder="Enter the member id">
    
      
     
    
        <input type="submit" name="submit" value="Show Bill">
           
            <br><div>${Message}</div> 
    </form>
    
    
</div>



   

</body>
</html>