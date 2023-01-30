# Kafka

To get started follow the official [documentation](https://developer.confluent.io/get-started/java/) page

Kafka setup can be done for practice in different way, [follow](https://developer.confluent.io/get-started/java/#kafka-setup) this guide to get the ball rolling 

## Start Kafka Cluster
 To start the cluster. reun below command (Make sure you have a valid docker compose file with all necessary details. Please take a look on local-kafka.yaml

```sh
docker compose up -d
```

## Topic

```sh
docker compose exec broker \
  kafka-topics --create \
    --topic purchases \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1
```

## Commandline to deal with kafka consumer and producer
```sh

```


## kafka-101

is a java application which use kafka provided library to deal with Consumer and Producer

```sh
mvn clean install

java -jar target/kafka-101-1.0-SNAPSHOT.jar src/main/resources/kafka.properties

java -cp target/kafka-101-1.0-SNAPSHOT.jar net.samitkumar.ProducerClient src/main/resources/kafka.properties
java -cp target/kafka-101-1.0-SNAPSHOT.jar net.samitkumar.ConsumerClient src/main/resources/kafka.properties

```


