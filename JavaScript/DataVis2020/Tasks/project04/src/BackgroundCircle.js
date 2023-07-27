// background circle specification, using ES6
export const BackgroundCircle = ({ radius, strokeWidth }) => (
    <circle
    r={radius}
    fill="yellow"
    stroke="black"
    stroke-width={strokeWidth}
  />
  );