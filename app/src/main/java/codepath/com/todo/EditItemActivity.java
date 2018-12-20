package codepath.com.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String oldText = getIntent().getStringExtra("oldItem");
        position = getIntent().getIntExtra("position", -1);

        // set text to old text
        EditText etNewItem = findViewById(R.id.editText1);

        //put cursor at the end of text
        etNewItem.setText(oldText);
        Editable etext = etNewItem.getText();
        Selection.setSelection(etext, oldText.length());
    }

    public void changeToDoItem(View v) {
        EditText etNewItem = findViewById(R.id.editText1);
        Intent data = new Intent();
        data.putExtra("newItem", etNewItem.getText().toString());
        data.putExtra("position", position);;
        setResult(RESULT_OK, data);
        finish();
    }
}
