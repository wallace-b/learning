var buttonArray = document.getElementsByClassName("drum"); // create array of buttons

/* for loop to cycle through array and add an Event Listener for each button
... using anonymous function */
for (i=0; i < buttonArray.length; i++) {
  buttonArray[i].addEventListener("click", function () {
      var audio = new Audio("sounds/tom-1.mp3");
      audio.play();

      console.log(this.innerHTML);  // display clicked element innerHTML
      this.style.color = "#DBEDF3";  // change style color on click

      // what to do when click is detected!
  });

}; // close for loop
