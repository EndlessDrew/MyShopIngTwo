package zhouqi.com.myshopping.Presention.main.myself.UpdataImage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import zhouqi.com.myshopping.R;

/**
 * Created by z on 2016/11/30.
 */
public class PictureSelectAdapter extends  RecyclerView.Adapter<PictureSelectAdapter.ViewHolder>{

    private LayoutInflater mInflater;
    private ArrayList<String>list;


    public PictureSelectAdapter(Context context,ArrayList<String>list) {
        mInflater =LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_pitcture_selecter,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.imageView = (ImageView) view.findViewById(R.id.iv_item_pic_selected);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ImageLoader.getInstance().displayImage("file:///"+list.get(i),viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
