import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  getAdminBoard() {
    throw new Error('Method not implemented.');
  }
  private apiServerUrl ='http://localhost:8080' ;

  constructor(private http: HttpClient) { }
  public getUsers(): Observable<User[]> {
    //console.log('hiiiiii', this.http.get<User[]>(`${this.apiServerUrl}/user/all`))
    return this.http.get<User[]>(`${this.apiServerUrl}/user/all`);
  }
  // public getUsers(): Observable<User[]>{
  //   return this.http.get<User[]>('${this.apiServerUrl}/user/all');
  // }

  // public addUser(user: User): Observable<User> {
  //   return this.http.post<User>(`${this.apiServerUrl}/user/add`, user);
  // }
  public addUser(user:User): Observable<User>{
    return this.http.post<User>(`${this.apiServerUrl}/user/add`, user);
  }

  // public updateUser(user: User): Observable<User> {
  //   return this.http.put<User>(`${this.apiServerUrl}/user/update`, user);
  // }
  public updateUser(user :User): Observable<User>{
    return this.http.put<User>(`${this.apiServerUrl}/user/update`, user); 
}
  public deleteUser(userId: User): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/user/delete/${userId}`);
  }

}