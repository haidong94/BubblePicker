package com.example.dong.bubblepicker;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BubblePicker bubblePicker;
    String[] name={
            "Captain America", "Spider Man", "Falcon",
            "daredevil", "cyclops", "Lucian","Leesin"
    };

    int[] images={
            R.drawable.captain,
            R.drawable.spiderman,
            R.drawable.falcon,
            R.drawable.daredevil,
            R.drawable.cyclops,
            R.drawable.lucian,
            R.drawable.leesin
    };

    int[] colors={
            Color.parseColor("#1A237E"),
            Color.parseColor("#6200EA"),
            Color.parseColor("#004D40"),
            Color.parseColor("#880E4F"),
            Color.parseColor("#B71C1C"),
            Color.parseColor("#5200EA"),
            Color.parseColor("#C04D40"),
    };
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubblePicker= (BubblePicker) findViewById(R.id.picker);
        ArrayList<PickerItem> listItems=new ArrayList<>();
        for(int i=0;i<name.length;i++){
            PickerItem item=new PickerItem(name[i],colors[i], Color.WHITE, getDrawable(images[i]));
            listItems.add(item);
        }

        bubblePicker.setItems(listItems);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                Toast.makeText(MainActivity.this,""+pickerItem.getTitle()+" Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {
                Toast.makeText(MainActivity.this,""+pickerItem.getTitle()+" Deselected",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
