package com.ingeint.scaleconnector.gui.cli;

import com.ingeint.scaleconnector.service.Server;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Command(name = "server", description = "Runs a TCP headless server")
public class ServerCommand implements Callable<Integer> {

    @Option(names = {"-p", "--port"}, description = "Port (default: ${DEFAULT-VALUE})", defaultValue = "5000")
    private int port;

    @Override
    public Integer call() throws Exception {
        Server server = new Server(port);

        CountDownLatch latch = new CountDownLatch(1);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                server.stop();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }));

        try {
            server.start();
            latch.await();
        } catch (Exception e) {
            log.error("Error starting server");
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
