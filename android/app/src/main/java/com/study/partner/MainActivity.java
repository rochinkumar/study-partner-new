
package com.study.partner;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.rgb(15, 23, 42));

        TextView header = new TextView(this);
        header.setText("✦  STUDY PARTNER");
        header.setTextSize(22);
        header.setTextColor(Color.WHITE);
        header.setPadding(20, 22, 20, 22);
        header.setBackgroundColor(Color.rgb(79, 70, 229));
        layout.addView(header);

        webView = new WebView(this);
        webView.setBackgroundColor(Color.WHITE);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://rochinkumar.github.io/study-partner-new/");

        layout.addView(webView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));

        TextView footer = new TextView(this);
        footer.setText("⌂ Home       ↻ Refresh       ✦ Learn");
        footer.setTextColor(Color.WHITE);
        footer.setTextSize(16);
        footer.setGravity(17);
        footer.setPadding(10, 18, 10, 18);
        footer.setBackgroundColor(Color.rgb(30, 41, 59));
        footer.setOnClickListener(v ->
                webView.loadUrl("https://rochinkumar.github.io/study-partner-new/"));
        layout.addView(footer);

        setContentView(layout);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
