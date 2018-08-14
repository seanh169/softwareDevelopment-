import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class HttpService {

  constructor(private _http: HttpClient) { 


  }
  getAuthors(){
  	return this._http.get('/authors');
  }
  // addAuthor(newtask){
  // 		// console.log(newtask.title + " "+ newtask.description);
  // 		// return this._http.post('/task', newtask)
  // 		return this._http.get('/new/'+ newtask.title + '/' + newtask.description + '/', newtask);

  // 		// return this._http.get('/task', newtask);

  		
  // 		// console.log(this._http.get('/tasks'));
  		
  // 	}

}
