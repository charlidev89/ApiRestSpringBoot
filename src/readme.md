# Proyecto ApiRestFull  CRUD  con SringBoot:

- Realizamos un crud basica con las siguientes herramientas:
- Maven para la gestion del proyecto
- Protocolo Http para la creacion de metodosCRUD
- Jpa+ Hibernate para la persistencia de datos
- H2 bd en memoria

#Endpoints
-
- GET /api/users  : obtener todos los users
- GET /api/users/{id}  : obtener user por id
- POST /api/users/   : agregar un user
- DELETE /api/users/{id}   : eliminar user por id


# Base de datos
Este proyecto utiliza H2, una base de datos en memoria, para desarrollo y pruebas.

se puede acceder en http://localhost:8080/h2-ui
JDBC URL: jdbc:h2:mem:testdb
Usuario: sa
Contraseña: 