package zhouqi.com.myshopping.Presention.main.myself.UpdataImage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.utils.L;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import zhouqi.com.myshopping.R;

/**
 * Created by z on 2016/11/30.
 */
public class GridViewAdapter  extends BaseAdapter{
    ArrayList<String> listpath = new ArrayList<>();
    Context context;
    private  ArrayList<Boolean>boolist;
    private  ArrayList<String>listselected  = new ArrayList<>();

    public  void setBoolist(ArrayList<Boolean>boolist){
        this.boolist = boolist;
    }
    public GridViewAdapter(Context context) {
        this.context = context;
    }

    public  void setListpath(ArrayList<String>listpath){
        this.listpath = listpath;
    }
    @Override
    public int getCount() {
        return listpath.size();
    }

    @Override
    public Object getItem(int position) {
        return listpath.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = null;
        if (convertView==null){
            convertView = inflater.inflate(R.layout.gridview_item, null);
            holder= new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_item_gridview);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb_update_picture);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    boolist.set(position,isChecked);
                }else{
                    boolist.set(position,false);
                }


            }
        });
        if(boolist.get(position)){
            holder.checkBox.setChecked(true);
        }else{
            holder.checkBox.setChecked(false);
        }
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolist.get(position)){
                    if(listselected.size()<=8){
                        listselected.add(listpath.get(position-1));
                    }
                }else{
                    listselected.remove(listpath.get(position-1));
                }
                if(listselected.size()>0){
                    listData.setLiData(listselected);
                }

            }
        });

        if(position==0){
            holder.checkBox.setVisibility(View.GONE);
            holder.imageView.setImageResource(R.drawable.photo);
        }else {
            ImageLoader.getInstance().displayImage("file:///" + listpath.get(position-1), holder.imageView);

        }
        return convertView;
    }



    private    ListData listData;
    public  void setListData(ListData listData){
        this.listData = listData;
    }
    public interface  ListData{
        void setLiData(ArrayList<String>listData);

    }
    class  ViewHolder{
        public ImageView imageView ;
        public CheckBox checkBox ;
    }
}
