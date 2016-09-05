package org.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kaenry on 2016/5/22.
 * PublicController
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(String err, ModelMap modelMap) {
        if (StringUtils.hasLength(err)) {
            modelMap.put("err", err);
        }
        return "login";
    }
}
