/**
 * 
 */

// 전체 체크박스를 클릭했을 때
const checkAll = document.getElementById("checkAll");
const ch = document.querySelectorAll(".ch");
const del = document.querySelector("#del");
const frm = document.getElementById("frm");
const add = document.getElementById("add");

add.addEventListener("click", ()=>{
	//체크 된것들이 하나 이상인지 검증
	frm.setAttribute("action","/account/add");
	frm.submit();
})

checkAll.addEventListener("click",()=>{
	ch.forEach((item)=>{
		
		/*checked속성에 true를 넣어줘 */
		item.checked = checkAll.checked;
		
	})
});

ch.forEach(items =>{
	items.addEventListener("click",()=>{
		let allChecked = true;
		for(let c of ch){
			if(!c.checked){
				allChecked = false;
				break;
			}
		}
		
		checkAll.checked = allChecked;
	})
})

del.addEventListener("click",()=>{
	//체크 된것들이 하나 이상인지 검증
	frm.submit();
})

/*action.addEventListener("click", function() {

    let flag = confirm("정말 삭제하시겠습니까?");
    if (!flag) {
        return;
    }

    for (let i = 0; i < ch.length; i++) {
        if (ch[i].checked) {

            let params = new URLSearchParams();
            params.append("productNum", ch[i].value);

            fetch("./cartDelete", {
                method: "post",
                body: params
            })
            .then(r => r.text())
            .then(r => {
                if (r.trim() == "1") { // 서버에서 1 반환 시 성공
                    ch[i].closest("tr").remove();
                } else {
                    alert("삭제 실패");
                }
            });
        }
    }

});
*/


// 마지막 요소의 상태만 반영됩니다.
//flag는 "전체 상태를 누적해서 저장하는 임시 변수" 역할
// 반복 도중 중간 결과로 checkAll.checked를 바꾸면
//마지막 요소 기준으로만 상태가 정해져 버리기 때문에 올바르지 않음
//flag 같은 누적 변수가 있으면 모든 항목을 평가한 뒤 한 번만 결과를 반영할 수 있음
/* flag = true;
ch.forEach((c)=>{
	if(!c.checked){
		flag = false;
		return;
	}
	checkAll.checked =  flag;
})*/

/*$("#checkAll").on("click", function() {
    $(".ch").prop("checked", this.checked);
});

// 개별 체크 클릭 → 전체 체크 상태 갱신
$(".ch").on("click", function() {
    $("#checkAll").prop("checked", $(".ch:checked").length === $(".ch").length);
});*/