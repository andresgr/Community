package com.asgr.community;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asgr.community.model.BibleGroup;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by andres on 31/10/17.
 */

public class BibleGroupEntityAdapter extends RecyclerView.Adapter<BibleGroupEntityAdapter.ViewHolder> {

    private final List<BibleGroup> mGroups;

    public BibleGroupEntityAdapter(List<BibleGroup> bibleGroups) {
        mGroups = ImmutableList.copyOf(bibleGroups);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        return new BibleGroupEntityAdapter.ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindGroup(mGroups.get(position));
    }

    @Override
    public int getItemCount() {
        return mGroups.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;
        public ViewHolder(TextView textView) {
            super(textView);
            mTextView = textView;
        }

        public void bindGroup(BibleGroup group) {
            mTextView.setText(group.getName());
        }
    }
}
