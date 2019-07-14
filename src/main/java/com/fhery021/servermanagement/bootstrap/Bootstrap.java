package com.fhery021.servermanagement.bootstrap;

import com.fhery021.servermanagement.domain.Server;
import com.fhery021.servermanagement.repositories.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {
    private final ServerRepository serverRepository;

    public Bootstrap(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        serverRepository.saveAll(
                List.of(
                        Server.builder()
                                .name("one")
                                .IPv4("192.168.1.3")
                                .build(),
                        Server.builder().name("two")
                                .IPv4("192.168.1.4")
                                .status("offline")
                                .build(),
                        Server.builder()
                                .name("three")
                                .IPv4("192.168.2.9")
                                .status("online")
                                .build()
                ));
    }
}
