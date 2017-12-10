package org.liveshow.service.impl;

import org.liveshow.dao.LiveRecordMapper;
import org.liveshow.dao.PartMapper;
import org.liveshow.dto.Show;
import org.liveshow.entity.Part;
import org.liveshow.service.LiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class LiveRecordServiceImpl  implements LiveRecordService{

    @Autowired
    private PartMapper partMapper;

    @Autowired
    private LiveRecordMapper liveRecordMapper;

    @Override
    public Show getPartsPopulation(int startTime, int endTime) {
        Show show = new Show();
        int countDay = (endTime - startTime) / 86400;
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Part> partList = partMapper.selectAll();
        map.put("part", partList);
        for(int i = 0;i < partList.size();i++){
            int[] temp = new int[countDay];
            int m = startTime;
            for(int n = 0;n < countDay;n++){
                if (liveRecordMapper.selectPartPopulationByDate(partList.get(i).getId(), m, m + 86400) == null){
                    temp[n] = 0;
                }else{
                    temp[n] = liveRecordMapper.selectPartPopulationByDate(partList.get(i).getId(), m, m + 86400);
                }
                m += startTime;
            }
            map.put(partList.get(i).getName(), temp);
        }
        show.setData(map);
        show.setState(1);
        return show;
    }
}
