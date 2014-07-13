package themagic.giftos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashActivity extends Activity {

  private Handler handler;
  private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
        finish();
//        handler = new Handler();
//        runnable = new Runnable() {
//          @Override
//          public void run() {
//            Intent i = new Intent(SplashActivity.this, MainActivity.class);
//            startActivity(i);
//            finish();
//          }
//        };
//        handler.postDelayed(runnable, 100);
    }
}
