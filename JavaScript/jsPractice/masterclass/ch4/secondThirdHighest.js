function secondThirdHighest(inputArr) { 

    let x = [...new Set(inputArr)];
    let y = x.sort((a,b) => {return b-a});

    let secondHighest;
    let thirdHighest;

    if(y.length >= 3) {
        secondHighest = y[1];
        thirdHighest = y[2];
    }

    if(y.length === 2) { 
        secondHighest = y[1];
        thirdHighest = undefined;
    }

    if(y.length < 2) { 
        secondHighest = undefined;
        thirdHighest = undefined;
    }

    return {secondHighest: secondHighest, thirdHighest: thirdHighest};

}


console.log(secondThirdHighest([5,3,2,1,4]));
console.log(secondThirdHighest([5,3,2,1,4,5]));
console.log(secondThirdHighest([5,5]));