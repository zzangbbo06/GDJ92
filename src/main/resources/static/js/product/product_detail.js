/**
 * 
 */

const actions1 = document.getElementsByClassName("action");
const actions2 = document.querySelectorAll(".action");
const frm = document.getElementById("frm");
const cartAdd = document.getElementById("cartAdd");
/*const checkAll = document.getElementById("checkAll");

checkAll.addEventListener("change",(e)=>{
	const chs = document.querySelectorAll(".ch");
	for(let ch of chs){
		ch.checked = e.target.checked;
	}
	
})*/

for (let a of actions1) {
  a.addEventListener("click", function (e) {
    let kind = this.getAttribute("data-kind"); // 또는 e.currentTarget.getAttribute("data-kind")
    if (kind === 'd') {
      frm.setAttribute("method", "POST");
      frm.setAttribute("action", "./delete");
    } else {
      frm.setAttribute("method", "GET");
      frm.setAttribute("action", "./update");
    }

    frm.submit();
  });
}

cartAdd.addEventListener("click", ()=>{
	let params = new URLSearchParams();
	params.append("productNum", cartAdd.getAttribute("data-product-num"));
	
	fetch("/member/cartAdd", {
		method:"post",
		body: params
	})
	.then(r=>r.json())
	.then(r=>{
		if(r>0){
			let result = confirm("장바구니에 담으시겠습니까?")
			if(result){
				location.href="/member/cartList"
			}
		}
	})
	.catch(e=>{
		alert("등록 실패")
	})
})