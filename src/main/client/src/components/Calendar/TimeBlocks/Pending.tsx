import React, { useState } from "react";
import 'components/Calendar/TimeBlock.css';
import { FaInbox,  FaRegEnvelope } from "react-icons/all";

interface pendingProps {
  startTime: number,
  hasSentTo: string | null,
  hasReceivedFrom: string | null,
}
const Pending: React.FC<pendingProps> = ({hasReceivedFrom,hasSentTo,startTime})=> {

  return hasReceivedFrom != null ? (
    <button className="calendar-event-request" onClick={()=>{}}>
      <div className="calendar-request-rectangle"></div>
      <div className="calendar-event-info">
        <div className="calendar-event-time">{startTime}:00-{startTime+1}:00</div>
        <div className="calendar-event-icon"><FaInbox /></div>
        <div className="calendar-event-title">{hasReceivedFrom}</div>
      </div>
    </button>
  ) : (
    <button className="calendar-event-request" onClick={()=>{}}>
    <div className="calendar-request-rectangle"></div>
    <div className="calendar-event-info">
      <div className="calendar-event-time">{startTime}:00-{startTime+1}:00</div>
      <div className="calendar-event-icon"><FaRegEnvelope /></div>
      <div className="calendar-event-title">{hasSentTo}</div>
    </div>
  </button>) ;
}


export default Pending;