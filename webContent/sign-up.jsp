<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
	<br/>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/signUpServlet"
					method="post">
					<div class="formContainer">
						<h1>Sign Up Form</h1>
						<hr>
						<label for="userName"><b>UserName</b></label> <input type="text"
							placeholder="Enter userName" name="userName" required><br />
						<br /> <label for="password"><b>Password</b></label> <input
							type="password" placeholder="Enter Password" name="password"
							required> <br /> <br /> <label for="email"><b>Email</b></label>
						<input type="text" placeholder="Enter Email" name="email" required><br />
						<br /> <label for="firstName"><b>FirstName</b></label> <input
							type="text" placeholder="Enter firstName" name="firstName"
							required><br /> <br /> <label for="lastName"><b>LastName</b></label>
						<input type="text" placeholder="Enter lastName" name="lastName"
							required><br /> <br />

						<!--  <label> <input type="checkbox"
				checked="checked" name="remember" style="marginbottom: 15px">
				Remember me </label><br/><br/>-->

						<div>
							<a href="/QuestionPaper/login.jsp" id="cancel"
								class="btn btn-success">Cancel</a>
							<button type="submit" class="btn btn-success">Sign Up</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>