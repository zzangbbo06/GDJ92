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
					  	<form action="${detail != null ? '/products/update' : '/products/add'}" method="post">
					  	<input type="hidden" name="productNum" value="${detail.productNum }">
					      <label for="productName">상품이름</label>
						  <input type="text" id="productName" name="productName" class="form-control" required value="${detail.productName }"/>
						  <br>
						  <label for="productContents">상품내용</label>
						  <textarea id="productContents" name="productContents" required class="form-control">${detail.productContents }</textarea>
						  <br>
					 	  <label for="productRate">할인율</label>
						  <input type="text" id="productRate" name="productRate" class="form-control" required value="${detail.productRate }"/>
						  <br>
						  <label for="kindNum">상품종류:</label>
							<select name="kindNum" id="kindNum">
							  <option value="1" <c:if test="${detail.kindNum eq '1'}">selected</c:if>>예금</option>
								<option value="2" <c:if test="${detail.kindNum eq '2'}">selected</c:if>>적금</option>
								<option value="3" <c:if test="${detail.kindNum eq '3'}">selected</c:if>>대출</option>
							</select>
						  <!-- name은 VO의 setter의 이름과 동일하게 만들어주기 -->
						  <button type="submit" class="btn btn-primary">
						    ${detail != null ? '수정' : '등록'}
						  </button>
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