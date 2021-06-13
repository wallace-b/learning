var gamePattern = [];
var userClickedPattern = [];

var buttonColours = ["red", "blue", "green", "yellow"];

function nextSequence() {
  var randomNumber = Math.floor(Math.random()*4);
  var randomChosenColour = buttonColours[randomNumber];
  $("#" + randomChosenColour).fadeOut(100).fadeIn(100);
  var soundPlay = new Audio("sounds/" + randomChosenColour + ".mp3");
  soundPlay.play();
  gamePattern.push(randomChosenColour);
};

// handler function
$(".btn").on("click", function() {
  userChosenColour = this.getAttribute("id");
  userClickedPattern.push(userChosenColour);
});
