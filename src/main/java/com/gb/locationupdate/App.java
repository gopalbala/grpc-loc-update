package com.gb.locationupdate;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50001;
        Server server = ServerBuilder.forPort(port).build();
        server.start();

        System.out.println("server started listening on port " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutting down");
            server.shutdown();
            System.out.println("server stopped");
        }));
        server.awaitTermination();
    }
}
