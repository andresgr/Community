package com.asgr.community;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asgr.community.model.Quote;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by andres on 31/10/17.
 */

public class QuoteEntityAdapter extends RecyclerView.Adapter<QuoteEntityAdapter.ViewHolder> {

    private final List<Quote> mQuotes;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public QuoteEntityAdapter(List<Quote> quotes) {
        mQuotes = ImmutableList.copyOf(quotes);
    }

    @Override
    public QuoteEntityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
//        TextView v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
//        ...
        TextView v = new TextView(parent.getContext());
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mQuotes.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

}

