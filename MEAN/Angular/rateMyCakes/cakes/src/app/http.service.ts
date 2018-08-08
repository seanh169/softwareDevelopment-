import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HttpService {

  constructor(private _http: HttpClient) { }



  addCake(newCake){
  		// console.log(newtask.title + " "+ newtask.description);
  		// return this._http.post('/task', newtask)
  		return this._http.get('/new/'+ newCake.title + '/' + newCake.URL + '/', newCake);

  		// return this._http.get('/task', newtask);

  		
  		// console.log(this._http.get('/tasks'));
  		
  }
   getCakes() {
 		return this._http.get('/cakes');
	 }

}

