package com.example.laba2;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Spinner countOptionsSpinner;
    private EditText inputEditText;
    private Button buttonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputEditText = findViewById(R.id.inputEditText);
        this.resultTextView = findViewById(R.id.resultTextView);
        this.countOptionsSpinner = findViewById(R.id.countOptionsSpinner);
        this.buttonCount = findViewById(R.id.button2);
        setSpinner();

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countWordsOrChars();
            }
        });
    }

    private void setSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countOptionsSpinner.setAdapter(adapter);
    }

    public void countWordsOrChars() {
        String inputText = this.inputEditText.getText().toString().trim();

        if (inputText.isEmpty()) {
            showToast(getString(R.string.empty_string_warning));
            return;
        }

        String selectedOption = countOptionsSpinner.getSelectedItem().toString();
        Counter counter = new Counter();
        int count;

        if (selectedOption.equals("Words")) {
            count = counter.countWords(inputText);
        } else {
            count = counter.countCharacters(inputText);
        }

        String resultText = count + " " + selectedOption;
        this.resultTextView.setText(resultText);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
