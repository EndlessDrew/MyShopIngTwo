package zhouqi.com.myshopping.Presention.main.myself.UpdataImage;

import java.util.ArrayList;

import zhouqi.com.myshopping.Base.MvpView;
import zhouqi.com.myshopping.Model.enity.GoodsDatas;

/**
 * Created by z on 2016/11/30.
 */
public interface PersonGoodsView extends MvpView{
    void getAllDatas(ArrayList<GoodsDatas.DatasBean>list);
}
