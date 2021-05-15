package com.mcitmocks.mcitmocks;

import net.minidev.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;

@SpringBootApplication
@RestController
public class MCITMocksApplication {

    @GetMapping(path = "/api/test")
    String test () {
        return "test string";
    }

    @RequestMapping(value = "/api/test/google", method = RequestMethod.POST)
    @ResponseBody
    public String getToken(HttpServletRequest request,
                           @RequestBody JSONObject jsonObject
    ) throws InterruptedException, GeneralSecurityException, IOException {

        String token =  jsonObject.get("token").toString();
        System.out.println(token);
        GoogleTokenVerify verifier = new GoogleTokenVerify();
        verifier.verify(token);
        return token;
    }


    public static void main(String[] args) {
        SpringApplication.run(MCITMocksApplication.class, args);
    }

}
