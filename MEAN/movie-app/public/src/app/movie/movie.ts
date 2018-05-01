export class Movie {
	constructor(
		public _id: string = "",
		public title: string = "",
		public reviewer: string = "",
		public stars: number = 0,
		public reviews: Array<Object> = [],
		public editable: boolean = false
	){}
}
