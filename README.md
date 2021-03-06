# grpc-spring-kotlin

Example of gRPC server with Spring.

### Launch gRPC server

```
$ ./gradlew bootRun
```

### Access from client

#### grpcc

```
$ grpcc --directory ./grpc/src/main/proto --proto helloworld.proto --address localhost:9090 --insecure --eval "client.sayHello({ name: 'gRPC' }, printReply)"
```

#### evans

```
$ echo '{ "name": "gRPC" }' | evans cli call helloworld.Greeter.SayHello --port 9090 --path ./grpc/src/main/proto --proto helloworld.proto
```

If `.evans.toml` is exist, you can omit the params.
```
[default]
protoPath = ["./grpc/src/main/proto/"]
protoFile = ["helloworld.proto"]
package = "helloworld"
service = "Greeter"

[server]
host = "127.0.0.1"
port = "9090"
```

```
$ echo '{ "name": "gRPC" }' | evans cli call SayHello
```

### Launch gRPC-Web proxy (optional)

```
$ docker-compose up -d
```

### References

* [gRPC](https://github.com/grpc/grpc)
* [gRPC-Java](https://github.com/grpc/grpc-java)
* [gRPC Spring Boot Starter](https://github.com/yidongnan/grpc-spring-boot-starter)
* [grpcc](https://github.com/njpatel/grpcc)
* [evans](https://github.com/ktr0731/evans)
* [Envoy](https://www.envoyproxy.io/)
