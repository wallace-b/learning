function PlayerCreator (name, age, yearsOfExperience, gamesCompeted) { // Constructor Function
  this.name = name;
  this.age = age;
  this.yearsOfExperience = yearsOfExperience;
  this.gamesCompeted = gamesCompeted;
}

var player1 = {
  name: "Bradley",
  age: 30,
  yearsOfExperience: 18,
  gamesCompeted: ["Warzone", "Dota2"],
}
// Example of Object.property syntax and Object creation

var player2 = PlayerCreator("Jeff", 28, 20, ["Valorant", "PUBG", "Dota2"]);
// Example of Constructor Function call

// Array methods

var array = [1, 2, 3, 4];
var sliceNew = array.slice(0,3); // == [1,2,3], array.slice([start], [end]), zero-indexing, does not include end-index
var spliceNew = array.splice(1,2); // == [2,3], array.splice([start], [length]), zero-indexing, selects n = [length] elements, makes array == [1,4] effectively removing [2,3]
var concatNew = sliceNew.concat(spliceNew); // == [1,2,3,2,3], joins the two arrays together ~~
var concatThree = sliceNew.concat(spliceNew, array); // this combines three arrays == [1,2,3,2,3,1,4]

var arrayTwo = [1, 2, 12, 15];
arrayTwo.sort(); // == [1, 12, 15, 2], array.sort converts all elements to strings by default, so 2 > 12 and 15.

// to avoid this, we need to supply a function as an arugument to array.sort();
function compareNumeric(a, b) {
  if (a > b) return 1;
  if (a == b) return 0;
  if (a < b) return -1;
}

arrayTwo.sort(compareNumeric); // == [1, 2, 12, 15] this is now working as intended.
arrayTwo.reverse(); // == [15, 12, 2, 1] no additional function pass is required for reverse() method. 

// map - applying functions element-wise to an array
var arrayThree = [1, 2, 3, 4];
arrayThree.map(function(item) { return 2 * item }); // == [2, 4, 6, 8]

// filter - by logical test - to an array
var arrayFour = [45, 29, 41, 15, 2, 8];
arrayFour = arrayFour.filter(function(item) { return item > 22 }); // == [45, 29, 41]. This overwrites the original array
arrayFour = arrayFour.sort(compareNumeric); // == [45, 29, 41]. This overwrites the original array

// join - comma delimited example
var vegetables = ["Carrot", "Potato", "Cabbage", "Brocolli", "Turnip", "Celery", "Parsnip"];
var vegetablesString = vegetables.join(", "); // == comma delimited string

// find index indexOf( )
var position = vegetables.indexOf("Turnip");
console.log("Turnip is found in position/index " + position); // == ... in position 4 (zero indexing)

// forEach example
var numbers = [1, 5, 7, 9, 11, 13, 14, 18, 21, 22, 25, 30];
numbers = numbers.map(function(item, index) { return item*index });

// example of constant (immutable) and Date function
const d1 = new Date(); // current date
const d2 = new Date(2021, 08, 02, 09, 30, 00, 00);  // == Mon Aug 02 2021 09:30:00:00, 7 values => new Date(year, month, day, hours, minutes, seconds, milliseconds)
