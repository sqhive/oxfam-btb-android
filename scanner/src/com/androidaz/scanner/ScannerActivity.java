package com.androidaz.scanner;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidaz.scanner.WebViewActivity;
import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;
import com.androidaz.scanner.Database;

public class ScannerActivity extends CaptureActivity 
{
	
	
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button txt = (Button) findViewById(R.id.button_settings);  
        Button txt2 = (Button) findViewById(R.id.button_myprofile); 
        Button txt3 = (Button) findViewById(R.id.button_moreinfo);  
        Typeface font = Typeface.createFromAsset(getAssets(), "oxfamglobalheadline-webfont.ttf");  
        txt.setTypeface(font);
        txt2.setTypeface(font);
        txt3.setTypeface(font);
    }
    
    @Override
    public void handleDecodeLibrary(Result rawResult, Bitmap barcode) 
    {	    	
    	Database Db = new Database();
    	
    	final Context context = this;
    	
    	Integer code = Db.search(rawResult.getText());
    	
    	Intent intent = new Intent(context, WebViewActivityCompanyNotFound.class);
    	switch (code) {
	    	case 1: {
	    		intent = new Intent(context, WebViewActivityCompany1.class);
	    		break;
	    	}
	    	case 2: {
	    		intent = new Intent(context, WebViewActivityCompany2.class);
	    		break;
	    	}
	    	case 3: {
	    		intent = new Intent(context, WebViewActivityCompany3.class);
	    		break;
	    	}
	    	case 4: {
	    		intent = new Intent(context, WebViewActivityCompany4.class);
	    		break;
	    	}
	    	case 5: {
	    		intent = new Intent(context, WebViewActivityCompany5.class);
	    		break;
	    	}
	    	case 6: {
	    		intent = new Intent(context, WebViewActivityCompany6.class);
	    		break;
	    	}
	    	case 7: {
	    		intent = new Intent(context, WebViewActivityCompany7.class);
	    		break;
	    	}
	    	case 8: {
	    		intent = new Intent(context, WebViewActivityCompany8.class);
	    		break;
	    	}
	    	case 9: {
	    		intent = new Intent(context, WebViewActivityCompany9.class);
	    		break;
	    	}
	    	case 10: {
	    		intent = new Intent(context, WebViewActivityCompany10.class);
	    		break;
	    	}
	    	default: {
	    		
	    		Intent resultIntent = new Intent(this, WebViewActivity.class);
	    		// Because clicking the notification opens a new ("special") activity, there's
	    		// no need to create an artificial back stack.
	    		PendingIntent resultPendingIntent =
	    		    PendingIntent.getActivity(
	    		    this,
	    		    0,
	    		    resultIntent,
	    		    PendingIntent.FLAG_UPDATE_CURRENT
	    		);
	    		
	    		Notification.Builder mBuilder =
	    			    new Notification.Builder(this)
	    			    .setSmallIcon(R.drawable.ic_launcher)
	    			    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
	    			    .setContentTitle("Improvement!")
	    			    .setStyle(new Notification.BigTextStyle().bigText("Hello! We have noticed that you improved your overall Land score.")) 
	    			    .setContentText("Hello! We have noticed that you improved your overall Land score.")
	    			    .addAction(R.drawable.ic_launcher, "Read more", resultPendingIntent)
	    				.addAction(R.drawable.ic_launcher, "Take action", resultPendingIntent);
	    		
	    		mBuilder.setContentIntent(resultPendingIntent);
	    		
	    		// Sets an ID for the notification
	    		int mNotificationId = 001;
	    		// Gets an instance of the NotificationManager service
	    		NotificationManager mNotifyMgr = 
	    		        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	    		// Builds the notification and issues it.
	    		mNotifyMgr.notify(mNotificationId, mBuilder.build());
	    		
	    		break;
	    	}
    	}
    	
	    startActivity(intent);
    }
    
    
    public void Iface_OpenSettings(View v) {
    	final Context context = this;
    	Intent intent = new Intent(context, WebViewActivitySettings.class);
	    startActivity(intent);
    }
    
    public void Iface_OpenMyProfile(View v) {
    	final Context context = this;
    	Intent intent = new Intent(context, WebViewActivityProfile.class);
	    startActivity(intent);
    }
    
    public void Iface_OpenMoreInfo(View v) {
    	final Context context = this;
    	Intent intent = new Intent(context, WebViewActivityInfo.class);
	    startActivity(intent);
    }
    
    
}