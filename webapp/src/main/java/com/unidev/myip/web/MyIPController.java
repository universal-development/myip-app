package com.unidev.myip.web;

import com.unidev.myip.MyIPService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.unidev.platform.template.TemplateBuilder.newClassPathTemplate;

/**
 * Basic controller for requests
 */
@Controller
public class MyIPController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MyIPService myIPService;

    @RequestMapping(value = "/ip")
    public ModelAndView htmlRequest() {
        String ip = myIPService.extractClinetIp(request);
        ModelAndView modelAndView = new ModelAndView("myip");
        modelAndView.addObject("ip", ip);
        return modelAndView;
    }

    @RequestMapping(value = "/ip", consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String plainTextRequest() {

        String ip = myIPService.extractClinetIp(request);
        return newClassPathTemplate("myip.ftl")
                .addVariable("ip", ip)
                .build();
    }

    @RequestMapping(value = "/ip", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JSONObject jsonRequest() {

        String ip = myIPService.extractClinetIp(request);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ip", ip);

        return jsonObject;
    }



}
