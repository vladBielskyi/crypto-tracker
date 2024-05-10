package ua.bielskyi.tracker.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .callTimeout(10, TimeUnit.SECONDS)
                .build();
    }
}
