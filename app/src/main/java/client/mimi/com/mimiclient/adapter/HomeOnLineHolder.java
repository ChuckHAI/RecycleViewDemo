package client.mimi.com.mimiclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import client.mimi.com.mimiclient.R;

/**
 * Created by chuck on 2018/2/2.
 */

public class HomeOnLineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView mImageView;
    public TextView mTextView;

    private HomeOnLineAdapter.OnItemClickListener listener;

    public HomeOnLineHolder(View itemView, HomeOnLineAdapter.OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
        mImageView = itemView.findViewById(R.id.imageView);
        mTextView = itemView.findViewById(R.id.textView);

    }

    @Override
    public void onClick(View view) {
        if (null != listener) {
            listener.ItemClick(view, getAdapterPosition());
        }
    }
}
