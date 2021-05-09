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


/* Love Calculator using Separate If statements Combining Comparators*/
if (n > 90) {
  console.log("The probability of LOVE is: " + n + "%. You could be SOULMATES!");
}

if (n > 65 && n <= 90) {
  console.log("The probability of LOVE is: " + n + "%. It looks promising.");
}

if (n <= 65) {
  console.log("The probability of LOVE is :" + n + "%. Maybe try looking elsewhere...");
}

/* Comparators and Equality == vs. === */
var a = 1;
var b = "1";
typeof(a); // number
typeof(b); // string
if (a === b) {
  console.log("a and b have the same type and value");
} else {
  console.log("no");
}
if (a == b) {
  console.log("a and b have the same value but potentially different types");
} else {
  console.log("no");
}

/* BMI Calculator Example */
function bmiCalculator (weight, height) {
    var bmi = weight/(height*height)
    if (bmi > 24.9) {
      var interpretation = ("Your BMI is " + bmi + ", so you are overweight.");
    } else if (bmi >= 18.5 && bmi <= 24.9) {
      var interpretation = ("Your BMI is " + bmi + ", so you have a normal weight.");
    } else if (bmi < 18.5) {
      var interpretation = ("Your BMI is " + bmi + ", so you are underweight.");
    }

    return interpretation;
}

alert(bmiCalculator(60, 2));

/* Leap Year function */

function isLeap0(year) {
    if (year % 4 == 0 && year % 100 != 0) {
        console.log("Leap year.")
    } else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
        console.log("Leap year.")
    } else {
        console.log("Not leap year.")
    }
}

isLeap0(1948);

/* Leap Year function as nested If Else statements*/

function isLeap1(year) {
    if (year % 4 == 0) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
              console.log("Leap year.")
            } else {
              console.log("Not leap year.")
            }

        } else {
            console.log("Leap year.")
        }
    }
    else {
        console.log("Not leap year.")
    }
}

isLeap1(2100);

/* .includes() example */
guestList = ["Brad", "Hyun", "Angela", "Felix", "Alan", "Joel", "Tiffany"];

var guestName = prompt("What is your name?");

if (guestList.includes(guestName)) {
    alert("Please enter and have a good time!");
} else {
    alert("Who are you? Go away!");
}

/* Fizz Buzz function JS - Nested If Else */
function fizzBuzz(givenNumber) {
    if (givenNumber % 3 == 0) {
        if (givenNumber % 5 == 0) {
            console.log("FizzBuzz");
        } else {
            console.log("Fizz");
        }
    } else {
        if (givenNumber % 5 == 0) {
            console.log("Buzz");
        }
    }
}

fizzBuzz(20);

/* Fizz Buzz function JS - Nested If Else, array.push and counter (needs loop added) */

var output = [];
var counter = 1;

function fizzBuzz() {
    if (counter % 3 == 0) {
        if (counter % 5 == 0) {
            output.push("FizzBuzz");
        } else {
            output.push("Fizz");
        }
    } else {
        if (counter % 5 == 0) {
            output.push("Buzz");
        } else {
            output.push(counter);
        }

    }

    counter ++; //equiv to counter += 1

    console.log(output);
}

fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
fizzBuzz();
