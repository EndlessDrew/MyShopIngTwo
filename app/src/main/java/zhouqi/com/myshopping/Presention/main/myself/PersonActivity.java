package zhouqi.com.myshopping.Presention.main.myself;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;

import zhouqi.com.myshopping.Commonutils.SharedpreferceData;
import zhouqi.com.myshopping.MainActivity;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;
import zhouqi.com.myshopping.Presention.main.myself.UpdataImage.PersonGoodsPresenter;
import zhouqi.com.myshopping.Presention.main.myself.UpdataImage.PersonGoodsView;
import zhouqi.com.myshopping.R;

/**
 *
 */
public class PersonActivity extends AppCompatActivity implements View.OnClickListener ,ListViewAdapter.UpdateData,PersonGoodsView {

    private Toolbar toolbar;
    private ImageView more;
    private PopupWindow pp;
    private View view;
    private ImageView all;
    private ImageView electron;
    private ImageView dress;
    private ImageView toys;
    private ImageView book;
    private ImageView gift;
    private ImageView other;
    private ImageView houseHold;
    private LinearLayout ll;
    private ListView listView;
    private Button all_select;
    private Button delete;
    private ArrayList<GoodsDatas.DatasBean> list;
    private ArrayList<Boolean> boolist;
    private ListViewAdapter listViewAdapter;
    private TextView tv_cancel;
    private PopupWindow popupWindow;
    private  PersonGoodsPresenter personGoodsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        toolbar = (Toolbar) findViewById(R.id.toolbar_person_title);
        personGoodsPresenter = new PersonGoodsPresenter();
        personGoodsPresenter.onCreate();
        personGoodsPresenter.attachView(this);
        //默认加载全部
        personGoodsPresenter.getAllGoods(1,"");
        setToolbar();
        setPopupWindow();
        initView();
        setListView();
        setItemList();
        setDeleteData();
    }
    private void setToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("我的商品");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    private void initView(){
        more = (ImageView) findViewById(R.id.iv_person_more);
        more.setOnClickListener(this);
        ll = (LinearLayout) findViewById(R.id.ll_person_goods);
        Button exit = (Button) findViewById(R.id.bt_exit);
        exit.setOnClickListener(this);
        all_select = (Button) findViewById(R.id.bt_select_all);
        all_select.setOnClickListener(this);
        delete = (Button)findViewById(R.id.bt_delete);
        delete.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.lv_per_goods);
        tv_cancel = (TextView) findViewById(R.id.tv_person_cancel);
        tv_cancel.setOnClickListener(this);
    }

    /**
     * 设置商品数据
     */
    private void setListView(){

    }

    /**
     * 全选
     */
    private void AllSelect() {
        if (!listViewAdapter.getGone()){
            for (int i = 0; i <boolist.size() ; i++) {
                boolist.set(i,true);
            }
            listViewAdapter.notifyDataSetChanged();
            delete.setText("删除（"+boolist.size()+")");
        }
    }

    /**
     * 取消操作
     *
     */
    private  void Cancel(){
        for (int i = 0; i <boolist.size() ; i++) {
            boolist.set(i,false);
        }
        listViewAdapter.notifyDataSetChanged();

    }

    /**
     * 点击删除商品
     */

    private void deleteGoods() {
        for (int i = 0; i <boolist.size() ; i++) {
            if (boolist.get(i)) {
                boolist.remove(i);
                list.remove(i);
                i--;
            }
        }
        listViewAdapter.notifyDataSetChanged();
    }

    private void setDeleteData(){



    }

    private void setItemList(){
        /**
         * 点击事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PersonActivity.this,"点击了",Toast.LENGTH_SHORT).show();

            }
        });
        /**
         * 长按事件
         */
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PersonActivity.this,"长按",Toast.LENGTH_SHORT).show();
                more.setVisibility(View.GONE);
                tv_cancel.setVisibility(View.VISIBLE);
                listViewAdapter.setGONE(false);
                listViewAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    /**
     * 获取拍照的popupWindow
     */
    private void  setPopupWindow(){
        view = getLayoutInflater().inflate(R.layout.person_popupwindow,null);
        all = (ImageView) view.findViewById(R.id.iv_pop_all);
        all.setOnClickListener(this);
        electron = (ImageView) view.findViewById(R.id.iv_pop_electron);
        electron.setOnClickListener(this);
        dress = (ImageView) view.findViewById(R.id.iv_pop_dress);
        dress.setOnClickListener(this);
        toys = (ImageView) view.findViewById(R.id.iv_pop_toys);
        toys.setOnClickListener(this);
        book = (ImageView) view.findViewById(R.id.iv_pop_book);
        book.setOnClickListener(this);
        gift = (ImageView) view.findViewById(R.id.iv_pop_gift);
        gift.setOnClickListener(this);
        other = (ImageView) view.findViewById(R.id.iv_pop_other);
        other.setOnClickListener(this);
        houseHold = (ImageView) view.findViewById(R.id.iv_pop_household);
        houseHold.setOnClickListener(this);
        pp = new PopupWindow(this);
        pp.setContentView(view);
        pp.setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pp.setFocusable(true);
        pp.setTouchable(true);
        pp.setOutsideTouchable(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.iv_person_more:
                if (pp != null && pp.isShowing()) {
                    pp.dismiss();
                } else {
                    pp.showAsDropDown(ll);
                }
                break;
            case R.id.iv_pop_all:
                personGoodsPresenter.getAllGoods(1,"");
                break;
            case R.id.iv_pop_electron:
                personGoodsPresenter.getAllGoods(1,"electron");
                break;
            case R.id.iv_pop_dress:
                personGoodsPresenter.getAllGoods(1,"dress");
                break;
            case R.id.iv_pop_toys:
                personGoodsPresenter.getAllGoods(1,"toys");
                break;
            case R.id.iv_pop_book:
                personGoodsPresenter.getAllGoods(1,"book");
                break;
            case R.id.iv_pop_gift:
                personGoodsPresenter.getAllGoods(1,"gift");
                break;
            case R.id.iv_pop_other:
                personGoodsPresenter.getAllGoods(1,"other");
                break;
            case R.id.iv_pop_household:
                personGoodsPresenter.getAllGoods(1,"household");
                break;
            case  R.id.bt_exit:
                SharedPreferences sp = getSharedPreferences(SharedpreferceData.sharedName,MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean(SharedpreferceData.STATE,false).commit();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.bt_select_all:
                AllSelect();
                break;
            case R.id.bt_delete:
                deleteGoods();
                tv_cancel.setVisibility(View.GONE);
                more.setVisibility(View.VISIBLE);
                listViewAdapter.setGONE(true);
                listViewAdapter.notifyDataSetChanged();
                delete.setText("删除（"+0+")");
                listViewAdapter.setIndex(0);

                break;
            case R.id.tv_person_cancel:
                Cancel();
                tv_cancel.setVisibility(View.GONE);
                more.setVisibility(View.VISIBLE);
                delete.setText("删除（"+0+")");
                listViewAdapter.setIndex(0);


        }
    }

    @Override
    public void ChangeData(int index) {
        delete.setText("删除（"+index+")");
    }

    @Override
    public void getAllDatas(ArrayList<GoodsDatas.DatasBean> lists) {
        list =lists;
        boolist = new ArrayList<>();
        for (int i = 0; i <lists.size() ; i++) {
            boolist.add(i,false);
        }
        listViewAdapter = new ListViewAdapter(list, boolist, this);
        listViewAdapter.setUpdateData(this);
        listViewAdapter.setGONE(true);
        listView.setAdapter(listViewAdapter);

    }
}
