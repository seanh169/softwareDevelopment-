function binarySearch (arr ,value) {

    let left = 0;
    let right = arr.length-1;
    
    while(left <= right) {
        let pivot = Math.floor((left+right) / 2);
        if(value === arr[pivot]){
            return pivot;
        }
        if(value < arr[pivot]){
            right = pivot - 1;
        }
        if(value > arr[pivot]){
            left = pivot + 1;
        }
    }

    return -1;

}

console.log(binarySearch([1,2,3,4,5,6], 2));


// 1
// 6

// pivot  = 4

// 2 < 4