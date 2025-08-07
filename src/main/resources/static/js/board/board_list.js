/**
 * 
 */

const pn = document.querySelectorAll(".pn");
const pn1 = document.getElementsByClassName("pn");
const searchForm = document.getElementById("searchForm");
const pageNum = document.querySelector("#pageNum");
console.log(pn);
console.log(pn1);

pn.forEach(function(item){
	item.addEventListener("click",(e)=>{
		let n = e.target.getAttribute("data-pn")
		pageNum.value=n;
		searchForm.submit();
	});
});

/*for(a of pn){
	a. addEvenListener("click",function(e){
		let k = e.target;
		let kind = k.getAttribute()
	})
}*/