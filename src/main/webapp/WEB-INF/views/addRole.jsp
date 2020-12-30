<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>

<form:form method="post" modelAttribute="employeeRole">
 <div class="form-group">
<form:input type="hidden" id="${employeeRole.employee }" path="employee" />
   <form:select  name="category" path="role" class="form-select" aria-label="Default select example">
      <c:forEach items="${roles}" var="category">
        <option value="${category.id}">${category.name}</option>
      </c:forEach>
  </form:select>
 </div>
<input class="btn btn-primary" type="submit" value="Add Role">
</form:form>
</body>
