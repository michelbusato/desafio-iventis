# Desafio - Iventis

## Technologies
- Spring Boot
- Postgresql
- Docker
- Docker Compose

## Compilando o projeto

Executar o comando do MAVEN após importar

mvn clean install -DskipTests

## Iniciando a API:
Executar o comando para iniciar o container:

docker-compose up --build

## Encerrando a API
Executar o comando para encerrar o container limpando os volumes:

docker-compose down --volumes

Para apenas encerrar:

docker-compose down




