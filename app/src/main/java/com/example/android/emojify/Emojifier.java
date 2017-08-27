package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

import static android.content.ContentValues.TAG;

/**
 * Created by Kontrol on 8/27/2017.
 */

public class Emojifier {

    public static final String TAG = "Emojifier";

    public static void detectFaces(Context context, Bitmap bitmap){

        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);

        Log.v(TAG, "No of faces detected: " + faces.size());

        if(faces.size() == 0){
            Toast.makeText(context, "No Faces Detected", Toast.LENGTH_SHORT).show();
        }
        faceDetector.release();
    }
}
