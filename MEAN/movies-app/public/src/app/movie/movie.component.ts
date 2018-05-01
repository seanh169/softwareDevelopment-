import { Component, OnInit } from '@angular/core';
import { Movie } from './movie';
import { MovieService } from './movie.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
	
	movies: Array<Movie> = [
		new Movie(1,"HarryPotter","Sean",3,[{name:"jim",review:"shitty",stars:5}],false),
		new Movie(2,"HarryPotter","Sean",3,[],false)
	];


  constructor(private _movieService: MovieService) { }

  ngOnInit() {
  	// this.getMovies();
  }

  create(movie: Movie){
    this.movies.push(movie);
  }

  destroy(movie: Movie){
    const i = this.movies.indexOf(movie);
    this.movies.splice(i, 1);
  }

  update(movies: any){
    console.log(movies);
    const i = this.movies.indexOf(movies.original)
    this.movies[i] = movies.edited;
  }

  getMovies(){
  	// this._movieService.getMovies()
  	// .then(movies => this.movies = movies)

  }

}
