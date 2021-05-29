import React, { useState } from "react";
import 'components/Calendar/TimeBlock.css';
import { FaRegCalendar } from "react-icons/all";

interface confirmedProps {
  startTime: number,
  withWhom: string
}
const Confirmed: React.FC<confirmedProps> = ({withWhom,startTime})=> {

  return (
    <button className="calendar-event-confirmed" onClick={()=>{alert('Are you sure you want to cancel the interview?')}}>
      <div className="calendar-confirmed-rectangle"></div>
      <div className="calendar-event-info">
        <div className="calendar-event-time">{startTime}:00-{startTime+1}:00</div>
        <div className="calendar-event-icon"><FaRegCalendar /></div>
        <div className="calendar-event-title">{withWhom}</div>
      </div>
    </button>
  );
}


export default Confirmed;