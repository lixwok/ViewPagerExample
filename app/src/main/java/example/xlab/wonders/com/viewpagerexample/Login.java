package example.xlab.wonders.com.viewpagerexample;

import android.content.Context;

import org.json.JSONObject;

/**
 * Created by lixuanwu on 15/8/18.
 */
public class Login {

    public static void Login(Context context) throws Exception {

        new ViewPagerImageActivity.TestTask(context).execute();

    }

    public interface LoginCallback {

        void login(JSONObject jsonObject);
    }
}
