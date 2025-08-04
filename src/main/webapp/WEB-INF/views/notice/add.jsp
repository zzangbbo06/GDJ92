<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <%@ include file="/WEB-INF/views/include/head_css.jsp" %> --%>
<!-- 결과는 같지만 컴파일 시 포함되며, 코드가 현재 JSP에 복사되는것처럼 작동하고
아래 거는 실행시 포함되며 외부에서 요청하고 그 결과를 현재 위치에 삽입 -->
<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/include/sidebar.jsp"></c:import>
		
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
				<div class="container-fluid">
					<!-- page contents 내용 -->
					<h1>add Page</h1>
					<div class="card">
					  <h5 class="card-header">글작성</h5>
					  <div class="card-body">
					  	<form action="${not empty vo.boardNum ? '/notice/update' : '/notice/add'}" method="post">
					  	<input type="hidden" name="boardNum" value="${vo.boardNum }">
					 	  <label for="noticeWriter">작성자</label>
						  <input type="text" id="boardWriter" name="boardWriter" class="form-control" required value="${vo.boardWriter }"/>
						  <!-- name은 VO의 setter의 이름과 동일하게 만들어주기 -->
					      <label for="noticeTitle">제목</label>
						  <input type="text" id="boardTitle" name="boardTitle" class="form-control" required value="${vo.boardTitle }"/>
						  <br>
						  <label for="noticeContents">내용</label>
						  <textarea id="boardContents" name="boardContents" required class="form-control">${vo.boardContents }</textarea>
						  <br>
						  <button type="submit" class="btn btn-primary">작성</button>
						  <!-- type을 버튼으로 바꾸거나 js로 막아주고 ajax, 내용이 맞는지 유효성 검사 필요 -->
						 </form>
					  </div>
					</div>
				</div>
			</div>
			<!-- End Content -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
	</div>
	<c:import url="/WEB-INF/views/include/tail.jsp"></c:import>
</body>
</html>