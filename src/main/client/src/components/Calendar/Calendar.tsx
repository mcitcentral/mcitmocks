import React, {useEffect, useLayoutEffect, useMemo, useState} from 'react';
import Day , {interviewInfo} from './Day';
import './Calendar.css';
import { FaAngleLeft } from "react-icons/fa";
import { FaAngleRight } from "react-icons/fa";

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
const Calendar: React.FC = () => {
  //Get current date
  const today = new Date;

  const month = today.getMonth()+1;
  let monthStr:string = "";
  const setMonth = (month:number)=> {
    if(month == 1) {
      monthStr= "Jan";
    } else if(month == 2) {
      monthStr= "Feb";
    } else if(month == 3) {
      monthStr= "Mar";
    } else if(month == 4) {
      monthStr= "Apr";
    } else if(month == 5) {
      monthStr= "May";
    } else if(month == 6) {
      monthStr= "Jun";
    } else if(month == 7) {
      monthStr= "July";
    } else if(month == 8) {
      monthStr= "Aug";
    } else if(month == 9) {
      monthStr= "Sept";
    } else if(month == 10) {
      monthStr= "Oct";
    } else if(month == 11) {
      monthStr= "Nov";
    }
    else if(month == 12) {
      monthStr= "Dec";
    }
    return monthStr;
  }
  setMonth(month);

  const firstDate:number = today.getDate() - today.getDay() + 1;





  //define hooks
  const [firstdate,setFirstdate] = useState(firstDate);
  const [weekinfo, setWeekinfo] = useState<weekdayInfo[]>(weekinfoInitial);



  const onClickLeft = () => {
    setFirstdate(firstdate-7);

  }
  const onClickRight = () => {
    setFirstdate(firstdate+7);
  }



  return (
    <div className="container">
      <div className="calendar-nav">
        <h2>{monthStr+" "+ firstdate +"-" + (firstdate+6).toString()+", "+today.getFullYear()}</h2>
        <div className="button-group">
          <button className="button" onClick={onClickLeft}><FaAngleLeft style={{color: "#D2D6DC", width: "20px",height: "20px"}}/></button>
          <button className="button" onClick={onClickRight}><FaAngleRight style={{color: "#D2D6DC" , width: "20px",height: "20px"}}/></button>
        </div>
      </div>
      <div className="calendar">

        <Day {...{date: monthStr+" "+(firstdate+6).toString(), dayOfTheWeek: "Sunday", dayInfo: weekinfo[0]}}/>
        <Day {...{date: monthStr+" "+(firstdate+5).toString(), dayOfTheWeek: "Saturday", dayInfo: weekinfo[1]}}/>
        <Day {...{date: monthStr+" "+(firstdate+4).toString(), dayOfTheWeek: "Friday", dayInfo: weekinfo[2]}}/>
        <Day {...{date: monthStr+" "+(firstdate+3).toString(), dayOfTheWeek: "Thursday", dayInfo: weekinfo[3]}}/>
        <Day {...{date: monthStr+" "+(firstdate+2).toString(), dayOfTheWeek: "Wednesday", dayInfo: weekinfo[4]}}/>
        <Day {...{date: monthStr+" "+(firstdate+1).toString(), dayOfTheWeek: "Tuesday", dayInfo: weekinfo[5]}}/>
        <Day {...{date: monthStr+" "+firstdate, dayOfTheWeek: "Monday", dayInfo: weekinfo[6]}}/>
      </div>
    </div>
  );

};

export default Calendar;
