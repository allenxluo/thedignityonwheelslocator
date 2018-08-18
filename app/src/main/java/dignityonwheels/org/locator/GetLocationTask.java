package dignityonwheels.org.locator;

import android.os.AsyncTask;
import android.widget.TextView;

public class GetLocationTask extends AsyncTask<Integer, Void, Location> {
    protected Location doInBackground(Integer ... args) {
        return new Location(args[0]);
    }

    protected void onPostExecute(Location result) {
        TextView text;

        for(int i = 0; i < result.getMessage().length; i++) {
            text = (TextView) MainActivity.inflater.inflate(R.layout.fragment_text, MainActivity.schedule.getScheduleLayout(), false);
            text.setText(result.getMessage()[i]);
            MainActivity.schedule.getScheduleLayout().addView(text);
        }
    }
}
