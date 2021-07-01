// require exrpess
const express = require('express');

// setup express
const app = express();

// get request
app.get("/", function(req,res) {
  res.send("Hello World");
});

app.listen(3000, function() {
  console.log("Server is running on Port 3000.")
});
