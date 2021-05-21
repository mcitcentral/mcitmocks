import React, {useState} from 'react';
import './TimeBlock.css';
import { FaRegCalendar,FaRegEnvelope,FaInbox } from "react-icons/fa";
export interface timeProps{
  startTime: number;
  isAvailable: boolean;
  confirmedWith?: string | null;
  sendRequestTo?: string | null;
  receivedRequestFrom?: string| null;
}

const TimeBlock: React.FC<timeProps> = ({isAvailable, confirmedWith, sendRequestTo, receivedRequestFrom,startTime}) => {
  const startTimeStr = startTime.toString()+":00";
  const endTimeStr = (startTime+1).toString()+":00";
  const [availability,setAvailability]  = useState(isAvailable);
  const [confirmedPerson,setConfirmedperson]  = useState(confirmedWith);



  return confirmedWith != null ? (
    <button className="calendar-event-confirmed" onClick={()=>{alert('Are you sure you want to cancel the interview?')}}>
      <div className="calendar-confirmed-rectangle"></div>
      <div className="calendar-event-info">
        <div className="calendar-event-time">{startTimeStr}-{endTimeStr}</div>
        <div className="calendar-event-icon"><FaRegCalendar /></div>
        <div className="calendar-event-title">{confirmedPerson}</div>
      </div>
    </button>
  )   : sendRequestTo != null?
    (
      <button className="calendar-event-request" onClick={()=>{}}>
        <div className="calendar-request-rectangle"></div>
        <div className="calendar-event-info">
          <div className="calendar-event-time">{startTimeStr}-{endTimeStr}</div>
          <div className="calendar-event-icon"><FaRegEnvelope /></div>
          <div className="calendar-event-title">{sendRequestTo}</div>
        </div>
      </button>
    ) : receivedRequestFrom != null? (
      <button className="calendar-event-request" onClick={()=>{}}>
        <div className="calendar-request-rectangle"></div>
        <div className="calendar-event-info">
          <div className="calendar-event-time">{startTimeStr}-{endTimeStr}</div>
          <div className="calendar-event-icon"><FaInbox /></div>
          <div className="calendar-event-title">{receivedRequestFrom}</div>
        </div>
      </button>
    ): availability ? (
      <button className="calendar-event-available" onClick={()=>setAvailability(false)}>
        <div className="calendar-available-rectangle"></div>
        <div className="calendar-event-info">
          <div className="calendar-event-time">{startTimeStr}-{endTimeStr}</div>
          <div className="calendar-event-title">I'm available!</div>
        </div>
      </button>
    ) : (
      <button className="calendar-event-navailable" onClick={()=>{setAvailability(true)}}>
        <div className="calendar-navailable-rectangle"></div>
        <div className="calendar-event-info">
          <div className="calendar-event-time">{startTimeStr}-{endTimeStr}</div>
        </div>
      </button>
    );
};

export default TimeBlock;


