<%@ page language="java"  pageEncoding="UTF-8" %>

<html>
<head>
    <title>Index</title>
    <%@include file="jspheader/header.jsp" %>
</head>
<body>
<%@include file="jspheader/nav.jsp" %>

<form action="controller" method="post" enctype='multipart/form-data'>
    <div class="form-group">
        <label for="file">Input XML file to parse</label>
        <input type="file" class="form-control-file" id="file"  name="file" accept=".xml">
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="command" id="SAX_PARSE" value="SAX_PARSE">
        <label class="form-check-label" for="SAX_PARSE">
            SAX_PARSE
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="command" id="DOM_PARSE" value="DOM_PARSE">
        <label class="form-check-label" for="DOM_PARSE">
            DOM_PARSE
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="command" id="STAX_PARSE" value="STAX_PARSE">
        <label class="form-check-label" for="STAX_PARSE">
            STAX_PARSE
        </label>
    </div>
    <button type="submit" class="btn btn-primary" name="command" value="parse">Parse</button>
</form>
</body>
</html>
