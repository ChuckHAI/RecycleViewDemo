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

public class HomeInvestFragment extends Fragment {

    public static HomeInvestFragment homeInvestFragment;

    public static HomeInvestFragment newInstance() {
        if (null == homeInvestFragment) {
            homeInvestFragment = new HomeInvestFragment();
        }
        return homeInvestFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_invest, container,false);
        Log.i("==========", 22222222 + "");
        return view;
    }
}
