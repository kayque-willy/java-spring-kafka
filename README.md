
# Java Spring Boot e Kafka

Esse projeto é uma demonstração de produção e consumo de mensagens do Kafka com o Java Spring Boot

### Execução do kafka com o Docker

    $ docker compose up -d

### Endpoint para geração da mensagem no Producer

    POST localhost:8081/mensagens

#### Objeto da mensagem

    {
        "nome":"Nome",
        "descricao":"Descrição",
        "valor":10
    }

# Execução do terminal do Kafka pelo Docker 

    $ docker exec -it kafka bash

## TÓPICOS
Após executar o "docker exec -it kafka bash"

### Criar tópico

    $ kafka-topics --create --topic meu-topico --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

### Listar tópicos

    $ kafka-topics --list --bootstrap-server localhost:9092

### Visualizar tópico

    $ kafka-topics --describe --topic meu-topico --bootstrap-server localhost:9092

### Remover tópico

    $ kafka-topics --delete --topic  meu-topico --bootstrap-server localhost:9092

## MENSAGENS
### Criar mensagem

    $ kafka-console-producer --topic meu-topico --bootstrap-server localhost:9092

### Ler mensagens

    $ kafka-console-consumer --topic meu-topico --from-beginning --bootstrap-server localhost:9092
