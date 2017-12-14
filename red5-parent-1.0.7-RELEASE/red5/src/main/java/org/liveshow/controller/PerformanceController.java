package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.service.AnchorService;
import org.liveshow.service.LiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Zzzz on 2017/12/1.
 */

@Controller
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private LiveRecordService liveRecordService;

    @Autowired
    private AnchorService anchorService;

    @RequestMapping("/part")
    @ResponseBody
    public Show getPartInfo(@RequestParam("startTime") int startTime, @RequestParam("endTime") int endTime){
        return liveRecordService.getPartsPopulation(startTime, endTime);
    }

    @RequestMapping("/anchorinfo")
    @ResponseBody
    public Show getAnchorInfo(@RequestParam("userName") String userName){
        return anchorService.getAchorInfo(userName);
    }

    @RequestMapping("/chartinfo")
    @ResponseBody
    public Show getChartInfo(@RequestParam("userName") String userName, @RequestParam("startTime") int startTime, @RequestParam("endTime") int endTime){
        return anchorService.getChartInfo(userName, startTime, endTime);
    }

}
