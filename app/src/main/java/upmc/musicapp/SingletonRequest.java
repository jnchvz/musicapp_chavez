package upmc.musicapp;

/**
 * Created by Janeth on 24/05/2017.
 */

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonRequest {
    //static var of the unique instance
    // ?? ?? ?? mInstance;

    //fields
    // mRequestQueue;             // the queue of requests
    private static Context mCtx;  // need a context to initialize the queue

    //Constructor ! (need a context)
    private SingletonRequest(Context context) {
        //init the context and the Request queue [method]
    }

    //for us the synchronized doesnt matter but is required for multi access
    //see design pattern courses
    public static synchronized SingletonRequest getInstance(Context context) {
      /*
        Singleton code
      */
    }

    //gets the Volley's Request Queue
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // Note: Caution use mCtx.getApplicationContext()
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            // mRequestQueue = // ??
        }
        return mRequestQueue;
    }

    //adds a request to the queue
    public <T> void addToRequestQueue(Request<T> req) {
        // add the request into the queue (that may be null)
    }
}