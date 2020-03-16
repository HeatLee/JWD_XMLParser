<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Index</title>
    <%@include file="jspheader/header.jsp" %>
</head>
<body>
<%@include file="jspheader/nav.jsp" %>

<form action="controller" method="post" enctype='multipart/form-data'>
    <div class="form-group row">
        <label for="file" class="col-sm-1 col-form-label">Input XML file</label>
            <input type="file" class="form-control-file col-sm-5" id="file" name="file" accept=".xml">
    </div>
    <fieldset class="form-group">
        <div class="row">
            <legend class="col-form-label col-sm-1 pt-0">Choose parser</legend>
            <div class="col-sm-5">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="command" id="SAX_PARSE" value="SAX_PARSE">
                    <label class="form-check-label" for="SAX_PARSE">
                        SAX
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="command" id="DOM_PARSE" value="DOM_PARSE">
                    <label class="form-check-label" for="DOM_PARSE">
                        DOM
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="command" id="STAX_PARSE" value="STAX_PARSE">
                    <label class="form-check-label" for="STAX_PARSE">
                        STAX
                    </label>
                </div>
            </div>
        </div>
    </fieldset>
    <button type="submit" class="btn btn btn-primary btn-lg btn-block" name="command" value="parse">Parse</button>
</form>
</body>
</html>
