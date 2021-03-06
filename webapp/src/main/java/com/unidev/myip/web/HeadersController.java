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
import java.util.List;
import java.util.Map;

import static com.unidev.platform.template.TemplateBuilder.newClassPathTemplate;

/**
 * Controller for returning all request headers
 */
@Controller
public class HeadersController {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MyIPService myIPService;

    @RequestMapping(value = "/headers")
    public ModelAndView htmlRequest() {
        JSONObject headers = buildHeadersJson();
        ModelAndView modelAndView = new ModelAndView("headers");
        modelAndView.addObject("headers", headers);
        return modelAndView;
    }

    @RequestMapping(value = "/headers", consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String plainTextRequest() {
        JSONObject headers = buildHeadersJson();
        return newClassPathTemplate("headers.ftl")
                .addVariable("headers", headers)
                .build();
    }

    @RequestMapping(value = "/headers", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JSONObject jsonRequest() {
        return buildHeadersJson();
    }

    protected JSONObject buildHeadersJson() {
        JSONObject jsonObject = new JSONObject();

        List<Map.Entry<String, Object>> entries = myIPService.extractHeaders(request);
        for(Map.Entry<String, Object> entry : entries) {
            String headerName =  entry.getKey();
            String headerValue = entry.getValue() + "";

            jsonObject.put(headerName, headerValue);
        }

        return jsonObject;
    }

}
