package com.lowell.girlswhocode.main;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by johnnychan on 4/20/16.
 */
public class Utils {

    public static void showMessage(Context context, String message) {
        if (context == null)
            return;

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
