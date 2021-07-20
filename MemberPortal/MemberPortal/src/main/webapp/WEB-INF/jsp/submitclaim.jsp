<!Doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
<title>Submit Claim Form</title>
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
	
    width: 821px;
    height:750px;
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
        margin-bottom: 5px;
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
   
<h3><center>SUBMIT CLAIM</center></h3>

	<form action="viewsubmittedclaim" method="POST">
    <p>Member Id</p>
        <input type="text" id="memberid" name="memberid" placeholder="Enter the member id">
    
    <p>Policy Id</p>
        <input type="text" id="policyid" name="policyid" placeholder="Enter the policy id">
    <p>Claim Id</p>
        <input type="text" id="claimid" name="claimid" placeholder="Enter the claim id">
    <p>Provider Id</p>
        <input type="text" id="providerid" name="providerid" placeholder="Enter the provider id">
    <p>Benefit Id</p>
        <input type="text" id="benefitid" name="benefitid" placeholder="Enter the benefit id">
    <p>Billed Amount</p>
        <input type="text" id="billedamount" name="billedamount" placeholder="Enter the billed Amount">
    <p>Claim Amount</p>
        <input type="text" id="claimamount" name="claimamount" placeholder="Enter the claim Amount">
        <p>Claim Status</p>
        <input type="text" id="claimstatus" name="claimstatus" placeholder="Enter the claim Status">
        <p>Description</p>
        <input type="text" id="desc" name="desc" placeholder="Enter the Description">
    
   
     <br>
     <br>
     <br>
    
        <input type="submit" name="submit" value="Submit claim">
              
    </form>
    
    
</div>




   
</body>

</html>