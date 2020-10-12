// Closures

// TWO BIG BENEFITS - 

// 1 . Memory efficient 


function heavyDutyFunction(idx){
    const bigArr = new Array(7000).fill('hi')
    console.log('created')
    return bigArr[idx]
}
// Each call to heavyDutyFunction creates a new bigArr 
// console.log(heavyDutyFunction(10))
// console.log(heavyDutyFunction(20))
// console.log(heavyDutyFunction(30))

// with closures we can make the same function but only create the original array once! amainzg! 
function heavyDutyFunctionWithClosure(){
    const bigArr = new Array(7000).fill('hi')
    console.log('created')
    return function(idx){
        return bigArr[idx]
    }
}

// const heavyClosure = heavyDutyFunctionWithClosure();
// console.log(heavyClosure(10))
// console.log(heavyClosure(20))
// console.log(heavyClosure(30))

// 2. Encapsulation
// const makeNuclearButton = () => {

//     let timeWithoutDestruction = 0;
//     const passTime = () => timeWithoutDestruction++;
//     const totalPeaceTime = () => timeWithoutDestruction;
//     const launch = () => {
//         timeWithoutDestruction = -1;
//         return "BOOM"
//     } 
//     setInterval(passTime, 1000)

//     return {
//         launch: launch,
//         totalPeaceTime: totalPeaceTime
//     }
// }

// const ohno = makeNuclearButton();
// ohno.totalPeaceTime()