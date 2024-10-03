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

La configuration doit se trouver sur un repo git.
Dans la formation on à dû faire un POST http://localhost:8081/actuator/refresh
Pour rafraichir la configuration dans les autres microservices.

## Izanami
Remplacement de SpringCloud Config avec des fonctionnalités différentes comme switch/desactivation
de fonctionnalités.
https://maif.github.io/izanami/docs/usages/features

# Spring Cloud Consul

Agent qui remplace vault, config et euréka.
https://www.hashicorp.com/products/consul

Uniquement pour info, a verifier il faudrait aws ou autre.

# Spring Cloud Kubernetes
Voir integration de kubernetes

# SpringCloud

Chaque microservices va recuperer sa configuration auprès de `Config Server`.
Puis se referencer auprès du `Service Registry : Eureka`
Et enfin les microservices/front/autres font appel auprès de l'`API Gateway` pour avoir
l'@ip correspondant à un nom donnée pour y accèder.
`Circuit Breaker Dashboard` permet d'avoir un ensemble d'outil/reponse si le microservices n'est pas disponible. (Comme la gestion d'exception dans le code)

# Discution entre microservices

## OpenFeign

Discution entre microservices de façon déclarative.
Creation d'une interface reprenant le controller du rest à appeller avec l'annotation @FeignClient(name="NOM-SERVICE-CLIENT")

## Resilience4j -SpringCloud Circuit Breaker
Fait office de RestHandlerError pour Feign
Voir example dans le classe ProductRestClient
https://www.baeldung.com/spring-cloud-circuit-breaker
Le circuitBreaker doit renvoyé une exception et sera catch par le HandlerException ?

# Microservices ayant besoin de toutes les BDD

## Batch
SpringBatch avec jdbc directe sur les BDD des autres micorservices.

# Security
Activer le Vault, SSL ...

# Pom.xml / Architecture
On fait comme on veut.
Inheritance conseiller

    Projet
     Microservice 1
     Microservice 2
     Gateway
     Eureka
     Config
     Securite

# Securité

Créer un microservice d'authentication/autorization
Utilisation d'un microservice gateway/proxy ou kong/spring gateway
Un autre microservice specifique autentication qui aura la charge de :
- BDD utilisateur
- Redirection mindef/keycloack etc..
- Creation token ...

Les autres microservice auront springsecurity d'activé mais redirigeront vers celui d'autentication si le token 
n'est pas valide.


# Projection auto generer par rest data
Si une projection spring est annoté avec celle ci-dessous, cela va créer automatiquement un endpoint
http://localhost:8081/customers?projection=customer_projection 
@Projection(name = "customer_projection", types = {Customer.class})

# Recherche Multicritere

Voir GraphQL ?


# Discovery (Eureka)
On utilisera une decouverte dynamique, ce qui obligera le client à connaitre le nom du MICROSERVICE/service

**ATTENTION A LA DEPENDANCE DONNE PAR SPRING INITIALIZER qui est gateway-mvc et non gateway**

    <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>

# Gateway (Routage)

## Routage Dynamique
Voir classe DiscoveryClientRouteConfiguration.java

## Routage Manuel
Voir application.yml du gateway-service.
On peut filtrer des routes avec des filtres comme Before, After, Between: Date

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


## URL du projet de la formation

- EUREKA - http://localhost:8761
- CONFIG-SERVICE - http://localhost:9999
- CUSTOMER-SERVICE - http://localhost:8081
- GATEWAY-SERVICE	- http://localhost:8080
- INVENTORY-SERVICE - http://localhost:8082
- ORDER-SERVICE - http://localhost:8083

### Actuator

health et autre outils, voir doc

### INVENTORY 
- En -directe avec l'url du service inventory http://localhost:8082/api/products
- Par la gateway avec route dynamique : http://localhost:8080/INVENTORY-SERVICE/api/products

### CUSTOMERS
- En direct par l'url du service customers et utilisation des projections : http://localhost:8081/customers?projection=customer_projection
- Par gateway en route manuelle : http://localhost:8080/customers
- Controler pour afficher les variables de la configuration globale : http://localhost:8081/api/test

### ORDERS
- En direct par l'url du service orders :
- Cette url va utiliser OpenFeign, c'est un controller qui va appeller en "interne" un autre microservice pour avoir les 
- liste de customers : http://localhost:8083/api/customers