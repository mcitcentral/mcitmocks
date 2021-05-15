import React from 'react';

import { GoogleLogin } from 'react-google-login';
import {refreshTokenSetup} from "./refreshToken";





const Login: React.FC<{}> = () => {
    const handleLogin = async (googleData:any) => {
        const res = await fetch("/api/test/google", {
            method: "POST",
            body: JSON.stringify({
                token: googleData.tokenId
            }),
            headers: {
                "Content-Type": "application/json"
            }
        })
        //const data = await res.json()
        // store returned user somehow
    }

    const onSuccess = (res :any) => {
        console.log("success");
        console.log('Login Success: currentUser:', res.profileObj);
        console.log('token:', res.tokenId);
        refreshTokenSetup(res);
        handleLogin(res);
    };

    const onFailure = (res :any) => {
        console.log('Login failed: res:', res);
        alert(
            `Failed to login. 😢 Please ping this to repo owner twitter.com/sivanesh_fiz`
        );
    };



    return (
        <div>
            <GoogleLogin
                clientId="373165512443-bpo262dcdnl1j4llk6gka7dfujsf434d.apps.googleusercontent.com"
                buttonText="Login"
                onSuccess={onSuccess}
                onFailure={onFailure}
                cookiePolicy={'single_host_origin'}
                style={{ marginTop: '100px' }}
                isSignedIn={true}
            />
        </div>
    );
};

export default Login;
