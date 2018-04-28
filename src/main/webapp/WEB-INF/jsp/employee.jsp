<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/styles.css" rel="stylesheet">
		<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="/js/script.js"></script>
	</head>
	<body>
		<div class="container"> 
			<form:form method="post" action="/join" modelAttribute="employee">
				<div class="form-group">
	             	<form:label path="name">Name</form:label>
	             	<form:input path="name"/>
	             	<form:errors path="name"/>
		        </div>
				<div class="form-group">
	               	<form:label path="email">Email</form:label>
             		<form:input path="email"/>
             		<form:errors path="email"/>
             		<!-- form:input type="email" path="email"/ -->
		        </div>
		       	<button type="submit" class="btn btn-primary">Submit</button>
	        </form:form>
	        
	        <c:if test="${not empty info}">
	        	<div class="alert alert-info" role="alert">
  					<strong>Info!</strong> <c:out value="${info}" /> 
				</div>
			</c:if>

	        <c:if test="${not empty success}">
	        	<div class="alert alert-success" role="alert">
  					<strong>Success!</strong> 
				</div>
			</c:if>
        </div>
	</body>
</html>

