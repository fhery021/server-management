import {RouterModule, Routes} from "@angular/router";
import {ServersComponent} from "./servers/servers.component";
import {ServerFormComponent} from "./server-form/server-form.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
  { path: 'servers', component: ServersComponent },
  { path: 'addServer', component: ServerFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
