/* New code improvements / refactoring: 
-refactor background yellow circle element outside of React App func exp with an external arrow function exp specified in ES6
-fixed missing semi-colons in code
*/
import './App.css';
import * as d3 from "d3";

// canvas size
const width = 960;
const height = 500;

// stroke size
const strokeWidth = 10;

// face dimensions
const centerX = width / 2;
const centerY = height / 2;

// eye dimensions
const eyeXOffset = 100;
const eyeYOffset = 80;
const eyeRadius = 40; 

// mouth dimensions, using d3 component
const mouthWidth = 10;
const mouthRadius = 120;
const mouthArc = d3.arc()
  .innerRadius(mouthRadius)
  .outerRadius(mouthRadius + mouthWidth)
  .startAngle(Math.PI / 2) // start at 90 degrees i.e. pi/2 radians
  .endAngle(3*Math.PI / 2); // end at 270 degrees i.e. 3*pi/2 radians

// background circle specification, using ES6
const BackgroundCircle = ({radius}) => (
  <circle
  r={radius}
  fill="yellow"
  stroke="black"
  stroke-width={strokeWidth}
/>
);

// Place all elements into a group element, also use template literal `****` 
const App = () => (   // arrow function expression
    <svg width={width} height={height}>
      <g transform={`translate(${centerX},${centerY})`}>
        <BackgroundCircle radius = {centerY - strokeWidth / 2}/>
        <circle
            cx={-eyeXOffset}
            cy={-eyeYOffset}
            r={eyeRadius}
        />
        <circle
            cx={eyeXOffset}
            cy={-eyeYOffset}
            r={eyeRadius}
        />   
        <path 
            d={mouthArc()}
            stroke="black"
            stroke-width={mouthWidth}
            fill="transparent"
        />
      </g>
    </svg>
);

export default App;

/* unrequired boilerplate code

import logo from './logo.svg';

function App() { // function declaration
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

*/