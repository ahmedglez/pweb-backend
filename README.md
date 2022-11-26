# pweb-backend

## Borrar pom.xml del cache de git

- 1.Abre la terminal en la ruta del proyecto

- 2.Escribe el siguite comando
```xml
git rm --cached pom.xml
```
- 3.Asegurate que este puesto en el .gitignore

## Spring Security

- 1.Instala esta dependencia

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
	<version>2.6.8</version>
</dependency>
  ```
  - 2.Trata de acceder a cualquier ruta y te va a dirigir automaticamente hacia:
  http://localhost:8095/pwebjsf/login 
  
  
  ## Swagger
  
  - 1.Instala esta dependencia
  ```
  <dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-ui</artifactId>
	<version>1.6.4</version>
</dependency>
```

- 2.Escribe `http://localhost:{port}/pwebjsf/swagger-ui/index.html` en el navegador

