package zhouqi.com.myshopping.Commonutils;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

import zhouqi.com.myshopping.R;

/**
 *
 * ImageLoader的磁盘设置
 * 单例模式
 * Created by Drew on 2016/11/16.
 */
public class ImageLoadOptions {
    private  static  DisplayImageOptions options_item;
    private  ImageLoadOptions(){

    }

    /**
     * 图片加载选项
     */
    public static DisplayImageOptions  build_item(){
        if(options_item==null){
            options_item = new DisplayImageOptions.Builder()
                    .showImageForEmptyUri(R.drawable.logo2)//如果url为空显示图片
                    .showImageOnLoading(R.drawable.logo2)//正在加载时显示的图片
                    .showImageOnFail(R.drawable.logo2)//加载失败显示的图片
                    .cacheOnDisk(true)//是否开启硬盘缓存 true表示为是
                    .cacheInMemory(true)//是否开启内存缓存 true表示开启
                    .resetViewBeforeLoading(true).build();
        }
        return  options_item;
    }
}
