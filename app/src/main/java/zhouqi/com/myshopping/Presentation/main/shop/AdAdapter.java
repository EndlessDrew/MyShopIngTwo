package zhouqi.com.myshopping.Presentation.main.shop;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by z on 2016/11/22.
 */
public class AdAdapter extends PagerAdapter {
    private ArrayList <ImageView>list = new ArrayList<>();
    public  void setData(ArrayList<ImageView>list){
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v=list.get(position);
        ViewGroup parent = (ViewGroup) v.getParent();
        if (parent != null) {
            parent.removeAllViews();
        }
        container.addView(list.get(position));
        return list.get(position);
    }
}
