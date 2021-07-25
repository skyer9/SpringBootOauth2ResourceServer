package com.example.oauth2resourceserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    // key-uri: http://auth.localhost:9000/oauth/token_key
    // 위 설정으로 인해, JWT 토큰인것과, 암호화방식, 그리고 공개키까지 제공됩니다.
    // 따라서, 추가설정 없이 암호화 JWT 토큰을 이용할 수 있습니다.

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/api/userinfo").access("#oauth2.hasScope('profile')")
                .anyRequest().authenticated();
    }
}
