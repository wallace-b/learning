const express = require("express");

const app = express();

app.get("/", function(req, res){
  res.send("<h1>Hello, world!</h1>");
  console.log("page accessed externally");
});

// "/" => route of going to the homepage a.k.a. home route html.com/contact
// callback function, req = request => incoming request information [there's a lot!], rep = response

app.get("/contact", function(req, res){
  res.send("Contact me at: bradley@gmail.com")
});

// "/contact" => route of going to the contact page a.k.a. html.com/contact

app.get("/about", function(req, res){
  res.send("<p>name: Bradley Wallace</p><p>age: 31</p><p>profession: aspiring Software Engineer</p>")
});

// "/about" => route of going to the about page a.k.a. html.com/about

app.get("/hobbies", function(req, res){
  res.send("<ul><li>AI</li><li>investing</li><li>D&D</li></ul>")
});

// "/hobbies" => route of going to the about page a.k.a. html.com/hobbies

app.listen(3000, function() {
  console.log("Server started on port 3000");
});
