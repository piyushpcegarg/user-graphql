# user-graphql-service

Command to run cassandra as a container in local

```
docker run --rm -d -p 9042:9042 --name user-cassandra cassandra
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
