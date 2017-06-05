# RestMars

A Sample Spring Boot Restfull project. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisities

1 - Java 8

2 - Maven 

### Running the app

```
mvn spring-boot:run
```

Movimento com rotações para direita:
curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
Saída esperada: (2, 0, S)
Movimento para esquerda:
Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
Saída esperada: (0, 2, W)
Repetição da requisição com movimento para esquerda:
Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
Saída esperada: (0, 2, W)
Comando inválido:
curl -s --request POST http://localhost:8080/rest/mars/AAA
Saída esperada: 400 Bad Request
Posição inválida:
curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
Saída esperada: 400 Bad Request


## Running the tests

mvn test

## Authors

* **Vinicius Piedade de Souza**