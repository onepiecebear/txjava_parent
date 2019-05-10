package cn.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @Author: yushibo
 * @Date: 2019/5/9 16:22
 * @Description:
 */
@SpringBootApplication
@EnableZipkinServer
//@Enable
public class SleuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class,args);
        }
}
