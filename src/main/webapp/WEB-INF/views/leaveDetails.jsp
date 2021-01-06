<!-- page that shows the details of employee existing leaves(approved,rejected,awaiting for approval)-->					
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"    uri="http://www.springframework.org/security/tags" %>
<%@include file="headerEmployee.jsp"%>
<!-- retrieving current logged in employee id using spring security tags -->					
<security:authentication property="principal.id" var="employeeId" />

<div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Employee List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
                   <thead>
						<tr>
							<th>From Date</th>
							<th>To Date</th>
							<th>No of Days</th>
							<th>Leave Type</th>
							<th>Status</th>
							<th>update</th>
							<th>delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="leaveHistory" items="${leaveHistory}" varStatus="status" >
						<!-- construct an "update" link with customer id -->
							<tr>
								<td>${leaveHistory.fromDate}</td>
								<td>${leaveHistory.todate}</td>
								<td>${leaveHistory.noOfDays}</td>
								<td>${leaveHistory.leaveType.type}</td>
								<c:set var="val" value="${leaveHistory.status}"/>
		
								<c:choose>
                                <c:when test="${val=='2'}"><td style="color:orange">awaiting for approval</td></c:when>
                                <c:when test="${val=='1'}"><td style="color:green">accepted</td></c:when> 
                                <c:otherwise><td style="color:red">rejected</td></c:otherwise>    
                                </c:choose>
                                <c:choose>
                                <c:when test="${val=='2'}">
                                <td><a type ="button" class="btn btn-success" href="/editLeave/${leaveHistory.id}">update</a></td>
                                </c:when>
                                <c:when test="${val=='1' } ">
                                 <td><input type="button" disabled="disabled" value="update"></td>
                                </c:when> 
                                <c:otherwise>
                                 <td><input type="button" disabled="disabled" value="update"></td>
                                </c:otherwise> 
                                </c:choose>
                                <c:choose>
                                <c:when test="${val=='2'}">
                                <td><a type ="button" class="btn btn-warning" href="/cancel-leave/${leaveHistory.id}/${employeeId}">delete</a></td>
                                </c:when>
                                <c:when test="${val=='1' } ">
                                 <td><input type="button" disabled="disabled" value="delete"></td>
                                </c:when> 
                                <c:otherwise>
                                 <td><input type="button" disabled="disabled" value="delete"></td>
                                </c:otherwise> 
                                </c:choose>  
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	

	


