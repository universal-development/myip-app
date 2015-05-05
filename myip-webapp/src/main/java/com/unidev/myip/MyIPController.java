package com.unidev.myip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyIPController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/", consumes = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String html() {

        return "htmlBody";
    }

    @RequestMapping(value = "/", consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String plainText() {

        return "plainText";
    }

    @RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String plainJson() {

        return "plainJson";
    }

}
