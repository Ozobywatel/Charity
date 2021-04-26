<%@ include file="/WEB-INF/views/header-main.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form>
        <div class="form-group">
            <input type="text" name="username" class="form-control form-control-user"
                   id="username" aria-describedby="emailHelp"
                   placeholder="Enter Username..." required="">
        </div>
        <div class="form-group">
            <input type="password" name="password" class="form-control form-control-user"
                   id="password" placeholder="Password" required="">
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="#" class="btn btn--without-border">Załóż konto</a>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn" type="submit" value="${_csrf.token}">Zaloguj się</button>
        </div>
    </form>
</section>

<%@ include file="/WEB-INF/views/footer.jsp" %>