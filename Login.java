package com.example.facilita;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText etEmail, etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmailLog);
        etSenha = findViewById(R.id.etSenha);
        Button btnLogar = findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Login.this, HomeActivity.class);
                startActivity(it);
            }
        });
    }

    private void login() {

        //só muda isto, o restante é igual
        Call<ResponseBody> call = RetrofitClient.getInstance().getMyApi().login(etEmail.toString(), "12345");

        //a chamada é igual ao método loginWithPost, poderia ser substituida por um método
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<User> response) {
                User user1 = response.body();


                Log.d("TAG", "onResponse: " + user1);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
                Log.e("TESTE", t.toString());
            }
        });

    }

}
