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
