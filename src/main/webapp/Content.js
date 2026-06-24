
//StaffLogin
//document.getElementById("psw").addEventListener("focus", confirmPswd);
//Attendance.jsp
document.getElementById("Roll_No").addEventListener("blur", attendanceValidation);
//Attendance.jsp
document.getElementById("Marks").addEventListener("blur", marksFormValidation);
//StudentLogin
document.getElementById("studentUsername").addEventListener("blur", studdentLoginValidation);
//========================InsertStudent=============
document.getElementById("roll_number").addEventListener("blur", rollNumberValidation);
document.getElementById("studentName").addEventListener("blur", studentNameValidation);
document.getElementById("avgMarks").addEventListener("blur", studentMarksValidation);
document.getElementById("phoneNumber").addEventListener("blur", studentPhoneNumberValidation);
document.getElementById("formButton").addEventListener("keypress", formValidation);
document.getElementById("studentLoginFinal").addEventListener("keypress", studentLoginEntire)
//document.getElementById("stafff").addEventListener("click", staff);







// ================= Marks Validation =================
function attendanceValidation() {
	var Roll_No = document.getElementById(Roll_No).value;
	var regex = /^[0-9]+$/;
	if (regex.test(Roll_No)) {
		document.getElementById("attendanceValidation").action = "AttendanceController";
	}
	else {
		var para = document.createElement("p");

		//		document.getElementById("Roll_No").insertAdjacentElement("afterend", para);
		para.id = "info";
		para.innerHTML = "Invalid Format";
		document.getElementById("parag").appendChild(para);



	}
}

function marksFormValidation() {
	var Marks = document.getElementById("Marks").value;
	var regex = /^[0-9]+$/;
	if (regex.test(Marks)) {

		document.getElementById("Marks").addEventListener("focus", removeinfoTag);
	}
	document.getElementById("marksValidation").action = "MarksController";
}

// ================= Staff Login =================

//function confirmPswd() {
//	// prevent duplicate input
//	//	if (document.getElementById("repswd")) return;
//
//	var input = document.createElement("input");
//	input.type = "password";
//	input.placeholder = "Confirm password";
//	input.id = "repswd";
//
//	document.getElementById("c-psw").appendChild(input);
//	var confirmPassword = document.getElementById("repswd").value;
//	if(confirmPassword !== ""){
//
//	document.getElementById("repswd").addEventListener("blur", checkPasswordMatch);
//	}
//}
//
//function checkPasswordMatch() {
//
//	var status = false;
//	var actualpswd = document.getElementById("psw").value;
//	var repswd = document.getElementById("repswd").value;
//	//	if(actualpswd==="" && repswd==="" ){
//	//		
//	//	}
//	var para = document.getElementById("msg");
//	if (actualpswd !== repswd) {
//		para.innerHTML = "Passwords do not match";
//		para.style.color = "red";
//	} else {
//		status = true;
//		para.innerHTML = "Passwords match";
//		para.style.color = "green";
//		document.getElementById("stafff").addEventListener("click", staff);
//
//
//
//	}
//	console.log(status);
//	return status;
//}
//function staff() {
//	document.getElementById("staffLoginValidation").action = "StaffLoginController";
//
//}




//=========================Student Login============================
function studdentLoginValidation() {
	document.getElementById("studentUsername").value;
	document.getElementById("studentPassword").value;
	var status = false;
	var regex = /^[0-9]+$/;
	if (regex.test(rollNumber)) {
		status = true;
	}
	else {
		status = false;
	}
	return status;

}
function studentLoginEntire() {
	if (studdentLoginValidation) {
		document.getElementById("studentLoginValidationForm").action = "StudentLoginController";

	}
	else {
		document.getElementById("Logininfo").innerHTML = "Invalid Details";
	}

}


//=======================insertStudentValidation============================
function rollNumberValidation() {
	var status = false;
	var rollNumber = document.getElementById("roll_number").value;
	var regex = /^[0-9]+$/;
	if (regex.test(rollNumber)) {
		status = true;
	} else {
		var para = document.createElement("div");
		para.id = "infopara";
		para.innerHTML = "Invalid Roll Number Format (only numbers allowed)";
		document.getElementById("roll_number").parentNode.appendChild(para);
	}
	return status;
}

function studentNameValidation() {
	var status = false;
	var studentName = document.getElementById("studentName").value;
	var regex = /^[A-Za-z\s]+$/;
	if (regex.test(studentName)) {
		status = true;
	} else {
		var para = document.createElement("div");
		para.id = "infopara";
		para.innerHTML = "Invalid Student Name (only letters allowed)";
		document.getElementById("studentName").parentNode.appendChild(para);
	}
	return status;
}

function studentMarksValidation() {
	var status = false;
	var avgMarks = document.getElementById("avgMarks").value;
	var regex = /^(100|[0-9]{1,2})$/;
	if (regex.test(avgMarks)) {
		status = true;
	} else {
		var para = document.createElement("div");
		para.id = "infopara";
		para.innerHTML = "Invalid Marks (must be between 0 and 100)";
		document.getElementById("avgMarks").parentNode.appendChild(para);
	}
	return status;
}

function studentPhoneNumberValidation() {
	var status = false;
	var phoneNumber = document.getElementById("phoneNumber").value;
	var regex = /^[6-9][0-9]{9}$/;
	if (regex.test(phoneNumber)) {
		status = true;
	} else {
		var para = document.createElement("div");
		para.id = "infopara";
		para.innerHTML = "Invalid Phone Number (must be 10 digits starting with 6–9)";
		document.getElementById("phoneNumber").parentNode.appendChild(para);
	}
	return status;
}
function formValidation() {
	if (rollNumberValidation() && studentMarksValidation() && studentNameValidation() && studentPhoneNumberValidation()) {
		document.getElementById("insertStudentValidationForm").action = "InsertStudentController";
	}
	else {
		document.getElementById("insertStudentValidation").innerHTML = "Invalid Details";
	}
}