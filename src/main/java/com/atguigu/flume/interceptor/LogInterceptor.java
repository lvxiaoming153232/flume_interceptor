package com.atguigu.flume.interceptor;

import com.atguigu.flume.utils.JSONUtils;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;


import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Myron on 2020/7/28.
 */
public class LogInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {
        byte[] b = event.getBody();
        String log = new String(b, StandardCharsets.UTF_8);
        if (JSONUtils.isJSONValidate(log)) {
            return event;
        }
        return null;


    }

    @Override
    public List<Event> intercept(List<Event> list) {

        Iterator<Event> iterator = list.iterator();
        while(iterator.hasNext()) {
            Event eve = iterator.next();
            if(intercept(eve) == null) {
                iterator.remove();
            }
        }
        return null;
    }

    public static class Builder implements Interceptor.Builder{
        @Override
        public Interceptor build() {
            return new LogInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }

    @Override
    public void close() {

    }
}
