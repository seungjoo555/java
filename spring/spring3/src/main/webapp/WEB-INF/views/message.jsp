<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메세지</title>
</head>
<body>
<script type="text/javascript">
<c:if test="${msg != null}">
	alert('${msg}');
</c:if>
location.href = '<c:url value="${url}"/>';
</script>
</body>
</html>