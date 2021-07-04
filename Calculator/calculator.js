// var declaration
var result = '';
var weight = '';
var height = '';

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

// get request #2
app.get("/bmicalculator", function(req,res) {
  res.sendFile(__dirname + '/bmiCalculator.html');
});

// post request #2
app.post("/bmicalculator", function(req,res) {
  console.log(req.body);
  weight = Number(req.body.weight); // kg
  height = Number(req.body.height)/100; // cm [input] into m conversion
  result = weight/(height**2); // kg/m^2
  res.send("Thanks, your BMI is: " + result);
});

// start server on given port
app.listen(port, function() {
  console.log("Server is running on Port " + port);
});
