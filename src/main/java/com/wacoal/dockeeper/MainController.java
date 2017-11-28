/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacoal.dockeeper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 92610
 */
@RestController
@RequestMapping("/main")
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ModelAndView index() {
        return new ModelAndView("main");
    //    return "main"; //call main.html
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public String getName(
            @PathVariable String name
    ) {
        return "Hello " + name;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/some")
    public String getSomeParam(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name
    ) {
        return "Some " + name;
    }

     @RequestMapping(method = RequestMethod.POST, value = "/some")
    public String getSomeParamPost(
            @RequestBody String name
    ) {
        return "Some " + name;
    }
}
