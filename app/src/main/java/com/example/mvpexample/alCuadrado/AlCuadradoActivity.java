package com.example.mvpexample.alCuadrado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvpexample.R;
import com.example.mvpexample.recycler.RVActivity;
import com.example.mvpexample.sharedPreferences.MySharedPreferences;

public class AlCuadradoActivity extends AppCompatActivity implements AlCuadradoContract.View {

    private EditText editTextNumber;
    private Button button, buttonIntent;
    private TextView textView;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private AlCuadradoContract.Presenter presenter;
    private MySharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_cuadrado);

        initViews();

        preferences = new MySharedPreferences(this);

        presenter = new AlCuadradoPresenterImpl(this, preferences);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.doSquare(editTextNumber.getText().toString());

            }
        });

        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlCuadradoActivity.this, RVActivity.class));
            }
        });

    }

    private void initViews(){

        editTextNumber = (EditText) findViewById(R.id.et_number);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        buttonIntent = (Button) findViewById(R.id.buttonIntent);

    }

    private void dialogLogOut(){

        builder = new AlertDialog.Builder(this);

        builder.setMessage("Seguro que desea cerrar sesion?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Método de presenter
                        presenter.logOut();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        dialog = builder.create();

        dialog.show();

    }

    @Override
    public void showResult(String result) {

        textView.setText(result);

    }

    @Override
    public void showError(String error) {

        textView.setText(error);

    }

    @Override
    public void onBackPressed() {

        dialogLogOut();

    }
}
