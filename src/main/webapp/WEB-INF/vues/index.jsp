<%-- 
    Document   : index
    Created on : 10 déc. 2025, 10:31:39
    Author     : Aoustin
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />   
        
        <a href="${pageContext.request.contextPath}/admin/srv_all_vehicule" class="btn btn-primary">Liste des vehicules</a>
        <a href="${pageContext.request.contextPath}/srv_all_entretien" class="btn btn-primary">Liste des entretiens</a>
        <a href="${pageContext.request.contextPath}/srv_all_entretientype" class="btn btn-primary">Liste des type d'entretiens</a>


        <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>
