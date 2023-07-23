
import './App.css';

const width = 960;
const height = 500;

const strokeWidth = 10

const centerX = width / 2;
const centerY = height / 2;

const eyeXOffset = 100; // changed easily from 120
const eyeYOffset = 80;
const eyeR = 40; // changed easily from 50

/* By adding variables containing our measurements for a smiley face, we can freely change the dimensions without ... 
... having to manually edit every dimension! This allows us to create our desired design more conveniently */

const App = () => (   // arrow function expression
    <svg width={width} height={height}>
        <circle
            cx={centerX}
            cy={centerY}
            r={centerY - strokeWidth/2}
            fill="yellow"
            stroke="black"
            stroke-width={strokeWidth}
        />
        <circle
            cx={centerX - eyeXOffset}
            cy={centerY - eyeYOffset}
            r={eyeR}
        />
        <circle
            cx={centerX + eyeXOffset}
            cy={centerY - eyeYOffset}
            r={eyeR}
        />   
        <path 
            d="M 350 325 C 400 400, 550 400, 610 325"
            stroke="black"
            stroke-width="20"
            fill="transparent"
        />
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