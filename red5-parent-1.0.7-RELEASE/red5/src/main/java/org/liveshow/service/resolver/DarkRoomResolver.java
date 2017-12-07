package org.liveshow.service.resolver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.liveshow.chat.Message;
import org.liveshow.chat.WebScoket;
import org.liveshow.chat.content.DarkChatContent;
import org.liveshow.chat.content.DarkRoomContent;
import org.liveshow.dto.Show;
import org.liveshow.entity.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by Cjn on 2017/12/7.
 */
@Service
public class DarkRoomResolver implements ContentResolver {
    @Override
    public void resolve(String msgJson, WebScoket webScoket) {
        Gson gson = new Gson();
        Type objectType = new TypeToken<Message<DarkRoomContent>>() {
        }.getType();
        Message<DarkRoomContent> message = gson.fromJson(msgJson, objectType);
        for (WebScoket item : webScoket.getWebSocketSet()) {
            try {
                if (item.getRoomId() == message.getContent().getId()) {
                    Message<Show> message1 = new Message<>();
                    Show show = new Show();
                    show.setMessage("该主播已经被查封");
                    show.setState(0);
                    message1.setContent(show);
                    message1.setType("darkRoom");
                    item.sendMessage(gson.toJson(message1));
                }

            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
