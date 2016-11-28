package zhouqi.com.myshopping.Presentation.details;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import zhouqi.com.myshopping.Base.MvpPresenter;
import zhouqi.com.myshopping.Model.enity.GoodsDetailEntity;
import zhouqi.com.myshopping.Model.enity.GoodsDetailResult;
import zhouqi.com.myshopping.Network.ShopClient;
import zhouqi.com.myshopping.Network.UICallback;

/**
 * Created by z on 2016/11/23.
 */
public class GoodsDetailPresenter extends MvpPresenter<GoodsDetailView>{

    private Call call;

    public void getData(String uuid){
        getView().showProgress();
        call = ShopClient.getInstance().getGoodsData(uuid);
        call.enqueue(new UICallback() {
            @Override
            public void onFailureInUi(Call call, IOException e) {
                getView().hideProgress();
            }

            @Override
            public void onResponseInUi(Call call, String result) {
              getView().hideProgress();
                GoodsDetailResult goodsDetailResult = new Gson().fromJson(result,GoodsDetailResult.class);
                if (goodsDetailResult.getCode() == 1) {
                    GoodsDetailEntity goodsDetail = goodsDetailResult.getDatas();
                    ArrayList<String> list = new ArrayList<>();
                    for (int i = 0; i < goodsDetail.getPages().size(); i++) {
                        list.add(goodsDetail.getPages().get(i).getUri());
                    }
                    getView().setImageData(list);
                    getView().setData(goodsDetail, goodsDetailResult.getUserEntity());
                } else{
                    getView().hideProgress();
                    // 获取错误
                }
            }
        });
    }

    @NonNull
    @Override
    protected GoodsDetailView getNullObject() {
        return GoodsDetailView.NULL;
    }

    @Override
    public void detachView() {
        super.detachView();
        if(call != null) call.cancel();
    }
}
