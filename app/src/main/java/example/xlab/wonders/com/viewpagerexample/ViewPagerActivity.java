package example.xlab.wonders.com.viewpagerexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ViewPagerActivity extends Activity {

    private ViewPager pager = null;
    private PagerTabStrip tabStrip = null;
    private ArrayList<View> viewContainter = new ArrayList<>();
    private ArrayList<String> titleContainter = new ArrayList<>();
    private RecyclerView mrecyclerView;
    private RecyclerAdapter recyclerAdapter;
    private View[] mImageViews;
    private int[] imgIdArray;
    public String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        pager = (ViewPager) findViewById(R.id.viewpager);
        tabStrip = (PagerTabStrip) findViewById(R.id.tabstrip);

        tabStrip.setDrawFullUnderline(false);
        tabStrip.setBackgroundColor(this.getResources().getColor(R.color.bg));

        tabStrip.setTabIndicatorColor(this.getResources().getColor(R.color.red));
        tabStrip.setTextSpacing(200);

        recyclerAdapter = new RecyclerAdapter();

        mrecyclerView = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.my_recycleview,null);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mrecyclerView.setAdapter(recyclerAdapter);

        //载入图片资源ID
        imgIdArray = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10, R.drawable.img11};

        initData();

        //LayoutInflater作用是将layout的xml布局文件实例化为View类对象
        View view1 = LayoutInflater.from(this).inflate(R.layout.item_view, null);

        View view2 = LayoutInflater.from(this).inflate(R.layout.item_view, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.item_view, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.item_view, null);

        viewContainter.add(mrecyclerView);
        viewContainter.add(view2);
        viewContainter.add(view3);
        viewContainter.add(view4);

        titleContainter.add("全部课程");
        titleContainter.add("职场养成");
        titleContainter.add("文青必备");
        titleContainter.add("码龙专区");


        pager.setAdapter(new PagerAdapter() {

            //viewpager 中的组件数量
            @Override
            public int getCount() {
                return viewContainter.size();
            }

            //滑动切换的时候销毁当前的组件
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager) container).removeView(viewContainter.get(position));
            }

            //每次滑动的时候生成的组件
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager) container).addView(viewContainter.get(position));
                return viewContainter.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleContainter.get(position);
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d(TAG, "-------scrolled position:" + position);
                Log.d(TAG, "-------scrolled positionOffset:" + positionOffset);
                Log.d(TAG, "-------scrolled positionOffsetPixels:" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "------selected:" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(TAG, "--------changed:" + state);
            }
        });

    }

    /**
     * 初始化数据
     */
    protected void initData() {
//将图片装载到数组中
        mImageViews = new View[imgIdArray.length];
        for (int i = 0; i < mImageViews.length; i++) {
            View itemView = getLayoutInflater().inflate(R.layout.item_view, null, false);

            ImageView image = (ImageView) itemView.findViewById(R.id.image);

            TextView text = (TextView) itemView.findViewById(R.id.text);

            TextView intro = (TextView) itemView.findViewById(R.id.image_intro);

            image.setImageResource(imgIdArray[i]);

//            text.getPaint().setTextSkewX(-0.25f);

            intro.getPaint().setStrikeThruText(true);

            intro.setText("41,9 yyy");

            mImageViews[i] = itemView;
        }
    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(ViewPagerActivity.this).inflate(R.layout.item_view, null, false));

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder viewHolder, int i) {
            viewHolder.imageView.setImageResource(imgIdArray[i]);
        }

        @Override
        public int getItemCount() {
            return imgIdArray.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public MyViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.image);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_pager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
