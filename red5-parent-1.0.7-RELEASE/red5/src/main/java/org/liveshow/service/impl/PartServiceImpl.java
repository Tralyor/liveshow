package org.liveshow.service.impl;

import org.liveshow.dao.PartMapper;
import org.liveshow.entity.Part;
import org.liveshow.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartMapper partMapper;

    @Override
    public List<Part> getAllPart() {
        return partMapper.selectAll();
    }
}
