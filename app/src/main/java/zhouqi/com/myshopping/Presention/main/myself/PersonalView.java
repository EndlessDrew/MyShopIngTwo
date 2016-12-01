package zhouqi.com.myshopping.Presention.main.myself;

import java.util.ArrayList;

import zhouqi.com.myshopping.Base.MvpView;
import zhouqi.com.myshopping.Model.enity.GoodsEntity;
import zhouqi.com.myshopping.Model.enity.Productdetails;
import zhouqi.com.myshopping.Model.enity.UserEntity;

/**
 * Created by Drew on 2016/11/28.
 */
public interface PersonalView extends MvpView {
    /**
     * 更新成功
     * @param data
     */
    void update(UserEntity data);
}
