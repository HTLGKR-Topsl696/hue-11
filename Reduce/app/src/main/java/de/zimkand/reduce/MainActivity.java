package de.zimkand.reduce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText etZaehler = findViewById(R.id.zaehler);
        EditText etNenner = findViewById(R.id.nenner);
        try {
            int zaehler = Integer.parseInt(etZaehler.getText().toString());
            int nenner = Integer.parseInt(etNenner.getText().toString());
            int ggT = ggT(zaehler, nenner);
            etZaehler.setText(String.valueOf(zaehler / ggT));
            etNenner.setText(String.valueOf(nenner / ggT));
        } catch (NumberFormatException e) {}
    }

    private int ggT(int a, int b) {
        // Beispiel: ggT(6, 8)
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            // 2. Iteration: a = 6, b = 2
            // 3. Iteration: a = 4, b = 2
            // 4. Iteration: a = 2, b = 2
            // 5. Iteration: a = 2, b = 0
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        // return 2;
        return a;
    }
}