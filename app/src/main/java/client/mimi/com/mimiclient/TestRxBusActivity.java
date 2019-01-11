package client.mimi.com.mimiclient;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import client.mimi.com.mimiclient.model.Student;
import client.mimi.com.mimiclient.util.RxBus;

public class TestRxBusActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setText("测试RxBus");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.getInstance().post(new Student(18, "chuck哈哈哈"));
                finish();
            }
        });
        setContentView(textView);
    }
}
