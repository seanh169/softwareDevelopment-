import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Movie } from './../movie';
import { MovieService } from './../movie.service';
import { Router, ActivatedRoute, Params} from '@angular/router';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {
	movies : Array<Movie>;
  @Output() destroyMovieEvent = new EventEmitter();
  @Output() updateMovieEvent = new EventEmitter();

  constructor(private _movieService: MovieService) { }

  ngOnInit() {
  this.activatedRoute.params.subscribe((params: Params)=>{
  let movieId = params['movieId'];
  });
  this.getMovie();
  }
  destroy(movie: Movie){
  	this.destroyMovieEvent.emit(movie);
  }

  update(movie: Movie){
    this.updateMovieEvent.emit(movie)
  }
   getMovies(){
    this._movieService.getMovies()
    .then(movies => this.movies = movies)
    .catch(err => console.log(err));

  }
  getMovie() {
  this.activatedRoute.params.subscribe((params: Params) =>{
  let movieId = params['movieId'];
  this._movieService.getMovieId(params.id)
  .then(movie => this.movieEdit = movie)
  .catch(err=> console.log(err));

  });
  }


}