package org.pursuit.lipstickrush.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import org.pursuit.lipstickrush.R;
import org.pursuit.lipstickrush.model.MakeupPOJO;

public class WebViewFragment extends Fragment {

    private View rootView;
    MakeupPOJO makeupPOJO;

    public WebViewFragment() {
    }

    public static WebViewFragment getInstance() {
        return new WebViewFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String websiteLink = "https//www.google.com";
        WebView myWebView = rootView.findViewById(R.id.webView);
        myWebView.getProgress();
        myWebView.canGoBackOrForward(1);
        myWebView.getTitle();
        myWebView.clearFormData();
        myWebView.getFavicon();
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myWebView.loadUrl(websiteLink);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_web_view, container, false);
        return rootView;
    }
}
