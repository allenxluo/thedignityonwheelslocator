package dignityonwheels.org.locator;

import android.os.AsyncTask;
import android.widget.TextView;

public class GetLocationTask extends AsyncTask<Integer, Void, Location> {
    protected Location doInBackground(Integer ... args) {
        return new Location(args[0]);
    }

    protected void onPostExecute(Location result) {
        for(String s: result.getMessage()) {
            TextView text = (TextView) MainActivity.inflater.inflate(R.layout.fragment_text, null);
            text.setText(s);
            MainActivity.schedule.getScheduleLayout().addView(text);
        }
    }
}
