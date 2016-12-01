package zhouqi.com.myshopping.Presention.main.myself.UpdataImage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import zhouqi.com.myshopping.R;

/**
 * 展示界面 ，显示相机获取的图片，然后通过checkBox来选择
 * 然后将数据返回给上传的界面，上传的自己选定的数据
 */
public class ShowImageActivity extends AppCompatActivity implements GridViewAdapter.ListData {

    private GridView gridView;
    private RecyclerView recyclerView_selected;
    private ArrayList<String> listimage;
    private Toolbar toolbar;
    private Button bt_showImage_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        setToolbar();
        showImage();
        setListener();
    }



    /**
     * 加载视图
     */
    private void initView(){
        gridView = (GridView) findViewById(R.id.gv_image);
        recyclerView_selected = (RecyclerView) findViewById(R.id.recycleView_selected);
        toolbar = (Toolbar) findViewById(R.id.ShowImage_toolbar);
        bt_showImage_selected = (Button) findViewById(R.id.bt_showImage_selected);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_selected.setLayoutManager(linearLayoutManager);
    }

    /**
     * 设置标题栏
     */
    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("选择图片");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 设置toolbar返回按键
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    /**
     * 获取手机中的所有图片，显示在界面上
     */
    private  void  showImage(){
        //手机中所有的图片，封装的静态方法
        listimage = CheckImage.getImage(this);
        ArrayList<Boolean>boolist = new ArrayList<>();
        for (int i = 0; i < listimage.size() ; i++) {
            boolist.add(false);
        }
        GridViewAdapter adapter = new GridViewAdapter(this);
        adapter.setListData(this);
        adapter.setListpath(listimage);
        adapter.setBoolist(boolist);
        gridView.setAdapter(adapter);
    }

    /**
     * 界面主要图片的监听，点击第一张图片调用系统相机
     * 点击后面的图片，打开popupWindow
     * 弹出自定义窗口 滑动显示图片
     */
    private void setListener(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /**
                 * 调用手机相机
                 */
                if(position==0){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 1);
                }else{
                    Toast.makeText(ShowImageActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    /**
     * 打开相机的回调，获取相机拍摄的照片，然后将照片存储
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == 1) {
            //检查sd是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                return;
            }
            Bundle bundle = data.getExtras();
            //获取相机返回的数据，并转化为Bitmap图片格式
            Bitmap bitmap = (Bitmap) bundle.get("data");
            FileOutputStream OutputStream = null;
            File file = new File(Environment.getExternalStorageDirectory(), "myImage");
            if (!file.exists()) {
                file.mkdirs();
            }
            // 创建文件夹，名称为pk4fun
            // 照片的命名，目标文件夹下，以当前时间数字串为名称，即可确保每张照片名称不相同。
            String str = null;
            Date date = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            date = new Date(requestCode);
            str = format.format(date);
            String fileName = str + ".jpg";
            try {
                OutputStream = new FileOutputStream(new File(file, fileName));
                //把数据写入文件
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, OutputStream);
                Log.i("aaa","ShowImage成功获取图片");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    OutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE),fileName);
            }

        }

    }

    /**
     * 回调接口，获取选中的数据图片
     * @param listSelected 选中的图片列表
     */

    @Override
    public void setLiData(ArrayList<String> listSelected) {

        if(listSelected.size()<=8){
            bt_showImage_selected.setText("已选中（"+listSelected.size()+"/8"+")");
            PictureSelectAdapter pictureSelectAdapter = new PictureSelectAdapter(this,listSelected);
            recyclerView_selected.setAdapter(pictureSelectAdapter);
            pictureSelectAdapter.notifyDataSetChanged();
            EventBus.getDefault().post(listSelected);
        }else{
            Toast.makeText(ShowImageActivity.this,"亲，最多只能添加8张哦",Toast.LENGTH_SHORT).show();
        }
    }


}
