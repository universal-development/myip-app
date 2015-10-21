<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My IP</title>
</head>
<body>
<h1>My IP</h1>

<a href="/ip">List request IP</a>
<a href="/headers">List request headers</a>

<hr/>
<div align="center">
    <h1>IP : ${ip}</h1>
</div>

<table border="1">
    <tr><td width="20%;">Header</td><td>Value</td></tr>
    <c:forEach var="entry" items="${headers}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
