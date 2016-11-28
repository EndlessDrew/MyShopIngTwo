package zhouqi.com.myshopping.Model.enity;

import java.util.List;

/**
 * Created by z on 2016/11/18.
 */
public class Productdetails {

    /**
     * code : 1
     * datas : {"description":"飙泪大甩卖","master":"ggg1111","name":"iphone 5s","pages":[{"goodsuuid":"551E123AB5FB40FD8BD492E20762B134","name":"0BB8AB986F.JPEG","uri":"/images/06EDD36E736344BC950D42ADB04BE9FE/551E123AB5FB40FD8BD492E20762B134/0BB8AB986F.JPEG","url":"http://wx.feicuiedu.com:9094/images/551E123AB5FB40FD8BD492E20762B134/0BB8AB986F.JPEG","uuid":"23C53449191B49FF8F1AF4EA9391E985"},{"goodsuuid":"551E123AB5FB40FD8BD492E20762B134","name":"5C8366A166.JPEG","uri":"/images/06EDD36E736344BC950D42ADB04BE9FE/551E123AB5FB40FD8BD492E20762B134/5C8366A166.JPEG","url":"http://wx.feicuiedu.com:9094/images/551E123AB5FB40FD8BD492E20762B134/5C8366A166.JPEG","uuid":"34CD51B909AB4AC685E8715F44A980BA"},{"goodsuuid":"551E123AB5FB40FD8BD492E20762B134","name":"F9BD166E2B.JPEG","uri":"/images/06EDD36E736344BC950D42ADB04BE9FE/551E123AB5FB40FD8BD492E20762B134/F9BD166E2B.JPEG","url":"http://wx.feicuiedu.com:9094/images/551E123AB5FB40FD8BD492E20762B134/F9BD166E2B.JPEG","uuid":"DD57BA339D5949CDB0E11B9B17EAB8DD"}],"price":"3","type":"electron","uuid":"551E123AB5FB40FD8BD492E20762B134"}
     * msg :  success
     * user : {"name":"yt4b7d20016c7642868e07cff8b724e865","nickname":"6666","other":"/images/06EDD36E736344BC950D42ADB04BE9FE/AA48FB3F27.jpg","password":"ggg1111","username":"ggg1111","uuid":"06EDD36E736344BC950D42ADB04BE9FE"}
     */

    private int code;
    /**
     * description : 飙泪大甩卖
     * master : ggg1111
     * name : iphone 5s
     * pages : [{"goodsuuid":"551E123AB5FB40FD8BD492E20762B134","name":"0BB8AB986F.JPEG","uri":"/images/06EDD36E736344BC950D42ADB04BE9FE/551E123AB5FB40FD8BD492E20762B134/0BB8AB986F.JPEG","url":"http://wx.feicuiedu.com:9094/images/551E123AB5FB40FD8BD492E20762B134/0BB8AB986F.JPEG","uuid":"23C53449191B49FF8F1AF4EA9391E985"},{"goodsuuid":"551E123AB5FB40FD8BD492E20762B134","name":"5C8366A166.JPEG","uri":"/images/06EDD36E736344BC950D42ADB04BE9FE/551E123AB5FB40FD8BD492E20762B134/5C8366A166.JPEG","url":"http://wx.feicuiedu.com:9094/images/551E123AB5FB40FD8BD492E20762B134/5C8366A166.JPEG","uuid":"34CD51B909AB4AC685E8715F44A980BA"},{"goodsuuid":"551E123AB5FB40FD8BD492E20762B134","name":"F9BD166E2B.JPEG","uri":"/images/06EDD36E736344BC950D42ADB04BE9FE/551E123AB5FB40FD8BD492E20762B134/F9BD166E2B.JPEG","url":"http://wx.feicuiedu.com:9094/images/551E123AB5FB40FD8BD492E20762B134/F9BD166E2B.JPEG","uuid":"DD57BA339D5949CDB0E11B9B17EAB8DD"}]
     * price : 3
     * type : electron
     * uuid : 551E123AB5FB40FD8BD492E20762B134
     */

    private ProductBeans datas;
    private String msg;
    /**
     * name : yt4b7d20016c7642868e07cff8b724e865
     * nickname : 6666
     * other : /images/06EDD36E736344BC950D42ADB04BE9FE/AA48FB3F27.jpg
     * password : ggg1111
     * username : ggg1111
     * uuid : 06EDD36E736344BC950D42ADB04BE9FE
     */

    private UserBean user;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ProductBeans getDatas() {
        return datas;
    }

    public void setDatas(ProductBeans datas) {
        this.datas = datas;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class ProductBeans {
        private String description;
        private String master;
        private String name;
        private String price;
        private String type;
        private String uuid;
        /**
         * goodsuuid : 551E123AB5FB40FD8BD492E20762B134
         * name : 0BB8AB986F.JPEG
         * uri : /images/06EDD36E736344BC950D42ADB04BE9FE/551E123AB5FB40FD8BD492E20762B134/0BB8AB986F.JPEG
         * url : http://wx.feicuiedu.com:9094/images/551E123AB5FB40FD8BD492E20762B134/0BB8AB986F.JPEG
         * uuid : 23C53449191B49FF8F1AF4EA9391E985
         */

        private List<PagesBean> pages;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMaster() {
            return master;
        }

        public void setMaster(String master) {
            this.master = master;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public List<PagesBean> getPages() {
            return pages;
        }

        public void setPages(List<PagesBean> pages) {
            this.pages = pages;
        }

        public static class PagesBean {
            private String goodsuuid;
            private String name;
            private String uri;
            private String url;
            private String uuid;

            public String getGoodsuuid() {
                return goodsuuid;
            }

            public void setGoodsuuid(String goodsuuid) {
                this.goodsuuid = goodsuuid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }
        }
    }

    public static class UserBean {
        private String name;
        private String nickname;
        private String other;
        private String password;
        private String username;
        private String uuid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
}
