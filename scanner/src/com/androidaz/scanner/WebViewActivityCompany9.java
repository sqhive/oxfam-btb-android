package com.androidaz.scanner;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;

import com.androidaz.scanner.R;
import com.androidaz.scanner.R.id;
import com.androidaz.scanner.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivityCompany9 extends Activity implements OnTouchListener, Handler.Callback {
	private static final int CLICK_ON_WEBVIEW = 1;
	private static final int CLICK_ON_URL = 2;

	private final Handler handler = new Handler(this);
	
	private WebView webView;
	private WebViewClient client;
	 
	public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.webview);
 
	   webView = (WebView) findViewById(R.id.webView1);

	   
	   try {
		   
		   InputStream stream = getAssets().open("identified-9.html");
		   int size = stream.available();
		   byte[] buffer = new byte[size];
		   stream.read(buffer);
		   stream.close();
		   String text = new String(buffer);
		   
		   webView.loadDataWithBaseURL("file:///android_asset/", text, "text/html", "UTF-8", "/");
		   
	   } catch (IOException e) {
		   webView.loadData(e.toString(), "text/html", "UTF-8");
	   }
	   
	   
	   client = new WebViewClient(){ 
	        @Override public boolean shouldOverrideUrlLoading(WebView view, String url) { 
	            handler.sendEmptyMessage(CLICK_ON_URL);
	            return false;
	        } 
	    };
	    
	    webView.setWebViewClient(client);
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
	    if (v.getId() == R.id.webView1 && event.getAction() == MotionEvent.ACTION_DOWN){
	        handler.sendEmptyMessageDelayed(CLICK_ON_WEBVIEW, 500);
	    }
	    return false;
	}

	@Override
	public boolean handleMessage(Message msg) {
	    if (msg.what == CLICK_ON_URL){
	        handler.removeMessages(CLICK_ON_WEBVIEW);
	        return false;
	    }
	    if (msg.what == CLICK_ON_WEBVIEW){
	        return true;
	    }
	    return false;
	}
}
