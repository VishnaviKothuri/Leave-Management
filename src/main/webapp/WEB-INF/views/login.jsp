<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
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
}
.login-container{
    margin-top: 1%;
    margin-bottom: 1%;
}

.login-form-1{
    padding: 9%;
    background:#282726;
    opacity:0.75;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-1 h3{
    text-align: center;
    margin-top:30%;
    margin-bottom:20%;
    color:#fff;
    font-family: "Lucida Console", "Courier New", monospace;
    font-weight:bold;
    font-size:2.5em;
}
.login-form-2{
    padding: 9%;
    background: #0062cc;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-2 h3{
    text-align: center;
    margin-bottom:12%;
    color: #fff;
}
.btnSubmit{
    font-weight: 600;
    width: 50%;
    color: #0062cc;
    background-color: #fff;
    border: none;
    border-radius: 1.5rem;
    padding:2%;
}
.btnForgetPwd{
    color: #fff;
    font-weight: 600;
    text-decoration: none;
}
.btnForgetPwd:hover{
    text-decoration:none;
    color:#fff;
}
 </style>
<body>
	<div class="menu-bar">
    <ul>
        <li><a href="/aboutUs">About us</a></li>
    </ul>
</div>
<div class="container" style="margin-top:125px;margin-bottom:70px;min-height:60vh;">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;opacity:0.96;">
	<div class="card text-center" style="width: 60rem;">
		<div class="card-body">
		<div align="center">
		<div class="container login-container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                   <h3> LEAVE MANAGEMENT SYSTEM</h3>
                    
                </div>
                <div class="col-md-6 login-form-2">
                    
                    <h3>Please enter your credentials</h3>
                    <form name='f' action="/doLogin" method='POST'>
   <c:if test="${param.error != null}">
            <div class="form-group" >
                Failed to login.
                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                  Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                </c:if>
            </div>
        </c:if>
      <table>
         <tr>
            <td>Email</td>
            <td><input type='text' class = "form-control" name='username' value=''></td>
           
         </tr>
         
         <tr>
            <td>Password:</td>
            <td><input type='password' class = "form-control" name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" class="btn btn-primary" value="submit" /></td>
         </tr>
      </table>
  </form>
                </div>
            </div>
        </div>
		
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



