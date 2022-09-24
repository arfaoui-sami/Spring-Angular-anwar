import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Materiel } from './materiel';

import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class MaterielService {
    private apiServerUrl ='http://localhost:8080' ;

  constructor(private http: HttpClient){}

  public getMateriels(): Observable<Materiel[]> {
    return this.http.get<Materiel[]>(`${this.apiServerUrl}/materiel/all`);
  }

  public addMateriel(materiel: Materiel): Observable<Materiel> {
    return this.http.post<Materiel>(`${this.apiServerUrl}/materiel/add`, materiel);
  }

  public updateMateriel(materiel: Materiel): Observable<Materiel> {
    return this.http.put<Materiel>(`${this.apiServerUrl}/materiel/update`, materiel);
  }

  public deleteMateriel(materielId: Materiel): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/materiel/delete/${materielId}`);
  }

}
