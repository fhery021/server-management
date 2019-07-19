package com.fhery021.servermanagement.services;

import com.fhery021.servermanagement.commands.ServerForm;
import com.fhery021.servermanagement.converters.ServerFormToServer;
import com.fhery021.servermanagement.converters.ServerToServerForm;
import com.fhery021.servermanagement.domain.Server;
import com.fhery021.servermanagement.repositories.ServerRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServerServiceImpl implements ServerService{

    private final ServerRepository serverRepository;
    private final ServerFormToServer serverFormToServer;
    private final ServerToServerForm serverToServerForm;

    private static Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);

    @Autowired
    public ServerServiceImpl(ServerRepository serverRepository, ServerFormToServer serverFormToServer, ServerToServerForm serverToServerForm) {
        this.serverRepository = serverRepository;
        this.serverFormToServer = serverFormToServer;
        this.serverToServerForm = serverToServerForm;
    }

    @Override
    public List<ServerForm> listAll() {
        List<ServerForm> serverForms = new ArrayList<>();
        serverRepository.findAll().forEach(server -> serverForms.add(serverToServerForm.convert(server)));

        return serverForms;
    }

    @Override
    public ServerForm getById(String id) {
        return serverRepository.findById(id).map(serverToServerForm::convert).orElse(null);
    }

    @Override
    public List<ServerForm> searchByNameOrIP(String text) {
        return  serverRepository.findAllByIdOrName(text)
                .stream()
                .map(serverToServerForm::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        serverRepository.deleteById(id);
    }

    @Override
    public ServerForm update(String id, ServerForm serverForm) {
        Server server = serverFormToServer.convert(serverForm);
        server.setId(new ObjectId(id));

        Server saved = serverRepository.save(server);

        logger.info("Server saved with id: " + saved.getId().toString());
        return serverToServerForm.convert(saved);
    }

    @Override
    public ServerForm save(ServerForm serverForm) {
        Server saved  = serverRepository.save(serverFormToServer.convert(serverForm));
        logger.info("Server saved with id: " + saved.getId().toString());
        return serverToServerForm.convert(saved);
    }
}
