package com.example.interfazdinamico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvDisplayGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplayGlobal = (TextView) findViewById(R.id.tvDisplay);
        final TextView tvDisplay = tvDisplayGlobal;
        final TableLayout tl = (TableLayout) findViewById(R.id.tlBotonera);

        TableRow tr = null;

        Button b;

        for(int i = 9; i >= 0; i--) {
            if(i % 3 == 0) {
                tr = new TableRow(this);

                tl.addView(tr);
            }

            b = new Button(this);
            b.setText(String.valueOf(i));

            TableRow.LayoutParams bParams = new TableRow.LayoutParams();

            bParams.weight = 1;

            b.setLayoutParams(bParams);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View viewClicked) {
                    Button bClicked = (Button)viewClicked;

                    String res = bClicked.getText().toString();

                    String previousText = tvDisplay.getText().toString();

                    if(!"0".equals(previousText)){
                        res = previousText + res;
                    }

                    tvDisplay.setText(res);
                }
            });

            tr.addView(b);
        }
    }

    public void doCe(View view) {
        tvDisplayGlobal.setText("0");
    }
}
