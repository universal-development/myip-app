package com.unidev.myip;


import com.unidev.platform.web.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Service for listing client ip and headers
 */
@Service
public class MyIPService {

    @Autowired
    private WebUtils webUtils;


    /**
     * Extract client IP from http request
     * @return
     */
    public String extractClinetIp(HttpServletRequest request) {
        String clientId = webUtils.getClientIp(request);
        return clientId;
    }

    /**
     * List all headers from request
     * @param request
     * @return
     */
    public List<Map.Entry<String, Object>> extractHeaders(HttpServletRequest request) {
        return webUtils.listAllHeaders(request);
    }


}
