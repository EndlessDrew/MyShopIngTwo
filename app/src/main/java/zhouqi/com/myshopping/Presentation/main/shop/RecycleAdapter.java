package zhouqi.com.myshopping.Presentation.main.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.List;
import zhouqi.com.myshopping.Commonutils.ImageLoadOptions;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;
import zhouqi.com.myshopping.Network.ShopApi;
import zhouqi.com.myshopping.R;

/**
 * RecycleView的适配器，所有商品展示
 * Created by Drew on 2016/11/16.
 */
public class RecycleAdapter extends RecyclerView.Adapter <RecycleAdapter.MyViewHolder>{
    ArrayList<GoodsDatas.DatasBean>list = new ArrayList<GoodsDatas.DatasBean>();
    Context context;
    private OnItemClickListener listener;

    public void addData(List<GoodsDatas.DatasBean>data){
        list.addAll(data);
        notifyDataSetChanged();

    }
    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context =viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_item,null);
        MyViewHolder holder =new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.name.setText(list.get(i).getName());
        ImageLoader.getInstance().displayImage(ShopApi.IMAGE_URL+list.get(i).getPage(),myViewHolder.imageView, ImageLoadOptions.build_item());
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onPhotoClicked(list.get(i));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView ;
        TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_item_pic);
            name = (TextView) itemView.findViewById(R.id.iv_item_name);
        }
    }

    public  void setListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onPhotoClicked(GoodsDatas.DatasBean datasBean);
    }
}
