import { Component } from '@angular/core';
import {KeycloakProfile} from "keycloak-js";
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'reservation-frontend-angular';
  public profile? :KeycloakProfile
  constructor(public keycloak: KeycloakService) {
  }
  ngOnInit(): void {
    if (this.keycloak.isLoggedIn()){
      this.keycloak.loadUserProfile().then(profile=>{
        this.profile=profile;
      });
    }
  }

  async login() {
    await this.keycloak.login({
      redirectUri: window.location.origin
    });
  }

  logout() {
    this.keycloak.logout(window.location.origin)
  }
}
