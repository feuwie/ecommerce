import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  constructor(private http: HttpClient) { }
  getItems() {
    this.http.get('http://localhost:8080/hello', {responseType: 'text'}).subscribe(result => {
      console.log(result);
    });
  }
}
