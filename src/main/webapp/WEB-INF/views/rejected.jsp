<!-- page that shows rejected leaves of the employee.belongs to manager-->
						
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"    uri="http://www.springframework.org/security/tags" %>
<%@include file="headerManager.jsp"%>


<div class="panel panel-info">

    <div class="panel-heading">
     <div class="panel-title">Employee List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
     <thead>
						<tr>
						    <th>Id</th>
						    <th>Name</th>
							<th>From Date</th>
							<th>To Date</th>
							<th>No of Days</th>
							<th>Leave Type</th>
							<th>comment</th>
							<th>Accept</th>
							
							
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="leaveRequests" items="${leaveRequests}" varStatus="status" >
						<!-- construct an "update" link with customer id -->
						
						
						   
							<tr>
							    <td>${leaveRequests.employee.employeeId}</td>
							    <td>${leaveRequests.employee.firstName}</td>
								<td>${leaveRequests.fromDate}</td>
								<td>${leaveRequests.todate}</td>
								<td>${leaveRequests.noOfDays}</td>
								<td>${leaveRequests.leaveType.type}</td>
								<td>${leaveRequests.reason}</td>
                                <td><a type ="button" class="btn btn-success" href="/manage-leaves/accept/${leaveRequests.id}">accept</a></td>
                               
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>

		</div>

	

	


