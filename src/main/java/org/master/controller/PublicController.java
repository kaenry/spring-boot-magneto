package org.master.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kaenry
 * @date 2016/5/22
 * PublicController
 */
@RestController
public class PublicController {

    @RequestMapping("/")
    public String index() {

        return "Hello, Master World.";
    }
}
