/**
 * 
 */

const actions1 = document.getElementsByClassName("action");
const actions2 = document.querySelectorAll(".action");
const frm = document.getElementById("frm");


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
