alert("hello"); // says "hello" as an alert, similar to the inline and internal js
document.querySelector("h1").innerHTML = "Good bye"; // replaces the h1 with "Good bye"

var heading = document.body.firstElementChild;
heading.innerHTML = "new words..";
heading.style.color = "orange"; // replaces the h1 with "new words..." in orange, using a var declaration

document.querySelector("input").click() // clicks the button
