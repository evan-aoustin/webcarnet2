<%-- 
    Document   : form_register
    Created on : 17 déc. 2025, 10:33:59
    Author     : Aoustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        
        <h2> Créer un compte </h2>
        <c:if test="${loginStatus == 1}">
            <div class="alert alert-danger" role="alert">
                ${loginMessage}
            </div>
        </c:if>

        <form method="post" action="srv_form_register">
            <div class="form-group">
                <label for="mail" >Email</label>
                <input class="form-control" type="email" id="mail" name="mail" />

                <br>

                <label for="mdp" >Mot de passe</label>
                <input class="form-control" type="password" id="mdp" name="mdp"/>

                <br>
                 
                <button class="btn btn-primary" type="submit">Créer</button>
                <a href="${pageContext.request.contextPath}/srv_form_login" class="btn btn-outline-primary">Se connecter</a>
            </div>
        </form>
        
    <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>

