import React from "react";
import { User } from "@types";
import "./Header.scss";
import GoogleLogin from "react-google-login";

export interface HeaderProps {
  user: User | null;
}

const Header: React.FC<{}> = () => {
  const onSuccess = (res: any) => {
    console.log(res.tokenId);
  };

  return (
    <header className="header">
      <div className="header__left">
        <span>_mcitmocks</span>
        <GoogleLogin
          clientId="970171967437-520d4shgbivtaeav1kqajk7466fudd2o.apps.googleusercontent.com"
          onSuccess={onSuccess}
        />
      </div>
    </header>
  );
};

export default Header;
