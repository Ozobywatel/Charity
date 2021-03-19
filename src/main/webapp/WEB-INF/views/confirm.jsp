<%@ include file="/WEB-INF/views/header-form.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Oddaj rzeczy, których już nie chcesz<br/>
            <span class="uppercase">potrzebującym</span>
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span>Wybierz rzeczy</span></div>
                </li>
                <li>
                    <div><em>2</em><span>Spakuj je w worki</span></div>
                </li>
                <li>
                    <div><em>3</em><span>Wybierz fundację</span></div>
                </li>
                <li>
                    <div><em>4</em><span>Zamów kuriera</span></div>
                </li>
            </ul>
        </div>
    </div>
</div>
</header>

<section class="form--steps">

    <div class="form--steps-container">

        <form:form method="post" modelAttribute="donation">
            <div data-step="1" class="active">
                <h3>Podsumowanie Twojej darowizny</h3>
                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz worki (łącznie <c:out value="${donation.quantity}"/> sztuk) z następujących
                            kategorii:</h4>
                        <ul>
                            <c:forEach items="${donation.categories}" var="category">
                                <li>
                                    <span class="icon icon-bag"></span>
                                    <span class="summary--text">
                        <c:out value="${category.name}"/></span>
                                </li>
                            </c:forEach>
                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >Dla fundacji <c:out value="${donation.institution.name}"/></span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li><c:out value="${donation.street}"/></li>
                                <li><c:out value="${donation.city}"/></li>
                                <li><c:out value="${donation.zipCode}"/></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li><c:out value="${donation.pickUpDate}"/></li>
                                <li><c:out value="${donation.pickUpTime}"/></li>
                                <li><c:out value="${donation.pickUpComment}"/></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <a href="<c:url value="/new_donation"/>" type="button" class="btn">Wstecz</a>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>

    </div>

</section>


<%@ include file="/WEB-INF/views/footer.jsp" %>