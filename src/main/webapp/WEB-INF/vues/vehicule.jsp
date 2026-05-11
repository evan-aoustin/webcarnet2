<%-- 
    Document   : vehicule
    Author     : Aoustin
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détail véhicule ${vehicule.getNumImma()}</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />

        <h2>Véhicule : ${vehicule.getNumImma()}</h2>
        <p><strong>Kilométrage actuel :</strong> ${vehicule.getNbKmActuel()} km</p>

        <hr>

        <h3>Entretiens passés</h3>
        <c:choose>
            <c:when test="${empty mesEntretiens}">
                <p>Aucun entretien enregistré pour ce véhicule.</p>
            </c:when>
            <c:otherwise>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Km compteur</th>
                            <th>Type</th>
                            <th>Commentaire</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="e" items="${mesEntretiens}">
                            <tr>
                                <td>${e.getDate()}</td>
                                <td>${e.getNbKmCompteur()} km</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${not empty e.getType().getLibelle()}">${e.getType().getLibelle()} — </c:when>
                                    </c:choose>${e.getType().getNbKm()} km
                                </td>
                                <td>${e.getCommentaire()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

        <hr>

        <h3>Entretiens nécessaires</h3>
        <c:choose>
            <c:when test="${empty typesNecessaires}">
                <p>Aucun entretien nécessaire pour le moment.</p>
            </c:when>
            <c:otherwise>
                <table class="table table-warning">
                    <thead>
                        <tr>
                            <th>Type</th>
                            <th>Intervalle</th>
                            <th>Tolérance</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="et" items="${typesNecessaires}">
                            <tr>
                                <td>
                                    <c:choose>
                                        <c:when test="${not empty et.getLibelle()}">${et.getLibelle()}</c:when>
                                        <c:otherwise>Type ${et.getCode()}</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${et.getNbKm()} km</td>
                                <td>± ${et.getNbKmTolere()} km</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/srv_form_entretien?vehiculeImmat=${vehicule.getNumImma()}&entretientypeCode=${et.getCode()}" class="btn btn-sm btn-outline-primary">Ajouter l'entretien</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

        <a href="${pageContext.request.contextPath}/admin/srv_all_vehicule" class="btn btn-outline-primary">Retour</a>

        <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>
