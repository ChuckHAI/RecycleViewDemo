package client.mimi.com.mimiclient.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import client.mimi.com.mimiclient.R;
import client.mimi.com.mimiclient.TestRxBusActivity;
import client.mimi.com.mimiclient.TestTitleBarActivity;
import client.mimi.com.mimiclient.model.Student;
import client.mimi.com.mimiclient.util.RxBus;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

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
        View view = inflater.inflate(R.layout.fragment_home_my_info, container, false);
        initRxBus();

        Button mBtnRxbus = view.findViewById(R.id.btnRxbus);
        mBtnRxbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TestRxBusActivity.class);
                startActivity(intent);
            }
        });

        Button mBtnTitleBar = view.findViewById(R.id.btnTitleBar);
        mBtnTitleBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TestTitleBarActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private Disposable disposable;

    private void initRxBus() {
        disposable = RxBus.getInstance().toObservable(Student.class).subscribe(new Consumer<Student>() {
            @Override
            public void accept(Student student) throws Exception {
                Toast.makeText(getActivity(), student.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
