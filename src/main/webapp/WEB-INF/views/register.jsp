<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<div class="container">
        <form:form modelAttribute="employee" id="employee"  method="post">
            
            
            <label for="firstname">FirstName</label>
            <form:input path="firstName" value="" />
            </br>
            <label for="lastname">LastName</label>
            <form:input path="lastName" value="" />
            </br>
             <label for="email">Email</label>
             <form:input type = "email" path="email" value="" />
             </br>
             <label for="password">Password</label>
             <form:input name="password" path="password" value="" />
             </br>
             <label for="dateofjoining">Date of Joining</label>
             <form:input type="date"  path="dateOfJoining" value="" />
             
             </br>
             <label for="mobile">Contact No</label>
             <form:input path="contactNumber" value="" />
             </br>
             <label for="gender">Gender</label>
             <form:input path="gender" value="" />
             </br>
            <div class="form-actions">
                <input type="submit" value="Save" />
            </div>
        </form:form>
    </div>
</body>