package com.fhery021.servermanagement.repositories;

import com.fhery021.servermanagement.domain.Server;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServerRepository  extends CrudRepository<Server, String> {

    List<Server> findAllByIdOrName(String text);
}
