function linearSearch(arr, value) { 
    
    for(let [index, val] of arr.entries()) { 
        if(val === value){
            return index;
        }
    }
    return -1;



}

console.log(linearSearch([1,2,3], 2));