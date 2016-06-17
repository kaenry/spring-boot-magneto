package org.master.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by kaenry on 2016/6/17.
 * UserController
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    public String info(Principal principal, ModelMap modelMap){
        String name = principal.getName();
        modelMap.put("name", name);

        return "user/info";
    }
}
