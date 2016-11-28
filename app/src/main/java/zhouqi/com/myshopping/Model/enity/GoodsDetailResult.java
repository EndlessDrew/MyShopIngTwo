package zhouqi.com.myshopping.Model.enity;

import com.google.gson.annotations.SerializedName;

/**
 * 商品展示对应返回的实体类
 */
public class GoodsDetailResult {

    private int code;
    @SerializedName("msg")
    private String message;
    private GoodsDetailEntity datas;
    /*发布者的信息*/
    @SerializedName("user")
    private UserEntity userEntity;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public GoodsDetailEntity getDatas() {
        return datas;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

}

