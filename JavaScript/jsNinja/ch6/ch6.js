// function* WeaponGenerator(){
//     yield "Katana";
//     yield "Wakizashi";
// }
// // console.log(WeaponGenerator);
// const weaponsIterator = WeaponGenerator();
// // const result1 = weaponsIterator.next();
// // if(typeof result1 === "object" && result1.value === "Katana" && !result1.done){
// //     console.log("Katana received!");
// //     console.log(result1);
// // }
// // const result2 = weaponsIterator.next();
// // if(typeof result2 === "object" && result2.value === "Wakizashi" && !result2.done){
// //     console.log("Wakizashi received!");
// // }
// // const result3 = weaponsIterator.next();
// // if(typeof result3 === "object" && result3.value === undefined && result3.done){
// //     console.log("No More Results!");
// // }

// let item;
// while(!(item = weaponsIterator.next()).done){
//     console.log(item);
// }

// function* NinjaGenerator(action){
//     const imposter = yield ("Hattori " + action);
//     if(imposter === "Hanzo"){
//         console.log("Generator has been infiltrated");
//     }
//     yield ("Yoshi (" + imposter + ") " + action);
// }
// const ninjaIterator = NinjaGenerator("skulk");
// console.log(ninjaIterator);



let undeclaredVariable =1;
const prom = new Promise((res, rej) => {
    undeclaredVariable++;
})

return prom.then(()=> console.log("passed"))
    .catch(e=>{
        console.log(e)
})