# Kafka

A chaques modifications de la BDD, le microservice envoi sur Kafka pour tenir au courant les consummers.
On peut envoyer l'entité complete pour ne pas avoir à rejouer toutes les actions.
Donc le FCRT utilisera le broker Kafka pour recuperer les informations completes.
Pourquoi pas faire que les microservices crée automatiquement toutes les entrées des FCRT et que le microservices 
FCRT aggrège le tout.

# SpringCloud

Voir Spring Cloud Kubernetes

Chaque microservices va recuperer sa configuration auprès de `Config Server`.
Puis se referencer auprès du `Service Registry : Eureka`
Et enfin les microservices/front/autres font appel auprès de l'`API Gateway` pour avoir
l'@ip correspondant à un nom donnée pour y accèder.
`Circuit Breaker Dashboard` permet d'avoir un ensemble d'outil/reponse si le microservices n'est pas disponible. (Comme la gestion d'exception dans le code)

# OpenFeign

Discution entre microservices de façon déclarative. 

# Questions

## Microservices ayant besoin de toutes les BDD

## Pom.xml
On fait comme on veut.
Inheritance conseiller

## Securité
Créer un microservice d'authentication/autorization
Utilisation d'un microservice gateway/proxy, kong/spring gateway

## Voir les projections de spring
@Projectoin(name = "customer_projection", types = {Customer.class})

# Exercice

## Definition du besoin en microservice
Client
Produit
Stockage
Commande
Fournisseur
Livraison
Transporteur