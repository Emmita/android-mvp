package com.example.mvpexample.alCuadrado;

public interface AlCuadradoContract {

    interface View{

        void showResult(String result);
        void showError(String error);


    }

    interface Presenter{

        void showResult(String result);
        void showError(String error);
        void doSquare(String number);
        void logOut();

    }

    interface Interactor{

        void doSquare(String number);
        void logOut();

    }

}
