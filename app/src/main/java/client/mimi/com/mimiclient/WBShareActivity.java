package client.mimi.com.mimiclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.sina.weibo.sdk.share.WbShareCallback;

import client.mimi.com.mimiclient.util.WBShareUtil;

/**
 * Created by chuck on 2018/3/5.
 */

public class WBShareActivity extends Activity implements WbShareCallback, View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wb);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        WBShareUtil.getInstace(this).getWbShareHandler().doResultIntent(intent, this);
    }


    @Override
    public void onWbShareSuccess() {
        Toast.makeText(this, "分享成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWbShareCancel() {
        Toast.makeText(this, "取消分享", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWbShareFail() {
        Toast.makeText(this, "分享error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                WBShareUtil.getInstace(this).toTextObj("文字", "我只是一个简单的Value", "htts://iqianjin.com");
                break;
            case R.id.btn2:
                WBShareUtil.getInstace(this).toImageObj("图片", "http://a0.att.hudong.com/31/35/300533991095135084358827466.jpg", "htts://iqianjin.com");
                break;
        }
    }
}
