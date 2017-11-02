package com.asgr.community;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asgr.community.model.Book;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by andres on 31/10/17.
 */
public class BookEntityAdapter extends RecyclerView.Adapter<BookEntityAdapter.ViewHolder> {

    private final List<Book> mBooks;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textName;
        private TextView textAbbreviation;
        private TextView textTestament;

        public ViewHolder(ViewGroup v) {
            super(v);
            textName = itemView.findViewById(R.id.texBooktTitle);
            textAbbreviation = itemView.findViewById(R.id.textBookAbbreviation);
            textTestament = itemView.findViewById(R.id.textBookTestament);
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
