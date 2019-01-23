package client.mimi.com.mimiclient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class TestTitleBarActivity extends FragmentActivity {
    private ListView mListView;
    private LinearLayout mTopLayout;

    private int headHeight;
    private int mStickyViewHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_titlebar);
        bindViews();
    }

    private void bindViews() {
        mListView = findViewById(R.id.listview);
        mTopLayout = findViewById(R.id.top_layout);
        mTopLayout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        headHeight = mTopLayout.getMeasuredHeight();
        mStickyViewHeight = mTopLayout.getChildAt(0).getMeasuredHeight();//需要滚动上去的高度

        LinearLayout positionView = new LinearLayout(this);
        positionView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, headHeight));

        mListView.addHeaderView(positionView, null, false); //给Listview添加一个head
        mListView.setAdapter(new myAdaper());

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                View first = mListView.getChildAt(0);
                if (first == null) {
                    return;
                }
                if (firstVisibleItem < 1 && (-first.getTop() < mStickyViewHeight)) {
                    mTopLayout.setTranslationY(first.getTop());
                } else {
                    mTopLayout.setTranslationY(-mStickyViewHeight);
                }
            }
        });
    }

    class myAdaper extends BaseAdapter {

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;

            if (null == convertView) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(TestTitleBarActivity.this).inflate(R.layout.item_listview, null);
                holder.mLabel = convertView.findViewById(R.id.label);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.mLabel.setText(position + "");
            return convertView;
        }

        class ViewHolder {
            TextView mLabel;
        }
    }
}
