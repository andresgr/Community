package com.asgr.community;

import android.support.v7.util.DiffUtil;

import com.asgr.community.model.Quote;

import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by andres on 5/11/17.
 */

@RequiredArgsConstructor
public class QuoteDiffCallback extends DiffUtil.Callback {

    @NonNull private final List<Quote> mOldQuotes;
    @NonNull private final List<Quote> mNewQuotes;

    @Override
    public int getOldListSize() {
        return mOldQuotes.size();
    }

    @Override
    public int getNewListSize() {
        return mNewQuotes.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Quote oldQuote = mOldQuotes.get(oldItemPosition);
        Quote newQuote = mNewQuotes.get(newItemPosition);
        return oldQuote.getId() == newQuote.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Quote oldQuote = mOldQuotes.get(oldItemPosition);
        Quote newQuote = mNewQuotes.get(newItemPosition);
        return oldQuote.equals(newQuote);
    }

}
