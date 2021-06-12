var gamePattern = [];

var buttonColours = ["red", "blue", "green", "yellow"];

function nextSequence() {
  var randomNumber = Math.floor(Math.random()*4);
  var randomChosenColour = buttonColours[randomNumber];
  $("#" + randomChosenColour).fadeOut(100).fadeIn(100);
  var soundPlay = new Audio("sounds/" + randomChosenColour + ".mp3");
  soundPlay.play();
};

$(document).on("click", function() {
  nextSequence();
});
