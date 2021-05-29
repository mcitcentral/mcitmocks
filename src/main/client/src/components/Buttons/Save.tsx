import React, { useState } from "react";
import './buttons.css';


const Save: React.FC = ()=> {
  const [state,setState] = useState(true);

  return state ? (
    <div>
      <button className="disabledButton" disabled={state} >SAVE</button>
    </div>
  ) : (
    <div>
      <button className="normalButton" disabled={state} onClick={()=>{alert("Saved succefully!")}}>SAVE</button>
    </div>
  );
}


export default Save;