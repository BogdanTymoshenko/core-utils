package ua.com.amicablesoft.android.core.utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 25.12.14.
 */
public final class UtilsFile {

    public static File createTmpImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";

        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!storageDir.exists())
            storageDir.mkdirs();

        return File.createTempFile(imageFileName, ".jpg", storageDir);
    }

    public static void deleteFileAsync(final File file) {
        if (file != null)
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            file.delete();
                        }
                    }
            ).start();
    }

    private UtilsFile() {}
}
