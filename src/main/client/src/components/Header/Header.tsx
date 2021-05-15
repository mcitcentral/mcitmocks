import React from "react";
import {User} from "@types";
import "./Header.scss";
import Login from "../Login/Login";

export interface HeaderProps {
    user: User | null;
}

const Header: React.FC<{}> = () => {
    return (
        <header className="header">
            <div className="header__left">
                <span>_mcitmocks</span>
                <Login/>
            </div>
        </header>
    );
};

export default Header;
