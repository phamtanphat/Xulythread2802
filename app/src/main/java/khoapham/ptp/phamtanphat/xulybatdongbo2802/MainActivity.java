package khoapham.ptp.phamtanphat.xulybatdongbo2802;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnXulybatdongbo;
    Thread threadA,threadB,threadC;
    int a,b,c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnXulybatdongbo = findViewById(R.id.buttonXulythread);

        btnXulybatdongbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadA = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        a = (int) Math.floor(Math.random() * 3 + 1);
                        Log.d("BBB","Thread A : " + a);
                    }
                });
                threadB = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        b = (int) Math.floor(Math.random() * 3 + 1);
                        Log.d("BBB","Thread b : " + b);
                    }
                });
                threadB = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        c = (int) Math.floor(Math.random() * 3 + 1);
                        Log.d("BBB","Thread C : " + c);
                    }
                });

            }
        });
    }
}
