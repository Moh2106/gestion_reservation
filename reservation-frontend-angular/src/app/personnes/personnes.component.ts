import { Component } from '@angular/core';
import {PersonneService} from "../service/personnes/personne.service";

@Component({
  selector: 'app-personnes',
  templateUrl: './personnes.component.html',
  styleUrl: './personnes.component.css'
})
export class PersonnesComponent {
  constructor(private personneService: PersonneService) {
  }

  personnes : Array<any> = []

  ngOnInit(): void {
    this.findAll();
  }

  findAll(){
    this.personneService.findAllPersonne()
      .subscribe({
        next: value => this.personnes = value,
        error: err => console.error("Une erreur s'est produite lors de la récupération de la donnée")
      })
  }

  deleteById(id:number) {
    const confirmation = confirm("Are you sure ?")
    if (confirmation) {
      this.personneService.deletePersonne(id)
        .subscribe(() => {
          console.log(`L'élément avec l'ID ${id} est supprimé`);
        });

      this.personnes = this.personnes.filter(value => value.id != id)
    }
  }

}
