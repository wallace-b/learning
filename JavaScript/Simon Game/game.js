var gamePattern = [];
var userClickedPattern = [];

var buttonColours = ["red", "blue", "green", "yellow"];

// plays sound for corresponding colour selected
function playSound(colourSelected) {
    var sound_ = new Audio("sounds/" + colourSelected + ".mp3");
    sound_.play();
};

function nextSequence() {
  var randomNumber = Math.floor(Math.random()*4);
  var randomChosenColour = buttonColours[randomNumber];
  $("#" + randomChosenColour).fadeOut(100).fadeIn(100);
  playSound(randomChosenColour);
  gamePattern.push(randomChosenColour);
};

// test nextSequence function by clicking <h1> element
$("h1").on("click", function() {
  nextSequence();
});

// handler function
$(".btn").on("click", function() {
  userChosenColour = this.getAttribute("id");
  userClickedPattern.push(userChosenColour);
  playSound(userChosenColour);
});
