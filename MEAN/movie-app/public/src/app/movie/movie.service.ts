import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Movie } from './movie';
import "rxjs/add/operator/map";
import { Observable } from "rxjs";

@Injectable()
export class MovieService {

  constructor(public _http: Http) { }

  create(movie: Movie){
  	return this._http.post("/movies", movie).map(data => data.json()).toPromise()


  }

  destroy(movie: Movie){
  	return this._http.delete("/movies/"+ movie._id).map(data => data.json()).toPromise()

  }


  update(movie: Movie){
  	return this._http.put("/movies/"+movie._id, movie).map(data => data.json()).toPromise()

  }

  getMovies(){
  	return this._http.get("/movies").map(data => data.json()).toPromise()

  }

  getMovie(movie: Movie){
  	return this._http.get("/movies/"+movie._id).map(data => data.json()).toPromise()

  }

}
