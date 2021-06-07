<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"    uri="http://www.springframework.org/security/tags" %>

<%@include file="headerEmployee.jsp"%>
         <security:authentication property="principal.id" var="employeeId" />
        <form:form modelAttribute="leaveEntry" id="leave" action="performEdit/${leaveEntry.id}/${employeeId}"  method="post">
           

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
             <label for="noofdays">Leave Type</label>
             <form:select  name="category" path="leaveType" class="form-select" aria-label="Default select example">
             <c:forEach items="${typesofLeaves}" var="category">
             <option value="${category.id}">${category.type}</option>
             </c:forEach>
            </form:select>
             </br>
             </br>

             </br>
             <label for="reason">Reason</label>
             <form:textarea  path="reason" value="" />
             </br>
            <div class="form-actions">
                <input type="submit"  value="update" />
            </div>
        </form:form>
   