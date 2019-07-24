import { Component, OnInit } from '@angular/core';
import {Server} from "../model/server";
import {ServerService} from "../service/server.service";

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  servers: Server[];

  constructor(private serverService: ServerService) { }

  ngOnInit() {
    this.serverService.findAll().subscribe(data => {
      console.log(data);
      this.servers = data;
    });
  }

}
