import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Movie } from './../movie';

@Component({
  selector: 'app-movie-new',
  templateUrl: './movie-new.component.html',
  styleUrls: ['./movie-new.component.css']
})
export class MovieNewComponent implements OnInit {
  newMovie = new Movie();
  @Output() createNewMovieEvent = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  create(){
  	// call the server to save
  	this.createNewMovieEvent.emit(this.newMovie);
  	this.newMovie = new Movie();


  }

}
