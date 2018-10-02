package com.example.desarrollo.recyclerviewdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends SingleFragment {


    @Override
    protected Fragment createFragment() {
        return new Recycler_Fragment().newInstance();
    }
}
