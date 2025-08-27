package io.github.raphonzius.grpcserver;

import io.github.raphonzius.java.stubs.example.HelloRequest;
import io.github.raphonzius.java.stubs.example.HelloResponse;
import io.github.raphonzius.java.stubs.example.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService extends HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Saying Hello to " + request.getName());
        HelloResponse response = HelloResponse.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        System.out.println("Done saying Hello to " + request.getName());
    }

}
