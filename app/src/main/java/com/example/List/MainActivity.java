package com.example.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter();

        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        RecyclerView rv = findViewById(R.id.wordList_recyclerView);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private WordItem[] items = {
            new WordItem(R.drawable.thai, "วิชาที่ 1","ภาษาไทย"),
            new WordItem(R.drawable.eng, "วิชาที่ 2","ภาษาอังกฤษ"),
            new WordItem(R.drawable.sport, "วิชาที่ 3","พละศึกษา"),
            new WordItem(R.drawable.music, "วิชาที่ 4","ดนตรี"),
            new WordItem(R.drawable.art, "วิชาที่ 5","ศิลปะ"),
            new WordItem(R.drawable.math, "วิชาที่ 6","คณิตศาสตร์"),
            new WordItem(R.drawable.came, "วิชาที่ 7","เคมี"),
            new WordItem(R.drawable.sh, "วิชาที่ 8","ชีววิทยา"),
            new WordItem(R.drawable.phy, "วิชาที่ 9","ฟิสิกส์"),
            new WordItem(R.drawable.t, "วิชาที่ 10","สังคมศึกษา")
    };


    public MyAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_word, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(items[position].imageResId);
        holder.wordTextView.setText(items[position].word);
        holder.wordTextView2.setText(items[position].word2);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView wordTextView;
        TextView wordTextView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            wordTextView = itemView.findViewById(R.id.word_text_view);
            wordTextView2 = itemView.findViewById(R.id.word_text_view2);
        }
    }
}
