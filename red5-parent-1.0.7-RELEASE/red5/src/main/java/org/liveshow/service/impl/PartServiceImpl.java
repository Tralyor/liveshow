package org.liveshow.service.impl;

import org.liveshow.dao.ModuleMapper;
import org.liveshow.dao.PartMapper;
import org.liveshow.dto.Show;
import org.liveshow.entity.Part;
import org.liveshow.entity.PartExample;
import org.liveshow.service.ModuleService;
import org.liveshow.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartMapper partMapper;

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    @Transactional
    public List<Part> getAllPart() {
        return partMapper.selectAll();
    }

    @Override
    @Transactional
    public List<Part> findAllPart() {
        PartExample partExample = new PartExample();
        List<Part> lists = partMapper.selectByExample(partExample);
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return lists;
    }

    @Override
    public Show updatePart(int id, String name) {
        Show show = new Show();
        Part part = new Part();
        part.setId(id);
        part.setName(name);
        partMapper.updateByPrimaryKey(part);
        show.setState(1);
        show.setMessage("修改成功");
        return show;
    }

    @Override
    public Show movePart(int id) {
        Show show = new Show();
        moduleMapper.deleteByPartId(id);
        partMapper.deleteByPrimaryKey(id);
        show.setState(1);
        show.setMessage("移除成功");
        return show;
    }

    @Override
    public Show addPart(String name) {
        Show show = new Show();
        Part part = new Part();
        part.setName(name);
        partMapper.insert(part);
        show.setData(partMapper.selectAll());
        show.setState(1);
        show.setMessage("添加成功");
        return show;
    }

    @Transactional
    public Part findPartById(int partId) {
        PartExample partExample = new PartExample();
        PartExample.Criteria criteria = partExample.createCriteria();
        criteria.andIdEqualTo(partId);
        List<Part> lists = partMapper.selectByExample(partExample);
        if (lists == null || lists.size() != 1) {
            return null;
        }
        return lists.get(0);
    }
}
