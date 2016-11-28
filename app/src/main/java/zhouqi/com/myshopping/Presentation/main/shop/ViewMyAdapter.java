package zhouqi.com.myshopping.Presentation.main.shop;

import android.content.Context;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import zhouqi.com.myshopping.Commonutils.ImageLoadOptions;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;
import zhouqi.com.myshopping.Model.enity.GoodsSubTitle;
import zhouqi.com.myshopping.Network.ShopApi;
import zhouqi.com.myshopping.R;

/**
 * Created by z on 2016/11/22.
 */
public class ViewMyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private OnItemClickListener listener;
    private onClciks clciks;
    private Context context;
    private ArrayList<GoodsDatas.DatasBean> data = new ArrayList<>();
    private ArrayList<ImageView> adData = new ArrayList<>();
    private ViewPager viewPager;
    private AdAdapter adAdapter = new AdAdapter();
    /**
     *设置广告的数据
     */
    public void setAdData(ArrayList<ImageView>adData){
        this.adData = adData;
    }
    /**
     * 设置数据
     */
    public void addData(ArrayList<GoodsDatas.DatasBean>list){
//        this.data=list;
        data.addAll(list);
    }
    /**
     * 清空数据
     */
    public  void  clearData(){
        data.clear();
    }
    /**
     * 返回ViewPager
     */
    public ViewPager getViewPager(){
        return  viewPager;
    }
    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 1;
        }
        if(position==1){
            return 2;
        }
        return 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        context  = viewGroup.getContext();
        if(viewType ==1){
            View view =LayoutInflater.from(context).inflate(R.layout.viewpager_item,null);
            return  new AdViewHolder(view);
        }
            View view = LayoutInflater.from(context).inflate(R.layout.recycle_item,null);
            return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if(viewHolder instanceof MyViewHolder){
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            myViewHolder.name.setText(data.get(position-1).getName());
            ImageLoader.getInstance().displayImage(ShopApi.IMAGE_URL+data.get(position-1).getPage(),myViewHolder.imageView, ImageLoadOptions.build_item());
            Log.i("Drew","aaaaaaa");
            myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onPhotoClicked(data.get(position-1));
                    }
                }
            });
        }else if (viewHolder instanceof AdViewHolder){
            AdViewHolder adViewHolder = (AdViewHolder) viewHolder;
            adAdapter.setData(adData);
            viewPager  = adViewHolder.viewPager;
            viewPager.setAdapter(adAdapter);
            final View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsSubTitle title  = new GoodsSubTitle();
                   ArrayList<GoodsSubTitle> s =  title.getSubList();
                    switch (v.getId()){
                        case R.id.iv_all:
                            clciks.onTitlePhoto(1,"");
                            break;
                        case R.id.iv_electron:
                            clciks.onTitlePhoto(1,s.get(1).getSubtitleEnglish());
                            break;
                        case R.id.iv_dress:
                            clciks.onTitlePhoto(1,s.get(2).getSubtitleEnglish());
                            break;
                        case R.id.iv_toys:
                            clciks.onTitlePhoto(1,s.get(3).getSubtitleEnglish());
                            break;
                        case R.id.iv_book:
                            clciks.onTitlePhoto(1,s.get(4).getSubtitleEnglish());
                            break;
                        case R.id.iv_gift:
                            clciks.onTitlePhoto(1,s.get(5).getSubtitleEnglish());
                            break;
                        case R.id.iv_other:
                            clciks.onTitlePhoto(1,s.get(6).getSubtitleEnglish());
                            break;
                        case R.id.iv_household:
                            clciks.onTitlePhoto(1,s.get(0).getSubtitleEnglish());
                            break;
                    }

                }
            };
            adViewHolder.iv_all.setOnClickListener(clickListener);
            adViewHolder.iv_electron.setOnClickListener(clickListener);
            adViewHolder.iv_dress.setOnClickListener(clickListener);
            adViewHolder.iv_toys.setOnClickListener(clickListener);
            adViewHolder.iv_book.setOnClickListener(clickListener);
            adViewHolder.iv_gift.setOnClickListener(clickListener);
            adViewHolder.iv_other.setOnClickListener(clickListener);
            adViewHolder.iv_household.setOnClickListener(clickListener);
        }
    }



    @Override
    public int getItemCount() {
        return data.size()+1;
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
    class   AdViewHolder extends  RecyclerView.ViewHolder{
        public  ViewPager viewPager;
         public   ImageView iv_all,iv_electron,iv_dress,iv_toys,iv_book,iv_gift,iv_other,iv_household;

        public AdViewHolder(final View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.item_viewpager);
            iv_all = (ImageView) itemView.findViewById(R.id.iv_all);
            iv_electron = (ImageView) itemView.findViewById(R.id.iv_electron);
            iv_dress = (ImageView) itemView.findViewById(R.id.iv_dress);
            iv_toys = (ImageView) itemView.findViewById(R.id.iv_toys);
            iv_book = (ImageView) itemView.findViewById(R.id.iv_book);
            iv_gift = (ImageView) itemView.findViewById(R.id.iv_gift);
            iv_other = (ImageView) itemView.findViewById(R.id.iv_other);
            iv_household = (ImageView) itemView.findViewById(R.id.iv_household);
        }
    }
    class TypeViewHolder extends  RecyclerView.ViewHolder{
        public RecyclerView recyclerView;
        public TypeViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.item_recycleView);
        }
    }


    public  void setListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onPhotoClicked(GoodsDatas.DatasBean datasBean);
    }

    public void setOnclick(onClciks clciks){
        this.clciks = clciks;

    }
    public interface  onClciks{
        void  onTitlePhoto(int i, String title);
    }
}
