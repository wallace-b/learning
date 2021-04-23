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
