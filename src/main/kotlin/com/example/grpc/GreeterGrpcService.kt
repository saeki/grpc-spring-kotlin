package com.example.grpc

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class GreeterGrpcService : GreeterGrpc.GreeterImplBase() {

    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<HelloReply>) {
        val reply: HelloReply = HelloReply.newBuilder().setMessage("Hello, " + request.name).build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}
