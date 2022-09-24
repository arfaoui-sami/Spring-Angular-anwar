import { Component, OnInit } from '@angular/core';
import { UserModule } from '../models/user/user.module';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log("++++++++",this.form);
    let user=new UserModule(this.form.name,this.form.username,this.form.email, this.form.password,this.form.phone,this.form.imageUrl ,this.form.role) 
    console.log("9999999",user);
    // var formData = new FormData();
    // formData.append("name",this.form.name);
    // formData.append("username",this.form.username);
    // formData.append("email",this.form.email);
    // formData.append("password",this.form.password);
    // formData.append("role[]",this.form.role);
    // console.log(formData.);
       
    this.authService.register(user).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}