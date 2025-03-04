# 📌 Prices ITX Service

## 📖 Descripción

`prices-itx-service` es un microservicio desarrollado en **Java 23** con **Spring Boot 3.x** que permite la gestión de precios de productos dentro de una cadena de tiendas. Sigue una **arquitectura hexagonal** y está basado en los principios de **Domain-Driven Design (DDD)**.

## 🛠️ Tecnologías

- **Java 23**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Liquibase**
- **H2 Database**
- **Lombok**
- **MapStruct**
- **OpenAPI** (para generar y documentar la API REST)
- **JUnit 5 y Mockito**

## 🚀 Configuración y Ejecución

### Clonar el repositorio

```sh
git clone https://github.com/balmarcha/prices-itx-service.git
cd prices-itx-service
```

### Ejecutar la aplicación con Maven

#### MacOS/Linux
```sh
./mvnw spring-boot:run
```

#### Windows
```sh
.\mvnw.cmd spring-boot:run
```

La aplicación correrá en el puerto `7071` con el siguiente contexto:

```
http://localhost:7071/prices-itx-service
```

### Acceder a la documentación OpenAPI

```
http://localhost:7071/prices-itx-service/swagger-ui.html
```

### Acceder a la consola de H2

```
http://localhost:7071/prices-itx-service/h2-console
```

Credenciales:

- **URL JDBC:** `jdbc:h2:mem:testdb`
- **Usuario:** `sa`
- **Contraseña:** *(vacío)*

## 📂 Estructura del Proyecto

```
📦 prices-itx-service
 ┣ 📂 application        # Casos de uso y servicios
 ┃ ┣ 📂 src
 ┃ ┃ ┣ 📂 main/java
 ┃ ┃ ┗ 📂 test/java
 ┃ ┗ 📜 pom.xml
 ┣ 📂 domain            # Entidades y repositorios
 ┃ ┣ 📂 src
 ┃ ┃ ┗ 📂 main/java
 ┃ ┗ 📜 pom.xml
 ┣ 📂 infrastructure     # Adaptadores, controladores, configuración y recursos
 ┃ ┣ 📂 src
 ┃ ┃ ┣ 📂 main/java 
 ┃ ┃ ┃ ┗ 📜 PricesItxServiceApplication.java
 ┃ ┃ ┣ 📂 main/resources
 ┃ ┃ ┃ ┣ 📂 bd
 ┃ ┃ ┃ ┃ ┣ 📂 changelog
 ┃ ┃ ┃ ┃ ┗ 📂 data
 ┃ ┃ ┃ ┗ 📂 openapi
 ┃ ┃ ┗ 📂 test/java
 ┃ ┗ 📜 pom.xml
 ┣ 📜 pom.xml
```

## 🗄️ Configuración de Base de Datos

La estructura de la base de datos está definida en **Liquibase** mediante `liquibase-changelog.yml`. Los datos iniciales se insertan desde archivos **CSV**.

## ✅ Pruebas

El proyecto incluye **pruebas unitarias y de integración end-to-end** utilizando **JUnit 5 y Mockito**. Para ejecutarlas:

```sh
./mvnw test
```

## 📜 Licencia

Este proyecto está bajo la licencia **MIT**. Puedes utilizarlo, modificarlo y distribuirlo libremente.

