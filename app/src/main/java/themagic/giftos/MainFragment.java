package themagic.giftos;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.bitmap.Transform;
import com.makeramen.RoundedDrawable;


public class MainFragment extends Fragment {

  private ImageView gif;
  int cornerRadius = 200;

  public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_main, container, false);
//      RoundedImageView gif = (RoundedImageView) view.findViewById(R.id.roundedView);
       gif = (ImageView) view.findViewById(R.id.gif);

//      Picasso.with(getActivity()).load("http://media.giphy.com/media/BX17E98mJ45TG/200.gif").into(gif);
//      RoundedImageView iv = new RoundedImageView(getActivity());
      loadRounded();

      return view;
    }

    Transform trans = new Transform() {
      boolean isOval = false;
      @Override
      public Bitmap transform(Bitmap bitmap) {
        Bitmap scaled = Bitmap.createScaledBitmap(bitmap, cornerRadius, cornerRadius, false);
        Bitmap transformed = RoundedDrawable.fromBitmap(scaled).setScaleType(ImageView.ScaleType.CENTER_CROP).setCornerRadius(cornerRadius).setOval(isOval).toBitmap();
        if (!bitmap.equals(scaled)) bitmap.recycle();
        if (!scaled.equals(transformed)) bitmap.recycle();

        return transformed;
      }

      @Override
      public String key() {
        return "rounded_radius_" + cornerRadius + "_oval_" + isOval;
      }
    };

    public void loadRounded() {
      Ion.with(gif)
              .resize(cornerRadius, cornerRadius)
              .centerCrop()
              .transform(trans)
              .load("http://media.giphy.com/media/BX17E98mJ45TG/200.gif");
    }

}
