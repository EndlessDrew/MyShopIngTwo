package zhouqi.com.myshopping.Presentation.main.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhouqi.com.myshopping.R;

/**
 * Created by z on 2016/11/16.
 */
public class Fragment_Message extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message,container,false);
        return view;
    }
}
