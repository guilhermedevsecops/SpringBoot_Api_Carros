# SpringBoot Api de Carros para Treinamento

Este projeto é uma aplicação Spring Boot desenvolvida com o propósito de fornecer um ambiente para praticar requisições em Spring Boot, entender sua arquitetura inicial e observar o comportamento do framework.

## Objetivos

- Praticar requisições em Spring Boot.
- Compreender a arquitetura inicial do Spring Boot.
- Observar o comportamento do framework em um ambiente de desenvolvimento.

## Requisitos

Certifique-se de ter os seguintes requisitos instalados em seu ambiente de desenvolvimento:

- MySQL Versão 8.0.36
- Apache Maven Versão 3.8.7
- Java Versão 22.0.1

## Configurações Básicas

Antes de executar o projeto, certifique-se de realizar as seguintes configurações básicas:

- Insira os dados de conexão do seu banco de dados local no arquivo application.properties.
-    Insira o nome de usuário e senha do seu banco de dados local no arquivo application.properties.
-    Renomeie o arquivo application.properties.example para application.properties e faça as alterações necessárias.

Exemplo de trecho de código no arquivo application.properties:

properties

# Configurações Banco de Dados
```
spring.datasource.url=jdbc:mysql://localhost:3306/seubanco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.security.user.name=senha_para_acessar_api
spring.security.user.password=senha_para_acessar_ap
```


## Buildar e executar o programa

Primeiramente, deve ser efetuado o build do programa para ser utilizado em um arquivo JAR. Para isso, execute os seguintes comandos:

```
mvn clean install
java -jar target/start-0.0.1-SNAPSHOT.jar
```

### Autor

Guilherme Henrique S. J.
