package org.liveshow.service.impl;

import org.liveshow.dao.AnchorMapper;
import org.liveshow.dao.DanmakuMapper;
import org.liveshow.dao.LiveRecordMapper;
import org.liveshow.dto.Show;
import org.liveshow.entity.CombinationEntity.AnchorInfo;
import org.liveshow.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class AnchorServiceImpl  implements AnchorService{

    @Autowired
    private AnchorMapper anchorMapper;

    @Autowired
    private LiveRecordMapper liveRecordMapper;

    @Autowired
    private DanmakuMapper danmakuMapper;

    @Override
    public Show getAchorInfo(String userName) {
        Show show = new Show();
        if(anchorMapper.selectAnchorByName(userName) != 0){
            AnchorInfo anchorInfo = anchorMapper.selectAnchorInfo(userName);

            if(liveRecordMapper.selectHighestPopulation(userName) == null){
                anchorInfo.setHighestPopulation(0);
            }else{
                anchorInfo.setHighestPopulation(liveRecordMapper.selectHighestPopulation(userName));
            }

            if(liveRecordMapper.selectWholeDuration(userName) == null){
                anchorInfo.setWholeDuration(0);
            }else{
                anchorInfo.setWholeDuration(liveRecordMapper.selectWholeDuration(userName));
            }

            if(liveRecordMapper.countTimes(userName) == null){
                anchorInfo.setTimes(0);
            }else{
                anchorInfo.setTimes(liveRecordMapper.countTimes(userName));
            }

            if(danmakuMapper.countDanmaku(userName) == null){
                anchorInfo.setDanmakuNumber(0);
            }else{
                anchorInfo.setDanmakuNumber(danmakuMapper.countDanmaku(userName));
            }
            show.setData(anchorInfo);
            show.setState(1);
            show.setMessage("成功");
        }else{
            show.setState(0);
            show.setMessage("查无此人");
        }
        return show;
    }

    @Override
    public Show getChartInfo(String userName, int startTime, int endTime) {
        Show show = new Show();
        int countDay = 0;
        int countTime = startTime;
        for (int i = 0;endTime > startTime;i++){
            countDay++;
            endTime -= 86400;
        }
        HashMap<String, int[]> map = new HashMap<String, int[]>();
        int[] temp = new int[countDay];
        for(int i = 0;i < countDay;i++){
            if(anchorMapper.selectDurationByDate(userName, countTime, countTime + 86400) == null){
                temp[i] = 0;
            }else{
                temp[i] = anchorMapper.selectDurationByDate(userName, countTime, countTime + 86400);
            }
            countTime += 86400;
        }
        map.put("duration", temp);
        countTime = startTime;
        for(int i = 0;i < countDay;i++){
            if(anchorMapper.selectPopulationByDate(userName, countTime, countTime + 86400) == null){
                temp[i] = 0;
            }else {
                temp[i] = anchorMapper.selectPopulationByDate(userName, countTime, countTime + 86400);
            }
            countTime += 86400;
        }
        map.put("population", temp);
        show.setData(map);
        show.setState(1);
        show.setMessage("图表数据");
        return show;
    }

}
