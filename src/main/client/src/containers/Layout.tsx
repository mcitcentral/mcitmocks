import React from "react";
import { Header, Footer } from "components";

const Layout: React.FC<{}> = ({ children }) => {
  return (
    <>
      <Header />
      <main>{children}</main>
      <Footer />
    </>
  );
};

export default Layout;
