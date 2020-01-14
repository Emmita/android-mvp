package com.example.mvpexample.recycler;

import com.example.mvpexample.database.UserDatabase;
import com.example.mvpexample.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecyclerInteractorImpl implements RecyclerContract.Interactor {

    private RecyclerContract.Presenter presenter;
    private List<User> users;
    private UserDatabase database;

    public RecyclerInteractorImpl(RecyclerContract.Presenter presenter, UserDatabase database){
        this.presenter = presenter;
        this.database = database;
    }

    @Override
    public void initRecycler() {

      //users = new ArrayList<>();
      //users.add(new User("Lalo", 23, "Los Ramirez"));
      //users.add(new User("Pedro", 45, "Los Conde"));
      //users.add(new User("Jorge", 24, "Los Picaso"));
      //users.add(new User("Alba", 10, "Sabanilla"));
      //users.add(new User("Jesus", 23, "La Luz"));

      //presenter.initRecycler(users);

    }

    @Override
    public void insertUser(User user) {

        database.getUserDAO().addUser(user);

    }

    @Override
    public void getUsers() {

        database.getUserDAO().getAllUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> userList) {

                        presenter.getUsers(userList);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
