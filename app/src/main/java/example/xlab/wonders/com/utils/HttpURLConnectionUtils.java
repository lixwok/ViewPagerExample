package example.xlab.wonders.com.utils;

import android.util.Log;

import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lixuanwu on 15/8/17.
 */
public class HttpURLConnectionUtils {

    public static JSONObject requestByGet(String requestUrl){

        JSONObject jsonObject = null;
        try {
            final URL url = new URL(requestUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //设置连接超时时间
            urlConnection.setConnectTimeout(5 * 1000);
            urlConnection.connect();

            StringBuilder builder = new StringBuilder();
            if (urlConnection.getResponseCode() == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                    builder.append(s);
                }
                Log.d("cat", ">>>>>>" + builder.toString());
                jsonObject = new JSONObject(builder.toString());

            } else {
                Log.d("Tag", "请求失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
