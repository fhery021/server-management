package com.fhery021.servermanagement.converters;

import com.fhery021.servermanagement.commands.ServerForm;
import com.fhery021.servermanagement.domain.Server;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ServerToServerForm implements Converter<Server, ServerForm> {

    @Override
    public ServerForm convert(Server server) {
        if (server ==  null){
            return null;
        }
        ServerForm form = new ServerForm();
        form.setIPv4(server.getIPv4());
        form.setName(server.getName());
        form.setStatus(server.getStatus());
        form.setId(server.getId().toString());

        return form;
    }

    // another option would be Mapstruct (auto-generates converters)
}
