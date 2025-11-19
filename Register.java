package com.example.facilita;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import com.example.facilita.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText edtName, edtEmail, edtPassword, edtPhone;
    Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.etNome);
        edtEmail = findViewById(R.id.etEmail);
        edtPassword = findViewById(R.id.etSenha);
        edtPhone = findViewById(R.id.etTelNum);
        btnCadastro = findViewById(R.id.botaoCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TESTE", "Clique detectado");
                register();   // 👉 AGORA O MÉTODO É CHAMADO
            }
        });
    }

    private void register() {

        User user = new User();
        user.setName(edtName.getText().toString());
        user.setEmail(edtEmail.getText().toString());
        user.setPassword(edtPassword.getText().toString());
        user.setPhone(edtPhone.getText().toString());

        Call<UserResponse> call = RetrofitClient.getInstance().getMyApi().register(user);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    Log.d("API", "Usuário cadastrado!");
                } else {
                    Log.e("API_ERROR", "Erro HTTP: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("API_ERROR", "Falha: " + t.getMessage());
            }
        });
    }

}
