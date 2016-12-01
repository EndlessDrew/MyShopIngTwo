package zhouqi.com.myshopping;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhouqi.com.myshopping.Presention.main.contacts.Fragment_Contacts;
import zhouqi.com.myshopping.Presention.main.message.Fragment_Message;
import zhouqi.com.myshopping.Presention.main.myself.Fragment_Myself;
import zhouqi.com.myshopping.Presention.main.shop.Fragment_Shop;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.vp_advertisement)
     ViewPager vp;
    @Bind({R.id.tv_supermarket,R.id.tv_message,R.id.tv_contacts,R.id.tv_myself})
    TextView []tv ;
    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.toolbar)
     Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    /**
     * 设置标题
     */
    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        initView();
    }


    private void initView(){
        tv[0].setSelected(true);
        tv[0].setTextColor(getResources().getColor(R.color.white));
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (TextView textview:tv) {
                    textview.setSelected(false);
                    textview.setTextColor(getResources().getColor(R.color.black));
                }
                tv_title.setText(tv[position].getText());
                tv[position].setSelected(true);
                tv[position].setTextColor(getResources().getColor(R.color.white));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        vp.setAdapter(adapter);
    }


    @OnClick({R.id.tv_supermarket,R.id.tv_message,R.id.tv_contacts,R.id.tv_myself})
    public void onClick(View view){
        for (int i = 0 ; i<tv.length;i++){
            tv[i].setSelected(false);
            tv[i].setTextColor(getResources().getColor(R.color.black));
            tv[i].setTag(i);
        }
        view.setSelected(true);
        ((TextView) view).setTextColor(getResources().getColor(R.color.white));
        vp.setCurrentItem((Integer)view.getTag(),false);
        tv_title.setText(tv[(Integer)view.getTag()].getText());
    }


    /**
     * ViewPager 适配器
     */
    public FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){
                case 0:
                    return  new Fragment_Shop();
                case 1:
                    return  new Fragment_Message();
                case 2:
                    return  new Fragment_Contacts();
                case 3:
                    return  new Fragment_Myself();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tv.length;
        }
    };
}
