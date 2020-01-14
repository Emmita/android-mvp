package com.example.mvpexample.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpexample.R;
import com.example.mvpexample.alCuadrado.AlCuadradoActivity;
import com.example.mvpexample.sharedPreferences.MySharedPreferences;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private EditText userEditText, passwordEditText;
    private Button buttonLogin;
    private ProgressBar progressBar;
    private LoginContract.Presenter presenter;
    private MySharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        preferences = new MySharedPreferences(this);

        presenter = new LoginPresenterImpl(this, preferences);

        presenter.initCheck();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.validateCredentials(userEditText.getText().toString(), passwordEditText.getText().toString());

            }
        });

    }

    private void initViews(){

        userEditText = (EditText) findViewById(R.id.et_user);
        passwordEditText = (EditText) findViewById(R.id.et_password);
        buttonLogin = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUsernameError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, AlCuadradoActivity.class));
    }

}
