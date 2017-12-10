package org.liveshow.service.impl;

import org.liveshow.bean.RoomHeat;
import org.liveshow.dao.PartMapper;
import org.liveshow.dao.RoomMapper;
import org.liveshow.dao.UserMapper;
import org.liveshow.dto.Show;
import org.liveshow.entity.Part;
import org.liveshow.entity.Room;
import org.liveshow.entity.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.liveshow.entity.UserExample;
import org.liveshow.service.UserService;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hp on 2017/11/20.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private PartMapper partMapper;

    @Transactional
    public List<User> users(){
        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);
    }

    @Override
    public Show overviewInfo() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        RoomPopularity roomPopularity = RoomPopularity.getInstance();
        HashMap<Integer, RoomHeat> roomMap = roomPopularity.getRoomIdAndPopularity();
        List<Room> roomList = roomMapper.getAllRoom();
        List<Part> partList = partMapper.selectAll();
        int population = 0;
        int[] partPopulation = new int[partList.size()];
        String[] partName = new String[partList.size()];
        String[] anchorName = new String[7];
        int[] roomPopulation = new int[]{0,0,0,0,0,0,0};
        int position = 0;
        for (int i = 0;i < roomList.size();i++){
            population += roomMap.get(roomList.get(i).getId()).getPopulartyNow();
            if(roomMap.get(roomList.get(i).getId()).getPopulartyNow() > roomPopulation[position] && roomMap.get(roomList.get(i).getId()).getRoomIsOnline() == true){
                anchorName[position] = userMapper.selectByPrimaryKey(roomList.get(i).getUserId()).getNickName();
                roomPopulation[position] = roomMap.get(roomList.get(i).getId()).getPopulartyNow();
            }
            int min = roomPopulation[0];
            for(int n = 0;n < 7;n++){
                if(roomPopulation[n] < roomPopulation[position]){
                    position = n;
                }
            }
        }
        hashMap.put("population", population);
        hashMap.put("anchorName", anchorName);
        hashMap.put("roomPopulation", roomPopulation);
        for(int i = 0;i < partList.size();i++){
            List<Room> rooms = roomMapper.getRoomByPart(partList.get(i).getId());
            partName[i] = partList.get(i).getName();
            int temp = 0;
            for(int n = 0;n < rooms.size();n++){
                temp += roomMap.get(rooms.get(n).getId()).getPopulartyNow();
            }
            partPopulation[i] = temp;
        }
        hashMap.put("partName", partName);
        hashMap.put("partPopulation", partPopulation);
        Show show = new Show();
        show.setData(hashMap);
        show.setState(1);
        show.setMessage("表格数据申请成功");
        return show;
    }

}
