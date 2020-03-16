<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>result_page</title>
    <%@include file="jspheader/header.jsp" %>
</head>
<body>
<%@include file="jspheader/nav.jsp" %>
<div class="row row-cols-1 row-cols-md-3">
    <div class="col mb-4">
        <div class="card">
            <%--@elvariable id="tariffs" type="by.training.xmlparser.entity.Tariff"--%>
            <c:forEach var="tariff" items="${tariffs}">
                <div class="card-header">${tariff.name}</div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">${tariff.operatorName}</li>
                    <li class="list-group-item">Payroll ${tariff.payroll}</li>
                    <li class="list-group-item">SMS price ${tariff.SMSPrice}</li>
                    <li class="list-group-item">Within network call price ${tariff.callPrice.withinNetworkPrice}</li>
                    <li class="list-group-item">Call price for other network ${tariff.callPrice.otherNetworkPrice}</li>
                    <li class="list-group-item">Call price for standard phone
                        number ${tariff.callPrice.standardPhoneNumbersPrice}</li>
                    <li class="list-group-item">Can contains favourite phone
                        numbers ${tariff.parameters.containsFavouritePhoneNumbers}</li>
                    <li class="list-group-item">Tariffing ${tariff.parameters.tariffing}</li>
                    <li class="list-group-item">Connection cost ${tariff.parameters.connectionCost}</li>
                </ul>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
