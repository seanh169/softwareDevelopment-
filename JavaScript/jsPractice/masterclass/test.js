// let someObject = {
//     makeNoise(){ return 'woot'; }, //will be ignored 
//     someRandomThing: undefined, //will be ignored 
//     thisOne: 'is ok', 
//     why: 'because hashtag data'
//    }

// console.log(JSON.stringify(someObject))


// let restaurant = {
//     name: "Prego",
//     location: "Ponsonby",
//     city: "Auckland",
//     country: "New Zealand", 
//     staff: { fullTime: 15, partTime: 6}
//   }

//   let dishList = [
//     {dish: "MARGHERITA", 
//      description: "Napoli style"},
//     {dish: "CAPRICCIOSA", 
//      description: "Napoli style"},
//      ]


//      restaurant.menu = dishList;

//     //  console.log(JSON.stringify(restaurant, function replacer(key, value){
//     //     if(key == 'city'){ return undefined};
//     //     return value;
//     //   })
//     //   );
//     // console.log(JSON.stringify(restaurant, null, 3));
// let someStringArrayThing = "[0, 1, 2, 3]";
// let turnItBack = JSON.parse(someStringArrayThing);
// console.log(turnItBack);

// var counter = function () {
//   var count = 0;
//   return {
//     getCount: function getCount() {
//       return count;
//     },
//     increment: function increment() {
//       count += 1;
//       return "new Count " + count;
//     }
//   };
// };

// const counter = {

//   count = 0,

//   getCount() {
//     return this.count;
//   }


// }


// console.log(counter.count)
// console.log(counter().increment())

const bark = () => {
  let barkingNoise = "BARK BARK BARK";

  return {
    barking: ()=> console.log(barkingNoise),
    setBarkingNoise: (newNoise)=> barkingNoise = newNoise
  }
}

const sniff = () => {
  let sniff = "SNIFFING THE GROUND";

  return {
    sniff: () => console.log(sniff)
  }
}

const snifflesTheDog = Object.assign({}, bark(), sniff());


// snifflesTheDog.sniff()
snifflesTheDog.setBarkingNoise("HA HA HA");
snifflesTheDog.barking()


