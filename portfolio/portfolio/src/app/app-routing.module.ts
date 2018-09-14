import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContentComponent } from './content/content.component';
import { FooterComponent } from './footer/footer.component';
import { HeadingComponent } from './heading/heading.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';

const routes: Routes = [

	{ path: 'About',component: AboutComponent},
	{ path: 'content', component: ContentComponent},
	{ path: 'contact', component: ContactComponent},
	{ path: '', pathMatch: 'full', redirectTo: '/content' },
	




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
