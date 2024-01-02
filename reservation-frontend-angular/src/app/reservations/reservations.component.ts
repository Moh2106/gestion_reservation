import { Component } from '@angular/core';
import {ReservationService} from "../service/reservations/reservation.service";
import {PersonneService} from "../service/personnes/personne.service";

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrl: './reservations.component.css'
})
export class ReservationsComponent {
  constructor(private reservationService: ReservationService, private personneService: PersonneService) {
  }

  reservations : Array<any> = []
  personne! : any
  showTable : boolean = false

  ngOnInit(): void {
    this.findAll();
  }

  findAll(){
    this.reservationService.findAllReservation()
      .subscribe({
        next: value => this.reservations = value,
        error: err => console.error("Une erreur s'est produite lors de la récupération de la donnée")
      })
  }

  deleteById(id:number) {
    const confirmation = confirm("Are you sure ?")
    if (confirmation) {
      this.reservationService.deleteReservation(id)
        .subscribe(() => {
          console.log(`L'élément avec l'ID ${id} est supprimé`);
        });

      this.reservations = this.reservations.filter(value => value.id != id)
    }
  }

  showPersonne(personne_id: number) {
    this.showTable = true

    this.personneService.findPersonneById(personne_id)
      .subscribe({
        next : value => this.personne = value,
        error : err => console.error("Une erreur s'est produite lors de la récupération de la donnée")
      })
  }
}
