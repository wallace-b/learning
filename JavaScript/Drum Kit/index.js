var buttonArray = document.getElementsByClassName("drum"); // create array of buttons

/* for loop to cycle through array and add an Event Listener for each button
... using anonymous function */
for (i=0; i < buttonArray.length; i++) {
  buttonArray[i].addEventListener("click", function () {
      alert("I got clicked!");

      // what to do when click is detected!
  });

}; // close for loop
