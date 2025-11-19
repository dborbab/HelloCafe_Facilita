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

import okhttp3.ResponseBody;
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
                Log.d("CLICK", "clicandooo");
                register();
            }
        });
    }

    private void register() {

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("name", edtName.getText().toString())
                .addFormDataPart("email", edtEmail.getText().toString())
                .addFormDataPart("password", edtPassword.getText().toString())
                .addFormDataPart("phone", edtPhone.getText().toString())
                .addFormDataPart("confirm-password", edtPassword.getText().toString())
                .addFormDataPart("role", "owner")
                .build();

        Call<ResponseBody> call = RetrofitClient.getInstance().getMyApi().register(requestBody);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Register.this, "Conta criada com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Log.e("API_ERROR", "" + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("API_ERROR", "" + t.getMessage());
            }
        });
    }


}
