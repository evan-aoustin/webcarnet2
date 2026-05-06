<%-- 
    Document   : form_login
    Created on : 17 déc. 2025, 10:27:43
    Author     : Aoustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2> Se connecter </h2>

        <c:if test="${registerStatus == 1}">
            <div class="alert alert-danger" role="alert">
                ${registerMessage}
            </div>
        </c:if>

        <c:if test="${registerStatus == 0}">
            <div class="alert alert-success" role="alert">
                Compte créé
            </div>
        </c:if>
        
        <%-- Message de succès après inscription (via session) --%>
        <c:if test="${not empty sessionScope.registerSuccessMsg}">
            <div class="alert alert-success" role="alert">
                ${sessionScope.registerSuccessMsg}
            </div>
            <% session.removeAttribute("registerSuccessMsg"); %>
        </c:if>
        
        <c:if test="${loginStatus == 1}">
            <div class="alert alert-danger" role="alert">
                ${loginMessage}
            </div>
        </c:if>
        <c:if test="${unconnectedMsg != null}">
            <div class="alert alert-danger" role="alert">
                ${unconnectedMsg}
            </div>
        </c:if>
        <c:if test="${disconnectMsg != null}">
            <div class="alert alert-success" role="alert">
                ${disconnectMsg}
            </div>
        </c:if>
        <form method="post" action="srv_form_login">
            <div class="form-group">
                <label for="mail" >Email</label>
                <input class="form-control" type="email" id="mail" name="mail" />

                <br>

                <label for="mdp" >Mot de passe</label>
                <input class="form-control" type="password" id="mdp" name="mdp"/>

                <br>
                 
                <button class="btn btn-primary" type="submit">Se connecter</button>
                <a href="${pageContext.request.contextPath}/srv_form_register" class="btn btn-outline-primary">Créer un compte</a>
            </div>
        </form>
        
    <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>
