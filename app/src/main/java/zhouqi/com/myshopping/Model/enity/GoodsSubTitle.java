package zhouqi.com.myshopping.Model.enity;

import java.util.ArrayList;

/**
 * Created by z on 2016/11/17.
 */
public class GoodsSubTitle {
    private String  subtitle;
    private String  subtitleEnglish;
    public GoodsSubTitle() {
    }


    public GoodsSubTitle(String subtitle, String subtitleEnglish) {
        this.subtitle = subtitle;
        this.subtitleEnglish = subtitleEnglish;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSubtitleEnglish() {
        return subtitleEnglish;
    }

    public void setSubtitleEnglish(String subtitleEnglish) {
        this.subtitleEnglish = subtitleEnglish;
    }

    public  ArrayList<GoodsSubTitle> getSubList(){
        ArrayList<GoodsSubTitle> list = new ArrayList<GoodsSubTitle>();
        list.add(new GoodsSubTitle("家用","household"));
        list.add(new GoodsSubTitle("电子","electron"));
        list.add(new GoodsSubTitle("服饰","dress"));
        list.add(new GoodsSubTitle("玩具","toy"));
        list.add(new GoodsSubTitle("图书","book"));
        list.add(new GoodsSubTitle("礼品","gift"));
        list.add(new GoodsSubTitle("其他","other"));
        return list;

    }
}
