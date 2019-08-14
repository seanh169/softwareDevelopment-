function pigIt(str) {
    let inputString = str.split(' ');
    console.log(inputString);
    // return inputString.map(v => v.match(/[A-Za-z]/) ? v.slice(1) + v.slice(0, 1) + 'ay' : v).join(' ');
    
}

pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
// pigIt('Hello world !');     // elloHay orldway !
// console.log('Pig latin is cool'.slice(1))

// console.log('Pig latin is cool'.slice(0, 1))

console.log('Pig latin is cool'.slice(1) + 'Pig latin is cool'.slice(0, 1) + 'ay');
