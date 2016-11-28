package zhouqi.com.myshopping.Network;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 写一个类实现okHttp的callback接口
 * 重新封装 可以使用主线程更新UI
 * 使用handler 机制发送消息给主线程
 * Created by Drew on 2016/11/17.
 */
public  abstract class UICallback implements Callback {
    private  final Handler  handler = new Handler(Looper.getMainLooper());

    /**
     * 失败的接口
     *
     * @param call
     * @param e
     */
    @Override
    public void onFailure(final Call call,final IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailureInUi(call,e);
            }
        });
    }

    /**
     * 成功的接口，获得到json
     * @param call
     * @param response
     */
    @Override
    public void onResponse(final Call call, final Response response) {
        try {
            if(!response.isSuccessful()){
                //自定义异常
                throw new IOException("error code"+response.code());
            }
            final String result   = response.body().string();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    onResponseInUi(call,result);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            onFailure(call,e);
        }


    }

    /**
     * 实例化这个类必须实现的两个方法
     * @param call
     * @param e
     */
    public abstract void onFailureInUi(Call call, IOException e);

    public abstract void onResponseInUi(Call call, String result);
}
