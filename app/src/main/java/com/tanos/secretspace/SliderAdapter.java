package com.tanos.secretspace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter (Context context){
        this.context = context;
    }

    public int [] image_slide = {
            R.drawable.screen_play,
            R.drawable.screen_learn,
            R.drawable.screen_learn_play
    };

    public String[] txt_first = {
            "Play",
            "Learn",
            "Space closer"
    };

    public String[] txt_secondary = {
            "Find the same pictures , what will help you in quiz",
            "Answer the questions and learn all about the space",
            "Win the game and be closer to the space"
    };

    @Override
    public int getCount() {
        return txt_first.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.image_slide);
        TextView slideFirstText = (TextView) view.findViewById(R.id.txt_first);
        TextView slideSecondText = (TextView) view.findViewById(R.id.txt_secondary);

        slideImageView.setImageResource(image_slide[position]);
        slideFirstText.setText(txt_first[position]);
        slideSecondText.setText(txt_secondary[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
