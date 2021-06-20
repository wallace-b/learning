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
var spliceNew = array.splice(1,2); // == [2,3], array.splice([start], [length]), zero-indexing, selects n = [length] elements
var concatNew = sliceNew.concat(spliceNew); // == [1,2,3,2,3], joins the two arrays together ~~

var arrayTwo = [1, 2, 12, 15];
arrayTwo.sort(); // == [1, 12, 15, 2], array.sort converts all elements to strings by default, so 2 > 12 and 15. This overwrites the original array

// to avoid this, we need to supply a function as an arugument to array.sort();
function compareNumeric(a, b) {
  if (a > b) return 1;
  if (a == b) return 0;
  if (a < b) return -1;
}

arrayTwo.sort(compareNumeric); // == [1, 2, 12, 15] this is now wokring as intended. This overwrites the original array
arrayTwo.reverse(); // == [15, 12, 2, 1] no additional function pass is required for reverse() method. This overwrites the original array

// map - applying functions element-wise to an array
arrayThree = [1, 2, 3, 4];
arrayThree.map(function(item) { return 2 * item }); // == [2, 4, 6, 8]
