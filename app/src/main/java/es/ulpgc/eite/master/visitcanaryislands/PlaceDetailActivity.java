package es.ulpgc.eite.master.visitcanaryislands;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import es.ulpgc.eite.master.visitcanaryislands.dummy.PlaceStore;

/**
 * An activity representing a single Place detail screen.
 */
public class PlaceDetailActivity extends AppCompatActivity {

    public static final String PARAM_PLACE_ID = "place_to_visit_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        // Show the Up button in the action bar.
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
        */

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        if (savedInstanceState == null) {

            String placeId = getIntent().getStringExtra(PARAM_PLACE_ID);

            Resources res = getResources();
            List<String> titles = Arrays.asList(res.getStringArray(R.array.places_titles));
            List<String> details = Arrays.asList(res.getStringArray(R.array.places_details));
            List<String> pictures = Arrays.asList(res.getStringArray(R.array.places_pictures));

            PlaceStore places = new PlaceStore(titles, details, pictures);
            PlaceStore.Place place = places.getPlaceById(placeId);

            if (place != null) {
                ActionBar actionbar = getSupportActionBar();
                if (actionbar != null) {
                    actionbar.setTitle(place.title);
                }

                TextView placeDetail = (TextView) findViewById(R.id.place_detail);
                placeDetail.setText(place.details);
                ImageView placePicture = (ImageView) findViewById(R.id.place_picture);

                int resId= getResources().getIdentifier(place.picture, "drawable", getPackageName());
                placePicture.setImageResource(resId);
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown.
            navigateUpTo(new Intent(this, PlaceListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
