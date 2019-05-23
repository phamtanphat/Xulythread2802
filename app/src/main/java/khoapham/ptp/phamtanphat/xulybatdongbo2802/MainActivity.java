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
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (dataobject){
                    for (int i = 0 ; i < 100 ;){
                        if (dataobject.getLaco() == 2){
                            i++;
                            index = i;
                            int a = new Random().nextInt(100);
                            Log.d("BBB" , " A " + a + " " + index);
                            dataobject.setA(a);
                            dataobject.setLaco(3);
                            dataobject.notifyAll();
                        }else{
                            try {
                                dataobject.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    dataobject.setLaco(5);
                    dataobject.notifyAll();
                }

            }
        });
        final Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (dataobject){
                    for (; true; ){
                        if (dataobject.getLaco() == 3 || dataobject.getLaco() == 5){
                            int b = new Random().nextInt(100);
                            Log.d("BBB" , " B " + b + " " + index);
                            if (dataobject.getLaco() == 5){
                                dataobject.setB(b);
                                dataobject.setLaco(6);
                                dataobject.notifyAll();
                                return;
                            }
                            dataobject.setB(b);
                            dataobject.setLaco(4);
                            dataobject.notifyAll();

                        }else{
                            try {
                                dataobject.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }

            }
        });
        final Thread threadc = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (dataobject){
                    for (; true ; ){
                        if (dataobject.getLaco() == 4 || dataobject.getLaco() == 6){

                            int tong = dataobject.tinhTong();
                            Log.d("BBB" , " C " + tong + " " + index);

                            if (dataobject.getLaco() == 6){
                                return;
                            }
                            dataobject.setLaco(2);
                            dataobject.notifyAll();
                        }else{
                            try {
                                dataobject.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("CCC",threadc.getState().name());
                Log.d("CCC",threadb.getState().name());
                Log.d("CCC",threadc.getState().name());
            }
        },3000);
//        a b c d
//                =>a random
//                => b random
//                => c = -a;
//                => d = -b

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
