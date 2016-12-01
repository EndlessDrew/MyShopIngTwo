package zhouqi.com.myshopping.Presention.main.myself.UpdataImage;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.utils.L;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import zhouqi.com.myshopping.Base.MvpPresenter;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;
import zhouqi.com.myshopping.Network.ShopClient;
import zhouqi.com.myshopping.Network.UICallback;

/**
 * Created by z on 2016/11/30.
 */
public class PersonGoodsPresenter extends MvpPresenter<PersonGoodsView> {

    Call call;
    public void getAllGoods(int page,String type){
        call = ShopClient.getInstance().getAllData(page,type);
        call.enqueue(new UICallback() {
            @Override
            public void onFailureInUi(Call call, IOException e) {

            }

            @Override
            public void onResponseInUi(Call call, String result) {
                Gson gson = new Gson();
                GoodsDatas datas =gson.fromJson(result, GoodsDatas.class);
                ArrayList<GoodsDatas.DatasBean>list=datas.getDatas();
                getView().getAllDatas(list);
            }
        });
    }







    @NonNull
    @Override
    protected PersonGoodsView getNullObject() {
        return null;
    }
}
