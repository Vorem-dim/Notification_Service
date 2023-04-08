package com.example.pizzaandsushi.ViewModels;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.lifecycle.ViewModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageViewPattern extends ViewModel {

    public void CreateAppSpecific(Context context, String fileName, String fileInformation) {
        try (FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE)) {
            fos.write(fileInformation.getBytes());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
    