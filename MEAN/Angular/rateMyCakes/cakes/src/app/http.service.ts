import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HttpService {

  constructor(private _http: HttpClient) { }



  addCake(newCake){
      let newCakez = newCake.URL.slice(8, newCake.URL.length-4);
  		console.log(newCake.URL);
  		return this._http.get('/new/'+ newCake.title + '/' + newCakez + '/', newCake);

  		// return this._http.get('/task', newtask);

  		
  		// console.log(this._http.get('/tasks'));
  		
  }
   getCakes() {
 		return this._http.get('/cakes');
	 }

}

