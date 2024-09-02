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


## Exemplo de Utilização

http://localhost:6868/compras
http://localhost:6868/maior-compra/{{ano}} exemplo http://localhost:6868/maior-compra/2020
http://localhost:6868/clientes-fieis
http://localhost:6868/recomendacao/cliente/tipo




