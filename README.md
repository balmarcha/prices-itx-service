# Prices ITX Service

## Descripción

Este proyecto es un microservicio de gestión de precios. Utiliza Spring Boot, arquitectura hexagonal, H2.

## Tecnologías Utilizadas

- Java 23
- Spring Boot 3.x
- Spring Data JPA
- H2
- Liquibase

## Arquitectura

El sistema sigue la arquitectura hexagonal, dividiendo la aplicación en:

- Dominio: Contiene las reglas de negocio y entidades. 
- Aplicación: Implementa los casos de uso. 
- Infraestructura: Maneja la persistencia, eventos y APIs REST.
