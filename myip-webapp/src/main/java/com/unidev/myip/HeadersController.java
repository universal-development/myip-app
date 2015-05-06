package com.unidev.myip;

import com.unidev.platform.web.WebUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Controller for returning all request headers
 */
@Controller
public class HeadersController {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private WebUtils webUtils;


    @RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JSONObject jsonRequest() {
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
