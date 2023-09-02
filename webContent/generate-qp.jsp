<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select question</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!--  <script type="text/javascript" src="${pageContext.request.contextPath}/js/generate-criteria.js"></script>-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


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
				<form id="criteriaForm" onclick="return doForm()">
					<h4>Select a Criteria</h4>
					<hr>
					<fieldset>
						<label>Number of Questions : <input type="number"
							name="noOfQuestion" min="0" max="100" step="1" value="1"></label>
						<br />
					</fieldset>

					<fieldset class="form-group">
						<label>Category <select name="category">
								<option>GK</option>
								<option>Science</option>
								<option>History</option>
								<option>Geography</option>
						</select>
						</label>
					</fieldset>

					<fieldset class="form-group">
						<label>Complexity</label> <select name="complexity">
							<option>Simple</option>
							<option>Medium</option>
							<option>Complex</option>
						</select>
					</fieldset>

					<br />
					<button type="submit" onclick="addCriteria()"
						class="btn btn-primary">Add Criteria</button>
				</form>
				<hr>

				<button type="submit" onclick="generateQuestionPaper()"
					class="btn btn-success">Generate Question Paper</button>
			</div>
		</div>
	</div>
	<br />
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Srno</th>
						<th>Question</th>
						<th>Option1</th>
						<th>Option2</th>
						<th>Option3</th>
						<th>Option4</th>
						<th>CorrectAns</th>
						<th>Category</th>
						<th>Complexity</th>
					</tr>
				</thead>
				<tbody id="questionData">
			</table>
		</div>
	</div>

	<script>
	    let template = [];
	    function doForm() {
	    	return false;
	    }
		function addCriteria() {
			let criteriaForm = document.getElementById("criteriaForm");
			var data = new FormData(criteriaForm);
			
			var criteria = {};
			data.forEach((value, key) => criteria[key] = value);
			var json = JSON.stringify(criteria);
			template.push(criteria)
			console.log(JSON.stringify(template))
			alert("Do you want to more criteria?");
		}
		function generateQuestionPaper(){
			fetch("/QuestionPaper/generate", { method:"post", body:JSON.stringify(template) })
			  .then(res => res.text())
			  .then(txt => {
				  let data = JSON.parse(txt) 
				  console.log(data)
	               var output = data.map(q => "<tr><td>" + q.srno + "</td><td>" + q.question + "</td><td>" + q.option1 + "</td><td>" + q.option2 + "</td><td>" + q.option3 + "</td><td>" + q.option4 + "</td><td>" + q.correctAns + "</td><td>" + q.category + "</td><td>" + q.complexity + "</td></tr>");
	               $("#questionData").html(output);
				  console.log(txt)
			  })
			  .catch(err => console.error(err));

		}
	</script>

</body>
</html>