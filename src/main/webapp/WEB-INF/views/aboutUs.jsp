<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    margin-bottom:0;
    padding-bottom:0;
    min-height:100%;
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
    float:right;
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
    background-color: #007bff;
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
 </style>
<body>
	<div class="menu-bar">
    <ul>
    	<li><a href="/homePage">Home</a></li>
        <li><a href="/aboutUs">About us</a></li>
        
    </ul>
</div>
<div class="container" style="margin-top:70px;margin-bottom:70px;min-height:60vh;">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;opacity:0.95;">
	<div class="card text-center" style="width: 60rem;">
		<div class="card-body">
		<div align="center">
				<!-- Header -->
				<header class="bg-primary text-center py-5 mb-4">
				  <div class="container">
				    <h1 class="font-weight-light text-white">Our Team</h1>
				  </div>
				</header>
				
				<!-- Page Content -->
				  <div class="row">
				    <!-- Team Member 1 -->
				    <div class="col-xl-3 col-md-6 mb-4">
				      <div class="card border-0 shadow">
				        <img src="https://source.unsplash.com/9UVmlIb0wJU/500x350" class="card-img-top" alt="...">
				        <div class="card-body text-center">
				          <h5 class="card-title mb-0">Team Member</h5>
				          <div class="card-text text-black-50"><p>Vishnavi Kothuri</p>
				          <p>HYD Campus()</p></div>
				        </div>
				      </div>
				    </div>
				    <!-- Team Member 2 -->
				    <div class="col-xl-3 col-md-6 mb-4">
				      <div class="card border-0 shadow">
				        <img src="https://source.unsplash.com/TMgQMXoglsM/500x350" class="card-img-top" alt="...">
				        <div class="card-body text-center">
				          <h5 class="card-title mb-0">Team Member</h5>
				          <div class="card-text text-black-50"><p>Gopu Kaushik</p>
				          <p>HYD Campus()</p></div>
				        </div>
				      </div>
				    </div>
				    <!-- Team Member 3 -->
				    <div class="col-xl-3 col-md-6 mb-4">
				      <div class="card border-0 shadow">
				        <img src="https://source.unsplash.com/sNut2MqSmds/500x350" class="card-img-top" alt="...">
				        <div class="card-body text-center">
				          <h5 class="card-title mb-0">Team Member</h5>
				          <div class="card-text text-black-50"><p>Debabrata Pradhan</p>
				          <p>CHE SEZ()</p></div>
				        </div>
				      </div>
				    </div>
				    <!-- Team Member 4 -->
				    <div class="col-xl-3 col-md-6 mb-4">
				      <div class="card border-0 shadow">
				        <img src="https://source.unsplash.com/9UVmlIb0wJU/500x350" class="card-img-top" alt="...">
				        <div class="card-body text-center">
				          <h5 class="card-title mb-0">Team Member</h5>
				          <div class="card-text text-black-50"><p>Debapriya Goswami</p>
				          <p>CHE SEZ()</p></div>
				        </div>
				      </div>
				    </div>
				  </div>
				  <!-- /.row -->
		</div>	
		</div>
	</div>
	</div>
</div>
<footer id="sticky-footer" class="py-4 bg-primary text-white-50">
    <div class="container text-center">
      <small>Copyright &copy; Virtusa:Team 6</small>
    </div>
</footer>
 </body>
</html>