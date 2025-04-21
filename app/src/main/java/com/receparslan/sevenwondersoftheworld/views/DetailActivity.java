package com.receparslan.sevenwondersoftheworld.views;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.receparslan.sevenwondersoftheworld.R;
import com.receparslan.sevenwondersoftheworld.databinding.ActivityDetailBinding;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding; // View Binding

    // Properties of the wonder
    ImageView wonderImageView;
    TextView nameTextView, countryTextView, informationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set the custom action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        // Inflate the layout for this activity
        wonderImageView = binding.wonderImageView;
        nameTextView = binding.nameTextView;
        countryTextView = binding.countryTextView;
        informationTextView = binding.informationTextView;

        // Set the properties of the information TextView
        informationTextView.setMovementMethod(new ScrollingMovementMethod()); // Set the movement method for the TextView
        String info = "<p align=\"justify\">" + informationTextView.getText().toString();
        informationTextView.setText(info);

        // Set the wonder's properties
        Intent intent = getIntent();
        wonderImageView.setImageResource(intent.getIntExtra("wonderImage", 0));
        nameTextView.setText(intent.getStringExtra("wonderName"));
        countryTextView.setText(intent.getStringExtra("wonderCountry"));
        informationTextView.setText(intent.getStringExtra("wonderInformation"));
    }
}