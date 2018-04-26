package com.example.seoulappbiz02;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PanelFragment extends Fragment {

    public static interface ChangeWebViewCallback{
        public void onChangeWebView(String uri);
    }

    public ChangeWebViewCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof ChangeWebViewCallback){
            callback = (ChangeWebViewCallback)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_panel, container, false);

        final EditText uriEdit = rootView.findViewById(R.id.uriEdit);
        Button moveButton = rootView.findViewById(R.id.moveButton);

        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = uriEdit.getText().toString();
                callback.onChangeWebView(uri);
            }
        });

        return rootView;
    }
}
