import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';







@Injectable()


export class HttpService {
	// getTasks(){
 //    // our http response is an Observable, store it in a variable
 //    let tempObservable = this._http.get('/tasks');
 //    // subscribe to the Observable and provide the code we would like to do with our data from the response
 //    tempObservable.subscribe(data => console.log("Got our tasks!", data));
 // 	}
  	constructor(private _http: HttpClient) { 
  	// console.log(this._http.get('/'));
  	// this.getTasks();

  	}
  	addTask(newtask){
  		// console.log(newtask.title + " "+ newtask.description);
  		// return this._http.post('/task', newtask)
  		return this._http.get('/new/'+ newtask.title + '/' + newtask.description + '/', newtask);

  		// return this._http.get('/task', newtask);

  		
  		// console.log(this._http.get('/tasks'));
  		
  	}
	 getTasks() {
 		return this._http.get('/tasks');
	 }
	 editTask(thistask){
	 	return this._http.get('/' + thistask);
	 }
	 updateTask(thisTas, thisId){
	 	console.log(thisTas.title);
	 	console.log(thisId);
	 	console.log(this._http.get('/update/'+thisId + '/' + thisTas.title + '/' + thisTas.description + '/'));
	 	return this._http.get('/update/'+thisId + '/' + thisTas.title + '/' + thisTas.description + '/');
	 }	
	 deleteTask(deleteID){
	 	return this._http.get('/remove/' + deleteID);
	 }
}
