package com.picassoimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.picassoimage.databinding.ActivityMainBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editText = binding.editText;
        imageView = binding.imageView;
        Picasso.get().load(R.drawable.ic_launcher_background).into(imageView);

        editText.setOnEditorActionListener((textView, i, keyEvent) -> {
            String url = editText.getText().toString();
            Picasso.get().load(url).into(imageView, new PicassoCallback());
            return true;
        });

    }

    private class PicassoCallback implements Callback {

        @Override
        public void onSuccess() {
            Toast.makeText(getApplicationContext(), "Image loaded", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(Exception e) {
            Toast.makeText(getApplicationContext(), "Failed to load image", Toast.LENGTH_LONG).show();
        }
    }
}