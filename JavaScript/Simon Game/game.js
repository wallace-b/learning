var gamePattern = []; // game pattern array determined randomly by computer
var userClickedPattern = []; // user entered pattern array

var buttonColours = ["red", "blue", "green", "yellow"];

// counters
var level = 0;
var userLevel = 0;
var initialCounter = 0;  // initialization counter

// plays sound for corresponding colour selected
function playSound(colourSelected) {
    var sound_ = new Audio("sounds/" + colourSelected + ".mp3");
    sound_.play();
};

// animate button press
function animatePress(currentColour) {
  $("#"+currentColour).addClass("pressed");
  setTimeout(function () {
    $("#"+currentColour).removeClass("pressed")
  }, 100);
};

// function for game to trigger next sequence
function nextSequence() {
  var randomNumber = Math.floor(Math.random()*4);
  var randomChosenColour = buttonColours[randomNumber];
  $("#" + randomChosenColour).fadeOut(100).fadeIn(100);
  playSound(randomChosenColour);
  gamePattern.push(randomChosenColour);
  $("#level-title").text("Level "+level);
  level++;
};

// test nextSequence function by clicking <h1> element
$(document).on("keypress", function() {
  if (initialCounter == 0) {
    nextSequence();
    initialCounter++;
  }
});

// handler function
$(".btn").on("click", function() {
  userLevel++;
  userChosenColour = this.getAttribute("id");
  animatePress(userChosenColour);
  userClickedPattern.push(userChosenColour);
  playSound(userChosenColour);

  console.log("User Level = "+userLevel);
  console.log("Level = "+level);

  // next stage
  if (userLevel == level) {
    if (checkAnswer(userLevel-1) == "True") {
        setTimeout(function () {
        userLevel = 0;
        nextSequence();
        userClickedPattern = [];
      }, 1000);
    };
  };

  // game restart
  if (checkAnswer(userLevel-1) == "False") {
    $("#level-title").text("Press A Key to Start");
    gamePattern = [];
    userClickedPattern = [];
    level = 0;
    userLevel = 0;
    initialCounter = 0;

  };

});

// function to compare array enrties between computer pattern and user entered pattern
function checkAnswer(currentLevel) {
  if (gamePattern[currentLevel] == userClickedPattern[currentLevel]) {
    return "True";
  } else {
    return "False";
  };
};
