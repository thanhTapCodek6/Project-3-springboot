<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><decorator:title default="Project 3" /></title>
    <decorator:head />
</head>
<body>
    <jsp:include page="/WEB-INF/commons/web/header.jsp" />

    <decorator:body />

    <jsp:include page="/WEB-INF/commons/web/footer.jsp" />
</body>
</html>