// yellow smiley eyes (left and right) specification, using ES6
export const Eyes = ({ eyeXOffset, eyeYOffset, eyeRadius }) => (
    <>
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
    </>  
);