import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgForOf, NgIf} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './home/home.component';
import { ResourcesComponent } from './resources/resources.component';
import {PersonnesComponent} from "./personnes/personnes.component";
import { ReservationsComponent } from './reservations/reservations.component';
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'reservation-realm',
        clientId: 'angular-app'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}

@NgModule({
  declarations: [
    AppComponent,
    PersonnesComponent,
    HomeComponent,
    ResourcesComponent,
    ReservationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
    NgForOf,
  ],
  providers: [
    {provide : APP_INITIALIZER, deps : [KeycloakService],useFactory : initializeKeycloak, multi : true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
