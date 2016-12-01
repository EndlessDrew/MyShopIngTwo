package zhouqi.com.myshopping.Presention.details;


import java.util.ArrayList;

import zhouqi.com.myshopping.Base.MvpView;
import zhouqi.com.myshopping.Model.enity.GoodsDetailEntity;
import zhouqi.com.myshopping.Model.enity.UserEntity;

/**
 * Created by Drew on 2016/11/18.
 */
public interface GoodsDetailView extends MvpView {
    void showProgress();
    void hideProgress();
    //设置图片路径
    void setImageData(ArrayList<String>viewList);
    void setData(GoodsDetailEntity data, UserEntity goods_userEntity);

    GoodsDetailView NULL = new GoodsDetailView() {
        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void setImageData(ArrayList<String> viewList) {

        }

        @Override
        public void setData(GoodsDetailEntity data, UserEntity goods_userEntity) {

        }
    };

}
