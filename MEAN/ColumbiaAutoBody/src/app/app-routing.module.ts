import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AutoHomeComponent } from './auto/auto-home/auto-home.component';
import { AutoAboutComponent } from './auto/auto-about/auto-about.component';
import { AutoTeamComponent } from './auto/auto-team/auto-team.component';
import { AutoBodyShopComponent } from './auto/auto-body-shop/auto-body-shop.component';
import { AutoContactUsComponent } from './auto/auto-contact-us/auto-contact-us.component';
import { AutoReviewsComponent } from './auto/auto-reviews/auto-reviews.component';
import { SelectivePreloadingStrategy } from './selective-preloading-strategy';

const appRoutes: Routes = [
    {
      path: 'home',
      component: AutoHomeComponent,
    //   data: { preload: true }
    },
    {
        path: 'about',
        component: AutoAboutComponent,
    },
    {
        path: 'body-shop',
        component: AutoBodyShopComponent,
    },
    {
        path: 'contact-us',
        component: AutoContactUsComponent,
    },
    {
        path: 'reviews',
        component: AutoReviewsComponent,
    },
    {
        path: 'team',
        component: AutoTeamComponent,
    },
    { path: '',   redirectTo: '/home', pathMatch: 'full' },
    { path: '**',  redirectTo: '/home' }
];

@NgModule({
    imports: [
      RouterModule.forRoot(
        appRoutes,
        {
          enableTracing: false, // <-- debugging purposes only
          preloadingStrategy: SelectivePreloadingStrategy,
        }
      )
    ],
    exports: [
      RouterModule
    ],
    providers: [
      SelectivePreloadingStrategy
    ]
  })
  export class AppRoutingModule { }