let xArr = [0, 2, 4, 6, 8, 10];
console.log(...xArr);

function containsAll(arr, ...nums) {
    for (let num of nums) {
        // indexOf() method returns the first index at which a given element can be found in the array, or -1 if it is not present\
        console.log("checking..." + num);
        if (arr.indexOf(num) === -1) {
            return false;
        }
    }
    return true;
    // i.e. for all ...nums, check if the element is present. If not present (-1), return false immediately.
}

console.log(containsAll(xArr, 4, 6, 8));
console.log(containsAll(xArr, 0, 2, 10));
console.log(containsAll(xArr, 1, 2, 4));
console.log(containsAll(xArr, 2, 3, 6));