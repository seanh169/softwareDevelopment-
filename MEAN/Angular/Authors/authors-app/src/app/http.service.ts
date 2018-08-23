import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class HttpService {

  constructor(private _http: HttpClient) { 


  }
  getAuthors(){
  	return this._http.get('/authors');
  }
  addAuthor(newauthor){
    console.log(newauthor);
    return this._http.get('/new/'+ newauthor.name +'/', newauthor);
  }  
  deleteAuthor(deleteID){
     return this._http.get('/remove/' + deleteID);
   }
  findOneAuthor(thisauthor){
     return this._http.get('/' + thisauthor);
   }
   updateAuthor(thisAuthor, thisId){
     console.log(thisAuthor.name)
     // console.log(thisTas.title);
     console.log(thisId); 
     // console.log(this._http.get('/update/'+thisId + '/' + thisTas.title + '/' + thisTas.description + '/'));
     return this._http.get('/update/'+thisId + '/' + thisAuthor.name + '/');
   }  
}
