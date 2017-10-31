package com.asgr.community;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asgr.community.model.Quote;

import java.util.List;

/**
 * Created by andres on 31/10/17.
 */

public class QuoteEntityAdapter extends RecyclerView.Adapter<QuoteEntityAdapter.ViewHolder>{

    private final List<Quote> mQuotes;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public QuoteEntityAdapter() {
        mQuotes = Quote.listAll(Quote.class);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public QuoteEntityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
//        TextView v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
//        ...
        TextView v = new TextView(parent.getContext());
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mQuotes.get(position).toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

}

