<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/templates/top.jsp" />


<h3>ServiceOrder N°: ${serviceOrder.serviceOrderId}</h3>
<c:forEach items="${quotas}" var="q">
	<div class="row">
		<div class="col-sm-4 col-md-4 col-md-offset-4">
			<div class="thumbnail">
				<div class="caption">
					<table class="table">
						
						<tr>
							<th>Job Code</th>
							<th>Job Title</th>
						</tr>
						<tr>
							<td>${q.jobCode}</td>
							<td>${q.jobTitle}</td>
						</tr>
					</table>
				
						<a href="../quota/details.html?id=${q.quotaId}" class="btn btn-primary">View</a>
					
				</div>
			</div>
		</div>
	</div>
</c:forEach>




<c:import url="/templates/bot.jsp" />