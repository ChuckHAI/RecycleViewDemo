package client.mimi.com.mimiclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import client.mimi.com.mimiclient.R;
import client.mimi.com.mimiclient.adapter.HomeOnLineAdapter;

/**
 * Created by chuck on 2018/2/1.
 */

public class HomeOnLineFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private HomeOnLineAdapter adapter;


    public static HomeOnLineFragment homeOnLineFragment;

    public static HomeOnLineFragment newInstance() {
        if (null == homeOnLineFragment) {
            homeOnLineFragment = new HomeOnLineFragment();
        }
        return homeOnLineFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_online, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE); //不设置的话，图片闪烁错位，有可能有整列错位的情况。

        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new HomeOnLineAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                layoutManager.invalidateSpanAssignments(); ////这行主要解决了当加载更多数据时，底部需要重绘，否则布局可能衔接不上。
            }
        });

        adapter.setItemOnClick(new HomeOnLineAdapter.OnItemClickListener() {
            @Override
            public void ItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getActivity(), WBShareActivity.class));
            }
        });

    }
}
