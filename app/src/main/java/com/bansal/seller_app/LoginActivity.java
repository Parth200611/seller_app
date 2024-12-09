package com.bansal.seller_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText etemail,etpassword;
    AppCompatButton btnLogin;
    CheckBox cbShowpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        getWindow().setNavigationBarColor(ContextCompat.getColor(LoginActivity.this,R.color.white));
        getWindow().setStatusBarColor(ContextCompat.getColor(LoginActivity.this,R.color.white));

        etemail=findViewById(R.id.etLoginEmail);
        etpassword=findViewById(R.id.etLoginPassword);
        btnLogin=findViewById(R.id.btnLogin);
        cbShowpassword=findViewById(R.id.cbShowpassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etemail.getText().toString().isEmpty()){
                    etemail.setError("Enter email");
                }else if (etpassword.getText().toString().isEmpty()){
                    etpassword.setError("Enter password");
                }else{
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                }
            }
        });
        cbShowpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    etpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    etpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }
}