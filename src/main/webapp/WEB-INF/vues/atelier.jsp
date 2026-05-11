<%-- 
    Document   : atelier
    Author     : Aoustin
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Véhicules à entretenir</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />

        <h2>Véhicules à entretenir</h2>

        <c:choose>
            <c:when test="${empty vehiculesTypesMap}">
                <p>Aucun véhicule ne nécessite d'entretien en ce moment.</p>
            </c:when>
            <c:otherwise>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Immatriculation</th>
                            <th scope="col">Km actuel</th>
                            <th scope="col">Entretien nécessaire</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="entry" items="${vehiculesTypesMap}">
                            <c:forEach var="et" items="${entry.value}">
                                <tr>
                                    <td>${entry.key.numImma}</td>
                                    <td>${entry.key.nbKmActuel} km</td>
                                    <td>
                                        <c:if test="${not empty et.libelle}">${et.libelle} — </c:if>${et.nbKm} km (±${et.nbKmTolere} km)
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/srv_form_entretien?vehiculeImmat=${entry.key.numImma}&entretientypeCode=${et.code}" class="btn btn-outline-primary">Ajouter l'entretien</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

        <a href="${pageContext.request.contextPath}/srv_index" class="btn btn-outline-primary">Retour</a>

        <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>
