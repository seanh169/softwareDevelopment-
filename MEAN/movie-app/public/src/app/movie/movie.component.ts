import { Component, OnInit } from '@angular/core';
import { Movie } from './movie';
import { MovieService } from './movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
	
	movies: Array<Movie> = [
	// 	new Movie(1,"HarryPotter","Sean",3,[{name:"jim",review:"shitty",stars:5}],false),
	// 	new Movie(2,"HarryPotter","Sean",3,[{name:"jim",review:"shitty",stars:5}],false)
	];


  constructor(
    public _movieService: MovieService,
    private router : Router
    ) { }

  ngOnInit() {
    this.router.navigate(["/moviez"]);
  	// this.getMovies();
  }

  create(movie: Movie){
    this._movieService.create(movie)
    .then(status => this.getMovies())
    .catch(err => console.log(err));
    this.movies.push(movie);
  }

  destroy(movie: Movie){
    
    this._movieService.destroy(movie)
    .then(status => this.getMovies())
    .catch(err => console.log(err));
    
  }

  update(movie: Movie){
    console.log(movie);
    this._movieService.update(movie)
    .then(status => this.getMovies())
    .catch(err => console.log(err));
  }

  getMovies(){
  	this._movieService.getMovies()
  	.then(movies => this.movies = movies)
    .catch(err => console.log(err));

  }

}
