alert("hello"); // says "hello" as an alert, similar to the inline and internal js
document.querySelector("h1").innerHTML = "Good bye"; // replaces the h1 with "Good bye"

var heading = document.body.firstElementChild;
heading.innerHTML = "new words..";
heading.style.color = "orange"; // replaces the h1 with "new words..." in orange, using a var declaration

var heading = document.body.firstElementChild;
heading.innerHTML = "new words..";
heading.style.color = "orange"; // replaces the h1 with "new words..." in orange, using a var declaration

document.querySelector("ul").lastElementChild.innerHTML = "Bradley"; // replaces last element of <ul> with "Bradley"

document.querySelector("input").click() // clicks the button

document.querySelector("li a").style.color = "red"; // combination selector to change color of hyperlink to red
document.getElementsByClassName("title")[0].style.color = "black"; // selecting title out of singular entry array

// use of other HTML DOM Style objects
document.querySelector("h2").style.visibility = "hidden";
document.querySelector("h3").style.fontSize = "2.5rem";
document.querySelector("button").style.backgroundColor = "yellow";
document.querySelector("button").style.marginLeft = "20px";

document.querySelector("h1").classList.add("huge"); // adds 'huge' class to h1 element

// Text manipulation and textContent property
document.querySelector("h4").innerHTML; // returns "<em>Change this!</em>"
document.querySelector("h4").textContent; // returns "Change this!"
document.querySelector("h4").innerHTML = "<strong>This was changed!</strong>" // changes the <h4> incl. </em> and string

// Manipulating HTML elements
document.querySelector("a").attributes;
document.querySelector("a").getAttribute("href");
document.querySelector("a").setAttribute("href","https://www.duckduckgo.com")
