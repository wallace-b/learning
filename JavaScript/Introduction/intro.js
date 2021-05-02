alert("Hello!");
alert("World!"); /* Alert -> String */
alert(2+3); /* Alert -> Number with addition operator */
typeof("Brad"); /* Type -> String */
typeof(2+3); /* Type -> Number with addition operator */
var myName = "Bradley" /* Var declaration */
var userName = prompt("What is your name?") /* Var declaration via prompt */
alert("Hello!, my name is " + myName + ", it is nice to meet you " + userName + "!")
/* ^ alert (print) a string using the variables of myName and the entered userName */

/* Example of variable assignment */
var a = 8;
var b = 3;

/* Problem: Flip the values */
var c = a;
a = b;
b = c;

/* Show solution */
alert("a is: " + a + " and b is: " + b);

/* Example - user-entered text length, string concatenation, var.length */
var userText = prompt("Enter your message.");
alert("You have written " + userText.length + " characters, you have " +
(140 - userText.length) + " characters remaining." );

/* Slicing Example */
var bread = "bread"
alert(bread.slice(0,3))

/* String case conversion */
var name = "Bradley"
var nameUpper = name.toUpperCase();
var nameLower = name.toLowerCase();

/* Example Problem of string conversion to correct case */
var userName = prompt("What is your name?");
userNameLength = userName.length;
alert("Hello," + " " + userName.slice(0,1).toUpperCase() + userName.slice(1,userNameLength).toLowerCase())

/* Arithmetic Operations */
var a = 2 + 3; // 5
var b = 14 - 3; // 9
var c = 6 * 3; // 18
var d = 8 / 2; // 4
var e = 15 % 4 // Modulo (remainder), 3

/* BODMAS ordering of operations */
var f1 = 2 + 5 * 2; // 12
var f2 = (2 + 5) * 2; // 14

/* Example Problem - Dog to Human years converter */
var dogAge = prompt("What is your dog's age? (please enter a number)")
var humanAge = ((dogAge - 2) * 4) + 21; // brackets help with ambiguity of order of operations
alert("Your dog's age in human years is: " + humanAge);

/* Increment and Decrement Expressions */
var x = 2;
x++; // ~ x = x + 1
x--; // ~ x = x - 1

var y = 4;
x+=y; // ~ x = x + y
x-=y; // ~ x = x - y
x*=y; // ~ x = x * y
x/=y; // ~ x = x / y

var w = 55;
var x = w++;
x++; // x = 56, not 57 *x is assigned to w's value before it is incremented

/* Example: Function creation and usage, with internal variable v2 */
function getMilk(money, costPerBottle) {

  console.log("leaveHouse");
  console.log("moveRight");
  console.log("moveRight");
  console.log("moveUp");
  console.log("moveUp");
  console.log("moveUp");
  console.log("moveUp");
  console.log("moveRight");
  console.log("moveRight");
  console.log("moveLeft");
  console.log("moveLeft");
  console.log("moveDown");
  console.log("moveDown");
  console.log("moveDown");
  console.log("moveDown");
  console.log("moveLeft");
  console.log("moveLeft");
  console.log("enterHouse");
  return console.log("buy " + numberOfBottles(money, costPerBottle) + " bottle(s) of milk - you had $" + money + " and have change $" + changeAfter(money, costPerBottle));
}

getMilk(5, 2);

function numberOfBottles(money, costPerBottle) {
      var bottles = Math.floor(money / costPerBottle);
      return bottles;
}

function changeAfter(money, costPerBottle) {
      var change = money % costPerBottle;
      return change;
}

/* Age converter function */

function lifeInWeeks(age) {

  var years = 90 - age;
  var zMonths = years*12;
  var yWeeks = years*52;
  var xDays = years*365;
  console.log("You have " + xDays + " days, " + yWeeks + " weeks, and " + zMonths + " months left.")

}

lifeInWeeks(32);

/* BMI calculator */

function bmiCalculator(weight, height){
    var bmi = Math.round(weight/(height*height));
    return bmi;
}

console.log(bmiCalculator(65, 1.8));
