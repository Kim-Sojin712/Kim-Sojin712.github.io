function checkForm() {
	const password = document.join.password.value;
	const confirmPassword = document.join.password_confirm.value;

	if (!document.join.id.value) {
		alert("아이디를 입력해주세요.");
		return false;
	}
	if (!document.join.password.value) {
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	if (password !== confirmPassword) {
		alert("비밀번호를 동일하게 입력해주세요.");
		return false;
	}
	if (document.join.security_question.value == "") {
		alert("보안 질문을 선택해주세요.");
		return false;
	}
	if (!document.join.sequrity_answer.value) {
		alert("보안 질문 답변을 입력해주세요.");
		return false;
	}
	if (!document.join.name.value) {
		alert("이름을 입력해주세요.");
		return false;
	}
	if (!document.join.gender.value) {
		alert("성별을 선택해주세요.");
		return false;
	}
	if (!document.join.birthyy.value) {
		alert("출생 연도를 입력해주세요.");
		return false;
	}
	if (document.join.birthmm.value == "") {
		alert("태어난 월을 입력해주세요.");
		return false;
	}
	if (document.join.birthdd.value == "") {
		alert("태어난 날을 선택해주세요.");
		return false;
	}
	if (!document.join.phone.value) {
		alert("전화번호를 입력해주세요.");
		return false;
	}
	if (!document.join.terms.value) {
		alert("약관에 동의해주세요.");
		return false;
	}

	return true;
}

document.getElementById('postcode').onclick = function() {
	new daum.Postcode({
		oncomplete: function(data) {
			document.querySelector('input[name="postcode"]').value = data.zonecode;
			document.querySelector('input[name="addr1"]').value = data.roadAddress;
		}
	}).open();
};

document.join.password_confirm.addEventListener('input', function() {
	const password = document.join.password.value;
	const confirmPassword = this.value;
	const passwordHelpInline = document.getElementById('passwordHelpInline');
	
	if (password && confirmPassword && password !== confirmPassword) {
		passwordHelpInline.style.display = 'block';
	} else {
		passwordHelpInline.style.display = 'none';
	}
});