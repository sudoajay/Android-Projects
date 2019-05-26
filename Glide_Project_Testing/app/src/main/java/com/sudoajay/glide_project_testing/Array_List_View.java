package com.sudoajay.glide_project_testing;

import android.app.Activity;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * Created by sudoajay on 3/23/18.
 */

public class Array_List_View extends ArrayAdapter<String> {
    private final Activity context;
    private ArrayList<File> arrayList;
    public Array_List_View(@NonNull Activity context, ArrayList<String> arrayLists, ArrayList<File> arrayList) {
        super(context,R.layout.list_view_layout,arrayLists);
        this.context = context;
        this.arrayList = arrayList;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_view_layout, null,true);

        ImageView imageView = rowView.findViewById(R.id.imageView);
        Log.e("Get" , ""+ position);

z
//        Glide.with(context)
//                .asBitmap()
//                .load(arrayList.get(position).getAbsoluteFile())
//                .into(imageView);

        getAudioAlbumImageContentUri(imageView,arrayList.get(position).getAbsolutePath());


        TextView textView = rowView.findViewById(R.id.textView);
        textView.setText(arrayList.get(position).getAbsolutePath());


        return rowView;

    }

    public void getAudioAlbumImageContentUri(ImageView imageView ,String filePath) {
        Uri audioUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.DATA + "=? ";
        String[] projection = new String[] { MediaStore.Audio.Media._ID , MediaStore.Audio.Media.ALBUM_ID};

        Cursor cursor = context.getContentResolver().query(
                audioUri,
                projection,
                selection,
                new String[] { filePath }, null);

        if (cursor != null && cursor.moveToFirst()) {
            long albumId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
            Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");
            Uri imgUri = ContentUris.withAppendedId(sArtworkUri,
                    albumId);
            Log.d(TAG,"AudioCoverImgUri = "+ imgUri.toString());

            Glide.with(context)
                    .load(imgUri)
                    .into(imageView);

            cursor.close();
        }
    }

}
