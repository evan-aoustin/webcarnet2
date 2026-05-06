<%-- 
    Document   : form_vehicule
    Created on : 10 déc. 2025, 14:34:20
    Author     : Aoustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un entretien</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />    
        
        <h1>Ajouter un entretien</h2>
        
        <form method="post" action="srv_form_entretien">
            <div class="form-group">
                <label>Date Entretien</label>
                <input class="form-control" type="date" id="dateEntretien" name="dateEntretien" value="${date}"/>

                <br>

                <label>Nb Km Compteur</label>
                <input class="form-control" type="number" id="nbKmCompteur" name="nbKmCompteur" value="${nbKmCompteur}"/>

                <br>
                
                <label>Commentaire</label>
                <input class="form-control" type="text" id="commentaire" name="commentaire" value="${commentaire}"/>

                <br>

                <label for="entretienTypeList">EntretienType</label>

                <select name="entretienTypeID" id="entretienType" class="form-select">
                    <option value="">-- Liste des type d'entretien--</option>
                
                    <c:forEach var="et" items="${allEntretienTypes}">
                        <option 
                        <c:if test="${entretientypeCode == et.getCode()}">
                            selected
                        </c:if>
                        value="${et.getCode()}">
                            
                            <b>${et.getCode()}</b><i>(nbKm : ${et.getNbKm()}, nbKmTolere : ${et.getNbKmTolere()})</i>
                        
                        </option>
                    </c:forEach>
                </select>
                
                <br>
                
                <label for="vehiculesList" >Vehicule</label>
                <select name="vehiculeImmat" id="vehiculesList" class="form-select">
                    <option value="">-- Liste des vehicules --</option>
                
                    <c:forEach var="v" items="${allVehicules}">
                        <option 
                        <c:if test="${vehiImmat == v.getNumImma()}">
                            selected
                        </c:if>
                        value="${v.getNumImma()}">
                            
                            <b>${v.getNumImma()}</b>

                        </option>
                    </c:forEach>
                </select>

                <br>
                <input type="hidden" name="idEntretien" id="idEntretien" value="${idEntretien}"/>
                                
                <button class="btn btn-primary" type="submit">Ajouter</button>
                <a href="${pageContext.request.contextPath}/srv_all_entretien" class="btn btn-outline-primary">Retour</a>
            </div>
        </form>
        
    <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>
