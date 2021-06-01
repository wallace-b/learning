// Part 1 - key press assignment of sounds

document.addEventListener("keydown", function(event) {
  // switch statement, linking key down to corresponding sound
  makeSound(event.key);
  // animate key press
  buttonAnimation(event.key);



});

// Part 2 - button mouseclick assignment of sounds

var buttonArray = document.getElementsByClassName("drum"); // create array of buttons

/* for loop to cycle through array and add an Event Listener for each button
... using anonymous function */
for (i=0; i < buttonArray.length; i++) {
  buttonArray[i].addEventListener("click", function () {

    var buttonInnerHTML = this.innerHTML; // create expression for switch statement
    makeSound(buttonInnerHTML); // play corresponding sound with switch statement
    // animate mouse click on buttons
    buttonAnimation(buttonInnerHTML);

  });
};

// function created for the same switch statement used in both Part 1 and Part 2

function makeSound(key) {
  // switch statement, linking keys / images to corresponding sound
  switch (key) {
    case "w":
        var crash = new Audio("sounds/crash.mp3");
        crash.play();
      break;

    case "a":
        var kick = new Audio("sounds/kick-bass.mp3");
        kick.play();
      break;

    case "s":
        var snare = new Audio("sounds/snare.mp3");
        snare.play();
      break;

    case "d":
        var tom1 = new Audio("sounds/tom-1.mp3");
        tom1.play();
      break;

    case "j":
        var tom2 = new Audio("sounds/tom-2.mp3");
        tom2.play();
      break;

    case "k":
        var tom3 = new Audio("sounds/tom-3.mp3");
        tom3.play();
      break;

    case "l":
        var tom4 = new Audio("sounds/tom-4.mp3");
        tom4.play();
      break;

    default: console.log(key);

  }
}

// function to play key animation - apply .pressed, then remove after 100ms
function buttonAnimation(currentKey) {
  var activeButton = document.querySelector("." + currentKey);
  activeButton.classList.add("pressed");
  setTimeout(function() {
    activeButton.classList.remove("pressed");
   }, 100);
}
