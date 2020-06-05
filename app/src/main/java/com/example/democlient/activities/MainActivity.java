package com.example.democlient.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.democlient.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private SharedPreferences mPrefs;

    private EditText userInput;
    private EditText passwordInput;

    private TextView btnClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClient = (TextView) findViewById(R.id.txtRegistrarClient);
        userInput = (EditText) findViewById(R.id.editText3);
        passwordInput = (EditText) findViewById(R.id.editText2);

    }

    public void showRegisterClient(View view){
        Intent intent = new Intent(MainActivity.this, RegisterClientActivity.class);
        startActivity(intent);
    }

    public void Login(View view){

        String user = userInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(user.isEmpty() || password.isEmpty()){
            Toast.makeText(MainActivity.this, "Todos los campos son requeridos" , Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);


        /*
        ApiService service= ApiServiceGenerator.createService(ApiService.class);

        Call<Cliente> call = null;

        call = service.login(dni, password);
        call.enqueue(new Callback<Cliente>() {



            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                try{
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code:" + statusCode);

                    if(response.isSuccessful()){

                        Cliente cliente = response.body();
                        Log.d(TAG, "cliente:" + cliente);
                        Toast.makeText(MainActivity.this, "Bienvenido cliente : "+ cliente.getNombre(), Toast.LENGTH_SHORT).show();
                        mPrefs = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor=mPrefs.edit();
                        editor.putInt("id", cliente.getId_cliente());
                        editor.putString("nombre", cliente.getNombre());
                        editor.putString("correo", cliente.getCorreo());
                        editor.putString("dni", cliente.getDni());
                        editor.putString("direccion", cliente.getDireccion());
                        editor.putString("password", cliente.getPassword());
                        editor.apply();

                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        finish();

                    }else{
                        Log.e(TAG, "onError: "+ response.errorBody().string());
                        throw new Exception("No registrado en la app");
                    }
                }catch (Throwable t){
                    try{
                        Log.e(TAG, "onThrowable:" +t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.e(TAG, "onFailure:" + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }



        });


         */



    }
}
