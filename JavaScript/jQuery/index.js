$("h1"); // selects the h1 equiv. document.querySelector("h1");
$("button"); // selects all button html elements, not just the first. equiv. document.querySelectorAll("button");

// it is possible to utilize css through JS, but it is better practice to keep
// behavior separate in JS and styling separate in CSS
$("h2").css("font-size", "5rem");

// this allows the JS to function even if the script links are placed at the top
// of the HTML file. i.e. it waits for all HTML elements to be loaded first
$(document).ready(function(){
  $("h1").addClass("big-title");
});

$("button").html("Don't Click Me!");

// remove styling with setTimeout
setTimeout(function () {
  $("h1").removeClass("big-title");
  $("h2").text("bye");
  $("button").html("Click Me")
}, 1000);
