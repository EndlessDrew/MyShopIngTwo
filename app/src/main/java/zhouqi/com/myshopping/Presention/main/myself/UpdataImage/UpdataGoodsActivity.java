package zhouqi.com.myshopping.Presention.main.myself.UpdataImage;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import zhouqi.com.myshopping.R;

public class UpdataGoodsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GalleryAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_goods);
        toolbar = (Toolbar) findViewById(R.id.Update_toolbar);
        setToolbar();
        initView();
        EventBus.getDefault().register(this);
    }


    private  void setToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("更新商品");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    /**
     * 设置返回按键
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }


    /**
     * 所有的图片列表
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getListDatas(ArrayList<String>list){
        adapter.setmDatas(list);
        adapter.notifyDataSetChanged();
    }

    private void  initView(){
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<String>path =  CheckImage.getImage(this);
        adapter = new GalleryAdapter(this);
        adapter.setmDatas(path);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(UpdataGoodsActivity.this,"自定义事件",Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        startActivity(new Intent(UpdataGoodsActivity.this,ShowImageActivity.class));
                        break;
                    case 1:
                        break;
                    case 2:
                        break;

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
