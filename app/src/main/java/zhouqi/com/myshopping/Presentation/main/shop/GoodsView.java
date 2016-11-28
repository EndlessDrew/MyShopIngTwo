package zhouqi.com.myshopping.Presentation.main.shop;

import java.util.ArrayList;
import java.util.List;

import zhouqi.com.myshopping.Base.MvpView;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;

/**
 * Created by z on 2016/11/17.
 */
public interface GoodsView extends MvpView {
    /**
     * 数据刷新 隐藏下啦刷新视图
     */
    void hideRefresh();
    /**
     * 添加更多的数据
     */
    void addRefreshData(ArrayList<GoodsDatas.DatasBean>data);


    GoodsView NULL =new GoodsView() {
        @Override
        public void hideRefresh() {

        }

        @Override
        public void addRefreshData(ArrayList<GoodsDatas.DatasBean> data) {

        }
    };


}
