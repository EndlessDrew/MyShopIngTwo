package zhouqi.com.myshopping.Presentation.main.myself;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pkmmte.view.CircularImageView;

import zhouqi.com.myshopping.Commonutils.ImageLoadOptions;
import zhouqi.com.myshopping.Commonutils.SharedpreferceData;
import zhouqi.com.myshopping.Network.ShopApi;
import zhouqi.com.myshopping.R;

/**
 * Created by z on 2016/11/16.
 */
public class Fragment_Myself extends Fragment implements View.OnClickListener {

    private View view;
    private CircularImageView cir_icon;
    private RelativeLayout rl_person_message, rl_my_goods, rl_up_goods;
    private TextView tv_my_land, tv_my_login;
    private TextView tv_land_username;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_myself, container, false);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    @Override
    public void onStart() {
        super.onStart();
        showView();
    }

    public void initView() {
        cir_icon = (CircularImageView) view.findViewById(R.id.iv_icon);
        cir_icon.setOnClickListener(this);
        rl_person_message = (RelativeLayout) view.findViewById(R.id.rl_person_message);
        rl_person_message.setOnClickListener(this);
        rl_my_goods = (RelativeLayout) view.findViewById(R.id.rl_my_goods);
        rl_my_goods.setOnClickListener(this);
        rl_up_goods = (RelativeLayout) view.findViewById(R.id.rl_up_goods);
        rl_up_goods.setOnClickListener(this);
        tv_my_land = (TextView) view.findViewById(R.id.tv_my_land);
        tv_my_land.setOnClickListener(this);
        tv_my_login = (TextView) view.findViewById(R.id.tv_my_login);
        tv_my_login.setOnClickListener(this);
        tv_land_username = (TextView) view.findViewById(R.id.tv_land_username);
    }

    private  void  showView(){
        if(SharedpreferceData.getState(getActivity())){
            //设置图片
            tv_my_land.setVisibility(View.GONE);
            tv_my_login.setVisibility(View.GONE);
            SharedPreferences sp = getActivity().getSharedPreferences(SharedpreferceData.sharedName,getActivity().MODE_PRIVATE);
            tv_land_username.setText(sp.getString(SharedpreferceData.USERNAME,""));
            ImageLoader.getInstance().displayImage(ShopApi.IMAGE_URL+sp.getString(SharedpreferceData.OTHER,null),cir_icon, ImageLoadOptions.build_item());
            Log.i("ccc",ShopApi.IMAGE_URL+sp.getString(SharedpreferceData.OTHER,null));
        }else{
            tv_land_username.setVisibility(View.GONE);
        }
    }
    /**
     * 点击事件
     * @param v
     */

    @Override
    public void onClick(View v) {
        boolean state = SharedpreferceData.getState(getActivity());
        switch (v.getId()) {
            case R.id.iv_icon:
                if(state){
                    startActivity(new Intent(getActivity(),PersonActivity.class));
                }else{
                    startActivity(new Intent(getActivity(),LandActivity.class));
                }
                break;
            case R.id.tv_my_land:
                if(state){
                    startActivity(new Intent(getActivity(),PersonActivity.class));
                }else{
                    startActivity(new Intent(getActivity(),LandActivity.class));
                }
                break;
            case R.id.tv_my_login:
                if(state){
                    startActivity(new Intent(getActivity(),PersonActivity.class));
                }else{
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                }
                break;
            case R.id.rl_person_message:
                if(state){
                    startActivity(new Intent(getActivity(),PersonActivity.class));
                }else{
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                }
                break;
            case R.id.rl_my_goods:
                if(state){
                    startActivity(new Intent(getActivity(),PersonActivity.class));
                }else{
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                }
                break;
            case R.id.rl_up_goods:
                if(state){
                    startActivity(new Intent(getActivity(),PersonActivity.class));
                }else{
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                }
                break;


        }

    }
}
