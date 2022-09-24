import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import {ExportService} from '../_services/export.service';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from '../_services/token-storage.service';
export class User{
  constructor(
   public id: number,
    public sensor: string,
    public value1: string,
    public date: String ,
  ) {
  }}

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {

  content: string;
  _filtertext:string='';
  users:User[];
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showUserBoard = false;
  username: string;
get filtertext(){
  return this._filtertext;
}
set filtertext(value:string){
  this._filtertext=value;
}
  constructor(private exportService: ExportService,private userService: UserService, private httpClient: HttpClient,private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.userService.getUserBoard().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles?.includes('ROLE_ADMIN');
      this.showUserBoard = this.roles?.includes('ROLE_USER');

      this.username = user.username;
    }
    this.getUsers();

  }
  dateselect:any
fetchdateselct(){
this.dateselect=this.filtertext;
  this.users=this.users.filter(res=> {
    return res.date.includes(this.dateselect);
    console.log(this.dateselect)
   })

}
  search(){
    this.users=this.users.filter(res=>{
return res.date.includes(this.dateselect);
      }

    )
  }
  export() {
    this.exportService.exportExcel(this.users, 'users');
  }


  getUsers(){
    this.httpClient.get<any>('http://localhost:8080/getdata').subscribe(
      response => {
        console.log(response);
        this.users = response;
      }
    );

}
 formatdate (d){
  return new Date(d)

 }
logout(): void {
  this.tokenStorageService.signOut();
  window.location.reload();
}
}
