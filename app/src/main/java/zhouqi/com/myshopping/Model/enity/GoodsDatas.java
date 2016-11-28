package zhouqi.com.myshopping.Model.enity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z on 2016/11/17.
 */
public class GoodsDatas {

    /**
     * code : 1
     * msg :  success
     * datas : [{"price":"11","page":"/images/9BEEBFFFC14545CDAB517210D46A7923/15297DBB751E458C87AB3FFC0B5B3731/BEF7B92FD0.JPEG","description":"asdfdf ds","name":"sdf ","uuid":"15297DBB751E458C87AB3FFC0B5B3731","type":"dress","master":"renxiang"},{"price":"28","page":"/images/EBC362E3E3494ACA8F5CAB4BEFDF4C49/2FFA2419AC114E11A130FBBE04380177/F058EBE7B8.JPEG","description":"好吃不错哦","name":"蛋糕","uuid":"2FFA2419AC114E11A130FBBE04380177","type":"other","master":"feicuicp"},{"price":"1000000","page":"/images/D84007B5E84C4F67A85FA8468918E250/3933FE29FB4241BDBCD5209381C7827F/060110FC9D.JPEG","description":"非常nice","name":"钩子的屁股","uuid":"3933FE29FB4241BDBCD5209381C7827F","type":"household","master":"钩子的爸爸"},{"price":"9999","page":"/images/EE5D94C18C874279808CA5B301B1DAA9/3E8CC31720714130A198F9C462F6DD6D/ECA6543441.JPEG","description":"mkjjdjdusjekdujdjddn","name":"mouth","uuid":"3E8CC31720714130A198F9C462F6DD6D","type":"household","master":"zeta"},{"price":"50","page":"/images/9BEEBFFFC14545CDAB517210D46A7923/471C3623E68447C0BC380E69EA20E5CE/B9DFF8607C.JPEG","description":"电影票","name":"电影","uuid":"471C3623E68447C0BC380E69EA20E5CE","type":"gift","master":"renxiang"},{"price":"1111","page":"/images/611203E9836C469FA7979620C112FDA8/6937B64402254B60971F132F6895687C/83BC272417.JPEG","description":"11111111111111","name":"111","uuid":"6937B64402254B60971F132F6895687C","type":"toy","master":"g729145859"},{"price":"96","page":"/images/9BEEBFFFC14545CDAB517210D46A7923/6B13B181F2D34918AA9891BE253FAE5E/CB842B9E9B.JPEG","description":"可爱的小熊","name":"小熊","uuid":"6B13B181F2D34918AA9891BE253FAE5E","type":"toy","master":"renxiang"},{"price":"86","page":"/images/0612105DB549499590272C188556B69B/83D0358184EF4BA1B00C699CB4744BE0/1D1225670C.JPEG","description":"好衣服","name":"衣服","uuid":"83D0358184EF4BA1B00C699CB4744BE0","type":"dress","master":"yuanc"},{"price":"1000000","page":"/images/BD1BE19588DE4227ADDAE55BE847C701/C856C669AB684DC1847BD953E9E9D54F/9A6FFB68A0.JPEG","description":"非常nice","name":"耗子的鞋子","uuid":"C856C669AB684DC1847BD953E9E9D54F","type":"household","master":"dk123456"},{"price":"250","page":"/images/D2DE0EF4740740A698E93655D762ED6F/E4937F40F1144B4EAC2AC36D43BA89B8/CC2D6EC3FD.JPEG","description":"放家当灯泡用","name":"大月亮","uuid":"E4937F40F1144B4EAC2AC36D43BA89B8","type":"household","master":"123456"},{"price":"25","page":"/images/EBC362E3E3494ACA8F5CAB4BEFDF4C49/E6C559E713C04546956B1FF3F75CF05B/1C67C486B8.JPEG","description":"好吃","name":"菠菜","uuid":"E6C559E713C04546956B1FF3F75CF05B","type":"other","master":"feicuicp"},{"price":"20","page":"/images/9BEEBFFFC14545CDAB517210D46A7923/EE7E83A2C77C43D08E0F64954550766D/108611AE51.JPEG","description":"很好吃哦！","name":"水果","uuid":"EE7E83A2C77C43D08E0F64954550766D","type":"gift","master":"renxiang"},{"price":"3000000","page":"/images/96EE9CB2CACF419EA81C358D828017B3/EE9167722CEC4D70B7519E74C0B21FCA/7B1D11E788.JPEG","description":"私聊~带好你的卡，我这有pos机。","name":"豪车","uuid":"EE9167722CEC4D70B7519E74C0B21FCA","type":"household","master":"717882275"}]
     */

    private int code;
    private String msg;
    /**
     * price : 11
     * page : /images/9BEEBFFFC14545CDAB517210D46A7923/15297DBB751E458C87AB3FFC0B5B3731/BEF7B92FD0.JPEG
     * description : asdfdf ds
     * name : sdf
     * uuid : 15297DBB751E458C87AB3FFC0B5B3731
     * type : dress
     * master : renxiang
     */

    private ArrayList<DatasBean> datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private String price;
        private String page;
        private String description;
        private String name;
        private String uuid;
        private String type;
        private String master;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMaster() {
            return master;
        }

        public void setMaster(String master) {
            this.master = master;
        }
    }
}
