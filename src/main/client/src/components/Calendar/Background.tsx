import React, {useEffect, useLayoutEffect, useMemo, useState} from 'react';
import Day , {interviewInfo} from './Day';
import './Background.css';
import { FaAngleLeft } from "react-icons/fa";
import { FaAngleRight } from "react-icons/fa";
import { addDays, eachDayOfInterval, parse } from "date-fns";

export interface weekdayInfo{
  availableTimes: number[];
  confirmedTimes?: interviewInfo[] | null;
  sendRequestTimes?: interviewInfo[] | null;
  receivedRequestTimes?: interviewInfo[] | null;
}
const weekinfoInitial = [{availableTimes: [3], confirmedTimes:[{time:2,name:"John Smith"},{time:4,name:"Andrew"}]},
  {availableTimes: [7]},
  {availableTimes: [1,5]},
  {availableTimes: [], confirmedTimes:[{time:3,name:"Andrew"}]},
  {availableTimes: [2,4]},
  {availableTimes: [6]},
  {availableTimes: [3,4], sendRequestTimes:[{time:5,name:"John Smith"}],receivedRequestTimes:[{time:6,name:"John Smith"}]}
];


interface backgroundProps {
  week: Interval;
}
const Background: React.FC<backgroundProps> = ({week}) => {

  const daysOfWeek = eachDayOfInterval({start: week.start, end: week.end});
  const [weekinfo, setWeekinfo] = useState<weekdayInfo[]>(weekinfoInitial);

  return (

      <div className="calendar">

        <Day {...{date: daysOfWeek[6], dayInfo: weekinfo[0]}}/>
        <Day {...{date: daysOfWeek[5], dayInfo: weekinfo[1]}}/>
        <Day {...{date: daysOfWeek[4], dayInfo: weekinfo[2]}}/>
        <Day {...{date: daysOfWeek[3], dayInfo: weekinfo[3]}}/>
        <Day {...{date: daysOfWeek[2], dayInfo: weekinfo[4]}}/>
        <Day {...{date: daysOfWeek[1], dayInfo: weekinfo[5]}}/>
        <Day {...{date: daysOfWeek[0], dayInfo: weekinfo[6]}}/>
      </div>
  );

};

export default Background;
