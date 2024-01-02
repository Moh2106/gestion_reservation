## Description du projet
On souhaite créer une application basée sur une architecture micro-service qui permet de gérer des réservations
concernant des ressources. Chaque réservation concerne une seule ressource. Une ressource est définie par son
id, son nom, son type (MATERIEL_INF0, MATERIEL_AUDIO_VUSUEL). Une réservation est définie par son id, son
nom, son contexte, , sa date, sa durée. Chaque réservation est effectuée par une personne. Une personne est
définie par son id, son nom, son email et sa fonction.
L’application doit permettre de gérer les ressources et les réservations. Pour faire plus simple, cette application
se composera de deux micro-services fonctionnels :
• Un Micro-service qui permet de gérer des « Resources-Service ».
• Un Micro-service qui permet de gérer les réservations effectuées par des personnes.
Les micro-services technique à mettre en place sont :
• Le service Gateway basé sur Spring cloud Gateway
• Le service Discovery base sur Eureka Server ou Consul Discovery (au choix)
• Le service de configuration basé sur Spring cloud config ou Consul Config (au choix)
Pour l’application, nous avons besoin de développer une frontend web, basé sur Angular Framework.
La sécurité de l’application est basée sur Oauth2 et OIDC avec Keycloak comme Provider
Pour les micro-services, il faut générer la documentation des web services Restfull en utilisant la spécification
OpenAPIDoc (Swagger). Prévoir aussi des circuit breakers basés sur Resilience4J comme solution de fault
tolerence

## Architecture du projet

![architecture](https://github.com/Moh2106/gestion_reservation/assets/83918154/7361dab1-e952-4c0d-9f02-f2ad390ad9f0)

## Démo de l'application
https://github.com/Moh2106/gestion_reservation/assets/83918154/803e7ac4-15a0-4d68-8954-828027c3432e

## Architecture de la base de donnée
![crossover-image](assets/reservation_database_architecture.jpg)

### Base de donnée personne
![crossover-image](assets/personne_database.jpg)

### Base de donnée ressource
![crossover-image](assets/resource_database.jpg)

### Base de donnée reservation
![crossover-image](assets/reservation_database.jpg)

## Consul Discovery
![crossover-image](assets/consul_discovery.jpg)

## Documentation swagger de ressource micro-service
- ![crossover-image](assets/resource_swagger_full.jpg)
- ![crossover-image](assets/resource_swagger_resources.jpg)
- ![crossover-image](assets/resource_swagger_resources_delete.jpg)
- ![crossover-image](assets/resource_swagger_resources_getid.jpg)
- ![crossover-image](assets/resource_swagger_resources_update.jpg)

## Documentation swagger de personne micro-service
- ![crossover-image](assets/personne_swagger.jpg)
- ![crossover-image](assets/personne_swagger_get.jpg)
- ![crossover-image](assets/personne_swagger_getById.jpg)

## Documentation swagger de reservation micro-service
- ![crossover-image](assets/reservation_swagger.jpg)
- ![crossover-image](assets/reservation_swagger_delete.jpg)
- ![crossover-image](assets/reservation_swagger_get.jpg)
- ![crossover-image](assets/reservation_swagger_getById.jpg)
- ![crossover-image](assets/reservation_swagger_post.jpg)
- ![crossover-image](assets/reservation_swagger_update.jpg)

## Frontend Angular
> [!NOTE]
> Authentification keycloak angular :
  ![crossover-image](assets/1_authentification_angular.jpg)
> Menu de l'application frontend : ![crossover-image](assets/1_menu_angular.jpg)
> Menu de l'application frontend : ![crossover-image](assets/1_menu_angular.jpg)
> Personne Interface : ![crossover-image](assets/1_personne_angular.jpg)
> Reservation Interface : ![crossover-image](assets/1_reservation_angular.jpg)
> Ressource Interface : ![crossover-image](assets/1_ressource_angular.jpg)

