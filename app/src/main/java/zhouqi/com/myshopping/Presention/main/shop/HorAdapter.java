package zhouqi.com.myshopping.Presention.main.shop;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import zhouqi.com.myshopping.Model.enity.GoodsSubTitle;
import zhouqi.com.myshopping.R;

/**
 * 水平title的适配器
 * Created by Drew on 2016/11/17.
 */
public class HorAdapter extends BaseAdapter {
    ArrayList<GoodsSubTitle>list;
    Context context;
    int index;

    public HorAdapter(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<GoodsSubTitle>list){
       this.list = list;
    }

    public void  setPosition( int position){
        index = position;
    }
    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView =  inflater.inflate(R.layout.hor_item,null);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_item_Subtitle);
        textView.setText(list.get(position).getSubtitle());
        if(index ==position){
            textView.setTextColor(Color.RED);
        }
        return convertView;
    }
}
