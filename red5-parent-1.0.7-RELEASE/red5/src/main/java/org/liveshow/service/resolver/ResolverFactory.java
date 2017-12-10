package org.liveshow.service.resolver;

import com.google.gson.Gson;
import org.liveshow.chat.Message;
import org.liveshow.chat.WebScoket;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by Cjn on 2017/12/6.
 */
@Service
public class ResolverFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
    public void doAction(String msgJson, WebScoket webSocket){
        System.out.println("doAction");
        Gson gson = new Gson();
        Message message = gson.fromJson(msgJson, Message.class);
        String type = message.getType() + "Resolver";
        System.out.println(type);
        ((ContentResolver)applicationContext.getBean(type)).resolve(msgJson,webSocket);
    }
    
}
