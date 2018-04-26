package com.example.seoulappbiz02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements PanelFragment.ChangeWebViewCallback{

    private Button panelButton;
    private PanelFragment fragment;
    private WebView webView;

    private boolean isPanelOpen = false;

    Animation translateUp;
    Animation translateDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        fragment = (PanelFragment) getSupportFragmentManager().findFragmentById(R.id.panelFragment);
        fragment.getView().setVisibility(View.GONE);

        translateUp = AnimationUtils.loadAnimation(this, R.anim.translate_up);
        translateDown = AnimationUtils.loadAnimation(this, R.anim.translate_down);

        SlidingPanelAnimationListener animationListener = new SlidingPanelAnimationListener();
        translateUp.setAnimationListener(animationListener);
        translateDown.setAnimationListener(animationListener);

        panelButton = findViewById(R.id.openPanel);
        panelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPanelOpen){
                    fragment.getView().startAnimation(translateUp);
                } else {
                    fragment.getView().setVisibility(View.VISIBLE);
                    fragment.getView().startAnimation(translateDown);
                }
            }
        });
    }

    private class SlidingPanelAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPanelOpen){
                fragment.getView().setVisibility(View.GONE);

                panelButton.setText("Open");
                isPanelOpen = false;
            } else {

                panelButton.setText("Close");
                isPanelOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        @Override
        public void onAnimationStart(Animation animation) {

        }
    }

    @Override
    public void onChangeWebView(String uri) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(uri);
    }
}
