package client.mimi.com.mimiclient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chuck on 2018/2/1.
 */

public class HomeMyInfoFragment extends Fragment {

    public static HomeMyInfoFragment homeMyInfoFragment;

    public static HomeMyInfoFragment newInstance() {
        if (null == homeMyInfoFragment) {
            homeMyInfoFragment = new HomeMyInfoFragment();
        }
        return homeMyInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_my_info, container,false);
        Log.i("==========", 44444444 + "");
        return view;
    }
}
