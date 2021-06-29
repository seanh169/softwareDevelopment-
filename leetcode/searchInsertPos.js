/** Given a sorted array and a target value,
 *  return the index if the target is found.
 *  If not, return the index where it would be 
 *  if it were inserted in order.

You may assume no duplicates in the array. */


/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
    if(nums.includes(target)){
        return nums.findIndex(i=> i === target);
    }else{
        for(let i = 0; i < nums.length; i++){
            if(nums[i] <= target && nums[i+1] > target || 
               nums[i] <= target && nums[i + 1] === undefined) {
                return i+1;
            }

            if(nums[i] > target && nums[i-1] === undefined ){
                return i;
            }
        }
    }
};

console.log(searchInsert([1,3,5,6], 5))
console.log(searchInsert([1, 3, 5, 6], 2))
console.log(searchInsert([1, 3, 5, 6], 7))
console.log(searchInsert([1, 3, 5, 6], 0))