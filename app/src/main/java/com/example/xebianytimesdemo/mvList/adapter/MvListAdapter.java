package com.example.xebianytimesdemo.mvList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xebianytimesdemo.R;
import com.example.xebianytimesdemo.mvList.Navigator;
import com.example.xebianytimesdemo.mvList.entity.Result;

import java.util.ArrayList;
import java.util.List;


public class MvListAdapter extends RecyclerView.Adapter<MvListAdapter.MVViewHolder> {

    private List<Result> results;
    private Navigator navigator;

    public MvListAdapter() {
        this.results = new ArrayList<>();
    }

    public void addData(List<Result> rs) {
        results = rs;
        notifyDataSetChanged();
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return results.size();
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MVViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MVViewHolder holder, int position) {

        Result result = results.get(position);
        if (result != null) {
            if (result.getTitle() != null) {
                holder.tvTitle.setText(result.getTitle());
                holder.tvTitle.setVisibility(View.VISIBLE);
            } else {
                holder.tvTitle.setVisibility(View.GONE);
            }
            if (result.getByline() != null) {
                holder.tvAuthor.setText(result.getByline());
                holder.tvAuthor.setVisibility(View.VISIBLE);
            } else {
                holder.tvAuthor.setVisibility(View.GONE);
            }
            if (result.getPublishedDate() != null) {
                holder.tvDate.setText(result.getPublishedDate());
                holder.tvDate.setVisibility(View.VISIBLE);
            } else {
                holder.tvDate.setVisibility(View.GONE);
            }

            holder.itemView.setOnClickListener(v -> navigator.showMessage(result.getTitle()));
        }
    }


    class MVViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvAuthor;
        TextView tvDate;

        MVViewHolder(View item) {
            super(item);
            tvTitle = item.findViewById(R.id.mv_title);
            tvAuthor = item.findViewById(R.id.mv_author);
            tvDate = item.findViewById(R.id.mv_date);
        }
    }

    public void setNavigator(Navigator nav) {
        this.navigator = nav;
    }
}
