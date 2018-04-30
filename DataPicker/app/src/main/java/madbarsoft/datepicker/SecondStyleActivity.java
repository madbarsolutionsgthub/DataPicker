package madbarsoft.datepicker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SecondStyleActivity extends Activity implements View.OnClickListener{

    EditText dateText;
    DatePickerDialog datePickerDialog;
    Calendar dateCalendar;
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_style);
        createObject();
        dateText.setOnClickListener(this);


    }

    public void createObject(){
        dateText = (EditText)findViewById(R.id.dateHolder);
        Calendar newCalender = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateCalendar = Calendar.getInstance();
                dateCalendar.set(year, month, dayOfMonth);

                dateText.setText(format.format(dateCalendar.getTime()));
            }
        }, newCalender.get(Calendar.YEAR), newCalender.get(Calendar.MONTH), newCalender.get(Calendar.DAY_OF_MONTH));
    }



    @Override
    public void onClick(View v) {
        datePickerDialog.show();
      //  Toast.makeText(getApplicationContext(), "Toast message!",Toast.LENGTH_SHORT).show();
    }



    public void goToHome(View view){
        Intent intent = new Intent(SecondStyleActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
