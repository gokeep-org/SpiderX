package com.spiderx;

import com.spiderx.config.ApplicationConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Bootstracp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Bootstracp.class)
                .bannerMode(Banner.Mode.OFF)
                .web(ApplicationConfig.ENABLE_WEB)
                .run(args);
    }
}
