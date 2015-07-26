<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
    <title>Headers</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1, user-scalable=yes">
</head>
<body>

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
