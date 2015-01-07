package ua.com.amicablesoft.android.core.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public final class UtilsBitmap {

	public static Bitmap decodeSampledBitmapFromFile(String imageFilePath, int reqWidth, int reqHeight) {
        if (imageFilePath != null && reqWidth > 0 && reqHeight > 0)
        {
            // First decode with inJustDecodeBounds=true to check dimensions
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(imageFilePath, options);

            if (options.outWidth > reqWidth || options.outHeight > reqHeight)
            {
                // Calculate inSampleSize
            	options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

            	final float xp = (float)reqWidth / (float)options.outWidth;
            	final float yp = (float)reqHeight / (float)options.outHeight;
            	
            	final float p = Math.min(xp, yp);
            	
                final int boundedWidth = Math.round(options.outWidth * p);
                final int boundedHeight = Math.round(options.outHeight * p);

                // Decode bitmap with inSampleSize set
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inDither = true;

                Bitmap decodeBitmap = BitmapFactory.decodeFile(imageFilePath, options);
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(decodeBitmap, boundedWidth, boundedHeight, true);
                if (decodeBitmap != scaledBitmap) {
                    decodeBitmap.recycle();
                }

                return scaledBitmap;
            }
            else
            {
                return BitmapFactory.decodeFile(imageFilePath);
            }
        }
            
        return null;
    }       

	
	private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth)
        {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    || (halfWidth / inSampleSize) > reqWidth)
            {
                inSampleSize *= 2;
            }
        }
            
        return inSampleSize;
    }       

	
	
	private UtilsBitmap() {}

}
