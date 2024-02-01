package com.example.quickcash.ui.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quickcash.MainActivity;
import com.example.quickcash.databinding.ActivityLoginBinding;
import com.example.quickcash.R;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Button LoginButton = findViewById(R.id.Sign_In_Request);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Toast.makeText(LoginActivity.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                Intent RIntent = new Intent(getBaseContext() , MainActivity.class);
                startActivity(RIntent);

            }
        });
    }
}
