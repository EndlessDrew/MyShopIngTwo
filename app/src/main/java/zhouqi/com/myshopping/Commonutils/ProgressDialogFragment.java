package zhouqi.com.myshopping.Commonutils;

import android.annotation.TargetApi;
import android.app.Dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

/**
 * 自定义的DialogFragment 相当于ProgressBar功能
 * 弹出该控件后，屏蔽返回按钮以及屏幕上的点击事件
 * Created by Drew on 2016/11/18.
 */
public class ProgressDialogFragment extends DialogFragment {
    public ProgressDialogFragment() {
        //空构造方法
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog =  super.onCreateDialog(savedInstanceState);
        Window window  =dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.requestFeature(Window.FEATURE_NO_TITLE);
        return  dialog;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new ProgressBar(getContext());
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.0f;
        window.setAttributes(windowParams);
    }


}
