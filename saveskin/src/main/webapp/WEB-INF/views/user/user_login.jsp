<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp" %>
<link rel="stylesheet" href="${rootPath}/static/css/login.css?ver=2022-06-05-1">
</head>
<body>
<%@ include file="/WEB-INF/views/include/include_nav.jsp" %>
<section>
      <div class="mainbox">
        <div class="line">
          <h1>로그인</h1>
        </div>
        <article class="login">
          <form method="POST" autocomplete="off">
            <fieldset>
              <div class="infoinput">
                <i class="fa-solid fa-user"></i>
                <input type="text" name="userid"placeholder="아이디를 입력해주세요" />
              </div>
              <div class="infoinput">
                <i class="fa-solid fa-lock"></i>
                <input type="text" name="password" placeholder="비밀번호를 입력해주세요" />
              </div>
              <div class="btnbox">
                <button class="btn" id="loginalertStart">
                  로그인
                </button>
              </div>
            </fieldset>
          </form>
          <div class="gotojoin">
            <p>
              계정이 없으신가요? &gt;
              <a href="${rootPath}/user/user_join">회원가입</a> 하러가기
            </p>
          </div>
          <div class="login_info">
		
		<h3>${LOGIN.message}</h3>
	
	<c:choose>
			<c:when test="${not empty USER}">
				<h3>로그인 성공</h3>
				<p><strong>USERNAME :</strong>${USER.username}</p>
				<p><strong>NAME :</strong>>${USER.name}</p>
				<p><strong>EMAIL :</strong>>${USER.email}</p>
				
			</c:when>
			<c:when test="${ empty USER}">
				<h3>로그인 실패</h3>
				<p><strong>USERNAME :</strong>${USER.username}</p>
				<p><strong>NAME :</strong>>${USER.name}</p>
				<p><strong>EMAIL :</strong>>${USER.email}</p>
				
			</c:when>
		</c:choose>
		
	</div>
        </article>
      </div>
</section>


<%@ include file="/WEB-INF/views/include/include_footer.jsp" %>
</body>
</html>