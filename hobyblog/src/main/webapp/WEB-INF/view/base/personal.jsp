<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="media user-media well-small">
	<a class="user-link" href="#"> <img
		class="media-object img-thumbnail user-img" alt="${person.username}"
		src='<c:url value="/resources/img/pimage/${person.pimage}"/>' />
	</a> <br />
	<div class="media-body">
		<h5 class="media-heading"><c:out value="${person.username}"/></h5>
	</div>
	<br />
</div>