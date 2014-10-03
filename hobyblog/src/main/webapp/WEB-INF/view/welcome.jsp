<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<div class="text-center">
		<img src='<c:url value="/resources/img/logo.png"/>' id="logoimg"
			alt=" Logo" />
	</div>
	<div class="tab-content">
		<div id="login" class="tab-pane active">
			<form name='f' action='${pageContext.request.contextPath}/check'
				method='POST' class="form-signin check">
				<p class="text-muted text-center btn-block btn btn-primary btn-rect">
					Enter your email and password</p>
				<input type='text' name='email' id="email" value=''
					placeholder="Email" required="required" class="form-control">
				<input type='password' name='password' placeholder="password"
					required="required" class="form-control" />
				<div class="checkbox">
					<label> <input type='checkbox' name='remember' /> Remember
						Me
					</label>
				</div>
				<input name="submit" type="submit" value="Sign in"
					class="btn text-muted text-center btn-danger" />

			</form>
		</div>
		<div id="forgot" class="tab-pane">
			<form:form modelAttribute="person" method="Post"
				action="${pageContext.request.contextPath}/recover"
				class="form-signin recover">
				<p class="text-muted text-center btn-block btn btn-primary btn-rect">Enter
					your valid e-mail</p>
				<form:input path="email" id="email" type="text" required="required"
					placeholder="Your E-mail" class="form-control" />
				<br />
				<button class="btn text-muted text-center btn-success" type="submit">Recover
					Password</button>
			</form:form>
		</div>
		<div id="signup" class="tab-pane">
			<form:form method="POST"
				action="${pageContext.request.contextPath}/create"
				modelAttribute="person" class="form-signin create">
				<p class="text-muted text-center btn-block btn btn-primary btn-rect">Please
					Fill Details To Register</p>
				<form:input path="fname" type="text" placeholder="First Name"
					class="form-control" />
				<form:input path="lname" type="text" placeholder="Last Name"
					class="form-control" />
				<form:input path="username" type="text" placeholder="Username"
					class="form-control" />
				<form:input path="email" id="email" required="required"
					placeholder="Your E-mail" class="form-control" />
				<br />
				<button class="btn text-muted text-center btn-success" type="submit">Register</button>
			</form:form>
		</div>
	</div>
	<div class="text-center">
		<ul class="list-inline">
			<li><a class="text-muted" href="#login" data-toggle="tab">Login</a></li>
			<li><a class="text-muted" href="#forgot" data-toggle="tab">Forgot
					Password</a></li>
			<li><a class="text-muted" href="#signup" data-toggle="tab">Signup</a></li>
		</ul>
	</div>
</div>
<script>
	$(document).ready($(".check").validate({
		rules : {
			email : {
				required : true,
				email : true
			}
		}
	}), $(".recover").validate({
		rules : {
			email : {
				required : true,
				email : true,
				remote : {
					url : "<spring:url value='/available/1' />",
					type : "get",
					data : {
						username : function() {
							return $("#email").val();
						}

					}
				}
			}

		},
		messages : {
			email : {
				remote : "Use exists Email"
			}
		}
	}), $(".create").validate({
		rules : {
			email : {
				required : true,
				email : true,
				remote : {
					url : "<spring:url value='/available/0' />",
					type : "get",
					data : {
						username : function() {
							return $("#email").val();
						}

					}
				}
			}

		},
		messages : {
			email : {
				remote : "chose anathor email"
			}
		}

	}));
</script>
<style>
.error {
	
}
</style>