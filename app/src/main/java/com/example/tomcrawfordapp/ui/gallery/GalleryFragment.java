package com.example.tomcrawfordapp.ui.gallery;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tomcrawfordapp.R;
import com.example.tomcrawfordapp.ui.home.HomeViewModel;

import java.util.List;

public class GalleryFragment extends Fragment {

   RecyclerView recyclerView;
   GalleryAdapter galleryAdapter;
   List<String> images;
   TextView gallery_number;
   private static final int MY_READ_PERMISSION_CODE = 101;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gallery_number = view.findViewById(R.id.gallery_number);
        recyclerView = view.findViewById(R.id.recycler_gallery_images);

        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_READ_PERMISSION_CODE);
        } else {
            loadImages();
        }
    }
    private void loadImages(){
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
      images = ImageGallery.listOfImages(getContext());
      galleryAdapter = new GalleryAdapter(getContext(), images, new GalleryAdapter.PhotoListener() {
          @Override
          public void onPhotoCLick(String path) {
              Toast.makeText(getContext(), ""+path, Toast.LENGTH_SHORT).show();
          }
      });

      recyclerView.setAdapter(galleryAdapter);
      gallery_number.setText("Photos ("+images.size()+")");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_READ_PERMISSION_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getContext(), "Read External Storage Permission Granted", Toast.LENGTH_SHORT).show();
                loadImages();
            } else {
                Toast.makeText(getContext(), "Read External Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
