<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication property="principal.id" var="employeeId" />
<%@ include file="headerEmployee.jsp"%>

<!-- Header -->
<header class="bg-primary text-center py-5 mb-4">
	<div class="container">
		<h1 class="font-weight-light text-white">
			Welcome,
			<security:authentication property="principal.firstName" />
		</h1>
	</div>
</header>

<!-- Page Content -->
<div class="row">
	<!-- Team Member 1 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/leave.png" />" alt="...">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/addLeave'">Add Leave</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Team Member 2 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/calculator.png" />"
					alt="calculator">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/view-leave-balance/${employeeId}'">Leave
						Balance</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Team Member 3 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/existing.png" />" alt="...">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/leave-history/${employeeId}'">Existing
						Leaves</button>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- /.row -->


