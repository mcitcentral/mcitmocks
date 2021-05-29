import React from 'react';
import './Day.css';
import TimeBlock, {timeProps} from './TimeBlock';
import {useState} from 'react';
import {weekdayInfo} from "./Background";
import { format } from "date-fns";


export interface interviewInfo {
  time: number;
  name: string;
}



interface DayProps {
  date: Date;
  dayInfo: weekdayInfo;
}

const renderTime = (dayInfo:weekdayInfo)=> {
  const timeprops:timeProps[] = [];


  for (let i = 1; i < 7; i++) {
    if(dayInfo.availableTimes!=null && dayInfo.availableTimes.includes(i)) {
      timeprops.push({
        startTime: i,
        isAvailable: true,
      });
    } else {
      const cur:timeProps = {
        startTime: i,
        isAvailable: false,
        confirmedWith: null,
        sendRequestTo: null,
        receivedRequestFrom: null,
      };
      if(dayInfo.confirmedTimes != undefined ) {
        dayInfo.confirmedTimes.map((info, index) =>  {
          if(cur.startTime == info.time) {
            cur.confirmedWith = info.name;
          }
        });
      }
      if(dayInfo.sendRequestTimes != undefined ) {
        dayInfo.sendRequestTimes.map((info, index) =>  {
          if(cur.startTime == info.time) {
            cur.sendRequestTo = info.name;
          }
        });
      }
      if(dayInfo.receivedRequestTimes != undefined ) {
        dayInfo.receivedRequestTimes.map((info, index) =>  {
          if(cur.startTime == info.time) {
            cur.receivedRequestFrom = info.name;
          }
        });
      }
      timeprops.push(cur);
    }


  }
  return timeprops;
}

const Day: React.FC<DayProps> = ({date,dayInfo}) => {

  const [timeprops,setTimeprops] = useState<timeProps[]>(renderTime(dayInfo));


  return (
    <div className="calendar-day" >
      <div className="calendar-day-label">
        <h4>{format(date,'EEEE')}</h4>
        <span>{format(date,'MMMM d')}</span>
      </div>
      <div className="calendar-events" >
        {timeprops.map((timeprop:timeProps)=> {
          return <TimeBlock {...timeprop}/>
        })}
      </div>
    </div>

  );
};

export default Day;
