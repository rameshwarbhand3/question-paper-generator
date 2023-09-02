<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- <script type="text/javascript">
	function preventBack() {
		window.history.forward();
	}
	setTimeout("preventBack()", 0);
	window.onunload = function() {
		null
	};
</script> -->
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div align="center">
				<h2 class="text-white">Question Paper Generator</h2>
			</div>
		</nav>
	</header>
	<br />
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<div align="center">
					<h1>User Login form</h1>

					<form action="<%=request.getContextPath()%>/loginServlet"
						method="post">
						UserName : <input type="text" name="username"><br /> <br />
						Password : <input type="password" name="password"><br />
						<br />
						<button type="submit" class="btn btn-success">Login</button>
						<a href="<%=request.getContextPath()%>/sign-up.jsp"> Sign Up </a>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>