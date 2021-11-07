package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.bean.ContactInfo;

import java.util.ArrayList;

public class TodoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<ContactInfo> data;

    public TodoListAdapter(Context inContext, ArrayList<ContactInfo> inData) {
        context = inContext;
        data = inData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.todo_card_view, parent, false);

        return new TodoListCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TodoListCardHolder todoListCardHolder = (TodoListCardHolder) holder;
        todoListCardHolder.myTextView.setText(data.get(position).getTime());
        todoListCardHolder.myCheckTextView.setText(data.get(position).getTodoContent());
        // TODO
        todoListCardHolder.myImageButton.setOnClickListener(new View.OnClickListener() {
            private static final String TAG = "my android debug";

            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: i have clicked the view");
            }
        });

        todoListCardHolder.myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView textView = todoListCardHolder.myCheckTextView;
                if (isChecked) {
                    textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    textView.setPaintFlags(textView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TodoListCardHolder extends RecyclerView.ViewHolder {
        public CardView myCardView;
        public CheckBox myCheckBox;
        public TextView myCheckTextView;
        public TextView myTextView;
        public ImageButton myImageButton;

        public TodoListCardHolder(@NonNull View itemView) {
            super(itemView);

            myCardView = (CardView) itemView.findViewById(R.id.cardView);
            myCheckBox = (CheckBox) itemView.findViewById(R.id.todoCheckBox);
            myTextView = (TextView) itemView.findViewById(R.id.Time_TextView);
            myCheckTextView = (TextView) itemView.findViewById(R.id.check_TextView);
            myImageButton = (ImageButton) itemView.findViewById(R.id.deleteButton);
        }
    }
}
