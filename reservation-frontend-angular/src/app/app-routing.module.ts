import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ResourcesComponent} from "./resources/resources.component";
import {PersonnesComponent} from "./personnes/personnes.component";
import {ReservationsComponent} from "./reservations/reservations.component";
import {AuthGuard} from "./guards/auth.guard";

const routes: Routes = [
  {
    path : "",
    component : HomeComponent
  },

  {
    path : "resources",
    component : ResourcesComponent,
    canActivate : [AuthGuard]
  },

  {
    path : "reservations",
    component : ReservationsComponent,
    canActivate : [AuthGuard]
  },

  {
    path : "personnes",
    component : PersonnesComponent,
    canActivate : [AuthGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
