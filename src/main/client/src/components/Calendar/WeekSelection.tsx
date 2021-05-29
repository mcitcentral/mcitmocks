import React, { useState } from "react";
import { FaAngleLeft, FaAngleRight } from "react-icons/all";


interface selectProp {
  onClickLeft?: any;
  onClickRight?: any;
}

const WeekSelection: React.FC<selectProp> = ({onClickLeft,onClickRight})=> {

  return (
    <div className="button-group">
      <button className="button" onClick={onClickLeft}><FaAngleLeft style={{ color: "#D2D6DC", width: "20px",height: "20px"}}/></button>
      <button className="button" onClick={onClickRight}><FaAngleRight style={{color: "#D2D6DC" , width: "20px",height: "20px"}}/></button>
    </div>
  );
}

export default WeekSelection;