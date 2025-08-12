/**
 * 
 */


document.addEventListener("submit", function(){
const form = document.getElementById('registerForm');
const firstName = document.getElementById("firstName").value.trim();
const lastName = document.getElementById("lastName").value.trim();
const userName = document.getElementById("username")

	form.addEventListener('submit', function (e) {
	    // 비번 일치 체크(원하면 생략 가능)
	    if (pw.value !== pwc.value) {
	      e.preventDefault();
	      alert('비밀번호가 일치하지 않습니다.');
	      return;
	    }
	userName.value=firstName + " " + lastName;
});
});