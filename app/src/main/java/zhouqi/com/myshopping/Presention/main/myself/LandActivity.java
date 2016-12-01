package zhouqi.com.myshopping.Presention.main.myself;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zhouqi.com.myshopping.Commonutils.SharedpreferceData;
import zhouqi.com.myshopping.MainActivity;
import zhouqi.com.myshopping.Model.enity.LoginDatas;
import zhouqi.com.myshopping.R;

/**
 * 登陆页面
 */
public class LandActivity extends AppCompatActivity implements TextWatcher {
    private TextView tv_land_login;
    private EditText et_land_username;
    private EditText et_land_password;
    private Button bt_land;
    public LoginDatas use;
    private String usename;
    private String passeord;
    private String path;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        initView();

    }

    public void initView() {
        //登陆界面上的注册按钮
        tv_land_login = (TextView) findViewById(R.id.tv_land_login);
        //输入用户名
        et_land_username = (EditText) findViewById(R.id.et_land_username);
        et_land_username.addTextChangedListener(this);
        //输入用户密码
        et_land_password = (EditText) findViewById(R.id.et_land_password);
        et_land_password.addTextChangedListener(this);
        //登陆按钮
        bt_land = (Button) findViewById(R.id.bt_land);

    }

    /**
     * handler 获取消息
     */
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            use = (LoginDatas) msg.obj;
            index = use.getCode();
            //保存数据文件 第一次登陆的时候的个人信息
            setListener();

        }
    };

    /**
     * 设置监听
     */
    public void setListener() {
        bt_land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 1) {
                    SharedpreferceData.saveShared(LandActivity.this, use, true);
                    startActivity(new Intent(LandActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LandActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 获取解析网络数据
     */
    protected void Login() {
        usename = et_land_username.getText().toString().trim();
        passeord = et_land_password.getText().toString().trim();
        if (usename == null || passeord == null) {
            Toast.makeText(LandActivity.this, "数值为空", Toast.LENGTH_SHORT).show();
        } else {
            path = "http://wx.feicuiedu.com:9094/yitao/UserWeb?method=login&username=" + usename
                    + "&password=" + passeord;
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(path).build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String s = response.body().string().toString();
                    Gson gson = new Gson();
                    LoginDatas loginDatas = gson.fromJson(s, LoginDatas.class);
                    Message msg = handler.obtainMessage();
                    msg.obj = loginDatas;
                    handler.sendMessage(msg);
                }
            });
        }
    }

    /**
     * EditText的内容改变的监听
     *
     * @param s
     * @param start
     * @param count
     * @param after
     */

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    /**
     * 内容完成后的监听
     *
     * @param s
     */
    @Override
    public void afterTextChanged(Editable s) {
        Login();
    }
}
