package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Zzzz on 2017/11/30.
 */

@Controller
@RequestMapping("/part")
public class PartManageController {

    @Autowired
    private PartService partService;

    @RequestMapping(value = "/addpart",method = RequestMethod.POST)
    @ResponseBody
    public Show addPart(@RequestParam("name") String name){
        return partService.addPart(name);
    }

    @RequestMapping("/movepart")
    @ResponseBody
    public Show movepart(@RequestParam("id") int id){
        return partService.movePart(id);
    }

    @RequestMapping(value = "/updatepart",method = RequestMethod.POST)
    @ResponseBody
    public Show updatepart(@RequestParam("id") int id, @RequestParam("name") String name){
        return partService.updatePart(id, name);
    }

}
