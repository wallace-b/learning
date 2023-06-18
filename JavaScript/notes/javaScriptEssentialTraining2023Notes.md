# Section 1 – Fundamentals

Without defer or async in the <header><script> declaration of the javascript(js) associated with a HTML, the browser encounters an error because the js script attempts to modify the HTML body section before it is rendered. The traditional way of addressing this is to simply move the script tag to the bottom of the html file. This introduces problems as there is a strong likelihood that some js should execute on document load initialization and while the document is loading.
The 'async' keyword minimizes render blocking, when the js script is fully-loaded it executes and modifies the html doc.
The 'defer' keyword loads the html doc and js script in-parallel and only executes the js script when the html doc is fully-loaded.
Loading js in the footer is now not an industry-standard, and loading using async or defer in the header is ideal.

### When does the browser execute JavaScript?

By default: When the script is encountered. If the script is set to "async", when the script is fully loaded. If the script is set to "defer", when the entire HTML page is rendered.

### What is the correct markup for adding an external JavaScript file to an HTML document?

<script src="javascript.js" async></script>

While `<script src="javascript.js"></script>` is technically correct, it is recommended to always async or defer your script unless you have a specific reason for the script to cause render blocking.

### What happens when you defer JavaScript?

The browser loads the JavaScript asynchronously when it is encountered, then waits until all HTML is rendered before executing the script.

### JavaScript modules are heavily used in frameworks like React and Vue. What is the advantage of using modules?

Modules enable modularization of code where individual functions, components, data objects, and other parts can be separated into individual files.
Also, type=”module” is automatically-deferred thereby preventing render blocking when you modularized sections / objects / methods of js code.

## Objects - New Information

### Global objects

If many people likely already want to do some basic operations with an object, chances are, there is already a standard built-in object for it.
E.g. Date.prototype._many available methods_
Refer https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects

### Methods

If there are internal method calculations, use 'let' to declare variables that are limited to the scope of the method (i.e. a block statement, or expression on which it is used).
Then, simply 'return' the result.

### Classes

Verbosely declaring each object e.g. const object = {key:value, key:value, etc. pairs} and related methods is tedious, so Classes (although a recent addition to js) allow us to create objects passing only property values at initialization. This allows methods and other things, such as default property values, to be shared.
Class naming convention should be with a capital letter first - e.g. Backpack, Clock, Bag, Smartphone and so on.
The constructor property names are called 'parameters'. The constructor will then use values passed as parameter values to construct an object where these parameter values become the property values for the newly-created object. Class prototype methods are added after the constructor method as discrete named methods.

# Section 5 - DOM (Document Object Model)

## Accessing elements

querySelector("main") uses tag, querySelector(".maincontent") uses class name only returns the first element that matches the criteria.
querySelectorAll("main li") returns a node that contains all matches for the criteria. Returns a node list

Ex:
document.querySelector(".backpack\_\_age").innerHTML="5555 days olds"
document.querySelectorAll("main li").forEach(item => item.style.backgroundColor="blue")

getElementsByClassName, getElementById are older methods that are falling-off in-favor of querySelector - returns a HTML array

### Class manipulation

element.classList or querySelector/All().classList have methods to manipulate classes of the element:
classList.add("new-class)
classList.remove("new-class")
classList.toggle("new-class")
classList.replace("old-class", "new-class")

In almost every case you want to use .classList for methods for manipulating classes,
only use .className to output string information and work directly with it.
element.className returns a string containing all classes appended to the element. element.classList returns a DOMTokenList with each class appended to the element.

### Attributes

document.querySelector("img").hasAttribute("src")
document.querySelector("img").getAttribute("src")
document.querySelector("img").setAttribute("src", "~new information~")
document.querySelector("img").setAttribute("newAttribute", "~new information~") -> creates a new attribute if it does not currently exist
document.querySelector("img").removeAttribute("newAttribute")

naming convention <type of data>-<name of attribute>

### Inline CSS manipulation

document.querySelector(".site-title").style ---> Full CSS Style declaration list, review the options
Ex: document.querySelector(".site-title").style.backgroundColor="blue"
CSS methods/elements are always in camelCase.

### Inserting elements or HTML `` inline content into elements or classes

ParentNode.append()
ParentNode.prepend()
Node.appendChild() , also returns this element to you
insertAdjacentElement() and more...

### Element creation

document.querySelector("main").createElement(...)

# Section 6 - Data Types

## Assignment

If you don't use var, let, or const keywords before a variable assignment, a global var is created with the name and value assignment.

var - globally scoped reassignable variable
let - locally scoped

Curiously, object properties within a constant object can be changed in js, but not in C++.

## == equality (value) and === identical equality (type & value)

a = b assigns the value of b to a. a == b tests for equality between a and b. a === b tests for identical equality between a and b.

# Section 7 - Arrays

Arrays in js can hold a mix of any data type, like a list in python.

<script>
const myArray = [1, 2, 3, 4]
myArray.forEach( (item, index) => {
myArray[index] = ++item;
});
</script>

array.forEach() executes a provided callback function once for each item in the array. array.map() creates a new array with the results of executing a provided callback function once for each item in the original array.

A callback function is a function passed into another function as an argument, which is then invoked inside the outer function to complete some kind of routine or action.

const myFunction = (data = 5, color = "red") => {..... this function} default values are passed

A function declaration defines a function with the specified parameters starting with the function keyword. A function expression expresses a function inside a variable by assigning the function to the variable.

<script>
myArray.forEach(function (item) {
  item = `<li>${item}</li>`;
  console.log(item);
});

let logItems = myArray.find(function (item) {
  if (item.length >= 5) {
    return item;
  }
});
</script>

# Section 8 - Functions and Methods

### 1. Function declaration

function decAdd(a=0, b=0){
let sum = a + b;
return sum;
}
Hoisted to the global scope, available everywhere (can call it before it is declared). Naming declaration is like an advanced variable i.e. you can override the name further down in your code.
With callback functions, the inner function needs to be declared first.

### 2. Function expression

const expAdd = function (a=0, b=0) {
let sum = a + b;
return sum;
}
Places itself inside a variable that calls an anonymous function. This pattern is preferred for js frameworks like React / best practice in a const. const (cannot be overwritten), locally-scoped/block-scoped. Not hoisted to the global scope.

decAdd(1, 4) --> 3
expAdd(1, 4) --> 5; expAdd() ...with no default values --> returns function.

### 3. Immediately Invoked Function Expression (IIFE), Anonymous function (no-name)

IIFE functions (anonymous functions) run immediately when the browser encounters it. They are self-invoking.

(function () {
let a = 4;
let b = 6;
let sum = expAdd(a, b);
console.log(`The sum of a and b is: ${c}`);
})();

### 4. Arrow function breakdown

Shortened version~!
Not hoisted and must be declared before it is called as a function.
You cannot use an arrow function to create methods in classes/objects.

1 Remove the 'function' keyword and place an arrow =>
(a, b) => {
return a + b;
}
2 Remove the body brackets and return (it is implied)
(a, b) => a + b;
3 (Optional) Remove the argument/input/parameter brackets. Sometimes code standards will re-implement these.
a, b => a + b;
E.g const func = (a, b) => a + b;
  
### 5. This and Function declarations or Arrow functions

Nesting anonymous IIFE functions in an object may result in unexpected behavior if the anonymous function is a function declaration i.e. hoisted to the global scope.
It is a good idea to try converting a function within an object/class to an arrow function format to ensure it locally-scoped.

For example:
<script>
window.speed = 50; // Define default speed for the window i.e. entire DOM
const car = {
  name: "Toyota Camry",
  speed: 25,
  newSpeed: function (speed) {
    console.log("this.speed in the method:", this.speed);
    this.speed = speed;
    console.log("this.speed after update:", this.speed);
    (function () {
      console.log("this.speed in nested function:", this.speed);
    })();
    (() => {
      console.log("this.speed in arrow function:", this.speed);
    })();
  },
};
console.log(car.newSpeed(35));
// Output
// 25
// 35
// 50 global scope func decl - hoisted
// 35 local scope => func - not-hoisted
</script>

### 6. Callback function behavior
Why not ignore using a callback function (passing the entire function as an argument to the outer function) and just call the function directly inside, rather than using a callback function?
With more complex functions there may be multiple iterations/variations of the same function name, and a callback function specified as an argument for an outer function allows us to pass the specific/precise version of the function needed.
Promises can be used for a similar purpose.
setTimeout and eventListener are examples of commonly-used callback functions.

### 7. Conditional if

if (checkCon) { ...args... }, will run args if there is any value that is not false, 0, null or undefined due to js weak-typing.
To ensure this does not happen, consider if (checkCon === "True")

#### 7.1 ternary operator

if (checkCon === true) {
console.log("open");
} else {
console.log("closed");
}

equivalently,

console.log(checkCon ? "open" : "closed");

### 8. Logical operators

&& (and), || (or)

### 9. For Loops

<script>
const stuff = ["pig", "toy", "pencil", "ruler", "vitamin", "medicine", "torch", "fork"];

const article = document.querySelector("article");
let stuffList = document.createElement("ul");

/**
 * for loop, using a counter and 0-indexing
 * @link https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/for
 */
for (let i = 0; i < stuff.length; i++) {
  let listItem = document.createElement("li");
  listItem.innerHTML = stuff[i];
  stuffList.append(listItem);
}

/**
 * for...of loop and arrays
 * @link https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/for...of
 */
for (const item of stuff) {
  let listItem = document.createElement("li");
  listItem.innerHTML = item;
  stuffList.append(listItem);
}

/**
 * foreach array method
 * @link https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach
 */
stuff.forEach((item) => {
  let listItem = document.createElement("li");
  listItem.innerHTML = item;
  stuffList.append(listItem);
});

/**
 * for...in loop and objects
 * @link https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/for...of
 */
for (const singleObject in nestedObjects) {
  let listItem = document.createElement("li");
  listItem.innerHTML = `Name: ${nestedObjects[singleObject].name}`;
  stuffList.append(listItem);
}

article.append(stuffList);

// popular standard to use 'forEach' for arrays, and 'for ... in' for objects
</script>

### 10. Map

If you need to loop through an array -> use forEach( )
If you need to loop through an old array and make a new array for later operations -> use map( )

For example:

<script>
  // map() through the stuff array to make a new stuffItems array. Where each item is now inside an <li> element within the new array
const stuffItems = stuff.map((item) => {
  let listItem = document.createElement("li");
  listItem.innerHTML = item;
  return listItem;
});

// Append each element from the stuffItems array to the stuffList <ul>
stuffItems.forEach((item) => {
  stuffList.append(item);
});

// Append stuffList to the <article>
article.append(stuffList);
</script>

# Section 9 - Events

Refer MDN docs, there are a lot of events you can monitor. When they are triggered, you can get some result, trigger a function, toggle classes, and so on i.e. using a callback or anonymous function added to an Event Listener that is called when the 'event' is triggered/detected.

<script>
target.addEventListener(target, callback [,options]);
/*window
or any element in the dom*/
// options: advanced functionality that is used rarely, but usually set to 'false' to ensure expected behavior.

// Example
<button class="toggle-hood">Open hood</button>

const status = carArticle.querySelector(".car_hood span");

button.addEventListener("click", (event) => {
  status.innerText === "open" ? status.innerText = "closed" : status.innerText = "open";
  button.innerText === "Open hood" ? button.innerText = "Close hood" : button.innerText = "Open hood";
}, false);

// OR we can use this and a function declaration

button.addEventListener("click", function(event) => {
  status.innerText === "open" ? status.innerText = "closed" : status.innerText = "open";
  this.innerText === "Open hood" ? this.innerText = "Close hood" : this.innerText = "Open hood";
}, false);


</script>

Form submits attempt to refresh the entire page, and this could be unwanted behavior. Prevent this by adding event.preventDefault() to the triggered functions/calls of the event on form submit. Refer below.

<script>
array.forEach(item => {
    console.log(item.querySelector("form").addEventListener("submit", (event)=> {
      event.preventDefault();
      console.log(item);
    }, false));

  });
  </script>

Arrow functions do not have their own this, so they refer to the closest defined this which is the window object.

The event object is automatically passed as a parameter to the callback function. Simply name and use the parameter. Generic names are addEventListener(event, (event or e) => { ... triggers }, false).

# 10. Debugging

console.log is key.
Add breakpoints in the debugger/console of a browser. This might also be possible in an IDE.
Commenting out/in sections.


