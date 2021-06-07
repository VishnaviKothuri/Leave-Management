<!-- registration form for employee registration -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="headerAdmin.jsp"%>

<br>
			<form:form modelAttribute="employee" id="employee" method="post"  >
				<label><h2>Register Employee</h2></label><br>
			
				<h2 style="color:red">${message}</h2>
				<br>
				<form:label  path="firstName" >FirstName</form:label>
				<form:input path="firstName" value=""  />
				<form:errors path="firstName" />
				</br>
				</br>
				<form:label path="lastName">LastName</form:label>
				<form:input path="lastName" value="" />
				<form:errors path="lastName" />
				</br></br>
				<form:label path="email">Email</form:label>
				<form:input type="email" path="email" value="" />
				<form:errors path="email" />
				</br></br>
				<form:label path="password">Password</form:label>
				<form:input name="password" path="password" value="" />
				<form:errors path="password" />
				</br></br>
				<form:label path="dateOfJoining">Date of Joining</form:label>
				<form:input type="date" path="dateOfJoining" value="" />
				<form:errors path="dateOfJoining" />
				</br>
				</br>
				 <label for="roles">Roles</label>
				
                 <form:select  name="category" path="role" class="form-select" aria-label="Default select example">
                 <c:forEach items="${roles}" var="category">
                 <option value="${category.id}">${category.name}</option>
                 </c:forEach>
                 </form:select>
                
				</br>
				</br>
				<form:label path="contactNumber">Contact No</form:label>
				<form:input path="contactNumber" value="" />
				<form:errors path="contactNumber" />
				</br></br>
				<form:label path="gender">Gender</form:label>
				<form:input path="gender" value="" />
				<form:errors path="gender" />
				</br></br>
				<div class="form-actions">
					<input type="submit" value="Save" />
				</div>
			</form:form>
