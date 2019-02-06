package com.ttekobra.sparkresume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView final_activity_finish,final_activity_donate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        final_activity_donate = findViewById(R.id.final_activity_donate);
        final_activity_finish = findViewById(R.id.final_activity_finish);

        final_activity_donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalActivity.this, WelcomeActivity.class);
                intent.putExtra("key", "Donation");
                startActivity(intent);
                finish();
            }
        });
        final_activity_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
