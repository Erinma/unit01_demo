package a16.erin.unit01_xutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.mybtn1)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);@ContentView(R.layout.activity_main)
        //注解查找view，初始化
        x.view().inject(this);

        //get请求
        x.http().get(new RequestParams("http://mapp.qzone.qq.com/cgi-bin/mapp/mapp_subcatelist_qq?yyb_cateid=-10&categoryName=%E8%85%BE%E8%AE%AF%E8%BD%AF%E4%BB%B6&pageNo=1&pageSize=20&type=app&platform=touch&network_type=unknown&resolution=412x732"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println("error");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                System.out.println("finish");

            }
        });

    }

    //event默认响应的是onclick事件；
    // @Event({R.id.mybtn1})
    @Event(type = View.OnClickListener.class, value = {R.id.mybtn1, R.id.mybtn2})
    private void doClick(View v) {
        switch (v.getId()) {
            case R.id.mybtn1:
                btn.setText("响应注解点击事件");
                break;
            case R.id.mybtn2:
                btn.setText("dierge响应注解点击事件");
                break;
        }
    }
}
