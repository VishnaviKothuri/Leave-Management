<!-- registration form for employee registration -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="headerAdmin.jsp"%>

<br>
			<form:form modelAttribute="leaveType" id="leaveType" method="post"  >
				<label><h2>Leave Type</h2></label><br>
				<h2 style="color:green">${message}</h2>
				<br>
				<form:label  path="type" >Type</form:label>
				<form:input path="type" value=""  />
				</br>
				</br>
				<form:label path="noOfLeaves">No of Days</form:label>
				<form:input path="noOfLeaves" value="" />
				</br></br>
				<div class="form-actions">
					<input type="submit" value="Add" />
				</div>
				
				
			</form:form>
