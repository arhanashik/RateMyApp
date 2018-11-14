package com.blackspider.util;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/14/2018 at 11:59 AM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/14/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.blackspider.ratemyapp.R;

public class PlayStoreLink {

    public static void checkForUpdate(Context context, String applicationId) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context.getString(R.string.url_market_details)
                            + applicationId)));
        } catch (android.content.ActivityNotFoundException ex) {
            try {
                context.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(context.getString(R.string.url_playstore_app)
                                + applicationId)));
            } catch (Exception e) {
                Toast.makeText(context,
                        R.string.install_google_play_store,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void showMoreApps(Context context, @StringRes int devName) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context.getString(R.string.url_market_search_app)
                            + context.getString(devName))));
        } catch (android.content.ActivityNotFoundException ex) {
            try {
                context.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(context.getString(R.string.url_playstore_search_app)
                                + context.getString(devName))));
            } catch (Exception e) {
                Toast.makeText(context,
                        R.string.install_google_play_store,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void rateMyApp(Context context, String applicationId) {
        try {
            Uri uri = Uri.parse(context.getString(R.string.url_market_details)
                    + applicationId);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH)
                flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
            else
                flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
            intent.addFlags(flags);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            checkForUpdate(context, applicationId);
        }
    }
}
