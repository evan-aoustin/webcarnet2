<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="header">
    <c:choose>
        <c:when test="${user == null}">
            <a href="${pageContext.request.contextPath}/srv_form_login" class="btn btn-primary">Se connecter</a>
            <a href="${pageContext.request.contextPath}/srv_form_register" class="btn btn-primary">Créer un compte</a>
        </c:when>
        <c:otherwise>
            <p>Vous êtes connecté en tant que : ${user.getMail()} (${user.getRole()})</p>
            <a href="${pageContext.request.contextPath}/srv_logout" class="btn btn-outline-danger">Déconnexion</a>
        </c:otherwise>
    </c:choose>
</div>