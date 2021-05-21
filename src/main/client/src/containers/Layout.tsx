import React from "react";
import { Header, Footer, Calendar } from "components";


const Layout: React.FC<{}> = ({ children }) => {
  return (
    <>
      <Header />
      <main>{children}</main>
      <Calendar/>
      <Footer />
    </>
  );
};

export default Layout;
