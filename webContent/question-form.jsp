<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Question Paper Generator System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					Question Paper Generator System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Questions</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${question != null}">
					<form action="edit" method="post">
				</c:if>
				<c:if test="${question == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${question != null}">
                                    Edit Question
                                </c:if>
						<c:if test="${question == null}">
                                    Add New Question
                                </c:if>
					</h2>
				</caption>

				<c:if test="${question != null}">
					<input type="hidden" name="srno"
						value="<c:out value='${question.getSrno()}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Question name</label> <input type="text"
						value="<c:out value='${question.getQuestion()}' />"
						class="form-control" name="question" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>OptionA</label> <input type="text"
						value="<c:out value='${question.getOption1()}' />"
						class="form-control" name="optionA" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>OptionB</label> <input type="text"
						value="<c:out value='${question.getOption2()}' />"
						class="form-control" name="optionB" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>OptionC</label> <input type="text"
						value="<c:out value='${question.getOption3()}' />"
						class="form-control" name="optionC" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>OptionD</label> <input type="text"
						value="<c:out value='${question.getOption4()}' />"
						class="form-control" name="optionD" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>CorrectAns</label> <select name="correctAns">

						<option ${question.correctAns eq 'A' ? 'selected' : '' }>A</option>
						<option ${question.correctAns eq 'B' ? 'selected' : '' }>B</option>
						<option ${question.correctAns eq 'C' ? 'selected' : '' }>C</option>
						<option ${question.correctAns eq 'D' ? 'selected' : '' }>D</option>

					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Category</label> <select name="category">
						<option ${question.category eq 'GK' ? 'selected' : '' }>GK</option>
						<option ${question.category eq 'Science' ? 'selected' : '' }>Science</option>
						<option ${question.category eq 'History' ? 'selected' : '' }>History</option>
						<option ${question.category eq 'Geography' ? 'selected' : '' }>Geography</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Complexity</label> <select name="complexity">
						<option ${question.complexity eq 'Simple' ? 'selected' : '' }>Simple</option>
						<option ${question.complexity eq 'Medium' ? 'selected' : '' }>Medium</option>
						<option ${question.complexity eq 'Complex' ? 'selected' : '' }>Complex</option>
					</select>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>

				</form>
			</div>
		</div>
	</div>
</body>

</html>