package khoapham.ptp.phamtanphat.xulybatdongbo2802;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Set;


public class MainActivity extends AppCompatActivity {


    @Override
    protected synchronized void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                inLog("A");
            }
        });

        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inLog("B");
            }
        });

        thread1.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB", "A " + thread.getState().name() + "");
                Log.d("BBB", "B " + thread.getState().name() + "");
            }
        },1000);

//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("BBB", thread.getState().name() + "");
//            }
//        },4000);

    }
    private synchronized void inLog(String ten ){
        for (int i = 0 ; i <1000 ; i++){
            Log.d("BBB",ten + " " + i);
        }
    }
}
