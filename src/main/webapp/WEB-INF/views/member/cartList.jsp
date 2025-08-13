<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Profile</title>
  <%@ include file="/WEB-INF/views/include/head_css.jsp"%>
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
									<th>
										<div class="form-check">
										  <input class="form-check-input" type="checkbox" value="" id="checkAll">
										  <label class="form-check-label" for="checkAll">
										    전체선택
										  </label>
										</div>
									</th>
									<th>상품명</th>
									<th>이자율</th>
									<th>상품종류</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${cart }" var="vo">
							
								<tr>
									 <td>
										<div class="form-check">
										  <input class="form-check-input ch" type="checkbox" value="${vo.productNum }" >								  
										</div>
									</td> 
									
									<!-- 받으려는 setter의 이름과 같게 -->
									<td><a href="./detail?productNum=${vo.productNum }">${vo.productName }</a></td>
									<td>${vo.productRate }</td>
									<td>${vo.productKindVO.kindName }</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- End Content -->
				</div>
			</div>
			<!-- End Content -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
	</div>
	<c:import url="/WEB-INF/views/include/tail.jsp"></c:import>
</body>
</html>
