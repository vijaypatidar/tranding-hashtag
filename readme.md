## Kafka 

### Create kafka topic 
```shell
cd opt/kafka/bin
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic posts
```

### List kafka topics
```shell
cd opt/kafka/bin
kafka-topics.sh --list --zookeeper zookeeper:2181
```

### Consume message from topic
```shell
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic posts --from-beginning
```
