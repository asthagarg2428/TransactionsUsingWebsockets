package com.example.websocket_blockchain_demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class BlockchainCommonUtil {

    public static final String APP_TAG = "TEST_LOG";
    public static final String CONNECTION_FAILURE = "Failure";
    public static final String CONNECTION_DISCONNECTED = "Disconnected";
    public static final String CONNECTION_CONNECTING = "Connecting";
    public static final String CONNECTION_CONNECTED = "Connected";
    public static final int NORMAL_CLOSURE_STATUS = 1000;
    public static final int MAX_COUNT = 5;

    public static String getTimeInString(long timeInMs) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a +05:30", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("IST"));
        return df.format(new Date(timeInMs * 1000));
    }
}
