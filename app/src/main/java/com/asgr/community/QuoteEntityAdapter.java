package com.asgr.community;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asgr.community.model.Quote;
import com.asgr.community.support.Persistence;
import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

/**
 * Created by andres on 31/10/17.
 */
public class QuoteEntityAdapter extends RecyclerView.Adapter<QuoteEntityAdapter.ViewHolder> {

    private final Persistence mPersistence;
    private final List<Quote> mQuotes;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textComment;
        private TextView textPunctuation;

        public ViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            textTitle = itemView.findViewById(R.id.texQuoteTitle);
            textComment = itemView.findViewById(R.id.textQuoteCommentValue);
            textPunctuation = itemView.findViewById(R.id.textQuotePunctuationValue);
        }

        public void bindQuote(Quote quote) {
            textTitle.setText(
                    String.format("%s %s", quote.getBook().getName(), quote.getRangeAsStr()));
            textComment.setText(quote.getComment());
            textPunctuation.setText(String.valueOf(quote.getPunctuation()));
        }

    }

    public QuoteEntityAdapter(@Nonnull Persistence persistence) {
        mPersistence = persistence;
        List<Quote> quotes = mPersistence.findQuotes();
        mQuotes = quotes.stream()
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public QuoteEntityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quote_item_layout, parent, false);
        return new QuoteEntityAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bindQuote(mQuotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

}

