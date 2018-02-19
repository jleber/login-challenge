# Login-challenge

[![Build Status](https://secure.travis-ci.org/jleber/login-challenge.png?branch=master)](https://travis-ci.org/jleber/login-challenge)

## Overview

Sistema de login (API) que disponibiliza token para consumir informações do usuário de qualquer origem, o projeto conta com uma camada de cache a fim de otimizar o tempo de resposta.

## Usage

Para utilizar a API é necessário:

  1. Trocar a senha do arquivo [application.properties](https://github.com/jleber/login-challenge/blob/master/src/main/resources/application.properties), para obter a senha correta entre em contato com o owner desse repositório.
  
  2. Ter o [Redis](https://redis.io/) rodando localmente na porta padrão ou se preferir é possível modificar o arquivo [ApplicationConfig](https://github.com/jleber/login-challenge/blob/master/src/main/java/com/jleber/login/challenge/configuration/ApplicationConfig.java) para utilizar outro endereço, exemplo:

          @Bean
            public JedisConnectionFactory jedisConnectionFactory() {
                JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
                connectionFactory.setHostName("meuredisexterno.com"); // ENDEREÇO DO REDIS
                connectionFactory.setPort(6379);
                return connectionFactory;
            }
  
  3. (Opcional) No caso de precisar abrir o projeto em sua IDE, siga as [instruções](https://projectlombok.org/setup/overview)




Após verificar as etapas acima, entre na raiz do projeto e rode o comando:

```sh
$ mvn spring-boot:run
```
### Endpoints Disponíveis

  * /users/authenticate
    
        Method - POST
        Request Body - {"email":"seuemail@email.com" , "password":"secret"}
        
        Response - {
                      "name": "seu nome",
                      "token": "token",
                      "company": {
                          "idCompany": 1,
                          "name": "Mock",
                          "phone": "11 555555555",
                          "address": "Rua dos Mocks",
                          "addressNumber": "7A",
                          "additionalInfo": "none"
                      }
                  }
                  
  * /companies
    
        Method - GET
        Headers - Key: api_token , Value: token obtido no endpoint(/users/authenticate)
      
        Response - {
                      "idCompany": 1,
                      "name": "Empresa",
                      "phone": "(11) 5555-5555",
                      "address": "Rua dos Javaneiros",
                      "addressNumber": "77",
                      "additionalInfo": "prox. ao Duke Mascot"
                  }
                  
  * /companies/{idCompany}/products
    
        Method - GET
        Headers - Key: api_token , Value: token obtido no endpoint(/users/authenticate)
      
        Response -[
                    {
                        "idProduct": 1,
                        "name": "produto 1",
                        "type": "tipo 1"
                    },
                    {
                        "idProduct": 2,
                        "name": "produto 2",
                        "type": "tipo 2"
                    }
                  ]
                  
            
Lista de usuários disponíveis para acesso:

    User - madruguinha@gmail.com
    Pass - testeIntelipost18

    User - duke_the_mascot@gmail.com
    Pass - teste2Intelipost18

    User - joffrey@gmail.com
    Pass - teste3Intelipost18

    User - long.johnson@gmail.com
    Pass - teste4Intelipost18

## Stack

* [Spring Boot](https://projects.spring.io/spring-boot/)
* [Spring Security](https://projects.spring.io/spring-security/)
* [Java 8](https://www.java.com/pt_BR/download/)
* [Redis](https://redis.io/)
* [PostgreSQL](https://www.postgresql.org/)
* [H2 DB](http://www.h2database.com/html/main.html)
* [Undertow](http://undertow.io/)
* [Lombok](https://projectlombok.org/)
* [Orika](https://orika-mapper.github.io/orika-docs/)
* [Jackson](https://github.com/FasterXML/jackson-databind)




