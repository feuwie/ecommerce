import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';

@Injectable()
export class HttpService {

    constructor(private http: HttpClient) { }

    postAdd(user: User) {
        const body = { name: user.name, age: user.age };
        return this.http.post('http://localhost:8080/hello/add', body);
    }

    postDel(user: User) {
        const body = { id: user.id };
        return this.http.post('http://localhost:8080/hello/delete', body);
    }

    postUpd(user: User) {
        const body = { id: user.id, name: user.name, age: user.age };
        return this.http.post('http://localhost:8080/hello/update', body);
    }
    postListOne(user: User) {
        const body = { id: user.id };
        return this.http.post('http://localhost:8080/hello/{id}', body);
    }
    getListAll() {
        return this.http.get('http://localhost:8080/hello/all', { responseType: 'json' });
    }
}
