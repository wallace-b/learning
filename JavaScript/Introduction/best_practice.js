// <-- Declarations on Top -->

// Declare at the beginning
let firstName, lastName, startingPrice, endPrice, growthRate, period;

// Use later
firstName = "Bradley";
lastName = "Wallace";

startingPrice = 100.5
growthRate = 0.03 // 3%
period = 5 // in years

endPrice = 100.5*((1+growthRate)**period);
console.log(endPrice);

// <-- Shorthand conditions -->
// longhand
if (x === 'Bradley' || x === 'Brad' || x === 'Wallace' || x === 'Wally') {
  console.log("name match");
};

// shorthand
if (['Bradley', 'Brad', 'Wallace', 'Wally'].includes(x)) {
  console.log("name match");
};

// Declare Arrays with const, to prevent accidental change of type
var fruits = ["Apple", "Banana", "Orange"];
fruits = 3; // Changes array to number

const fruits = ["Apple", "Banana", "Orange"];
fruits = 3; // not possible
                  
