import { Component } from '@angular/core';
import { HttpService } from './http.service';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less'],
  providers: [ HttpService ]
})
export class AppComponent {

  user: User = new User();

  receivedUser: User;
  receivedUserAll: User;

  constructor(private httpService: HttpService) { }


  add(user: User) {
    this.httpService.postAdd(user)
      .subscribe(
        error => console.log(error)
      );
  }

  del(user: User) {
    this.httpService.postDel(user)
      .subscribe(
        error => console.log(error)
      );
  }

  upd(user: User) {
    this.httpService.postUpd(user)
      .subscribe(
        (data: User) => { this.receivedUser = data; },
        error => console.log(error)
      );
  }

  listOne(user: User) {
    this.httpService.postListOne(user)
      .subscribe(
        (data: User) => { this.receivedUser = data; },
        error => console.log(error)
      );
  }

  listAll() {
    this.httpService.getListAll()
      .subscribe(
        (data: User) => { this.receivedUserAll = data; },
        error => console.log(error)
      );
  }
}
