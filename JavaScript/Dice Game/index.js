var randomNumber1 = Math.floor((Math.random())*6 + 1);
var string1 = "images/dice" + String(randomNumber1) + ".png";
//alert(string1);
document.querySelector(".img1").setAttribute("src", string1);

var randomNumber2 = Math.floor((Math.random())*6 + 1);
var string2 = "images/dice" + String(randomNumber2) + ".png";
//alert(string2);
document.querySelector(".img2").setAttribute("src", string2);

if (randomNumber1 == randomNumber2) {
  document.querySelector(".result").innerHTML = "It's a draw!";
} else if (randomNumber1 > randomNumber2) {
  document.querySelector(".result").innerHTML = "🚩 Player 1 wins!";
} else {
  document.querySelector(".result").innerHTML = "Player 2 wins! 🚩";
}
