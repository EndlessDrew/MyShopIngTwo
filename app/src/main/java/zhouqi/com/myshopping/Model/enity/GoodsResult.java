package zhouqi.com.myshopping.Model.enity;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * 获取商品返回对应的实体类
 */
public class GoodsResult {

    private int code;
    @SerializedName("msg")
    private String message;
    private List<GoodsEntity> datas;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<GoodsEntity> getData() {
        return datas;
    }
}
