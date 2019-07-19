package com.fhery021.servermanagement.services;

import com.fhery021.servermanagement.commands.ServerForm;

import java.util.List;

public interface ServerService {

    List<ServerForm> listAll();

    List<ServerForm> searchByNameOrIP(String text);

    ServerForm getById(String id);

    void delete(String id);

    ServerForm update(String id, ServerForm serverForm);

    ServerForm save(ServerForm serverForm);
}
