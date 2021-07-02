// require express
const express = require('express');

// setup express
const app = express();

// port selection
const port = process.env.PORT || 3000;

// get request
app.get("/", function(req,res) {
  res.sendFile(__dirname + '/index.html');
});

// post request
app.post("/", function(req,res) {
  res.send("Thanks for posting that!");
});

// start server on given port
app.listen(port, function() {
  console.log("Server is running on Port " + port);
});
