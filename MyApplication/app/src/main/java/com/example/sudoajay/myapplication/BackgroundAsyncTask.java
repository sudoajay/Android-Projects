package com.example.sudoajay.myapplication;

/**
 * Created by sudoajay on 12/16/17.
 */

public class BackgroundAsyncTask extends AsyncTask<String, Uri, Void> {
    Integer track = 0;
    ProgressDialog dialog;

    protected void onPreExecute() {
        dialog = new ProgressDialog(PlayVideo.this);
        dialog.setMessage("Loading, Please Wait...");
        dialog.setCancelable(true);
        dialog.show();
    }

    protected void onProgressUpdate(final Uri... uri) {

        try {

            media=new MediaController(PlayVideo.this);
            video.setMediaController(media);
            media.setPrevNextListeners(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // next button clicked

                }
            }, new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish();
                }
            });
            media.show(10000);

            video.setVideoURI(uri[0]);
            video.requestFocus();
            video.setOnPreparedListener(new OnPreparedListener() {

                public void onPrepared(MediaPlayer arg0) {
                    video.start();
                    dialog.dismiss();
                }
            });


        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            Uri uri = Uri.parse(params[0]);

            publishProgress(uri);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }


}