package com.unidev.myip.web;

import com.unidev.myip.MyIPService;
import com.unidev.platform.web.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Frontend controller
 */
@Controller
public class IndexController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MyIPService myIPService;

    @RequestMapping("/")
    public ModelAndView index() {
        String ip = myIPService.extractClinetIp(request);
        List<Map.Entry<String, Object>> headers = myIPService.extractHeaders(request);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("ip", ip);
        modelAndView.addObject("headers", headers);
        return modelAndView;
    }


}
