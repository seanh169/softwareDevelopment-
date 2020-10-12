var twoSum = function(nums, target) {
    
    let obj = {};
    
    for(let i = 0; i < nums.length; i++) {
        obj[nums[i]] = i;
        let val = target - nums[i];
        if(val in obj){
            console.log(i, obj[val]);
        }
    }
    
};

twoSum([2, 7, 11, 15], 9);