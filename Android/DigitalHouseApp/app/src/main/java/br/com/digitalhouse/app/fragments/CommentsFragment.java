package br.com.digitalhouse.app.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.digitalhouse.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentsFragment extends Fragment {

    private String message;

    public CommentsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String value) {
        CommentsFragment fragment = new CommentsFragment();

        Bundle bundle = new Bundle();
        bundle.putString("VALUE", value);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            message = getArguments().getString("VALUE");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        TextView textViewComments = view.findViewById(R.id.textViewComments);

        textViewComments.setText(message);

        return view;
    }
}
