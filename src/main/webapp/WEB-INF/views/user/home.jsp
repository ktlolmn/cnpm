<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="partials/header.jsp" %>
<div>
    <h2>Danh sách người dùng</h2>
    <h1>${username}</h1>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Password</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="partials/footer.jsp" %>
