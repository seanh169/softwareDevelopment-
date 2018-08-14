import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
@Injectable()
export class HttpService {

  constructor(private _http: HttpClient) { }





  addAuthor(newauthor){
  	return this._http.get('/new/'+ newauthor.name +'/', newauthor);
  }	
















}
