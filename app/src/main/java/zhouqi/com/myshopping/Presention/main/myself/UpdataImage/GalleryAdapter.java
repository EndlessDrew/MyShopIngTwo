package zhouqi.com.myshopping.Presention.main.myself.UpdataImage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import zhouqi.com.myshopping.R;

/**
 * Created by z on 2016/11/30.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    private ArrayList<String> mDatas = new ArrayList<>();
    public  void setmDatas(ArrayList<String >mDatas){
        this.mDatas = mDatas;
    }
    public GalleryAdapter(Context context) {
        mInflater =LayoutInflater.from(context);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycle_hor_picture,null);
        ViewHolder holder = new ViewHolder(view);
        holder.imageView= (ImageView)view.findViewById(R.id.id_index_gallery_item_image);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        if(i==0){
            viewHolder.imageView.setImageResource(R.drawable.hello);
            if (onItemClickListener != null) {
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(viewHolder.itemView, i);
                    }
                });
            }

        }else {
            ImageLoader.getInstance().displayImage("file:///" + mDatas.get(i), viewHolder.imageView);
            if (onItemClickListener != null) {
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(viewHolder.itemView, i);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public  static  class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


    /**
     * 给RecycleView 写回调接口
     */
    private OnItemClickListener onItemClickListener;
    public interface  OnItemClickListener{
        void onItemClick(View view ,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

}
