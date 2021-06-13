package com.tanjiaming99.community.provider;


import com.alibaba.fastjson.JSON;
import com.tanjiaming99.community.dto.AccessTokenDTO;
import com.tanjiaming99.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @Author tanjiaming99.com
 * @Date 2021/6/10 19:25
 **/
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = okhttp3.MediaType.get("application/json; charset=utf-8");
        String url = "https://github.com/login/oauth/access_token";
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str = response.body().string();
            String token = str.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        System.out.println(accessToken);
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                // 这是官网更新了，而且这种API方法也好像过时了
                .header("Authorization", "token " + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(string);
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
