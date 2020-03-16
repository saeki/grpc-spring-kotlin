grpcc --proto ./grpc/src/main/proto/helloworld.proto --address localhost:9090 --insecure --eval "client.sayHello({ name: 'gRPC' }, printReply)"
