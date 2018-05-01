export class Movie {
	constructor(
		public _id: number = Math.floor(Math.random()*100),
		public title: string = "",
		public reviewer: string = "",
		public stars: number = 0,
		public review: string = "",
		public editable: boolean = false
	){}
}
