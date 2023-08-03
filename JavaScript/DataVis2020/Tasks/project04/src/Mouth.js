// yellow smiley mouth (left and right) specification, using ES6 and ...
// React components
import { arc } from "d3";

export const Mouth = ({ mouthRadius, mouthWidth }) => {
  const mouthArc = arc()
    .innerRadius(mouthRadius)
    .outerRadius(mouthRadius + mouthWidth)
    .startAngle(Math.PI / 2) // start at 90 degrees i.e. pi/2 radians
    .endAngle((3*Math.PI) / 2); // end at 270 degrees i.e. 3*pi/2 radians
    
    // notice the lack of curly braces around {var} because the code is not ...
    // ... within <> a html element.
    // this is performed at the return statement.
  return <path d={mouthArc()}/>;
};