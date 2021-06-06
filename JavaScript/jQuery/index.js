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

$("a").attr("href", "https://www.bing.com"); // changing an attribute with JS

setTimeout(function () {
  alert($("h1").attr("class")); // get an alert containing the classes of the <h1> element on delay
}, 500);

// remove styling with setTimeout
setTimeout(function () {
  $("h1").removeClass("big-title");
  $("h2").text("bye");
  $("button").html("Click Me")
}, 1000);

var buttonArray = document.querySelectorAll("button");

//for (var i=0; i<buttonArray.length; i++) {
//  buttonArray[i].addEventListener("click", function() {
//    document.querySelector("h2").style.color = "blue";
//  });
//}

// on click of <button> elements, apply callback function
// example of how much smaller code can be using jQuery, compared to for loop
$("button").click(function(){
  $("h2").css("color", "blue");
});

// on keypress of any key on the page i.e. the whole document, apply callback function
$(document).keypress(function(event) {
  $("h1").text(event.key);
  $("input").attr("value",event.key);
})

// on mouseover of <h1>, apply callback function
$("h1").mouseover(function(event) {
  $("h1").text("Hello world.");
})

// example of before, after, prepend, append
$("h1").before("<p>Hi! (before)</p>");
$("h1").after("<p>Hi! (after)</p>");
$("h1").prepend("<p>Hi! (prepend)</p>");
$("h1").append("<p>Hi! (append)</p>");
