package com.wanniu.game.downjoy;

import com.wanniu.core.logfs.Out;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpClientUtil {
    public static final String DEFAULT_URL_CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String JSON_CONTENT_TYPE = "application/json";
    public static final int CONNECT_TIME_OUT = 5000;
    public static final String DEFAULT_CHARSET = "UTF-8";

    public static String doPost(String postURL, String requestBody) throws Exception {
        return doPost(postURL, requestBody, "application/x-www-form-urlencoded");
    }

    public static String doPost(String postURL, String requestBody, String contentType) throws Exception {
        Out.info(new Object[]{"HTTP POST URL=", postURL, ", requestBody=", requestBody});

        HttpURLConnection httpConn = null;

        try {
            URL postUrl = new URL(postURL);

            httpConn = (HttpURLConnection) postUrl.openConnection();


            httpConn.setDoOutput(true);

            httpConn.setDoInput(true);

            httpConn.setRequestMethod("POST");

            httpConn.setUseCaches(false);

            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestProperty("Content-Type", contentType + "; charset=UTF-8;");

            byte[] bytes = requestBody.getBytes("UTF-8");
            httpConn.setRequestProperty("Content-Length", String.valueOf(bytes.length));


            httpConn.setConnectTimeout(5000);

            httpConn.setReadTimeout(5000);


            httpConn.connect();
            DataOutputStream out = new DataOutputStream(httpConn.getOutputStream());
            out.write(bytes);
            out.flush();
            out.close();
            int status = httpConn.getResponseCode();
            if (status != 200) {
                System.out.println("发送请求失败，状态码：[" + status + "] 返回信息：" + httpConn.getResponseMessage());
                return null;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            StringBuffer responseSb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                responseSb.append(line.trim());
            }
            reader.close();
            return responseSb.toString().trim();
        } finally {
            httpConn.disconnect();
        }
    }
}


