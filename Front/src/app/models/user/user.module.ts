export class UserModule { 
    public name:string;
    public username:string;
    public email:string;
    public password: string;
    phone : string;
    imageUrl : string;
    public role:string[]=[];

    constructor(  name:string,  username:string,  email:string,  password:string,phone:string,imageUrl:string, role:string ){
      this.name=name;
      this.username=username;
      this.email=email;
      this.password=password;
      this.phone=phone;
      this.imageUrl=imageUrl;

      this.role.push(role);
    }
}
