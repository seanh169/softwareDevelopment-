import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HttpService {
	getPokemon(){
    	let bulbasaur = this._http.get('https://pokeapi.co/api/v2/pokemon/1/');
    	bulbasaur.subscribe(data => console.log(data.name));
    
	}
	getAbiltiies(){
		let bulbasaur = this._http.get('https://pokeapi.co/api/v2/pokemon/1/');
		

		bulbasaur.subscribe(data => {
			console.log("Bulbasur's first ability is: " + data.abilities[0].ability.name)
			console.log("Bulbasur's second ability is: " + data.abilities[1].ability.name)
		})
	}
	showSimilar() {
		let allPokemonAbilityOne = this._http.get('https://pokeapi.co/api/v2/ability/34/');
		allPokemonAbilityOne.subscribe(data => {
			let counter = 0;
			for(let i in data.pokemon){counter++;}
			console.log(counter + " Pokemon also have the chlorophyll ability");
		})
		let allPokemonAbilityTwo = this._http.get('https://pokeapi.co/api/v2/ability/65/');
		allPokemonAbilityTwo.subscribe(data => {
			let counter = 0;
			for(let i in data.pokemon){counter++;}
			console.log(counter + " Pokemon also have the overgrow ability");
		})
	}
  constructor(private _http: HttpClient) {
    // this.getPokemon();
    // this.getAbiltiies();
    // this.showSimilar();
	}


}
