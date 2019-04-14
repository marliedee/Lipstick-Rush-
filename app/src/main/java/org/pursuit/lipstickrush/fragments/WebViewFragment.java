package org.pursuit.lipstickrush.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import org.pursuit.lipstickrush.R;

public class WebViewFragment extends Fragment {

    private View rootView;
    private String makeupUrl;

    public WebViewFragment() {
    }

    public static WebViewFragment getInstance(String urlLink) {
        WebViewFragment webViewFragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString("URL",urlLink);
        webViewFragment.setArguments(args);
        return webViewFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            makeupUrl = getArguments().getString("URL");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_web_view, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        WebView myWebView = rootView.findViewById(R.id.webView);
        myWebView.getProgress();
        myWebView.getTitle();
        myWebView.getFavicon();
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myWebView.loadUrl(makeupUrl);
    }

}
