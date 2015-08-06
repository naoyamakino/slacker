package com.naoya.slacker.data.disk;

import com.naoya.slacker.model.User;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Singleton;

/**
 * Created by Naoya on 15-08-05.
 */
@Singleton
public class ProfileImageCache {
    private static final String TAG = "ProfileImageCache";

    public File getFile(Context context, User user) {
        return new File(context.getCacheDir(), user.getId());
    }

    public File saveImage(Context context, Bitmap image, User user) {
        File file = new File(context.getCacheDir(), user.getId());
        FileOutputStream fos = null;
        try {
            //Convert bitmap to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
            byte[] bitmapdata = bos.toByteArray();

            //write the bytes in file
            fos = new FileOutputStream(file);
            fos.write(bitmapdata);
            fos.flush();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
        return file;
    }
}
