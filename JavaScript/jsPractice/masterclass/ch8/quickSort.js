function quickSort (arr, left = 0, right = arr.length-1) { 

    if(left < right) {
        let pivotIndex  = pivot(arr, left, right);
        // left
        quickSort(arr, left, pivotIndex-1);
        // right
        quickSort(arr, pivotIndex+1,right);
    }
    return arr;
    


}


function pivot(arr, startIdx=0, endIdx=arr.length-1) {

    let pivot =  arr[startIdx];
    let swapIdx = startIdx;

    for(let i = startIdx+1 ; i < arr.length; i++) {
        if (pivot > arr[i]) {
            swapIdx++;
            swap(arr, swapIdx, i);
        }
    }
    swap(arr, startIdx, swapIdx);
    return swapIdx;



}


function swap(arr, i, j) {
    let temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    // console.log(arr);
    return arr;
}


console.log(quickSort([5,6,2,1,9,8]));
// console.log(pivot([5,2,3,4,1]));
// console.log(swap([1,2,3,4,5], 0, 4));