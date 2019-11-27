package com.example.project311;

import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class Global {

    public static RecordList records = new RecordList();
    public static RecordController recordc = new RecordController();
}
