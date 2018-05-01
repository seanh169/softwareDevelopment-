import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Movie } from './../movie';
import { MovieService } from './../movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  movies : Array<Movie>;
  @Output() destroyMovieEvent = new EventEmitter();
  @Output() updateMovieEvent = new EventEmitter();

  constructor(private _movieService: MovieService) { }

  ngOnInit() {
  this.getMovies();
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


}
