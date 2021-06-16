var gamePattern = []; // game pattern array determined randomly by computer
var userClickedPattern = []; // user entered pattern array
var buttonColours = ["red", "blue", "green", "yellow"]; // array of possible colours

// counters
var initialCounter = false;  // initialization boolean var
var level = 0;
var userLevel = 0;

// test nextSequence function by clicking <h1> element
$(document).on("keypress", function() {
  if (!initialCounter) {
    nextSequence();
    initialCounter = true;
  }
});

$(".btn").on("click", function() {
  userLevel++;
  var userChosenColour = this.getAttribute("id");
  userClickedPattern.push(userChosenColour);
  animatePress(userChosenColour);
  playSound(userChosenColour);

  // next stage, if the user is at the last step of the level
  if (userLevel == level) {
    if (checkAnswer(userLevel-1)) {
        setTimeout(function () {
        userLevel = 0;
        nextSequence();
      }, 1000);
    };
  };

  // game over and game restart
  if (!checkAnswer(userLevel-1)) {
    playSound("wrong");
    $("body").addClass("game-over");
    setTimeout(function () {
      $("body").removeClass("game-over");
    }, 400);
    $("#level-title").text("Game Over, Press ANY Key to Start");
    startOver();
  };
});

// function for game to trigger next sequence
function nextSequence() {
  userClickedPattern = [];
  var randomNumber = Math.floor(Math.random()*4);
  var randomChosenColour = buttonColours[randomNumber];
  $("#" + randomChosenColour).fadeOut(100).fadeIn(100);
  playSound(randomChosenColour);
  gamePattern.push(randomChosenColour);
  $("#level-title").text("Level "+level);
  level++;
};

// animate button press
function animatePress(currentColour) {
  $("#"+currentColour).addClass("pressed");
  setTimeout(function () {
    $("#"+currentColour).removeClass("pressed")
  }, 100);
};

// function to compare array entries between computer pattern and user entered pattern
function checkAnswer(currentLevel) {
  if (gamePattern[currentLevel] == userClickedPattern[currentLevel]) {
    return true;
  } else {
    return false;
  };
};

// plays sound for corresponding colour selected
function playSound(colourSelected) {
    var sound_ = new Audio("sounds/" + colourSelected + ".mp3");
    sound_.play();
};

// function to restart game and variables
function startOver () {
  gamePattern = [];
  level = 0;
  userLevel = 0;
  initialCounter = 0;
};
