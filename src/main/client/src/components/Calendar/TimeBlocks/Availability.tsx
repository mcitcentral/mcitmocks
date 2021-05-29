import React, { useState } from "react";
import 'components/Calendar/TimeBlock.css';

interface availabilityProps {
  isAvailable: boolean,
  startTime: number,
}
const Availability: React.FC<availabilityProps> = ({isAvailable,startTime})=> {
  const [availability,setAvailability]  = useState(isAvailable);

  return availability ? (
    <button className="calendar-event-available" onClick={()=>setAvailability(false)}>
      <div className="calendar-available-rectangle"></div>
      <div className="calendar-event-info">
        <div className="calendar-event-time">{startTime}:00-{startTime+1}:00</div>
        <div className="calendar-event-title">I'm available!</div>
      </div>
    </button>
  ) : (<button className="calendar-event-navailable" onClick={()=>{setAvailability(true)}}>
    <div className="calendar-navailable-rectangle"></div>
    <div className="calendar-event-info">
      <div className="calendar-event-time">{startTime}:00-{startTime+1}:00</div>
    </div>
  </button>);
}


export default Availability;