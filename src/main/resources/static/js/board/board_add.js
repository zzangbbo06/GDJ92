/**
 * 
 */
const add = document.getElementById("add");
const result = document.getElementById("result");
const del = document.querySelectorAll(".del")
/*const curCount = result.querySelectorAll(".mb-3").length;*/
const deleteFile = document.querySelectorAll(".deleteFile");
let count = parseInt(result.getAttribute("data-file-count"));
/*숫자로 인식을 못할수도 있기 때문에 숫자로 바꾸기*/

//-------------------------------------------------

deleteFile.forEach((item)=>{
	item.addEventListener("click", function(){
		//fetch, axios
		let params = new URLSearchParams();
		params.append("fileNum", 2);
		let num =1;
		fetch(`./fileDelete`, {
			method:"post",
			body:params
		})
		.then(r=>r.json())
		.then(r=>{
			console.log(r);
		})
	});
});




// ----------------------------------------------------
add.addEventListener("click", ()=>{
	/*result.innerHTML +=`<div class="mb-3">
				  		<input type="file" class="form-control" name="attaches">
						<button class="del" type="button">X</button>
					  </div>`*/
	let div = document.createElement("div"); //<div></div>
	div.classList.add("mb-3")				 //<div class="mb-3"></div>
	
	let ch = document.createElement("input");
	ch.setAttribute("type", "file");
	ch.setAttribute("maxlength", "5")
	ch.classList.add("form-controal");
	ch.setAttribute("name", "attaches");
	
	div.append(ch);
	
	ch = document.createElement("button");
	ch.classList.add("del");
	ch.setAttribute("type", "button");
	ch.innerText="X";
	
	div.append(ch);
	
	result.append(div);
/*이렇게 하지 않으면 ADD누를때마다 첨부된 파일도 초기화 되어짐*/


	count++;
	if(count > 5){
		alert("최대 5개까지만 추가할 수 있습니다.")
		return;
	}
});					  

result.addEventListener("click", (e)=>{
	if(e.target.classList.contains("del")){
		e.target.parentElement.remove();
		/*부모요소가 선택되어짐*/
		
		/*const targetDiv = e.target.closest(".mb-3");
		if(targetDiv){
			targetDiv.remove();
		}*/
	}
});				  


/*$("#result").on("click", ".del", ()=>{
	
})
*/
