package edu.tieorange.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int[] drawableIds = {R.drawable.tomaszew, R.drawable.logo};
    private int index;

    Button next;
    Button prev;
    ImageView imageView;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views:
        next = (Button) findViewById(R.id.next);
        prev = (Button) findViewById(R.id.previous);
        imageView = (ImageView) findViewById(R.id.image);
        checkBox = (CheckBox) findViewById(R.id.autoPlay);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {

                final Handler handler = new Handler();

                if (isChecked)
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (!checkBox.isChecked()) return;

                            onClickNext(imageView);
                            handler.postDelayed(this, 2000);
                        }
                    }, 2000);
            }
        });
    }

    private void generateNextIndex() {
        if (++index == drawableIds.length) {
            index = 0;
        }
    }

    private void generatePrevIndex() {
        if (--index == -1) {
            index = drawableIds.length - 1;
        }
    }

    public void onClickNext(View view) {
        generateNextIndex();
        int drawableId = drawableIds[index];
        imageView.setImageResource(drawableId);
//        imageView.setImageDrawable();
    }

    public void onClickPrev(View view) {
    }
}
