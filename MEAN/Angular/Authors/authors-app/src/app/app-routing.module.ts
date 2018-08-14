import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewAuthorComponent} from './new-author/new-author.component';
const routes: Routes = [
	{path: 'new',component: NewAuthorComponent},
	{ path: '', pathMatch: 'full', redirectTo: '/' },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
