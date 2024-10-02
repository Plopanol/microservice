# Kafka

A chaques modifications de la BDD, le microservice envoi sur Kafka pour tenir au courant les consummers.
On peut envoyer l'entité complete pour ne pas avoir à rejouer toutes les actions.
Donc le FCRT utilisera le broker Kafka pour recuperer les informations completes.
Pourquoi pas faire que les microservices crée automatiquement toutes les entrées des FCRT et que le microservices 
FCRT aggrège le tout.

# Configuration

Utilisation d'un projet maven de configuration sur un repo.
Voir projet config de la formation.

# SpringCloud

Voir Spring Cloud Kubernetes

Chaque microservices va recuperer sa configuration auprès de `Config Server`.
Puis se referencer auprès du `Service Registry : Eureka`
Et enfin les microservices/front/autres font appel auprès de l'`API Gateway` pour avoir
l'@ip correspondant à un nom donnée pour y accèder.
`Circuit Breaker Dashboard` permet d'avoir un ensemble d'outil/reponse si le microservices n'est pas disponible. (Comme la gestion d'exception dans le code)

# OpenFeign

Discution entre microservices de façon déclarative.
Creation d'une interface reprenant le controller du rest à appeller avec l'annotation @FeignClient(name="NOM-SERVICE-CLIENT")

# Microservices ayant besoin de toutes les BDD

# Discovery - Gateway
On utilisera une decouverte dynamique, ce qui obligera le client à connaitre le nom du MICROSERVICE/service

# Pom.xml
On fait comme on veut.
Inheritance conseiller

# Securité
Créer un microservice d'authentication/autorization
Utilisation d'un microservice gateway/proxy, kong/spring gateway

Voir si Spring Security activer sur tout les microservices.
Un microservice d'authentication (Créer un token)

# Voir les projections de spring
@Projection(name = "customer_projection", types = {Customer.class})
Vs DTO ? Utilité ?

# Recherche Multicritere

Voir GraphQL ?