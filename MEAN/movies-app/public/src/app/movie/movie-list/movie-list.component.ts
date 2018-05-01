import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Movie } from './../movie';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  @Input() movies;
  @Output() destroyMovieEvent = new EventEmitter();
  @Output() updateMovieEvent = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }
  destroy(movie: Movie){
  	this.destroyMovieEvent.emit(movie);
  }

  update(movies){
    this.updateMovieEvent.emit(movies)
  }

}
