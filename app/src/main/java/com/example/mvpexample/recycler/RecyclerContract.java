package com.example.mvpexample.recycler;

import com.example.mvpexample.model.User;

import java.util.List;

public interface RecyclerContract {


    interface View{

        void initRecycler(List<User> users);
        void getUsers(List<User> userList);

    }

    interface Presenter{

        void initRecycler(List<User> users);
        void insertUser(User user);
        void getUsers(List<User> userList);
        void setUpUserList();

    }

    interface Interactor{

        void initRecycler();
        void insertUser(User user);
        void getUsers();

    }

}
