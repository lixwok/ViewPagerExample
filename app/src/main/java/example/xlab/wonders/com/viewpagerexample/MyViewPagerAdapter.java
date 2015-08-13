package example.xlab.wonders.com.viewpagerexample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lixuanwu on 15/8/13.
 */
public class MyViewPagerAdapter extends PagerAdapter {

    private List<String> names;

    public MyViewPagerAdapter(List<String> names) {
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);

    }
}
