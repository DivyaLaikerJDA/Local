function doValidate() {
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	if(email == null || email == ""){
		alert("Email cannot be null")
	}else if (email != null || email != "") {
		var emailRegex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		alert("Invalid Email ");
		return emailRegex.test(email);
		//return false;
	} else if (password == null || password == "") {
		alert("invalid password");
		return false;
	} else {
		return true;
	}
}