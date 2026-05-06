# Instructions pour GitHub Copilot

## Contexte du projet

**webcarnet** est une application web Java EE (Jakarta EE 10) de gestion de carnet d'entretien automobile.

Stack technique :
- **Backend** : Java EE / Jakarta EE 10, Servlets, JSTL, JSP
- **Base de données** : MySQL (via JDBC, `ConnectionDAO`)
- **Build** : Maven, packaging WAR
- **Structure** : pattern MVC manuel — Servlets dans `com.mycompany.webcarnet`, modèles dans `classes/`, DAO dans `classes/`, vues JSP dans `WEB-INF/vues/`

Entités principales : `Vehicule`, `Entretien`, `EntretienType`, `Atelier`, `User`  
DAO associés : `VehiculeDAO`, `EntretienDAO`, `EntretienTypeDAO`, `UserDAO`  
Filtres de sécurité : `AuthFilter`, `AdminFilter`

---

## Règles pour l'agent

### Travailler dans le workspace
Tu es un agent qui agit directement dans le workspace `/home/evan/webcarnet2`.  
Toutes les modifications doivent être faites dans ce dossier.  
Évite de sortir du workspace. Évite d'utiliser `/tmp` ou des répertoires temporaires extérieurs — préfère toujours créer des fichiers temporaires à l'intérieur du projet si nécessaire, sauf si c'est strictement indispensable.

### Respecter l'architecture existante
Ne change pas la structure du projet sans que ce soit demandé explicitement.  
Respecte les conventions déjà en place :
- Les Servlets suivent le nommage `srv_*.java` dans `com.mycompany.webcarnet`
- Les vues JSP sont dans `WEB-INF/vues/`
- Les classes métier et DAO sont dans le package `classes/`
- Les includes JSP partagés sont dans `WEB-INF/includes/`

N'introduis pas de nouveaux frameworks, librairies ou patterns architecturaux non présents dans le projet.  
Garde le style de code cohérent avec l'existant.
