package com.tupi.game;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.graphics.Color;

public class MainActivity extends Activity {
    private WebView game;
    private void immersive() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
    @Override public void onCreate(Bundle state) {
        super.onCreate(state); immersive();
        game = new WebView(this); game.setBackgroundColor(Color.rgb(11,18,32));
        WebSettings s=game.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
        s.setMediaPlaybackRequiresUserGesture(false); s.setAllowFileAccess(true); s.setAllowContentAccess(false);
        game.setOverScrollMode(View.OVER_SCROLL_NEVER); game.setWebViewClient(new WebViewClient());
        game.setWebChromeClient(new WebChromeClient()); setContentView(game);
        game.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onWindowFocusChanged(boolean focus) { super.onWindowFocusChanged(focus); if(focus) immersive(); }
    @Override public void onBackPressed() { }
    @Override protected void onDestroy() { if(game!=null){game.destroy();game=null;} super.onDestroy(); }
}
