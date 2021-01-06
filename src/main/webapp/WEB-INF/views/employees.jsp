 
<!-- page that shows the list of the each employee -->
						
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"    uri="http://www.springframework.org/security/tags" %>
<%@include file="headerAdmin.jsp"%>
<div class="panel panel-info">

<div class="panel-heading">
     <div class="panel-title">Employee List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
     
                   <thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Password</th>
							<th>Date of Joining</th>
							<th>Contact Number</th>
							<th>Gender</th>
							<th>update</th>
							<th>change status</th>
						</tr>
					</thead>
					
					<tbody>
					   <!-- loop for traversing each employee list -->
						
						<c:forEach var="employees" items="${employees}" varStatus="status" >   
							<tr>
								<td>${employees.employeeId}</td>
								<td>${employees.firstName}</td>
								<td>${employees.lastName}</td>
								<td>${employees.email}</td>
								<td>${employees.password}</td>
								<td>${employees.dateOfJoining}</td>
								<td>${employees.contactNumber}</td>
								<td>${employees.gender}</td>
								<td><a type ="button" class="btn btn-success" href="/editEmployee/${employees.employeeId}">update</a></td>
                                <c:choose>
                                <c:when test="${employees.status=='1'}"> <td><a type ="button" class="btn btn-warning" href="/updateStatus/${employees.employeeId}">inactive</a></td></c:when>
                                <c:otherwise> <td><input type="button" disabled="disabled" value="inactive"></td></c:otherwise>    
                                </c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	

	


