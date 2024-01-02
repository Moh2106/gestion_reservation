import { Component } from '@angular/core';
import {ResourceService} from "../service/resources/resource.service";

@Component({
  selector: 'app-resources',
  templateUrl: './resources.component.html',
  styleUrl: './resources.component.css'
})
export class ResourcesComponent {
  resources : Array<any> = [];
  constructor(private resourceService: ResourceService) {
  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(){
    this.resourceService.findAllResource()
      .subscribe({
        next: value => this.resources = value,
        error: err => console.error("Une erreur s'est produite lors de la récupération de la donnée")
      })
  }

  deleteById(id:number){
    const confirmation = confirm("Ettes vous sur de supprimer cette résource ?")
    if (confirmation){
      this.resourceService.deleteResource(id)
        .subscribe(() => {
          console.log(`L'élément avec l'ID ${id} est supprimé`);
        });

      this.resources = this.resources.filter(value => value.id != id)
    }

  }
}
