package org.liveshow.service.resolver;

import org.liveshow.chat.Message;
import org.liveshow.chat.WebScoket;

/**
 * Created by Cjn on 2017/12/6.
 */
public interface ContentResolver{
    void resolve(String msgJson, WebScoket webScoket);
}
