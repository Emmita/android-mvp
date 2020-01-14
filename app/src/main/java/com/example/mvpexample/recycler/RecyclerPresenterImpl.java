package com.example.mvpexample.recycler;

import com.example.mvpexample.database.UserDatabase;
import com.example.mvpexample.model.User;

import java.util.List;

public class RecyclerPresenterImpl implements RecyclerContract.Presenter {

    private RecyclerContract.View view;
    private RecyclerContract.Interactor interactor;

    public RecyclerPresenterImpl(RecyclerContract.View view, UserDatabase database){
        this.view = view;
        this.interactor = new RecyclerInteractorImpl(this, database);
    }

    @Override
    public void initRecycler(List<User> users) {

        if (view != null){
            view.initRecycler(users);
        }

    }

    @Override
    public void insertUser(User user) {

        interactor.insertUser(user);

    }

    @Override
    public void getUsers(List<User> userList) {

        view.getUsers(userList);

    }

    @Override
    public void setUpUserList() {

        interactor.getUsers();

    }
}
