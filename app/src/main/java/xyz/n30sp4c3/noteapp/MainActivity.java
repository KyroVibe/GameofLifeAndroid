package xyz.n30sp4c3.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.icu.util.MeasureUnit;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    public String[] idk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView) findViewById(R.id.grid);

        int height = 4;
        int width = 5;

        idk = new String[height * width];
        for (int i = 0; i < idk.length; i++) {
            idk[i] = i % 2 == 0 ? "h" : "o";
        }

        grid.setNumColumns(width);
        // USE THIS: https://mkyong.com/android/android-gridview-example/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, idk);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setBackgroundColor(Color.BLACK);
                //Toast.makeText(getApplicationContext(), i, Toast.LENGTH_SHORT).show();
            }
        });

        /*TableLayout layout = (TableLayout) findViewById(R.id.grid);
        TableLayout.LayoutParams lp = new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams rp = new TableRow.LayoutParams(100, 100);
        for (int y = 0; y < height; y++) {
            TableRow row = new TableRow(this);
            row.setGravity(Gravity.CENTER_VERTICAL);
            for (int x = 0; x < width; x++) {

                View v = new View(this);
                v.setBackgroundColor((x + y) % 2 == 0 ? Color.BLACK : Color.WHITE);
                v.setForegroundGravity(Gravity.HORIZONTAL_GRAVITY_MASK);
                // Button b = new Button(this);
                // b.setText(x + ":" + y);
                // b.setPadding(0, 0, 0, 0);
                row.addView(v, rp);
            }

            layout.addView(row, lp);
        }*/
    }
}