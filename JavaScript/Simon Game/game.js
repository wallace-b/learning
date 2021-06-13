var gamePattern = [];
var userClickedPattern = [];

var buttonColours = ["red", "blue", "green", "yellow"];

// counters
var initialCounter = 0;
var level = 0;

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
  $("#level-title").text("Level "+level);
  level++;
};


// test nextSequence function by clicking <h1> element
$(document).on("keypress", function() {
  if (initialCounter == 0) {nextSequence();
  initialCounter++;
  }
});

// handler function
$(".btn").on("click", function() {
  userChosenColour = this.getAttribute("id");
  animatePress(userChosenColour);
  userClickedPattern.push(userChosenColour);
  playSound(userChosenColour);
  if (checkAnswer(level-1) == 1) {
    setTimeout(function () {
      nextSequence();
      userClickedPattern = [];
    }, 1000);
  };
});

function animatePress(currentColour) {
  $("#"+currentColour).addClass("pressed");
  setTimeout(function () {
    $("#"+currentColour).removeClass("pressed")
  }, 100);
};

function checkAnswer(currentLevel) {
  if (gamePattern[currentLevel] == userClickedPattern[currentLevel]) {
    return 1;
  };
};
