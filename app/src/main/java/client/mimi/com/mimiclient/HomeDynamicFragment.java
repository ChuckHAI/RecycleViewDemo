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

public class HomeDynamicFragment extends Fragment {

    public static HomeDynamicFragment homeDynamicFragment;

    public static HomeDynamicFragment newInstance() {
        if (null == homeDynamicFragment) {
            homeDynamicFragment = new HomeDynamicFragment();
        }
        return homeDynamicFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_dynamic, container,false);
        Log.i("==========", 333333333 + "");
        return view;
    }
}
