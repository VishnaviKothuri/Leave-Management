<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
 <style type"text/css">
 html {
  position: relative;
  min-height: 100%;
}
*{
    padding:0;
    margin:0;
    box-sizing: border-box;
}
body{
    background:url("<c:url value="/resources/image1.png" />")  no-repeat;
    background-size:cover;
    background-position: center;
    
    font-family:sans-serif;
    color:black;
    margin-bottom: 0;
    padding-bottom:0;
    min-height:100%;
}
 label {
        display: inline-block;
        width: 200px;
        margin-right: 5px;
        text-align: left;
        color:black;
        font-weight:900;
        font-family:Lucida Console;
    }
 .thumnail img{
 height:200px;
 width:200px;
 }
 input[type=text], input[type=password], select {
        width: 350px;  
        border-top-style: hidden;
        border-right-style: hidden;
        border-left-style: hidden;
        border-bottom-style: groove;
        font-family:Verdana;    
        font-size:large;
        
    }
    input[type=radio] {
        display: inline-block;
        margin-left: 45px;
    }
   textarea{
        display: inline-block;
        margin-left: 45px;
        width:300px;
    }
    input[type=checkbox] {
        display: inline-block;
        margin-right: 190px;
    }  
    input[type=date] {
       width: 350px;
       border-top-style: hidden;
        border-right-style: hidden;
        border-left-style: hidden;
        border-bottom-style: groove;
    }  
    input[type=email] {
        width: 350px;
        border-top-style: hidden;
        border-right-style: hidden;
        border-left-style: hidden;
        border-bottom-style: groove;
    }  
    .form-actions {
        padding: 30px;
        margin: 30px;
        
        
        background-color:#4682b4;
    }
 h2{
 text-color:black;
 }
.menu-bar{
    background:#007bff;
    text-align: center;
    height:75px;
}
.menu-bar ul{
    display:inline-flex;
    list-style: none;
    color:#fff;
}
.menu-bar ul li{
    width: 200px;
    height: 50px;
    margin:15px;
    padding: 15px;
}
.menu-bar ul li a{
    text-decoration: none;
    color:#fff;
}
.active, .menu-bar ul li:hover{
    background:rgb(87, 101, 112);
    border-radius: 3px;
}
.sub-menu1 {
    display:none;
}

.menu-bar ul li:hover .sub-menu1{
    display:block;
    position: absolute;
    background-color:#007bff;
    margin-top: 15px;
    margin-left: 15px;    
}
.menu-bar ul li:hover .sub-menu1 ul{
    display: block;
    margin:10px;
    border-bottom: 1px dotted #fff;
    background: transparent;
    text-align: left;
}
.menu-bar ul li:hover .sub-menu1 ul  li{
    width: 150px;
    padding:10px;
    border-bottom: 1px dotted #fff;
    background: transparent;
    border-radius:0;
    text-align: left;
}
.menu-bar ul li:hover .sub-menu1 ul li:last-child{
    border-bottom: none;
}
.menu-bar ul li:hover .sub-menu1 ul li a:hover{
    color:rgb(87, 101, 112);
}
}
#footers {
  position: fixed;
  bottom: 0;
  right:0;
  
  padding:1rem;
  bottom:0;
  width:100%;
  height:40px;
  background:grey;
  }
 
#page-content {
  flex: 1 0 auto;
}

#sticky-footer {
  flex-shrink: none;
}
@media screen and (max-width: 500px) {
  .menu-bar a {
    float: none;
    display: block;
    text-align: left;
  }
  .menu-bar-left {
    float: none;
  }
  .conatiner{
 	padding:16px;
  }
}

 </style>
<body>
	<div class="menu-bar">
    <ul>
        <li><a href="/managerHome">Home</a></li>   
        <li><a href="/managerLeavePolicies">Leave Policies</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>
</div>
<div>



</div>

<div class="container" style="margin-top:70px;margin-bottom:70px;min-height:50vh;">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;opacity:0.96;">
	<div class="card text-center" style="width: 60rem;">
		<div class="card-body">
		<div align="center">
