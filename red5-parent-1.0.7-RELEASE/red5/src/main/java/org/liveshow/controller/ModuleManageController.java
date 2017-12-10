package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.service.ModuleService;
import org.liveshow.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zzzz on 2017/11/30.
 */

@Controller
@RequestMapping("/module")
public class ModuleManageController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private PartService partService;

    @RequestMapping("/manager")
    public String getAll(HttpServletRequest req,Model model){
        List<Part> partList = partService.getAllPart();
        List<Module> moduleList = moduleService.getAllModule();
        model.addAttribute("partList", partList);
        model.addAttribute("moduleList", moduleList);
        return "manager/partmanager";
    }

    @RequestMapping("/addmodule")
    @ResponseBody
    public Show addModule(@RequestParam("partId") int partId ,@RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("file")MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        Show show = moduleService.addModule(partId ,name, description, multipartFile.getOriginalFilename());
        moduleService.savepic(multipartFile.getInputStream(), request.getSession().getServletContext().getRealPath("/") + "static\\img\\module", multipartFile.getOriginalFilename());
        return show;
    }

    @RequestMapping("/changename")
    @ResponseBody
    public Show changename(@RequestParam("id") int id, @RequestParam("name") String name){
        return moduleService.changeModuleName(id, name);
    }

    @RequestMapping("/changedescription")
    @ResponseBody
    public Show changedescription(@RequestParam("id") int id, @RequestParam("description") String description){
        return moduleService.changeModuleDescription(id, description);
    }

    @RequestMapping("/changephoto")
    @ResponseBody
    public Show changephoto(@RequestParam("id") int id, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        Show show = moduleService.changeModulePhoto(id, multipartFile.getOriginalFilename());
        moduleService.savepic(multipartFile.getInputStream(), request.getSession().getServletContext().getRealPath("/") + "static\\img\\module", multipartFile.getOriginalFilename());
        return show;
    }

    @RequestMapping("/movemodule")
    @ResponseBody
    public Show moveModule(@RequestParam("id") int id){
        return moduleService.moveModule(id);
    }

}
