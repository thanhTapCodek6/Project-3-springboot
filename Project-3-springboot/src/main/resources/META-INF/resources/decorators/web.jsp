<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property="title"/></title>
    <sitemesh:write property="head"/>
</head>
<body>
    <jsp:include page="/WEB-INF/commons/web/header.jsp" />

    <sitemesh:write property="body"/>

    <jsp:include page="/WEB-INF/commons/web/footer.jsp" />
</body>
</html>