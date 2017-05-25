package upmc.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.view.*;

public class MainActivity extends AppCompatActivity {
    //Constant to identify the Intent
    public final static String EXTRA_MESSAGE = "upmc.request.MESSAGE";

    private EditText editText;


    //standard onCreate method
    //linking the activity_main layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);                   // association avec une vue
            editText = (EditText) findViewById(R.id.edit_message);        //récupération de l'EditText grâce à son ID
                                                                        //récupération du bouton grâce à son ID
        }
    }

    //sendMessage is the callback called by a click onto the Button 'send'
    public void sendMessage(View view) {
        //get the edit_message EditText object
        // EditText editText = ??
        EditText editText = (EditText) findViewById(R.id.edit_message);

        //get its user's message (artist name request)
        // String message = ??
        String message = editText.getText().toString();

        //Create the explicit intent (to start DisplayMessageActivity activity)
        // Intent intent = ??
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        //add an extra (the message)
        // intent.??
        intent.putExtra(EXTRA_MESSAGE, message);

        //start activity !
        // ??
        startActivity(intent);
    }
}
