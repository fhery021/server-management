import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ServerService} from "../service/server.service";
import {Server} from "../model/server";

@Component({
  selector: 'app-server-form',
  templateUrl: './server-form.component.html',
  styleUrls: ['./server-form.component.css']
})
export class ServerFormComponent implements OnInit {

  server: Server;

  constructor(private route:ActivatedRoute, private router: Router, private serverService: ServerService) {
    this.server = new Server();
  }

  onSubmit() {
    this.serverService.save(this.server).subscribe(result => this.goToServerList())
  }

  goToServerList() {
    this.router.navigate(['/servers'])
  }

  ngOnInit() {

  }

}
