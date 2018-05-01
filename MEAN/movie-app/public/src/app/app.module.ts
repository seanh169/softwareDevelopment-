import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MovieService } from './movie/movie.service';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
// import { RouterModule, Routes } from '@angular/router';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import { MovieComponent } from './movie/movie.component';
import { MovieDetailsComponent } from './movie/movie-details/movie-details.component';
import { MovieListComponent } from './movie/movie-list/movie-list.component';
import { MovieNewComponent } from './movie/movie-new/movie-new.component';
import { MovieEditComponent } from './movie/movie-edit/movie-edit.component';
import { ReviewNewComponent } from './movie/review-new/review-new.component';

const appRoutes: Routes = [
  {path: '', component : MovieComponent}
  { path: 'moviez', component: MovieListComponent},
  { path: 'moviez/:id', component: MovieDetailsComponent},
  { path: 'moviez/new', component: MovieNewComponent},
  { path: 'moviez/review/:id', component: ReviewNewComponent}
  

]


@NgModule({
  declarations: [
   
    AppComponent,
    MovieComponent,
    MovieDetailsComponent,
    MovieListComponent,
    MovieNewComponent,
    MovieEditComponent,
    ReviewNewComponent,
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false } // <-- debugging purposes only
    )
  ],
  providers: [MovieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
