package io.github.dnivra26.kulirandroid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AlarmArrayAdapter extends ArrayAdapter<Alarm> {

    List<Alarm> alarms;
    Activity activity;


    public AlarmArrayAdapter(Context context, List<Alarm> objects) {
        super(context, R.layout.layout_event_row, objects);
        this.alarms = objects;
        this.activity = (Activity) context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater layoutInflater = activity.getLayoutInflater();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_event_row, parent, false);
        }
        TextView eventTime = (TextView) convertView.findViewById(R.id.event_time);
        TextView eventTemperature = (TextView) convertView.findViewById(R.id.event_temperature);
        Alarm alarm = alarms.get(position);
        eventTime.setText(alarm.getHour() + " : " + alarm.getMinute());
        eventTemperature.setText(alarm.getTemperature() + " C");
        return convertView;
    }
}
