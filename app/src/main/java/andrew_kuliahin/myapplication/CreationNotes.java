package andrew_kuliahin.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreationNotes extends AppCompatActivity {

    public String note_category;
    public String note_date;

    String[] data = {"без категории", "категория 1", "категория 2", "категория 3", "категория 4", "категория 5"};

    public void onInfo2Click(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(CreationNotes.this);
        Info info = new Info(builder);
    }

    public void onCloseClick(View v){
        finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_notes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        TextView dateout = (TextView)findViewById(R.id.date_out);
        dateout.setText("Новая запись    " + format1.format(d));
        note_date = d.toString();

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



