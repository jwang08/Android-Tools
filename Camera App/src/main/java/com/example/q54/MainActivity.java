package com.example.q54;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.Color;

//Main activity
public class MainActivity extends AppCompatActivity
{
    private int PICTURE_REQUEST = 1;      //code used for camera activity
    private Bitmap bitmap;                //bit map used to store image
    private Bitmap greyBitmap;            //bit map used to store grey image
    private Bitmap bwBitmap;            //bit map used to store grey image
    private Bitmap greenBitmap;            //bit map used to store grey image

    //Main screen
    protected void onCreate(Bundle savedInstanceState)
    {
        //display screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //package manager
        PackageManager manager = getPackageManager();

        //if camera feature is available
        if (manager.hasSystemFeature(PackageManager.FEATURE_CAMERA))
        {
            //create camera activity
            Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            //start camera activity
            startActivityForResult(pictureIntent, PICTURE_REQUEST);
        }
        //otherwise display error message
        else
            Toast.makeText(this, "No camera", Toast.LENGTH_LONG).show();
    }

    //Method displays result of camera activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        //if the result is from camera activity
        if (requestCode == PICTURE_REQUEST)
        {
            //get result of camera activity
            Bundle bundle = data.getExtras();

            //get bitmap (picture) from result
            bitmap = (Bitmap)bundle.get("data");

            //access image view to display bitmap
            ImageView imageView = findViewById(R.id.picture);

            //display bitmap on image view
            imageView.setImageBitmap(bitmap);
        }
    }

    //Method displays grey scale image of camera image
    public void grey(View view)
    {
        //create a mutable bitmap to store grey scale image
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config configuration = bitmap.getConfig();
        greyBitmap = Bitmap.createBitmap(width, height, configuration);

        //go thru each pixel of camera image
        for (int i = 0; i < bitmap.getWidth(); i++)
            for (int j = 0; j < bitmap.getHeight(); j++)
            {
                //get color value of pixel
                int color = bitmap.getPixel(i, j);

                //find r, g, b values of color
                int red = Color.red(color);
                int green = Color.green(color);
                int blue = Color.blue(color);

                //find average of r, g, b values
                int grey = (int)((red + green + blue)/3.0);

                //create grey color using average
                color = Color.rgb(grey, grey, grey);

                //set grey pixel on grey bit map
                greyBitmap.setPixel(i, j, color);
            }

        //access image view to display grey image
        ImageView imageView = findViewById(R.id.picture);

        //display grey image on image view
        imageView.setImageBitmap(greyBitmap);
    }

    public void original(View view) {
        //access image view to display grey image
        ImageView imageView = findViewById(R.id.picture);

        //display grey image on image view
        imageView.setImageBitmap(bitmap);
    }

    public void bw(View view) {
        //create a mutable bitmap to store green scale image
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config configuration = bitmap.getConfig();
        bwBitmap = Bitmap.createBitmap(width, height, configuration);

        //go thru each pixel of camera image
        for (int i = 0; i < bitmap.getWidth(); i++)
            for (int j = 0; j < bitmap.getHeight(); j++)
            {
                //get color value of pixel
                int color = bitmap.getPixel(i, j);

                //find r, g, b values of color
                int red = Color.red(color);
                int green = Color.green(color);
                int blue = Color.blue(color);

                //find average of r, g, b values
                int avg = (int)((red + green + blue)/3.0);

                if(avg < 127){
                    color = Color.rgb(0, 0, 0);
                }else{
                    color = Color.rgb(255, 255, 255);
                }


                bwBitmap.setPixel(i, j, color);
            }

        ImageView imageView = findViewById(R.id.picture);

        imageView.setImageBitmap(bwBitmap);
    }

    public void green(View view) {
        //create a mutable bitmap to store green scale image
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config configuration = bitmap.getConfig();
        greenBitmap = Bitmap.createBitmap(width, height, configuration);

        //go thru each pixel of camera image
        for (int i = 0; i < bitmap.getWidth(); i++)
            for (int j = 0; j < bitmap.getHeight(); j++)
            {
                //get color value of pixel
                int color = bitmap.getPixel(i, j);

                //find r, g, b values of color
                int red = Color.red(color);
                int green = Color.green(color);
                int blue = Color.blue(color);

                //find average of r, g, b values
                int avg = (int)((red + green + blue)/3.0);

                //create green color using average
                color = Color.rgb(0, avg, 0);

                //set green pixel on green bit map
                greenBitmap.setPixel(i, j, color);
            }

        //access image view to display green image
        ImageView imageView = findViewById(R.id.picture);

        //display green image on image view
        imageView.setImageBitmap(greenBitmap);
    }
}
