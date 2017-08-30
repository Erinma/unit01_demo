package a16.erin.unit01_xutils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by mamiaomiao on 2017/8/30.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化配置xutils
        x.Ext.init(this);
        //设置是否输出debug日志, TRUE开启debug会影响性能.
        x.Ext.setDebug(false);
    }
}
