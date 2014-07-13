package themagic.giftos;

import android.app.Activity;
import android.os.Bundle;



public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
//      byte[] bitmapData =
//      gifView.setBytes(bitmapData);
//      setContentView(gifView);
       setContentView(R.layout.activity_main);
      getFragmentManager().beginTransaction().replace(R.id.frame,new MainFragment()).commit();
    }

}
