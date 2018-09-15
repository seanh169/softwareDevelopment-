import { NgModule } from '@angular/core'; 
import { Routes, RouterModule } from '@angular/router';
import { SanJoseComponent } from './san-jose/san-jose.component';
import { SeattleComponent } from './seattle/seattle.component';
import { WasdcComponent } from './wasdc/wasdc.component';
import { DallasComponent } from './dallas/dallas.component';
import { ChicagoComponent } from './chicago/chicago.component';
import { BurbankComponent } from './burbank/burbank.component';

const routes: Routes = [
	
	{ path: 'sanJose',component: SanJoseComponent},
	{ path: 'seattle',component: SeattleComponent},
	{ path: 'wasdc',component: WasdcComponent},
	{ path: 'dallas',component: DallasComponent},
	{ path: 'chicago',component: ChicagoComponent},
	{ path: 'burbank',component: BurbankComponent},
	{ path: '', pathMatch: 'full', redirectTo: '/wasdc' },
	// { path: }





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
