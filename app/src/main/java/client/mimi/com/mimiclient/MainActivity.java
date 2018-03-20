package client.mimi.com.mimiclient;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioGroup;

import java.util.List;

import client.mimi.com.mimiclient.util.AppInfoUtils;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mradio_group;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Activity> activities = AppInfoUtils.getActivitiesByApplication(getApplication());
        for (int i = 0; i < activities.size(); i++) {
            Log.i("========", activities.get(i).getLocalClassName());
        }

        String ss = AppInfoUtils.getSingInfo(getApplicationContext(), getPackageName(), AppInfoUtils.SHA1);
        Log.i("=========", ss);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            window.setNavigationBarColor(Color.TRANSPARENT);
//        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }

//        StatusBarUtil.setStatusBarLightMode(getWindow());

        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mradio_group = findViewById(R.id.radio_group);
        mradio_group.setOnCheckedChangeListener(this);
        mradio_group.getChildAt(0).setClickable(true);

        toFragment(HomeOnLineFragment.newInstance());
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio1:
                fragment = HomeOnLineFragment.newInstance();
                break;
            case R.id.radio2:
                fragment = HomeInvestFragment.newInstance();
                break;
            case R.id.radio3:
                fragment = HomeDynamicFragment.newInstance();
                break;
            case R.id.radio4:
                fragment = HomeMyInfoFragment.newInstance();
                break;
        }
        toFragment(fragment);
    }

    private void toFragment(Fragment fragment) {
        if (null != fragment) {
            FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.ll_fragment, fragment);
            fragmentTransaction.commit();
        }
    }

}
