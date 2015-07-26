package com.unidev.myip;

import com.unidev.platform.web.WebUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

import static com.unidev.platform.template.TemplateBuilder.newClassPathTemplate;

/**
 * Controller for returning all request headers
 */
@Controller("/headers")
public class HeadersController {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private WebUtils webUtils;

    @RequestMapping
    public ModelAndView htmlRequest() {
        JSONObject headers = buildHeadersJson();
        ModelAndView modelAndView = new ModelAndView("headers");
        modelAndView.addObject("headers", headers);
        return modelAndView;
    }

    @RequestMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String plainTextRequest() {
        JSONObject headers = buildHeadersJson();
        return newClassPathTemplate("headers.ftl")
                .addVariable("headers", headers)
                .build();
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JSONObject jsonRequest() {
        return buildHeadersJson();
    }

    protected JSONObject buildHeadersJson() {
        JSONObject jsonObject = new JSONObject();

        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            String headerValue = request.getHeader(headerName);

            jsonObject.put(headerName, headerValue);
        }

        return jsonObject;
    }

}
