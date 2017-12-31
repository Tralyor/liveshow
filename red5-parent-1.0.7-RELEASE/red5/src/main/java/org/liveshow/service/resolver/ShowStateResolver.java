package org.liveshow.service.resolver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.liveshow.chat.Message;
import org.liveshow.chat.WebScoket;
import org.liveshow.chat.content.DarkRoomContent;
import org.liveshow.chat.content.ShowStateContent;
import org.liveshow.dto.Show;

import java.io.IOException;
import java.lang.reflect.Type;

public class ShowStateResolver implements  ContentResolver{
    @Override
    public void resolve(String msgJson, WebScoket webScoket) {
        Gson gson = new Gson();
        Type objectType = new TypeToken<Message<ShowStateContent>>() {
        }.getType();
        Message<DarkRoomContent> message = gson.fromJson(msgJson, objectType);

        for (WebScoket item : webScoket.getWebSocketSet()) {
            try {
               if (item.getRoomId() == webScoket.getRoomId()){
                   item.sendMessage(msgJson);
               }

            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }

    }
}
