package org.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kaenry on 2016/5/22.
 * PublicController
 */
@Controller
public class PublicController {

    @RequestMapping("/")
    public String index() {

        return "index";
    }
}
