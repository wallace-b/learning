/* Love Calculator and Pseudo-random Generation with If Statement (Conditional) */
var name1 = prompt("Please enter the first name:");
var name2 = prompt("Please enter the second name:");
var scale = 100;
var n = Math.random();
n = Math.floor(n*scale) + 1;
if (n > 70){
  console.log("The probability of LOVE is: " + n + "%. You are SOULMATES!");
} else {
  console.log("The probability of LOVE is: " + n + "%. It could be worse.");
}
