package zhouqi.com.myshopping.Network;

import com.google.gson.Gson;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import zhouqi.com.myshopping.Model.enity.UserEntity;

/**
 * 联网获取商品信息
 * Created by Drew on 2016/11/17.
 */
public class ShopClient {
    private OkHttpClient okHttpClient;


    private  ShopClient(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//连接超时
                .writeTimeout(10,TimeUnit.SECONDS)//写入超时
                .readTimeout(30, TimeUnit.SECONDS)//读取超时
                .build();
    }

    /**
     * 单例模式
     */
    private  static  ShopClient shopClient;
    public static ShopClient getInstance(){
        if(shopClient==null){
            shopClient = new ShopClient();
        }
        return  shopClient;
    }
    /**
     *获取所有的商品
     */
    public Call getAllData(int pageNo,String type){
        RequestBody requestBody = new FormBody.Builder()
                .add("pageNo", String.valueOf(pageNo))
                .add("type", type)
                .build();
        Request request = new Request.Builder()
                .url(ShopApi.BASE_URL + ShopApi.ALL_GOODS)
                .post(requestBody)
                .build();
        return okHttpClient.newCall(request);
    }

    /**
     *获取商品详情
     */
    public Call getGoodsData(String uuid){
        RequestBody requestBody = new FormBody.Builder()
                .add("uuid",uuid)
                .build();
        Request request = new Request.Builder()
                .url(ShopApi.BASE_URL+ShopApi.DETAIL)
                .post(requestBody)
                .build();
        return okHttpClient.newCall(request);
    }
    /**
     *更新信息
     */
    public Call getUpdateData(UserEntity data,File file){
       RequestBody requestBody=new MultipartBody.Builder()
               .addFormDataPart("user",new Gson().toJson(data))
               .addFormDataPart("image",file.getName(),RequestBody.create(MediaType.parse("image/png"),file))
               .build();
        Request request = new Request.Builder()
                .url(ShopApi.BASE_URL+ShopApi.UPDATE)
                .post(requestBody)
                .build();
        return okHttpClient.newCall(request);
    }



}
