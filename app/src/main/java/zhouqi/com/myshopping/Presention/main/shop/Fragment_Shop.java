package zhouqi.com.myshopping.Presention.main.shop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;
import zhouqi.com.myshopping.Model.enity.GoodsSubTitle;
import zhouqi.com.myshopping.Presention.details.GoodsDetailActivity;
import zhouqi.com.myshopping.R;

/**
 * Created by Drew on 2016/11/16.
 */
public class Fragment_Shop extends Fragment  implements  GoodsView{

    private View view;
    @Bind(R.id.shop_recycleView)
    RecyclerView recyclerView;
    @Bind(R.id.Pcf)
    PtrClassicFrameLayout ptrLayout;
    @Bind(R.id.horListView)
    HorizontalListView horizontalListView;
    private  GoodsPresenter presenter;
    private ViewMyAdapter adapter;
    private  HorAdapter horAdapter;
    //默认子标题  显示商品类型
    private String title;
    //轮播图
    private int  [] imageViews = {R.drawable.logo1,R.drawable.logo2,R.drawable.logo3};
    //图片列表
    private ArrayList<ImageView>imageViewsList = new ArrayList<>();
    //handler发消息机制
    private Handler handler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //默认加载全部
        title  = "";
        horAdapter =new HorAdapter(getActivity());
        presenter = new GoodsPresenter();
        presenter.onCreate();
        adapter = new ViewMyAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop,container,false);
        ButterKnife.bind(this,view);
        presenter.attachView(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        SubTitle();
        ClickJoin();
        setPlay();
    }

    @Override
    public void onStart() {
        super.onStart();
        /**
         * 当前页面没有数据时候。刷新
         *
         */
        if(adapter.getItemCount() ==1){
            ptrLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ptrLayout.autoRefresh();
                }
            },200);

        }
    }

    /**
     * 广告轮播条
     */

    public  void setPlay(){
        for (int i =0;i<imageViews.length;i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageViews[i]);
            imageViewsList.add(imageView);
        }
        adapter.setAdData(imageViewsList);
        handler  = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int index = adapter.getViewPager().getCurrentItem();
                if(index<imageViews.length-1){
                    index++;
                }else{
                    index =0;
                }
                adapter.getViewPager().setCurrentItem(index,false);
                handler.sendEmptyMessageDelayed(0,4000);
            }
        };
        handler.sendEmptyMessageDelayed(0,4000);
    }
    /**
     * RecycleView 和PtrClassicFrameLayout的初始化
     */
    private void initView() {
        //设置recycleView的manager
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                if(i==0){
                    return 2;
                }else{
                return 1;
                }
            }
        });
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        //设置refreshLayout
        //使用本对象最为key，来记录上一次的刷新时间，如果两次刷新时间太近就不会触发刷新方法
        ptrLayout.setLastUpdateTimeRelateObject(this);
        ptrLayout.setDurationToCloseHeader(1500);
        ptrLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                //加载更多
                ptrLayout.refreshComplete();
            }
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                presenter.refreshData(1,title);
            }
        });
    }

    /**
     * 设置标题
     */
    private  void SubTitle(){
        GoodsSubTitle goodsSubTitle = new GoodsSubTitle();
        final ArrayList<GoodsSubTitle>list = goodsSubTitle.getSubList();
        horAdapter.setList(list);
        horizontalListView.setAdapter(horAdapter);
        horizontalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title = list.get(position).getSubtitleEnglish();
                horAdapter.setPosition(position);
                horAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), title,Toast.LENGTH_SHORT).show();
                presenter.refreshData(1, title);
            }
        });
    }

    /**
     * 跳转页面
     */
    private  void  ClickJoin(){
        /**
         * 点击图片跳转页面
         */
        adapter.setListener(new ViewMyAdapter.OnItemClickListener() {
            @Override
            public void onPhotoClicked(GoodsDatas.DatasBean datasBean) {
                Intent intent = new Intent(getActivity(),GoodsDetailActivity.class);
                intent.putExtra("uuid",datasBean.getUuid());

                startActivity(intent);
            }
        });
        /**
         * 点击类型图片刷新界面
         */

        adapter.setOnclick(new ViewMyAdapter.onClciks() {
            @Override
            public void onTitlePhoto(int i, String title) {
                presenter.refreshData(1,title);
            }
        });

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
    @Override
    public void hideRefresh() {
        ptrLayout.refreshComplete();

    }

    /**
     * 获取数据
     * @param data
     */
    @Override
    public void addRefreshData(ArrayList<GoodsDatas.DatasBean> data) {
            adapter.clearData();
            adapter.addData( data);
            adapter.notifyDataSetChanged();
    }
}
