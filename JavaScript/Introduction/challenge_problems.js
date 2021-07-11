// how to deal with multiple inputs which are not comma-separated;
// Problem - create mul function
console.log(mul(3)(4)(5)); // output : 60
console.log(mul(6)(4)(5)); // output : 120

// Answer - use nested return function( );
function mul (x) {
  return function (y) { // anonymous function
    return function (z) { // anonymous function
      return x * y * z;
    };
  };
}

// interval timers
const timer = setInterval(function() {
  console.log("This message will show every 1 seconds until this interval is cleared");
}, 1000);

const stop = setTimeout(function() {
  clearInterval(timer);
}, 5000);

stop;
