import React, { ButtonHTMLAttributes, createRef, useRef, useState } from "react";
import Background from "./Background";
import WeekSelection from "./WeekSelection";
import Save from "components/Buttons/Save";
import { add, addDays, eachDayOfInterval, endOfWeek, format, parse, startOfWeek } from "date-fns";

const Calendar: React.FC = () =>  {
  const [curweek, setCurweek] = useState({start: addDays(startOfWeek(new Date()),1),end:addDays(endOfWeek(new Date()),1)});

  return(
    <div style={{width: "800px"}}>
      <h2>{format(curweek.start, 'LLLL d')+'-'+format(curweek.end, 'LLLL d, yyyy')}</h2>
      <WeekSelection {...{
        onClickLeft:()=> {setCurweek({start: addDays(curweek.start,-7),end:addDays(curweek.end,-7)});},
        onClickRight:()=> {setCurweek({start: addDays(curweek.start,7),end:addDays(curweek.end,7)});}
      }}/>
      <hr style={{border: "1px solid #E5E7EB"}}/>
      <Background {...{week: curweek}}/>
      <Save/>
    </div>
  );
}

export default Calendar;