/* New code improvements / refactoring: 
-relocate background circle, eyes and mouth elements (which has a d3.arc) outside of App.js as external js ES6 components
*/
import './App.css';
import { BackgroundCircle } from './BackgroundCircle.js';
import { Eyes } from './Eyes.js';
import { Mouth } from './Mouth.js';

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

// mouth dimensions
const mouthRadius = 120;
const mouthWidth = 10;

// Place all elements into a group element, also use template literal `****` 
const App = () => (   // arrow function expression
    <svg width={width} height={height}>
      <g transform={`translate(${centerX},${centerY})`}>
        <BackgroundCircle 
          radius={centerY - strokeWidth / 2}
          strokeWidth={strokeWidth}
        />
        <Eyes 
          eyeXOffset={eyeXOffset}
          eyeYOffset={eyeYOffset}
          eyeRadius={eyeRadius}
        /> 
        <Mouth
          mouthRadius={mouthRadius}
          mouthWidth={mouthWidth}
        />
      </g>
    </svg>
);

export default App;
