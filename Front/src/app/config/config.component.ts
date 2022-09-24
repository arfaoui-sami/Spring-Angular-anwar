import { Component, OnInit } from '@angular/core';
import { Materiel } from '../materiel';
import { TokenStorageService } from '../_services/token-storage.service';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { MaterielService} from '../materiel.service';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit {
  public materiels: Materiel[] ;
  public editMateriel: Materiel | null | undefined;
  public deleteMateriel: Materiel | null | undefined;
  content: string;

  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showUserBoard = false;
  username: string;
  constructor(private materielService: MaterielService, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles?.includes('ROLE_ADMIN');
      this.showUserBoard = this.roles?.includes('ROLE_USER');

      this.username = user.username;
    }
    this.getMateriels();
  }
  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

  public getMateriels(): void {
    this.materielService.getMateriels().subscribe(
      (response: Materiel[]) => {
        this.materiels = response;
        console.log("liste utlisateurs",this.materiels);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddMateriel(addForm: NgForm): void {
    console.log(addForm)
   // document.getElementById('add-user-form').click();
   document.getElementById('add-materiel-form')?.click();
    this.materielService.addMateriel(addForm.value).subscribe(
      (response: Materiel) => {
        console.log(response);
        this.getMateriels();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateMateriel(materiel: Materiel): void {
    this.materielService.updateMateriel(materiel).subscribe(
      (response: Materiel) => {
        console.log(response);
        this.getMateriels();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public onDeleteMateriel(materielId:any): void {
    this.materielService.deleteMateriel(materielId).subscribe(
      (response: void) => {
        console.log(response);
        this.getMateriels();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(materiel: Materiel | null | undefined, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'add') {

      button.setAttribute('data-target', '#addMaterielModal');
    }
    if (mode === 'edit') {
      this.editMateriel = materiel;
      button.setAttribute('data-target', '#updateMaterielModal');
    }
    if (mode === 'delete') {
      this.deleteMateriel = materiel;
      console.log(this.deleteMateriel)
      button.setAttribute('data-target', '#deleteMaterielModal');
    }
    container?.appendChild(button);
    button.click();
    console.log("hiiii", button)
  }

}
