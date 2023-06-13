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
