package org.liveshow.service.impl;

import org.liveshow.dao.ModuleMapper;
import org.liveshow.dao.PartMapper;
import org.liveshow.dto.Show;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class ModuleServiceImpl  implements ModuleService{

    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private PartMapper partMapper;

    @Override
    public List<Module> getAllModule() {
        return moduleMapper.selectAll();
    }

    @Override
    public Show getModuleAndPart() {
        Show show = new Show();
        HashMap<String, List> hashMap = new HashMap<String,List>();
        hashMap.put("part", partMapper.selectAll());
        hashMap.put("module", moduleMapper.selectAll());
        show.setData(hashMap);
        show.setState(1);
        show.setMessage("获取成功");
        return show;
    }

    @Override
    public List<Module> findModuleByPartId(int typeNum) {
        List<Module> lists = moduleMapper.findByPart(typeNum);
        if (lists == null || lists.size() ==0){
            return null;
        }
        return lists;
    }

    @Override
    public Show addModule(int partId, String name, String description, String photo) {
        Show show = new Show();
        photo = "../../static/img/module/" + photo;
        Module module = new Module();
        module.setPartId(partId);
        module.setName(name);
        module.setDescription(description);
        module.setPhoto(photo);
        moduleMapper.insert(module);
        show.setState(1);
        show.setMessage("添加成功");
        show.setData(moduleMapper.selectAll());
        return show;
    }

    @Override
    public void savepic(InputStream stream, String path, String file) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + file);
            byte[] buffer = new byte[1024*1024];
            int bytesum = 0;
            int byteread = 0;
            while((byteread = stream.read(buffer)) != -1){
                bytesum += byteread;
                fileOutputStream.write(buffer,0,byteread);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            stream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Show changeModuleName(int id, String name) {
        moduleMapper.updateNameById(id, name);
        Show show = new Show();
        show.setState(1);
        show.setMessage("修改成功");
        return show;
    }

    @Override
    public Show changeModuleDescription(int id, String description) {
        moduleMapper.updateDescriptionById(id, description);
        Show show = new Show();
        show.setState(1);
        show.setMessage("修改成功");
        return show;
    }

    @Override
    public Show changeModulePhoto(int id, String photo) {
        photo = "../../static/img/module/" + photo;
        moduleMapper.updatePhotoById(id, photo);
        Show show = new Show();
        show.setState(1);
        show.setMessage("修改成功");
        show.setData(moduleMapper.selectAll());
        return show;
    }

    @Override
    public Show moveModule(int id) {
        Show show = new Show();
        moduleMapper.deleteByPrimaryKey(id);
        show.setState(1);
        show.setMessage("移除成功");
        return show;
    }
}
