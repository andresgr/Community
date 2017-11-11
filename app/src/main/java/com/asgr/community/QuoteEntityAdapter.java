package com.asgr.community;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asgr.community.model.Quote;
import com.asgr.community.support.Persistence;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andres on 31/10/17.
 */
public class QuoteEntityAdapter extends RecyclerView.Adapter<QuoteEntityAdapter.ViewHolder> {

    private final Persistence mPersistence;
    private final List<Quote> mQuotes;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.texQuoteTitle)
        TextView textTitle;

        @BindView(R.id.textQuoteCommentValue)
        TextView textComment;

        @BindView(R.id.textQuotePunctuationValue)
        TextView textPunctuation;

        public ViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            ButterKnife.bind(this, viewGroup);
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
        mQuotes = buildQuoteList();
    }

    private List<Quote> buildQuoteList() {
        List<Quote> quotes = mPersistence.findQuotes();
        return quotes.stream()
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

    public void refresh() {
        List<Quote> newQuotes = buildQuoteList();
        QuoteDiffCallback diffCallback = new QuoteDiffCallback(mQuotes, newQuotes);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        mQuotes.clear();
        mQuotes.addAll(newQuotes);
        diffResult.dispatchUpdatesTo(this);
    }

    public void onQuoteAdded(Quote quote) {
        mQuotes.add(quote);
        Collections.sort(mQuotes);
        notifyItemInserted(mQuotes.indexOf(quote));
    }

}

