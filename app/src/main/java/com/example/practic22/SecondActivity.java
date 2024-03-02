package com.example.practic22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle image = getIntent().getExtras();
        ImageView imageView = findViewById(R.id.cat_img);
        int imageResource = image.getInt("image");
        imageView.setImageResource(imageResource);
        Button backButton = findViewById(R.id.choice1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("image", imageResource);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}