<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
        <form:form modelAttribute="leaveEntry" id="leave"  method="post">
            
            
            <label for="fromdate">From-Date</label>
            <form:input type ="date" path="fromDate" value="" />
            </br>
            </br>
            <label for="todate">To-Date</label>
            <form:input type="date" path="todate" value="" />
            </br>
            </br>
             <label for="noofdays">Number of Days</label>
             <form:input  path="noOfDays" value="" />
             </br>
             
          </br>
             <form:select  name="category" path="leaveType" class="form-select" aria-label="Default select example">
             <c:forEach items="${typesofLeaves}" var="category">
             <option value="${category.id}">${category.type}</option>
             </c:forEach>
            </form:select>
             </br>
             </br>
             
             
          
             </br>
             <label for="quarter">Quarter</label>
             <form:input path="quarter" value="" />
             </br>
             </br>
             <label for="reason">Reason</label>
             <form:textarea  path="reason" value="" />
             </br>
            <div class="form-actions">
                <input type="submit" value="Save" />
            </div>
        </form:form>
    </div>
</body>
</html>