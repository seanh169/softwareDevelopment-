import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Dojo Weather Forecast';
  constructor(
    private _route: ActivatedRoute,
    private _router: Router
  ) {}

  ngOnInit() {
  	// console.log('hello');
  	// let observable = this._httpService.http.get('/api.openweathermap.org/data/2.5/forecast?id=524901&APPID=195a40dd1ccaaeb3f13684fe02f04bcd')
  	this._route.params.subscribe((params: Params) => {
        console.log(params['id'])
    });
  }
  goHome() {
    this._router.navigate(['/']);
  }
}
