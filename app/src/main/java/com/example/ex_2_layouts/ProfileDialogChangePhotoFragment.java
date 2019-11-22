package com.example.ex_2_layouts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

public class ProfileDialogChangePhotoFragment extends DialogFragment implements View.OnClickListener {

    private File photoFile;
    //final static int CAMERA_REQUEST = 1;
    private static final int CAMERA_REQUEST = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        View dialogChange = inflater.inflate(R.layout.fragment_profile_dialog,
                container,false);
       dialogChange.findViewById(R.id.fragment_profole_dialog_choose_text).setOnClickListener(this);
       dialogChange.findViewById(R.id.fragment_profole_dialog_camera_text).setOnClickListener(this);
       dialogChange.findViewById(R.id.fragment_profole_dialog_remove_text).setOnClickListener(this);

       return dialogChange;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_profole_dialog_choose_text:
                ImageView imageViewChoose = getActivity().findViewById(R.id.image_man_image_view);
                Picasso.with(getContext()).load(R.drawable.image_man)
                        .into(imageViewChoose);
                dismiss();
                break;
            case R.id.fragment_profole_dialog_camera_text:
                takePictureIntent();
                break;
            case R.id.fragment_profole_dialog_remove_text:
                ImageView imageViewRemove = getActivity().findViewById(R.id.image_man_image_view);
                Picasso.with(getContext()).load(R.drawable.user_icon)
                        .into(imageViewRemove);
                dismiss();
                break;
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if(getActivity() != null) {
                ImageView imageView = getActivity().findViewById(R.id.image_man_image_view);
                Picasso.with(getContext()).load(photoFile).fit().centerCrop().into(imageView);
                dismiss();
            }
        }
    }

    private void takePictureIntent() {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(getActivity() != null) {
            if (pictureIntent.resolveActivity(getActivity()
                    .getPackageManager()) != null) {
                photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                    Toast.makeText(getActivity(),
                            ex.getMessage(), Toast.LENGTH_SHORT)
                            .show();
                }
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(getActivity(),
                            "com.example.ex_2_layouts.fileprovider",
                            photoFile);
                    pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(pictureIntent, CAMERA_REQUEST);
                }
            }
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File image = null;
        if(getActivity() != null) {
            File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            image = File.createTempFile(
                    imageFileName,
                    ".jpg",
                    storageDir
            );
        }
        return image;
    }
}
