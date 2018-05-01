import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MovieService } from './movie/movie.service';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { MovieComponent } from './movie/movie.component';
import { MovieDetailsComponent } from './movie/movie-details/movie-details.component';
import { MovieListComponent } from './movie/movie-list/movie-list.component';
import { MovieNewComponent } from './movie/movie-new/movie-new.component';
import { MovieEditComponent } from './movie/movie-edit/movie-edit.component';


@NgModule({
  declarations: [
    AppComponent,
    MovieComponent,
    MovieDetailsComponent,
    MovieListComponent,
    MovieNewComponent,
    MovieEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [MovieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
