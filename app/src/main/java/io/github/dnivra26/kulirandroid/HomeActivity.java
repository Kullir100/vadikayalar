package io.github.dnivra26.kulirandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import io.github.dnivra26.kulirandroid.rest.CloudService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity {

    @ViewById(R.id.event_list)
    ListView eventList;

    @ViewById(R.id.add_new_event)
    FloatingActionButton floatingActionButton;

    List<Alarm> alarmList = new ArrayList<>();

    ArrayAdapter<Alarm> alarmArrayAdapter;

    CloudService cloudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cloudService = new CloudService();
    }

    @AfterViews
    public void init() {
        alarmArrayAdapter = new AlarmArrayAdapter(this, alarmList);
        eventList.setAdapter(alarmArrayAdapter);

        cloudService.getEvents(Util.getDeviceId(this), new Callback<Alarm>() {
            @Override
            public void success(Alarm alarm, Response response) {
                alarmList.add(alarm);
                alarmArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(HomeActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Click(R.id.add_new_event)
    public void addEvent() {
        startActivity(new Intent(this, MainActivity_.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
