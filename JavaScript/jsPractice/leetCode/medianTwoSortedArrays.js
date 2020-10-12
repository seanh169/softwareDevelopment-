var findMedianSortedArrays = function(nums1, nums2) {
    let newArr = nums1.concat(nums2).sort((a,b)=>a-b);
    if(newArr.length === 1) {
        return newArr[0];
    }
    console.log(newArr);
    let midpoint =  Math.floor(newArr.length / 2);
    // console.log(midpoint)
    let median = 0;
    if(newArr.length % 2 === 0) {
        median = ((newArr[midpoint] + newArr[midpoint - 1]) / 2)
    }else{
        median = newArr[midpoint];
    }
    return median;
};

// console.log(findMedianSortedArrays([1, 3], [2]))
// console.log(findMedianSortedArrays([1, 2], [3,4]))
// console.log(findMedianSortedArrays([], [1]))
console.log(findMedianSortedArrays([3], [-2,-1]))
// console.log(-1 < -2)
// console.log(findMedianSortedArrays([], [2,3]))