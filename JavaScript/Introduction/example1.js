/* Love Calculator and Pseudo-random Generation with If Statement (2-Conditional) */
var name1 = prompt("Please enter the first name:");
var name2 = prompt("Please enter the second name:");
var scale = 100;
var n = Math.random();
n = Math.floor(n*scale) + 1;
// n = 91 TEST
if (n > 90) {
  console.log("The probability of LOVE is: " + n + "%. You could be SOULMATES!");
} else if (n > 65) {
  console.log("The probability of LOVE is: " + n + "%. It looks promising.");
} else {
  console.log("The probability of LOVE is :" + n + "%. Maybe try looking elsewhere...");
} // If Else If Else example
