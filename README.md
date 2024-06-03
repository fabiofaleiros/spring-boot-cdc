<h1 align="center">
  Spring Boot CDC + Kafka Connect
</h1>

Spring Boot example for Change Data Capture (CDC) multi database with Kafka Connect.

## Technologies
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL](https://www.mysql.com)
- [Postgres](https://www.postgresql.org)
- [Docker Compose](https://docs.docker.com/compose/)
- [Kafka](https://kafka.apache.org)
- [Kafka Connect](https://docs.confluent.io/platform/current/connect/index.html)
- [Debezium MySQL Source Connector](https://docs.confluent.io/kafka-connectors/debezium-mysql-source/current/mysql_source_connector_config.html)
- [JDBC Sink Connector](https://docs.confluent.io/kafka-connectors/jdbc/current/sink-connector/sink_config_options.html)

## How to execute

- Init infra with docker-compose:
```
docker-compose up -d
```

- Add mysql and postgres connectors:
```
curl -X POST  -H  "Content-Type:application/json" http://localhost:8083/connectors -d @mysql.json

curl -X POST  -H  "Content-Type:application/json" http://localhost:8083/connectors -d @postgres.json
```

- Check if the connectors were added properly:
```
http GET :8083/connectors
```

- Init Java Projects

## API

Endpoints will be available for each microservice:

### posts-service
- POST /posts
```
http POST :8080/posts content='New Post 01'
```

- GET /posts
```
http :8080/posts
```

### comments-service
- POST /comments
```
http POST :8081/comments text='New Comment 01!' postId=1
```

- GET /comments
```
http :8081/comments
```