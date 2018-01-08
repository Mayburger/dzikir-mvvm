package com.nacoda.dzikir_mvvm.data.remote;

import android.content.Context;

import com.nacoda.moviesmvvm.data.source.DzikirDataSource;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mayburger on 1/8/18.
 */

public class DzikirRemoteDataSource implements DzikirDataSource {
    @Override
    public void getDzikirList(@NotNull GetDzikirListCallback callback, @NotNull Context mContext) {
        String json = null;
        try {
            InputStream is = mContext.getAssets().open("json/dzikir_list_english.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        callback.onDzikirListLoaded(json);


    }
}
