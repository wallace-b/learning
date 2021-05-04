/* Love Calculator and Pseudo-random Generation */
var name1 = prompt("Please enter the first name:");
var name2 = prompt("Please enter the second name:");
var scale = 100;
var n = Math.random();
n = Math.floor(n*scale) + 1;
console.log("The probability of LOVE is: " + n + "%.");
