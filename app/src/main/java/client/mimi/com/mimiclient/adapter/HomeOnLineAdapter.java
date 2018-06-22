package client.mimi.com.mimiclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import client.mimi.com.mimiclient.R;

/**
 * Created by chuck on 2018/2/2.
 */

public class HomeOnLineAdapter extends RecyclerView.Adapter<HomeOnLineHolder> {

    LayoutInflater inflater;

    public HomeOnLineAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HomeOnLineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_home_online, parent, false);
        return new HomeOnLineHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(HomeOnLineHolder holder, int position) {
        if (position == 0 || position == 2) {
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(holder.mImageView.getLayoutParams());
//            lp.setMargins(10, 0, 0, 0);
//            holder.mLayout.setLayoutParams(lp);
            holder.mLayout.setPadding(100, 0, 10, 0);
        } else {
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(holder.mImageView.getLayoutParams());
//            lp.setMargins(0, 0, 0, 0);
//            holder.mLayout.setLayoutParams(lp);
            holder.mLayout.setPadding(0, 0, 10, 0);
        }

        holder.mTextView.setText(position + "选项");
    }

    @Override
    public int getItemCount() {
        return 20;
    }


    private OnItemClickListener listener;

    public void setItemOnClick(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void ItemClick(View view, int position);
    }
}
