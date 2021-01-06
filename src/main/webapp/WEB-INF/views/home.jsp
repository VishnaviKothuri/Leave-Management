<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="headerAdmin.jsp" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


				<!-- Header -->
				<header class="bg-primary text-center py-5 mb-4">
				  <div class="container">
				    <h1 class="font-weight-light text-white">
				    Welcome <security:authentication property="principal.firstName" />
				    </h1>
				  </div>
				</header>
				
				<div class="row">
	<!-- Team Member 1 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/addEmp.jpg" />" alt="...">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/register'">Add Employee</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Team Member 2 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/empDetails.jpg" />"
					alt="calculator">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/view-employees'">View Employees
						</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Team Member 3 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/leaveType.jpg" />" alt="...">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/view-rejected-leaves'">Add
						Leave Types</button>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- /.row -->
				
				  
				 
				  
