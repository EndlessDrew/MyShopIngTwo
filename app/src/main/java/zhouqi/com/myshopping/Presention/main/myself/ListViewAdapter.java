package zhouqi.com.myshopping.Presention.main.myself;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import zhouqi.com.myshopping.Commonutils.ImageLoadOptions;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;
import zhouqi.com.myshopping.Network.ShopApi;
import zhouqi.com.myshopping.Network.ShopClient;
import zhouqi.com.myshopping.R;

/**
 * 我的商品展示适配器  包含删除  全选商品取消商品 等
 * Created by Drew on 2016/11/29.
 */
public class ListViewAdapter extends BaseAdapter  {
    ArrayList<GoodsDatas.DatasBean>list = new ArrayList<>();
    ArrayList<Boolean>boolist = new ArrayList<>();
    Context context;
    private    boolean gone=true;
    private  int index ;

    public ListViewAdapter(ArrayList<GoodsDatas.DatasBean> list, ArrayList<Boolean>boolist, Context context) {
        this.list = list;
        this.context = context;
        this.boolist = boolist;
    }
    public void setIndex(int index){
        this.index = index;

    }
    public void setGONE(boolean gone){
        this.gone = gone;
    }

    public boolean  getGone(){
        return  gone;
    }

    @Override
    public int getCount() {
        return list.size() ;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder =null;
        if(convertView==null){
            convertView=  inflater.inflate(R.layout.item_list,null);
            viewHolder = new ViewHolder();
            viewHolder.nickname  = (TextView) convertView.findViewById(R.id.tv_person_item_nickname);
            viewHolder.username  = (TextView) convertView.findViewById(R.id.tv_person_item_username);
            viewHolder.descripe  = (TextView) convertView.findViewById(R.id.tv_person_item_descripe);
            viewHolder.price= (TextView) convertView.findViewById(R.id.tv_person_item_price);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_person_goods_pic);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (gone) {
            viewHolder.checkBox.setVisibility(View.GONE);
        }else{
            viewHolder.checkBox.setVisibility(View.VISIBLE);
            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        boolist.set(position,isChecked);
                    }else{
                        boolist.set(position,false);
                    }
                }

            });
            if(boolist.get(position)){
                    viewHolder.checkBox.setChecked(true);
                }else{
                    viewHolder.checkBox.setChecked(false);
                }
        }
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolist.get(position)){
                    index ++;
                    Log.i("aaa",index+"");
                }else{
                    if(index==0){
                        return;
                    }else{
                        index--;
                    }
                }
                updateData.ChangeData(index);

            }
        });

        viewHolder.nickname.setText("商品名称："+list.get(position).getName());
        viewHolder.username.setText("用户名："+list.get(position).getMaster());
        viewHolder.descripe.setText("描述："+list.get(position).getDescription());
        viewHolder.price.setText("￥ ："+list.get(position).getPrice());
        ImageLoader.getInstance().displayImage(ShopApi.IMAGE_URL+list.get(position).getPage(),viewHolder.imageView, ImageLoadOptions.build_item());
        return convertView;
    }

    class  ViewHolder {
        public TextView nickname,username,descripe,price;
        public CheckBox checkBox;
        public ImageView imageView;
    }
    private  UpdateData updateData;
    public void setUpdateData(UpdateData updateData){
        this.updateData=updateData;
    }
    public interface  UpdateData{
        void ChangeData(int index);
    }
}
