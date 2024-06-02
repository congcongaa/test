<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title></title>
	<link rel="stylesheet" href="css/style.css"/>
  </head>
  <body>
  	<%-- jsp의 액션 요소 중 다른 jsp 의 결과를 포함시키는 요소:include --%>	
  	<jsp:include page="menu.jsp"/>
  	<%-- 현 위치에 menu.jsp를 실행결과(html)를 포함시킨다. --%>
  </body>
</html>