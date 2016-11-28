package zhouqi.com.imageloadertest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv_data);
//        intiImageLoader();

        testMd5();

    }


    public void  a(View view){
        startActivity(new Intent(MainActivity.this,BActivity.class));
    }
    private  void  testMd5(){
        String s = "1561518182191321";
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(s.getBytes());
            byte[] m = messageDigest.digest();
            for (byte b:m) {
                int i =  b&0xff;
                String hexString =Integer.toHexString(i);
                if(hexString.length()<2){
                    hexString = "0"+hexString;
                }
                sb.append(hexString);
            }
            Log.i("aaa",sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private  void intiImageLoader(){
        ImageLoaderConfiguration configuration  = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
        ImageLoader.getInstance().displayImage("http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg", imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

    }
    private  void  setConfig(){
//        ImageLoaderConfiguration.Builder cofig = new ImageLoaderConfiguration.Builder(this).diskCache()
    }
}
