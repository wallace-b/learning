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
