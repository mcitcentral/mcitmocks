import React from "react";
import { User } from "@types";
import "./Header.scss";

export interface HeaderProps {
  user: User | null;
}

const Header: React.FC<{}> = () => {
  return (
    <header className="header">
      <div className="header__left">
        <span>_mcitmocks</span>
          <button>LOGIN WITH GOOGLE</button>
      </div>
    </header>
  );
};

export default Header;
