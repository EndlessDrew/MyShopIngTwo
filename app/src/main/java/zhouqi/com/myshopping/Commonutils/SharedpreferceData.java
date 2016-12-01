package zhouqi.com.myshopping.Commonutils;

import android.content.Context;
import android.content.SharedPreferences;

import zhouqi.com.myshopping.Model.enity.LoginDatas;

/**
 * Created by z on 2016/11/24.
 */
public class SharedpreferceData {
    public   static  final String sharedName = "land";
    public   static  final String STATE ="state";
    /**
     * 用户名
     */
    public static final String USERNAME ="username";
    /**
     * 图片地址
     */
    public static final String OTHER ="other";
    /**
     * 昵称
     */
    private static final String NICKNAME ="nickname";
    /**
     * 环信名称
     */
    private static final String NAME ="name";
    /**
     * uuid
     */
    private static final String UUID ="uuid";
    /**
     * 用户密码
     */
    private static final String PASSWORD ="password";
    private static SharedPreferences sp;

    /**
     * 存储用户状态
     * @param context
     * @param datas
     * @param state
     */
    public static void saveShared(Context context, LoginDatas datas, boolean state){
        SharedPreferences sp  = context.getSharedPreferences(sharedName,context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(USERNAME,datas.getData().getUsername());
        edit.putString(OTHER,datas.getData().getOther());
        edit.putString(NICKNAME,datas.getData().getNickname());
        edit.putString(NAME,datas.getData().getName());
        edit.putString(UUID,datas.getData().getUuid());
        edit.putString(PASSWORD,datas.getData().getPassword());
        edit.putBoolean(STATE,state);
        edit.commit();
    }

    /**
     * 读取用户存储的数据
     */
    public  static boolean getState(Context context ){
        sp = context.getSharedPreferences(sharedName,context.MODE_PRIVATE);
        return  sp.getBoolean(STATE,false) ;
    }

    public static  String  getName(Context context){
      return   sp.getString(NAME,null);
    }
    public static  String  getUuid(Context context){
        return   sp.getString(UUID,null);
    }
}
