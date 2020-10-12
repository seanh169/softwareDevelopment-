function solution(input, markers) {
    let markerFlag = false;
    let result = [];
    let inputString = input.split('');
    for(i of inputString){
        if(markers.includes(i)){
            markerFlag = true;
        }
        if(markerFlag && i === '\n'){
            markerFlag = false;
        }
        if(!markerFlag){
            result.push(i);
        }
    }
    let finalResult = result.join("").replace(/\s\n/,'\n').trim();
    return finalResult;
  
};

console.log(solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"]));