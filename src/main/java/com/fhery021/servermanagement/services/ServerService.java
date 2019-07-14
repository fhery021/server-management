package com.fhery021.servermanagement.services;

import com.fhery021.servermanagement.commands.ServerForm;
import com.fhery021.servermanagement.commands.ServerListDTO;
import com.fhery021.servermanagement.domain.Server;

import java.util.List;

public interface ServerService {

    ServerListDTO listAll();

    ServerListDTO searchByNameOrIP(String text);

    ServerForm getById(String id);

    void delete(String id);

    ServerForm update(String id, ServerForm serverForm);

    ServerForm save(ServerForm serverForm);
}
