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

// fucnction to restart game and variables
function startOver () {
  gamePattern = [];
  userClickedPattern = [];
  level = 0;
  userLevel = 0;
  initialCounter = 0;
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
    if (checkAnswer(userLevel-1) == true) {
        setTimeout(function () {
        userLevel = 0;
        nextSequence();
        userClickedPattern = [];
      }, 1000);
    };
  };

  // game over and game restart
  if (checkAnswer(userLevel-1) == false) {
    playSound("wrong");
    $("body").addClass("game-over");
    setTimeout(function () {
      $("body").removeClass("game-over");
    }, 400);
    $("#level-title").text("Game Over, Press ANY Key to Start");
    startOver();
  };
});

// function to compare array enrties between computer pattern and user entered pattern
function checkAnswer(currentLevel) {
  if (gamePattern[currentLevel] == userClickedPattern[currentLevel]) {
    return true;
  } else {
    return false;
  };
};
