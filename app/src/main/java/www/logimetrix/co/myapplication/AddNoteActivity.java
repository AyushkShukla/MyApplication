package www.logimetrix.co.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.app.Activity.RESULT_OK;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =
            "www.logimetrix.co.myapplication.EXTRA_TITLE";

    public static final String EXTRA_DESCRIPTION =
            "www.logimetrix.co.myapplication.EXTRA_DESCRIPTION";

    public static final String EXTRA_PRIORITY =
            "www.logimetrix.co.myapplication.EXTRA_PRIORITY";

    private EditText edit_text_title, edit_text_description;
    private NumberPicker number_picker_priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        edit_text_title = findViewById(R.id.edit_text_title);
        edit_text_description = findViewById(R.id.edit_text_description);
        number_picker_priority = findViewById(R.id.number_picker_priority);

        number_picker_priority.setMinValue(1);
        number_picker_priority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title = edit_text_title.getText().toString();
        String description = edit_text_description.getText().toString();
        int priority = number_picker_priority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_DESCRIPTION, description);
        intent.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, intent);
        finish();
    }
}
