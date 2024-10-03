# Kafka

A chaques modifications de la BDD, le microservice envoi sur Kafka pour tenir au courant les consummers.
On peut envoyer l'entité complete pour ne pas avoir à rejouer toutes les actions.
Donc le FCRT utilisera le broker Kafka pour recuperer les informations completes.
Pourquoi pas faire que les microservices crée automatiquement toutes les entrées des FCRT et que le microservices 
FCRT aggrège le tout.

Kafka Stream

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

# Batch
SpringBatch avec jdbc directe sur les BDD des autres micorservices.

# Discovery - Gateway
On utilisera une decouverte dynamique, ce qui obligera le client à connaitre le nom du MICROSERVICE/service

**ATTENTION A LA DEPENDANCE DONNE PAR SPRING INITIALIZER qui est gateway-mvc et non gateway**

    <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>

## Routage Dynamique
Voir classe DiscoveryClientRouteConfiguration.java

## Routage Manuel
Voir application.yml du gateway-service.

    gateway:
      routes:
        - id: r1
          uri: http://localhost:8081/
          predicates:
            - Path=/customers/**
        - id: r2
          uri: http://localhost:8082/
          predicates:
            - Path=/api/products/**
        - id: r3
          uri: http://localhost:8083/
          predicates:
            - Path=/orders/**

Ce qui permet d'acceder directement au services rest en appelant uniquement l'url du gateway
example :
http://localhost:8080/customers

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

# URL du projet de la formation

EUREKA - http://localhost:8761
CONFIG-SERVICE - http://localhost:9999
CUSTOMER-SERVICE - http://localhost:8081
GATEWAY-SERVICE	- http://localhost:8080
INVENTORY-SERVICE - http://localhost:8082
ORDER-SERVICE - http://localhost:8083

## INVENTORY 
En -directe avec l'url du service inventory http://localhost:8082/api/products
Par la gateway avec route dynamique : http://localhost:8080/INVENTORY-SERVICE/api/products

## CUSTOMERS
En direct par l'url du service customers et utiliqation des projections : http://localhost:8081/customers?projection=customer_projection
Par gateway en route manuelle : http://localhost:8080/customers

## ORDERS
En direct par l'url du service orders :
Cette url va utiliser OpenFeign, c'est un controller qui va appeller en "interne" un autre microservice pour avoir les 
liste de customers : http://localhost:8083/api/customers