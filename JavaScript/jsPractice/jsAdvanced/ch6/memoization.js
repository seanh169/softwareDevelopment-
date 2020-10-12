
function addTo80 () {
    let cache = {};
    return function(n) {
        if(cache.hasOwnProperty(n)){
            console.log('got here')
            return cache[n];
        }
        cache[n] = n + 80;
        return n + 80;
    }
    
}
const memoizded = addTo80();
console.log(memoizded(5))
console.log(memoizded(5))

