import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import { fromPromise } from 'rxjs';

@Injectable()
export class HttpService {

  constructor(private _http: HttpClient) { 
  // 	let x = _http.get(`http://api.openweathermap.org/data/2.5/weather?id=4140963&APPID=195a40dd1ccaaeb3f13684fe02f04bcd`);
  // 	x.subscribe(data => {
  		
  // 		console.log(data)


  // 	})

  // }



}


  // {
  //   "id": 4140963,
  //   "name": "Washington, D. C.",
  //   "country": "US",
  //   "coord": {
  //     "lon": -77.036369,
  //     "lat": 38.895111
  //   }
  // },