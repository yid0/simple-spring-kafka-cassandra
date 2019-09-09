# Simple-spring-kafka-cassandra
A simple project with Spring boot 2, Apache kafka and Apache cassandra.

**Install Apache Kafka (On Windows)**

Download Apache Kafka from the official web page https://kafka.apache.org/quickstart 

**Create a new Topic :**

    kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions  1 --topic test-topic

**Install Apache Cassandra (Docker)**

Visit Docker hub : https://hub.docker.com/_/cassandra

Download **Cassandra** image from the Docker Hub :
    
    docker pull cassandra
    
    docker run --name cassandra -d -p 9042:9042 cassandra

To access to the container : 

    docker exec -it cassandra bash

Create a keyspace :

    CREATE KEYSPACE mykeyspace
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

**REST API Test :**

- Prcoduce a new message:

    
    curl --header "Content-Type: application/json" \
         --request POST \
         --data '{"content":"hello world", "topic":"test-topic", "otherData": { "key": "value" } }' \
         http://localhost:8888/produce
  
  
- Get  all messages:


    curl --header "Content-Type: application/json" \
         --request GET \
         http://localhost:8888/message
     
- Get message with id (UUID format): 

 
     curl --header "Content-Type: application/json" \
          --request GET \
          http://localhost:8888/message/{id}
   
   
     