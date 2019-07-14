package com.fhery021.servermanagement.controllers;

import com.fhery021.servermanagement.commands.ServerForm;
import com.fhery021.servermanagement.commands.ServerListDTO;
import com.fhery021.servermanagement.services.ServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "Server management API")
@RestController
@RequestMapping(ServerController.BASE_URL)
// TODO Test w. Angular -> @CrossOrigin(origins = "http://localhost:4200")
public class ServerController {

    static final String BASE_URL = "/api/servers";

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @ApiOperation(value = "Get a list of servers", notes = "Full list, no filtering")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ServerListDTO getServersList(){
        return serverService.listAll();
    }

    @ApiOperation(value = "Get server by id")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ServerForm getServerById(@PathVariable String id){
        return serverService.getById(id);
    }

    @ApiOperation(value = "Create new server")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServerForm createNewServer(@RequestBody ServerForm serverForm){
        return serverService.save(serverForm);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ServerForm update(@PathVariable String id, @RequestBody ServerForm serverForm){
        return serverService.saveOrUpdate(id, serverForm);
    }

    @ApiOperation(value = "delete a server")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        serverService.delete(id);
    }

}