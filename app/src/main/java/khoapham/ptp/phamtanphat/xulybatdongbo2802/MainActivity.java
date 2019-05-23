package khoapham.ptp.phamtanphat.xulybatdongbo2802;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {


    Dataobject dataobject = new Dataobject(0,0,2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 50 ; i++){
                    int a = new Random().nextInt(100);
                    Log.d("BBB" , " A " + a + " " + i);
                    dataobject.setA(a);
                }
            }
        });
        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 50 ; i++){
                    int b = new Random().nextInt(100);
                    Log.d("BBB" , " B " + b + " " + i);
                    dataobject.setB(b);
                }
            }
        });
        Thread threadc = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 50 ; i++){
                    int tong = dataobject.tinhTong();
                    Log.d("BBB" , " C " + tong + " " + i);

                }
            }
        });
        threada.start();
        threadb.start();
        threadc.start();

//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("BBB", thread.getState().name() + "");
//            }
//        },4000);

    }
    private  void inLog(String ten ){
        for (int i = 0 ; i <100 ; i++){
            try {
                Thread.sleep(100);
                Log.d("BBB",ten + " " + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void xulythreadpool(){
        //         final Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                inLog("A");
//            }
//        });
//
//        thread.start();
//
//        final Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                inLog("B");
//            }
//        });
//
//        thread1.start();
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("BBB", "A " + thread.getState().name() + "");
//                Log.d("BBB", "B " + thread1.getState().name() + "");
//            }
//        },1000);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                inLog("A");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                inLog("B");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                inLog("C");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                inLog("D");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                inLog("E");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                inLog("F");
            }
        });
    }
}
