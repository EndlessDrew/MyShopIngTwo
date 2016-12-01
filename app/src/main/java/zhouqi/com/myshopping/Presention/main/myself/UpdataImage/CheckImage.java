package zhouqi.com.myshopping.Presention.main.myself.UpdataImage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;


import java.util.ArrayList;

/**
 * Created by z on 2016/11/30.
 */
public class CheckImage {
    public static ArrayList<String>  getImage(Context context) {
        ArrayList<String> listpath = new ArrayList<>();
        Uri imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(imageUri, null, null,null, MediaStore.Images.Media.DATE_ADDED);
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                //查询图片的路径
                String path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                if (path==null){
                    continue;
                }
                listpath.add(path);
            }
            return  listpath;
        }else {
            return null;
        }
    }
}
