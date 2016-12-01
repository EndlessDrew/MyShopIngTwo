package zhouqi.com.myshopping.Presention.main.shop;

import android.support.annotation.NonNull;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import zhouqi.com.myshopping.Base.MvpPresenter;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;
import zhouqi.com.myshopping.Network.ShopClient;
import zhouqi.com.myshopping.Network.UICallback;

/**
 * Created by Drew on 2016/11/17.
 */
public class GoodsPresenter extends MvpPresenter<GoodsView> {
    private Call call;

    /**
     * 获取商品时，分页加载
     */
    private  int pageInt = 1;

    public void refreshData(int  pageNO,String type){
        call = ShopClient.getInstance().getAllData(pageNO,type);
        call.enqueue(new UICallback() {
          @Override
          public void onFailureInUi(Call call, IOException e) {
          }
          @Override
          public void onResponseInUi(Call call, String result) {
              Gson gson = new Gson();
              GoodsDatas datas =gson.fromJson(result, GoodsDatas.class);

              switch (datas.getCode()){
                  case 1:
                      getView().addRefreshData(datas.getDatas());
                      getView().hideRefresh();
                      pageInt = 2;
                      break;
              }
          }
      });

    }

    @NonNull
    @Override
    protected GoodsView getNullObject() {
        return GoodsView.NULL;
    }

    @Override
    public void detachView() {
        super.detachView();
        if(call!=null){
            call.cancel();
        }
    }
}
