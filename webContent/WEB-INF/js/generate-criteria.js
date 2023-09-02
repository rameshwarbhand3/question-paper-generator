/**
 * 
 */

let criteriaForm = document.getElementById("criteriaForm");

criteriaForm.addEventListener("submit", (e) => {
	e.preventDefault();

	console.log("Inside submit event");

	let username = document.getElementById("username");
	let password = document.getElementById("password");

	if (username.value == "" || password.value == "") {
		alert("Ensure you input a value in both fields!");
	} else {
		// perform operation with form input
		alert("This form has been successfully submitted!");
		console.log(
			`This form has a username of ${username.value} and password of ${password.value}`
		);

		username.value = "";
		password.value = "";
	}
});