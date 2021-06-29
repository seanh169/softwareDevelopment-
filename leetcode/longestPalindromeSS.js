/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {

    if(s.length === 0) return false;



    let longestPalin = '';
    let longP = '';

    const isPalindrome = (s) => {
        return s === s.split('').reverse().join('')
    }

    for(let i = 0; i < s.length; i++) {
        longP = s[i];
        for(let j = i+1; j < s.length; j++){
            longP += s[j];
            if(isPalindrome(longP) && longP.length > longestPalin.length) {
                longestPalin = longP;
            }
        }
        longP = '';
    }

    return longestPalin

};

console.log(longestPalindrome("baba"))
console.log(longestPalindrome("cbbd"))
console.log(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"))
// 