package com.unidev.myip;

import com.unidev.platform.web.WebUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.unidev.platform.template.TemplateBuilder.*;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyIPController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private WebUtils webUtils;

    @RequestMapping(value = "/", consumes = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String html() {

        return "htmlBody";
    }

    @RequestMapping(value = "/", consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String plainText() {

        String ip = extractClinetIp();

        return newClassPathTemplate("plainText.template")
                .addVariable("ip", ip)
                .build();
    }

    @RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JSONObject jsonRequest() {

        String ip = extractClinetIp();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ip", ip);

        return jsonObject;
    }

    /**
     * Extract client IP from http request
     * @return
     */
    protected String extractClinetIp() {
        String clientId = webUtils.getClientIp(request);
        return clientId;
    }

}
