package io.github.dnivra26.kulirandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.github.dnivra26.kulirandroid.rest.CloudService;
import retrofit.ResponseCallback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.alarm_timepicker)
    TimePicker eventTimePicker;

    @ViewById(R.id.temperature_spinner)
    Spinner temperatureSpinner;

    @ViewById(R.id.create_button)
    Button createButton;

    CloudService cloudService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cloudService = new CloudService();
    }

    @AfterViews
    public void init() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperatureSpinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Click(R.id.create_button)
    public void createAlarm() {
        String temperature = temperatureSpinner.getSelectedItem().toString();
        int temperatureInDegree = Util.getTemperatureInDegree(temperature);
        int hour = eventTimePicker.getCurrentHour();
        int minute = eventTimePicker.getCurrentMinute();
        Alarm alarm = new Alarm(temperatureInDegree, hour, minute);
        cloudService.createAlarm(alarm, new ResponseCallback() {
            @Override
            public void success(Response response) {
                Toast.makeText(MainActivity.this, "Alarm Created Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
