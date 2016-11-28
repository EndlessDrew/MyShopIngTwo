package zhouqi.com.myshopping.Model.enity;

/**
 * Created by z on 2016/11/24.
 */
public class LoginDatas {

    /**
     * code : 1
     * msg : succeed
     * data : {"username":"ggg1111","other":"/images/06EDD36E736344BC950D42ADB04BE9FE/AA48FB3F27.jpg","nickname":"6666","name":"yt4b7d20016c7642868e07cff8b724e865","uuid":"06EDD36E736344BC950D42ADB04BE9FE","password":"ggg1111"}
     */

    private int code;
    private String msg;
    /**
     * username : ggg1111
     * other : /images/06EDD36E736344BC950D42ADB04BE9FE/AA48FB3F27.jpg
     * nickname : 6666
     * name : yt4b7d20016c7642868e07cff8b724e865
     * uuid : 06EDD36E736344BC950D42ADB04BE9FE
     * password : ggg1111
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String username;
        private String other;
        private String nickname;
        private String name;
        private String uuid;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
