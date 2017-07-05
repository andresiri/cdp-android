package br.andre.cdp.cdp_android.support;

import android.content.Context;

/**
 * Created by helio on 7/4/17.
 */

public class Support {

    public static String getStringResourceByName(Context context, String aString) {
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(aString, "string", packageName);
        return context.getString(resId);
    }

}
