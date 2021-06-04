// this allows the JS to function even if the script links are placed at the top
// of the HTML file. i.e. it waits for all HTML elements to be loaded first
$(document).ready(function () {
  $("h1").style.color = "red";
};

$("h1"); // selects the h1 equiv. document.querySelector("h1");
$("button"); // selects all button html elements, not just the first. equiv. document.querySelectorAll("button");
