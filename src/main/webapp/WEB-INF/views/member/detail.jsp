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
  <c:import url="/WEB-INF/views/include/sidebar.jsp"/>
  <div id="content-wrapper" class="d-flex flex-column">
    <div id="content">
      <c:import url="/WEB-INF/views/include/topbar.jsp"/>
      <div class="container-fluid">

        <div class="card shadow mb-4">
          <div class="card-body">
            <div class="row g-3">
              <!-- 프로필 이미지 -->
              <div class="col-md-3 text-center">
                <c:choose>
                  <c:when test="${not empty member.profileVO and not empty member.profileVO.saveName}">
                    <img class="img-fluid rounded-circle"
                         src="<c:url value='/files/member/${member.profileVO.saveName}'/>"
                         alt="profile">
                  </c:when>
                  <c:otherwise>
                    <img class="img-fluid rounded-circle"
                         src="<c:url value='/img/no-profile.png'/>"
                         alt="no profile">
                  </c:otherwise>
                </c:choose>
                <!-- 사진 변경 (선택) -->
                <form action="<c:url value='/member/profile/upload'/>" method="post" enctype="multipart/form-data" class="mt-3">
                 
                  <input type="file" name="profile" class="form-control form-control-sm">
                  <input type="hidden" name="${_csrf.parameterName}" value="${member.profileVO.saveName}">
                  <button class="btn btn-sm btn-secondary mt-2">사진 변경</button>
                </form>
              </div>

              <!-- 프로필 정보 -->
              <div class="col-md-9">
                <h4 class="mb-3">
                  <c:out value="${member.name}"/>
                  <small class="text-muted">@<c:out value="${member.username}"/></small>
                </h4>

                <dl class="row">
                  <dt class="col-sm-3">Email</dt>
                  <dd class="col-sm-9"><c:out value="${member.email}"/></dd>

                  <dt class="col-sm-3">Phone</dt>
                  <dd class="col-sm-9"><c:out value="${member.phone}"/></dd>

                </dl>

                

      </div>
    </div>
    <c:import url="/WEB-INF/views/include/footer.jsp"/>
  </div>
</div>
<c:import url="/WEB-INF/views/include/tail.jsp"/>
</body>
</html>
