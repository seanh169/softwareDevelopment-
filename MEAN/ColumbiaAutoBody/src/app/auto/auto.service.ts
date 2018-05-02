import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { HttpClient } from "@angular/common/http";
import 'rxjs/add/operator/map';

@Injectable()
export class AutoService {

  constructor(private _http : Http) { }

  // getReviews() {
  //   return this._http.get("https://mybusiness.googleapis.com/v3/accounts/account_name/locations/location_name/reviews")
  // }

}
