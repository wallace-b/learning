const express = require("express");

const app = express();

app.get("/", function(req, res){
  res.send("<h1>Hello, world!</h1>");
  console.log("page accessed externally");
});

// callback function, req = request => incoming request information [there's a lot!], rep = response

app.listen(3000, function() {
  console.log("Server started on port 3000");
});
