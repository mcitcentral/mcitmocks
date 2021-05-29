import React, { useState } from "react";
import "./TimeBlock.css";
import { FaRegCalendar, FaRegEnvelope, FaInbox } from "react-icons/fa";
import Confirmed from "./TimeBlocks/Confirmed";
import Pending from "./TimeBlocks/Pending";
import Availability from "./TimeBlocks/Availability";

export interface timeProps {
  startTime: number;
  isAvailable: boolean;
  confirmedWith?: string | null;
  sendRequestTo?: string | null;
  receivedRequestFrom?: string | null;
}

const TimeBlock: React.FC<timeProps> = ({ isAvailable, confirmedWith, sendRequestTo, receivedRequestFrom, startTime }) => {
  const startTimeStr = startTime.toString() + ":00";
  const endTimeStr = (startTime + 1).toString() + ":00";
  const [availability, setAvailability] = useState(isAvailable);
  const [confirmedPerson, setConfirmedperson] = useState(confirmedWith);


  return confirmedWith != null ? (<Confirmed startTime={startTime} withWhom={confirmedWith} />)
    : sendRequestTo != null ?
      (<Pending startTime={startTime} hasSentTo={sendRequestTo} hasReceivedFrom={null} />)
      : receivedRequestFrom != null ? (
          <Pending startTime={startTime} hasSentTo={null} hasReceivedFrom={receivedRequestFrom} />)
        : availability ? (<Availability startTime={startTime} isAvailable={true} />)
          : (<Availability startTime={startTime} isAvailable={false} />)
};

export default TimeBlock;


