package com.example.mvpexample.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;

import com.example.mvpexample.R;
import com.example.mvpexample.adapters.UserAdapter;
import com.example.mvpexample.database.UserDatabase;
import com.example.mvpexample.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RVActivity extends AppCompatActivity implements RecyclerContract.View {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private RecyclerContract.Presenter presenter;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        presenter = new RecyclerPresenterImpl(this, UserDatabase.getDatabase(this));
//        presenter.setUpUserList();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.insertUser(new User(0, "Jesus", 2, "La Luz"));
            }
        });

    }

    @Override
    public void initRecycler(List<User> users) {

        //adapter = new UserAdapter(users);
        //recyclerView.setAdapter(adapter);

    }

    @Override
    public void getUsers(List<User> userList) {

        adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);

    }
}
