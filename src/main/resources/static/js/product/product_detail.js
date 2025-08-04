/**
 * 
 */

const actions1 = document.getElementsByClassName("action");
const actions2 = document.querySelectorAll(".action");
const frm = document.getElementById("frm");


for(a of actions1){
	a.addEventListener("click", function(e){
		let k = e.target;
		let kind = k.getAttribute("data-kind");
		if(kind == 'd'){
			frm.setAttribute("method", "POST");
			frm.setAttribute("action", "./delete");
			frm.submit();
		}else{
			frm.setAttribute("action", "./update");
			frm.submit();
		}
	});
}