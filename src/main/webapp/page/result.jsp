<%@ page language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>result_page</title>
    <%@include file="jspheader/header.jsp" %>
</head>
<body>
<%@include file="jspheader/nav.jsp" %>
<div>
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">Tariff name</th>
            <th scope="col">Operator name</th>
            <th scope="col">Payroll</th>
            <th scope="col">SMSPrice</th>
            <th scope="col">Within network call price</th>
            <th scope="col">Call price for other network</th>
            <th scope="col">Call price for standard phone number</th>
            <th scope="col">Can contains favourite phone numbers</th>
            <th scope="col">Tariffing</th>
            <th scope="col">Connection cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tariff" items="${tariffs}">
            <tr>
                <td>${tariff.name}</td>
                <td>${tariff.operatorName}</td>
                <td>${tariff.pay roll}</td>
                <td>${tariff.SMSPrice}</td>
                <td>${tariff.callPrice.withinNetworkPrice}</td>
                <td>${tariff.callPrice.otherNetworkPrice}</td>
                <td>${tariff.callPrice.standardPhoneNumbersPrice}</td>
                <td>${tariff.parameters.containsFavouritePhoneNumbers}</td>
                <td>${tariff.parameters.tariffing}</td>
                <td>${tariff.parameters.connectionCost}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
