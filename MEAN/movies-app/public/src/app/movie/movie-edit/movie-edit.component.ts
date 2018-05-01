import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Movie } from './../movie';

@Component({
  selector: 'app-movie-edit',
  templateUrl: './movie-edit.component.html',
  styleUrls: ['./movie-edit.component.css']
})
export class MovieEditComponent implements OnInit {
  @Input() movie: Movie;
  @Output() updateMovieEvent = new EventEmitter();
  movieEdit: Movie = new Movie();

  constructor() { }

  ngOnInit() {
  	Object.assign(this.movieEdit, this.movie)
  	console.log(this.movieEdit);
  }
  update(){
  	this.movieEdit.editable = false;
  	this.updateMovieEvent.emit({original: this.movie, edited: this.movieEdit});
  }

}
