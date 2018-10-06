package br.com.digitalhouse.pageview.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.pageview.R;

public class PhotoFragment extends Fragment {

    public PhotoFragment() {
    }

    public static PhotoFragment newInstance(int image, String text) {
        Bundle args = new Bundle();

        args.putInt("IMAGE", image);
        args.putString("TEXT", text);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container, false);

        ImageView imageViewPhoto = view.findViewById(R.id.imageview_photo);
        TextView textViewTitle = view.findViewById(R.id.textview_title);

        int imageResource = getArguments().getInt("IMAGE");
        String textTitle = getArguments().getString("TEXT");

        imageViewPhoto.setImageResource(imageResource);
        textViewTitle.setText(textTitle);

        return view;
    }
}
