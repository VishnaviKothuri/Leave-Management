
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.jsp"%>

<br>
			<form:form modelAttribute="employee" id="employee" method="post">
				<label><h2>Register Employee</h2></label><br>
				
				<form:label  path="firstName" >FirstName</form:label>
				<form:input path="firstName" value="" />
				</br>
				</br>
				<form:label path="lastName">LastName</form:label>
				<form:input path="lastName" value="" />
				</br></br>
				<form:label path="email">Email</form:label>
				<form:input type="email" path="email" value="" />
				</br></br>
				<form:label path="password">Password</form:label>
				<form:input name="password" path="password" value="" />
				</br></br>
				<form:label path="dateOfJoining">Date of Joining</form:label>
				<form:input type="date" path="dateOfJoining" value="" />
				</br>
				</br>
				<form:label path="contactNumber">Contact No</form:label>
				<form:input path="contactNumber" value="" />
				</br></br>
				<form:label path="gender">Gender</form:label>
				<form:input path="gender" value="" />
				</br></br>
				<div class="form-actions">
					<input type="submit" value="Save" />
				</div>
			</form:form>
<%@ include file="footer.jsp" %>