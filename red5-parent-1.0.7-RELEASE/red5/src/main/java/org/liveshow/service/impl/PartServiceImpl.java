package org.liveshow.service.impl;

import org.junit.Test;
import org.liveshow.dao.PartMapper;
import org.liveshow.entity.Part;
import org.liveshow.entity.PartExample;
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
