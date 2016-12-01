package zhouqi.com.myshopping.Presention.main.myself;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import zhouqi.com.myshopping.Base.MvpPresenter;
import zhouqi.com.myshopping.Model.enity.UserEntity;
import zhouqi.com.myshopping.Network.ShopClient;
import zhouqi.com.myshopping.Network.UICallback;

/**
 * 更新数据
 * Created by Drew on 2016/11/28.
 */
public class PersonaPersenter extends MvpPresenter<PersonalView> {
    /**
     * 跟新商品
     */
    Call call=null;
    public void update(UserEntity data,File file){
        call= ShopClient.getInstance().getUpdateData(data,file);
        call.enqueue(new UICallback() {
            @Override
            public void onFailureInUi(Call call, IOException e) {
            }

            @Override
            public void onResponseInUi(Call call, String result) {
                UserEntity userEntity=new Gson().fromJson(result,UserEntity.class);
                getView().update(userEntity);
            }
        });
    }







    @NonNull
    @Override
    protected PersonalView getNullObject() {
        return null;
    }
}
