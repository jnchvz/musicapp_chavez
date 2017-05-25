package upmc.musicapp;

/**
 * Created by Janeth on 24/05/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import upmc.musicapp.pojos.Release;

public class DisplayMessageActivity extends AppCompatActivity {

    //Reference to the unique Volley's Request Queue [Singleton]
    SingletonRequest queue;

    //References to the messageView and editMessage (for future requests and answers)
    TextView messageView;
    EditText editMessage;

    //Constant to create the URL request (musicbrainz API)
    static String ARTIST_URL_PREFIX = "https://musicbrainz.org/ws/2/release?query=artist:";
    static String ARTIST_URL_SUFFIX = "&fmt=json&inc=release-groups";
    // release (store answers history)
    LinearLayout releaseLayout;

    //standard onCreate method (called by MainActivity via the Intent)
    //linking the activity_display_message layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //init mother class and view
        super.onCreate(savedInstanceState);
        // ??
        // ??

        //set messageView and editMessage (display_message and modify_message ids)
        // messageView = ??
        // editMessage = ??

        setContentView(R.layout.activity_display_message);
        messageView = (TextView) findViewById(R.id.display_message);
        editMessage = (EditText) findViewById(R.id.edit_message);

        //set releaseLayout (releases_list id)
        // releaseLayout = ??

        //get the unique Volley's Request Queue instance
        // queue = // ??

        //request the user artist
        loadMusicDataFromIntent();
    }

    // loadMusicDataFromIntent gets the intent's extra, sends the request and displays the answer
    private void loadMusicDataFromIntent() {
        // Get the intent
        // Intent intent = // ??

        //get the message from the intent
        // String mbid = intent. //??

        //load
        loadMusicData(mbid);
        //and display :)
        displayMessage(mbid);
    }

    //displays the message
    private void displayMessage(String msg) {
        messageView.setTextSize(40);
        //sets the answer into the messageView text
        // messageView.//??
    }

    //sendMessage is the callback called by a click onto the Button 'modify'
    public void modifyMessage(View view) {
        String message = editMessage.getText().toString();
        displayMessage(message);
    }

    //Creates the StringRequest (Volley) and adds it to the queue
    private void loadMusicData(String mbid) {
        //create the complete url
        String request_url_api = make_artist_URL(mbid);

        //creates the request
        //note 4 arguments (use private class for answer's handlers)
        // StringRequest request = // ??

        //adds it into the queue
        //queue.//??
    }

    private String make_artist_URL(String mbid) {
        return ARTIST_URL_PREFIX + mbid + ARTIST_URL_SUFFIX;
    }

    //Private class to handle the Volley's Request answers (callback)
    // handle normal answers
    private class ReleaseRequestListener implements Response.Listener<String> {

        @Override
        public void onResponse(String response) {
            try {
                Log.d("ApiReader", "response ok: " + response);
                ArrayList<Release> releases = Release.releasesFromJSON(response);
                releaseLayout.removeAllViews();
                for(Release release: releases) {
                    TextView releaseView = new TextView(DisplayMessageActivity.this);
                    releaseView.setText(release.getTitle());
                    releaseLayout.addView(releaseView);
                }
            }
            catch (Exception e) {
                Log.e("ApiReader",e.toString());
            }
        }
    }

    //Private class to handle the Volley's Request answers (callback)
    // handle erroneous answers
    private class ReleaseRequestErrorListener implements Response.ErrorListener {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("ApiReader", error.toString());
        }
    }
}

