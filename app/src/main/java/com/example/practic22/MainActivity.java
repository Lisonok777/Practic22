package com.example.practic22;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.practic22.databinding.ConstraintLayoutBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayoutBinding binding = ConstraintLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buyTicket.setText(getString(R.string.milo));
        binding.imgCat3.setImageResource(R.drawable.cat);
        binding.buyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("image", R.drawable.cat);
                start.launch(intent);
                //Log.d("MyTag", "Кнопка была нажата!");
            }

            ActivityResultLauncher<Intent> start = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            Bundle image = result.getData().getExtras();
                            ImageView imageView = findViewById(R.id.image);
                            int imageResource = image.getInt("image");
                            imageView.setImageResource(imageResource);
                        }
                    });
        });
    }
}