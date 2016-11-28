package zhouqi.com.myshopping.Base;

import android.support.annotation.NonNull;

/**
 * Presenter是视图和模型之间的中间人。它通过视图接口（{@link MvpView}）来控制视图的行为
 * 模型层的数据变化通过事件总线传递给presenter
 *@param <V>该persenter所关联的视图类型
 * Created by Drew on 2016/11/16.
 */
public abstract class MvpPresenter <V extends  MvpView> {
    private  V view ;
    /**
     * presenter创建的 回调
     * 在Activity或者fragment的onCreate（）方法中回调
     */
    public final void onCreate(){

    }
    /**
     * presenter 和视图关联
     * 在activity 的onCreate（）中回调
     * 在fragment的onViewCreate()或者onActivityCreate中回调
     */

    public final void attachView(V view){
        this.view =view;
    }

    /**
     *  presenter 和视图解除关联
     *  在activity的  onDestroy()中调用
     *  在fragment中的onViewDestroy()中调用
     */

    public void detachView(){
        //使用Null Object Pattern ,避免子类使用getView（）方法时频繁检查null值
        this.view=getNullObject();
    }

    /**
     * presenter销毁时的回调
     * 在activity或者fragment的ondestroyed()中调用
     */
    public final void onDestroy(){

    }

    protected final V getView(){
        return  view;
    }

    protected abstract @NonNull  V getNullObject();
}
