// var declaration
var result = '';

// require express, body-parser
const express = require('express');
const bodyParser = require('body-parser');

// setup express
const app = express();

// use body-parser in express
app.use(bodyParser.urlencoded({extended: true}));

// port selection
const port = process.env.PORT || 3000;

// get request
app.get("/", function(req,res) {
  res.sendFile(__dirname + '/index.html');
});

// post request
app.post("/", function(req,res) {
  console.log(req.body);
  result = Number(req.body.num1) + Number(req.body.num2);
  res.send("Thanks for posting that! Addition of the two numbers is: " + result);
});

// start server on given port
app.listen(port, function() {
  console.log("Server is running on Port " + port);
});
