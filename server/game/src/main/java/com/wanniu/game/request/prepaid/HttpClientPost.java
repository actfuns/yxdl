package com.wanniu.game.request.prepaid;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


public class HttpClientPost {
    public static boolean doPost(String url, String userId, String userCode, int gameType, Double money) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();


        StringBuffer params = new StringBuffer();

        try {
            params.append("userId=" + userId);
            params.append("&");
            params.append("userCode=" + userCode);
            params.append("&");
            params.append("gameType=" + gameType);
            params.append("&");
            params.append("money=" + money);
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        HttpPost httpPost = new HttpPost(url + "?" + params);


        httpPost.setHeader("Content-Type", "application/json;charset=utf8");


        CloseableHttpResponse response = null;
        String msg = null;

        try {
            response = httpClient.execute((HttpUriRequest) httpPost);

            HttpEntity responseEntity = response.getEntity();

            String s = EntityUtils.toString(responseEntity);
            Gson gson = new Gson();
            Map map = (Map) gson.fromJson(s, Map.class);
            msg = (String) map.get("msg");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return msg.equalsIgnoreCase("成功");
    }
}


