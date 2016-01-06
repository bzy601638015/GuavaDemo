package com.bamboo.guava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.main_recyclerView)
    RecyclerView mRecyclerView;
    String[] mNames = {
            "基本工具"
    };
    private NameAdapter mNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mNameAdapter = new NameAdapter();
        mNameAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = null;
                if(position == 0){
                    intent = new Intent(MainActivity.this,BaseToolActivity.class);
                }
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mNameAdapter);

    }

    public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
        private OnItemClickListener mOnItemClickListener;
        public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener){
            this.mOnItemClickListener = paramOnItemClickListener;
        }
        @Override
        public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lv, parent, false);
            return new NameViewHolder(view);
        }

        @Override
        public void onBindViewHolder(NameViewHolder holder, int position) {
            holder.mTvName.setText(mNames[position]);
        }

        @Override
        public int getItemCount() {
            return mNames.length;
        }

        class NameViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.item_tv_name)
            TextView mTvName;

            public NameViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                itemView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (getAdapterPosition() == RecyclerView.NO_POSITION) {
                            return;
                        }
                        if(mOnItemClickListener != null){
                            mOnItemClickListener.onItemClick(getAdapterPosition());
                        }
                    }
                });
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
