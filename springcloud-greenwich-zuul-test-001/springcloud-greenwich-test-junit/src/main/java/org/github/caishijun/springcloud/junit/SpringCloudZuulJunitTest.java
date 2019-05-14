package org.github.caishijun.springcloud.junit;

import org.github.caishijun.springcloud.http.HttpClientUtils;
import org.junit.Test;

public class SpringCloudZuulJunitTest {

    private static String HOST = "localhost";
    private static int PORT = 8104;

    private static int FOR_TIMES = 1;
    private static int SLEEP_TIME = 0;

    public static String getUrl(String uri, String host, int port) {
        return "http://" + host + ":" + port + uri;
    }

    @Test
    public void zuulCloud_provider() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            String result = HttpClientUtils.sendGetRequest(getUrl("/producer/hello?name=dasdfsadfd", HOST, PORT));
            System.out.println("result ： " + result);
            Thread.sleep(SLEEP_TIME);
        }
    }

    @Test
    public void zuulCloud_consumer_provider() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            String result = HttpClientUtils.sendGetRequest(getUrl("/consumer/feignClient/feignClient-dafsdfasdfas", HOST, PORT));
            System.out.println("result ： " + result);
            Thread.sleep(SLEEP_TIME);
        }
    }
}