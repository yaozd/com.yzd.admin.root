package com.yzd.admin.web.conf;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by zd.yao on 2017/6/8.
 */
@Component
public class StartupListener implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
    public static int serverPort;
    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        this.serverPort = event.getEmbeddedServletContainer().getPort();
    }
    public int getPort() {
        return this.serverPort;
    }

}
