package andrew_kuliahin.myapplication;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreationNotes extends AppCompatActivity {

    public String note_category;
    public String note_date;
    DatabaseHelper sqlHelper;
    EditText etNote;



    String[] data = {"без категории", "праздник", "категория 2", "категория 3", "категория 4", "категория 5"};

    public void onInfo2Click(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(CreationNotes.this);
        Info info = new Info(builder);
    }

    public void onCloseClick(View v){
        finish();
    }

    protected void hideInputMethod(EditText ed) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(ed.getWindowToken(), 0);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_notes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etNote = (EditText) findViewById(R.id.editText);
        sqlHelper = new DatabaseHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed = (EditText) findViewById(R.id.editText);
                String ed_text = ed.getText().toString();

                if(ed_text.length() == 0 ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreationNotes.this);
                    Empty empty = new Empty(builder);
                }
                else {
                    hideInputMethod(ed);

                        String name = etNote.getText().toString();
                        SQLiteDatabase database = sqlHelper.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(DatabaseHelper.COLUMN_NOTE, name);
                        contentValues.put(DatabaseHelper.COLUMN_DATECATEGORY, note_date + "                         " + note_category);
                        database.insert(DatabaseHelper.TABLE, null, contentValues);
                        sqlHelper.close();

                    finish();
                }
            }
        });

        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yy  HH:mm");
        TextView dateout = (TextView)findViewById(R.id.date_out);
        dateout.setText("Новая запись      " + format1.format(d));
        note_date = format1.format(d).toString();

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        // выделяем элемент
        spinner.setSelection(0);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                TextView category = (TextView)findViewById(R.id.category);
                category.setText(spinner.getSelectedItem().toString());
                note_category = spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        }

    }



