<%--@elvariable id="informMessage" type="String"--%>
<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Informer_page</title>
    <%@include file="jspheader/header.jsp" %>

</head>
<body>
<%@include file="jspheader/nav.jsp" %>
<div>
    <h2>
        ${informMessage}
    </h2>
</div>

</body>
</html>