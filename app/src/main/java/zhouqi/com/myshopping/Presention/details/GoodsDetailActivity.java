package zhouqi.com.myshopping.Presention.details;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;
import zhouqi.com.myshopping.Commonutils.ImageLoadOptions;
import zhouqi.com.myshopping.Commonutils.ProgressDialogFragment;
import zhouqi.com.myshopping.Model.enity.GoodsDetailEntity;
import zhouqi.com.myshopping.Model.enity.UserEntity;
import zhouqi.com.myshopping.Network.ShopApi;
import zhouqi.com.myshopping.R;

public class GoodsDetailActivity extends AppCompatActivity  implements GoodsDetailView{

    private static final String UUID = "uuid";
    /**
     * 此状态如果是从我的页面进来为1,0为默认值,也就是从goods进来
     */
    private static final String STATE = "state";

    private String str_uuid;
    private ProgressDialogFragment dialogFragment;
    private GoodsDetailPresenter presenter;
    /*用来存放图片uri的list*/
    private ArrayList<String> list_uri;
    private ArrayList<ImageView> list;
    private GoodsDetailAdapter adapter;


    @Bind(R.id.toolbar_goods_detail_title)
    Toolbar toolbar;
    @Bind(R.id.vp_photos)
    ViewPager viewPager;
    /*使用开源库CircleIndicator来实现ViewPager的圆点指示器。*/
    @Bind(R.id.indicator)
    CircleIndicator indicator;
    @Bind(R.id.tv_detail_name)
    TextView tv_detail_name;
    @Bind(R.id.tv_detail_price)
    TextView tv_detail_price;
    @Bind(R.id.tv_detail_master)
    TextView tv_detail_master;
    @Bind(R.id.tv_detail_describe)
    TextView tv_detail_describe;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
    }
    @Override
    public void onContentChanged() {
        super.onContentChanged();
        presenter = new GoodsDetailPresenter();
        presenter.onCreate();
        presenter.attachView(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar_goods_detail_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list = new ArrayList<>();
        adapter = new GoodsDetailAdapter(list);
        viewPager = (ViewPager) findViewById(R.id.vp_photos);
        viewPager.setAdapter(adapter);
        init();
    }

    private void init(){
        Intent intent =getIntent();
        str_uuid = intent.getStringExtra(UUID);
        Log.i("Drew",str_uuid);
        presenter.getData(str_uuid);
        adapter.setListener(new GoodsDetailAdapter.OnItemClickListener() {
            @Override
            public void onItemClick() {
                Toast.makeText(GoodsDetailActivity.this,"点击图片",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {
        if(dialogFragment == null){
            dialogFragment = new ProgressDialogFragment();
        }
        if (dialogFragment.isVisible()) return;
        dialogFragment.show(getSupportFragmentManager(),ProgressDialogFragment.class.getName());
    }

    @Override
    public void hideProgress() {
        dialogFragment.dismiss();
    }

    /*将图片路径转化为一个ImageView*/
    private void getImage(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(this);
            ImageLoader.getInstance()
                    .displayImage(ShopApi.IMAGE_URL + list.get(i),
                            imageView, ImageLoadOptions.build_item());
            this.list.add(imageView);
        }
    }

    @Override
    public void setImageData(ArrayList<String> viewList) {
        list_uri = viewList;
        getImage(viewList);
        adapter.notifyDataSetChanged();
        indicator.setViewPager(viewPager);
    }

    @Override
    public void setData(GoodsDetailEntity data, UserEntity goods_userEntity) {
        tv_detail_name.setText(data.getName());
        tv_detail_price.setText(getString(R.string.goods_money, data.getPrice()));
        tv_detail_master.setText(getString(R.string.goods_detail_master, goods_userEntity.getNick_Name()));
        tv_detail_describe.setText(data.getDescription());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}




