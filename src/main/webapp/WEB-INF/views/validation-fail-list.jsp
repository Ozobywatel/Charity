<%@ include file="/WEB-INF/views/header-form.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="slogan container container--90">
    <h2>Uwaga! Podczas wypełniania formularza wystąpiły następujące błędy:</h2><br></div>

<div class="slogan container container--90">

<c:forEach items="${errors}" var="error2">
    <h3>${error2.defaultMessage}</h3><br>
</c:forEach>

Spróbuj jeszcze raz!
<a href="<c:url value="/new_donation#form"/>" class="btn btn--without-border">Przekaż dary</a>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>