package org.liveshow.service.resolver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.liveshow.chat.Message;
import org.liveshow.chat.WebScoket;
import org.liveshow.chat.content.DarkChatContent;
import org.liveshow.dto.Show;
import org.liveshow.entity.DarkroomDanmaku;
import org.liveshow.entity.User;
import org.liveshow.service.DarkroomDanmakuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;


/**
 * Created by Cjn on 2017/12/7.
 */
@Service
public class DarkDanmakuResolver implements ContentResolver{
    @Autowired
    private DarkroomDanmakuService darkroomDanmakuService;
    
    @Override
    public void resolve(String msgJson, WebScoket webScoket) {
        Gson gson = new Gson();
        Type objectType = new TypeToken<Message<DarkChatContent>>() {
        }.getType();
        Message<DarkChatContent> message = gson.fromJson(msgJson, objectType);
        DarkroomDanmaku darkroomDanmaku = new DarkroomDanmaku();
        darkroomDanmaku.setDanmakuId(message.getContent().getDanmakuId());
        darkroomDanmaku.setHours(message.getContent().getHours()*60*60);
        darkroomDanmaku.setTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
        int res = darkroomDanmakuService.addDarkRoomDanmaku(darkroomDanmaku);
        if (res != 0) {
            for (WebScoket item : webScoket.getWebSocketSet()) {
                try {
                    User user = (User) item.getHttpSession().getAttribute("user");
                    if (user.getId() == message.getContent().getUserId()) {
                        Message<Show> message1 = new Message<>();
                        Show show = new Show();
                        show.setMessage("你被主播封禁");
                        show.setState(0);
                        message1.setContent(show);
                        message1.setType("darkDanmaku");
                        item.sendMessage(gson.toJson(message1));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }
}
