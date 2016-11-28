package zhouqi.com.myshopping;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by z on 2016/11/17.
 */
public class ShopApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)/*开启内存缓存*/
                .cacheOnDisk(true)/*开启硬盘缓存*/
                .resetViewBeforeLoading(true)/*在ImageView加载前清除它上面之前的图片*/
                .build();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSize(4 * 1024 * 1024)/*设置内存缓存的大小(4M)*/
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}

