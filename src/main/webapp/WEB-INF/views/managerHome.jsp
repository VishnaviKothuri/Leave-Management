<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="headerManager.jsp" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


				<!-- Header -->
				<header class="bg-primary text-center py-5 mb-4">
				  <div class="container">
				    <h1 class="font-weight-light text-white">
				    Welcome,  <security:authentication property="principal.firstName" />
				    </h1>
				  </div>
				</header>
				
				<div class="row">
	<!-- Team Member 1 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/view.png" />" alt="...">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/view-leaves-requests'">view Leave Requests</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Team Member 2 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/accept.png" />"
					alt="calculator">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/view-approved-leaves'">Approved
						Leaves</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Team Member 3 -->
	<div class="col-xl-4 col-md-8 mb-4">
		<div class="card border-0 shadow">
			<div class="thumnail">
				<img src="<c:url value="/resources/reject.jpg" />" alt="...">
			</div>
			<div class="card-body text-center">
				<h5 class="card-title mb-0">Team Member</h5>
				<div class="card-text text-black-50">
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='/view-rejected-leaves'">Rejected
						Leaves</button>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- /.row -->
				
				  
				 
				  
