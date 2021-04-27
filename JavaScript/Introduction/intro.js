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

/* Example: Function creation and usage, with internal variable */
function getMilk(bottles) {
    var cost = bottles * 1.5;
  console.log("leaveHouse");
  console.log("moveRight");
  console.log("moveRight");
  console.log("moveUp");
  console.log("moveUp");
  console.log("moveUp");
  console.log("moveUp");
  console.log("moveRight");
  console.log("moveRight");
  console.log("buy " + bottles + " bottles of milk - this cost $" + cost + ".");
  console.log("moveLeft");
  console.log("moveLeft");
  console.log("moveDown");
  console.log("moveDown");
  console.log("moveDown");
  console.log("moveDown");
  console.log("moveLeft");
  console.log("moveLeft");
  console.log("enterHouse");
}

getMilk(2);
