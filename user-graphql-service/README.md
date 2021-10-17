# user-graphql-service

Command to run cassandra as a container in local

```
docker network create cassandra
docker run -d -p 9042:9042 --network cassandra --hostname cassandra --name user-cassandra cassandra
```

Then start interactive shell of container by below command:

```
docker exec -it user-cassandra bash
```

The execute below command inside container

```
cqlsh
```

After this, to create keyspace and user table, execute commands given in schema.cql file under resources folder


Run below command to generate docker image for backend service from root folder.

Below command fetches all the libraries so it will take 5-10 mins for first time .

cd user-graphql-service
./gradlew bootBuildImage
Above command builts image 'docker.io/library/user-graphql-service:1.0.0'

Verify whether image has successfully built by below command:

docker images | grep user-graphql-service
Now to run this service execute below command:

docker run -d -p 8080:8080 --name user-graphql-service --network cassandra --platform linux/amd64 user-graphql-service:1.0.0
To verify service is working properly execute below url in browser

http://localhost:8080/graphiql
