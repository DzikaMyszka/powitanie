package com.example.powitanie;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Tu trzymamy elementy z ekranu
    private EditText etName;
    private Button btnGreet;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // ładujemy wygląd ekranu

        // To zostawiamy - żeby tekst nie chował się pod paskiem stanu
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Łączymy zmienne z elementami z XML
        etName = findViewById(R.id.etName);
        btnGreet = findViewById(R.id.btnGreet);
        tvResult = findViewById(R.id.tvResult);

        // Co ma się stać po kliknięciu przycisku
        btnGreet.setOnClickListener(v -> greet());
    }

    // Metoda, która się uruchamia po kliknięciu
    private void greet() {
        // Pobieramy tekst z pola i usuwamy spacje z przodu i z tyłu
        String name = etName.getText().toString().trim();

        // Sprawdzamy czy pole jest puste
        if (name.isEmpty()) {
            // Pokazujemy krótki komunikat
            Toast.makeText(this, R.string.error_empty_name, Toast.LENGTH_SHORT).show();
            return; // kończymy metodę, nic więcej nie robimy
        }

        // Ustawiamy tekst powitania
        tvResult.setText(getString(R.string.greeting, name));
    }
}