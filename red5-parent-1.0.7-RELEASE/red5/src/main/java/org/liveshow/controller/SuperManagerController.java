package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.RecommendHome;
import org.liveshow.entity.User;
import org.liveshow.service.DarkroomRoomService;
import org.liveshow.service.RecommendHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Cjn on 2017/11/30.
 */
@Controller
@RequestMapping("/supermanager")
public class SuperManagerController {
    @Autowired
    private DarkroomRoomService darkroomRoomService;
    @Autowired
    private RecommendHomeService recommendHomeService;
    
    /**
     *@Author Cjn
     * @param roomId
     * @param reason
     * @param hours
     * @param managerId
     * @param request
     * @param model
     * @return
     * 封禁主播
     */
    @RequestMapping("/closure")
    @ResponseBody
    public Show closureRoom(Integer roomId, String reason ,Integer hours,HttpServletRequest request,Model model){
        Show show = new Show();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        /**构建图片保存的目录**/
        String logoPathDir = "/static/img/closure/"+ dateformat.format(new Date());
        /**得到图片保存目录的真实路径**/
        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
        /**根据真实路径创建目录**/
        File logoSaveFile = new File(logoRealPathDir);
        if(!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        /**页面控件的文件流**/
        MultipartFile multipartFile = multipartRequest.getFile("file");
        /**获取文件的后缀**/
        String suffix = multipartFile.getOriginalFilename().substring
                (multipartFile.getOriginalFilename().lastIndexOf("."));
        /**使用UUID生成文件名称**/    
        String logImageName = UUID.randomUUID().toString()+ suffix;//构建文件名称     
        //String logImageName = multipartFile.getOriginalFilename();
        /**拼成完整的文件保存路径加文件**/
        String fileName = logoRealPathDir + File.separator   + logImageName;
        File file = new File(fileName);
        System.out.println(fileName);
        try {
            multipartFile.transferTo(file);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        
        int res = darkroomRoomService.insertDarkRecord(roomId,reason,hours*60*60,fileName,user.getId());
        if (res == 0){
            show.setState(0);
            show.setMessage("操作失败");
        }else{
            show.setState(1);
            show.setMessage("封印成功");
        }
        
        return show;
    }
    
    
    @RequestMapping("/recoRoom")
    @ResponseBody
    public Show addRecoRoom( int roomId ,int managerId){
        Show show = new Show();
        int res = recommendHomeService.addRecoRoom(roomId,managerId);
        if (res == 1){
            show.setState(1);
            show.setMessage("推荐成功");
        }else{
            show.setState(0);
            show.setMessage("推荐失败");
        }
        return show;
    }
    
}
