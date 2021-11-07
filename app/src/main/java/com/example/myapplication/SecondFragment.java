package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.TodoListAdapter;
import com.example.myapplication.bean.ContactInfo;
import com.example.myapplication.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private CardView listCardView;
    private LinearLayout todoListLayout;

    private ArrayList<ContactInfo> arrayListMo;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void generate() {
        for (Integer i = 0; i < 10; i++) {
            ContactInfo c = new ContactInfo(false,"test"+ i.toString(),"test2" + i.toString());
            arrayListMo.add(c);
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayListMo = new ArrayList<>();
        generate();

        RecyclerView mRv = (RecyclerView) getActivity().findViewById(R.id.list_recyclerview);
        //线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);

        TodoListAdapter adapter = new TodoListAdapter(getActivity(), arrayListMo);
        mRv.setAdapter(adapter);

        // cardView
//        listCardView = (CardView) getActivity().findViewById(R.id.cardView);

        // get todoPage layout
//        todoListLayout = (LinearLayout) getActivity().findViewById(R.id.todoList_layout);
//        todoListLayout.addView(listCardView);

//        for (int i = 0; i < 10; i++) {
//            todoListLayout.addView(listCardView);
//        }

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}