package com.asgr.community;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asgr.community.model.Book;
import com.google.common.collect.ImmutableList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andres on 31/10/17.
 */
public class BookEntityAdapter extends RecyclerView.Adapter<BookEntityAdapter.ViewHolder> {

    private final List<Book> mBooks;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.texBooktTitle)
        TextView textName;

        @BindView(R.id.textBookAbbreviation)
        TextView textAbbreviation;

        @BindView(R.id.textBookTestament)
        TextView textTestament;

        public ViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            ButterKnife.bind(this, viewGroup);
        }

        public void bindBook(Book book) {
            textName.setText(book.getName());
            textAbbreviation.setText(book.getAbbreviation());
            textTestament.setText(book.getTestament().name());
        }

    }

    public BookEntityAdapter(List<Book> books) {
        mBooks = ImmutableList.copyOf(books);
    }

    @Override
    public BookEntityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item_layout, parent, false);
        return new BookEntityAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BookEntityAdapter.ViewHolder holder, int position) {
        holder.bindBook(mBooks.get(position));
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

}
