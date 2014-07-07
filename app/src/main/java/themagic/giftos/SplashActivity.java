package themagic.giftos;

import android.app.Activity;
import android.os.Bundle;

import java.util.logging.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

      Handler handler = new Handler();
    }
}
