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
