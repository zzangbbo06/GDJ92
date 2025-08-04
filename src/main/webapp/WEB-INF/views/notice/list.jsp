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
					<div class = "row col-md-8 offset-md-2">
					<!-- 부트스트랩은 12칸을 차지함 -->
						<table class="table table-dark table-striped">
							<thead>
								<tr>
									<th>Num</th>
									<th>Title</th>
									<th>Writer</th>
									<th>Date</th>
									<th>Hit</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list }" var="vo">
							
								<tr>
									<td>${vo.boardNum }</td>
									<td><a href="./detail?boardNum=${vo.boardNum }">${vo.boardTitle }</a></td>
									<!-- 받으려는 setter의 이름과 같게 -->
									<td>${vo.boardWriter }</td>
									<td>${vo.boardDate }</td>
									<td>${vo.boardHit }</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<div>
						<a href="./add" class="btn btn-outline-danger">글쓰기</a>
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