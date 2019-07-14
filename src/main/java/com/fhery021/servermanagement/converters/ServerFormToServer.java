package com.fhery021.servermanagement.converters;

import com.fhery021.servermanagement.commands.ServerForm;
import com.fhery021.servermanagement.domain.Server;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ServerFormToServer implements Converter<ServerForm, Server> {

    @Override
    public Server convert(ServerForm form) {
        if (form == null){
            return null;
        }

        Server server = new Server();
        server.setIPv4(form.getIPv4());
        server.setStatus(form.getStatus());
        server.setName(form.getName());

        return server;

    }
}
