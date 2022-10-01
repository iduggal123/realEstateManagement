$('#signupform').submit(function() {
	signup();
	return false;
});


$('#loginform').submit(function() {
	login();
	return false;
});

$('#user--logout').click(function() {
	logout();
	return false;
});

function logout() {
	//in case of logout, just delete the cookie and reditect to login page as it is just an assignment.
	deleteCookie('userinfo');
	window.location.href = "login";
}


function signup() {

	var email = document.getElementById("user--address").value;
	var password = document.getElementById("user--password").value;
	var confirmPassword = document.getElementById("user--confirm--password").value;
	var phone = document.getElementById("user--phone").value;

	var submit = document.getElementById("signupButton");
	var status = document.getElementById("signup--status");
	status.setAttribute('style', 'display:block');
	status.innerHTML = "Please wait <i class='fa fa-spinner'></i>";

	if (password !== confirmPassword) {
		status.innerHTML = "Password did not match."
		return false;
	}
	var params = {};
	params.clientName = email;
	params.clientContactNumber = phone;
	params.clientEmailAddress = email;
	params.clientPassword = btoa(password);
	params.confpassword = btoa(confirmPassword);
	var url = "/users/signup";
	setTimeout(function() {
		$.when(httpPost(url, params, true)).then(function(response) {
			submit.innerHTML = 'Signup';
			if (response.errorCode == 0) {
				window.setTimeout(function() {
					status.innerHTML = "User is registered successfully. Redirecting to login page."
					window.location.href = "login";
				}, 5000);
			} else {

				window.setTimeout(function() {
					status.innerHTML = response.error;

				}, 1000);
			}
		});
	});
}

function login() {
	var email = document.getElementById("user--address").value;
	var password = document.getElementById("user--password").value;

	var submit = document.getElementById("loginButton");
	var status = document.getElementById("login--status");
	status.setAttribute('style', 'display:block');
	status.innerHTML = "Please wait <i class='fa fa-spinner'></i>";

	var params = {};
	params.clientEmailAddress = email;
	params.clientPassword = btoa(password);
	var url = "/users/login";
	setTimeout(function() {
		$.when(httpPost(url, params, true)).then(function(response) {
			submit.innerHTML = 'Login';
			if (response.errorCode == 0) {
				window.setTimeout(function() {
					status.innerHTML = "Logged in, here we go."
					window.location.href = "list";
				}, 1000);
			} else {

				window.setTimeout(function() {
					status.innerHTML = response.error;

				}, 1000);
			}
		});
	});
}