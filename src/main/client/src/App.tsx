import React, { useEffect, useState } from "react";

import Layout from "containers/Layout";
import apiClient from "lib/apiClient";
import "styles/Reset.scss";
import "styles/App.scss";
import {Calendar}  from "./components";

const App: React.FC<{}> = () => {
  const [testText, setTestText] = useState<string>("");

  useEffect(() => {
    const fetchTestData = async () => {
      const res = await apiClient.getTestData();
      setTestText(res);
    };
    fetchTestData();
  }, []);

  return (
    <Layout >
      <h1>{testText}</h1>
      <Calendar/>
    </Layout>
  );
};

export default App;
