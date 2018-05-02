import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { Router } from '@angular/router';

import { AppComponent } from './app.component';
import { AutoComponent } from './auto/auto.component';
import { AutoHomeComponent } from './auto/auto-home/auto-home.component';
import { AutoAboutComponent } from './auto/auto-about/auto-about.component';
import { AutoTeamComponent } from './auto/auto-team/auto-team.component';
import { AutoBodyShopComponent } from './auto/auto-body-shop/auto-body-shop.component';
import { AutoContactUsComponent } from './auto/auto-contact-us/auto-contact-us.component';
import { AutoReviewsComponent } from './auto/auto-reviews/auto-reviews.component';


@NgModule({
  declarations: [
    AppComponent,
    AutoComponent,
    AutoHomeComponent,
    AutoAboutComponent,
    AutoTeamComponent,
    AutoBodyShopComponent,
    AutoContactUsComponent,
    AutoReviewsComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
