package com.example.uas_aja_10118331;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;



public class ViewPager extends PagerAdapter {

    String[] texts = {
            "Welcome Bandung Tourism",
            "We have many place to visit for you",
            "Enjoy the Holiday~"
    };

    int[] image = {
            R.drawable.ic_welcome,
            R.drawable.ic_place,
            R.drawable.ic_heart,
    };

    Context ctx;

    public ViewPager(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.view_pager, null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.image_viewpager);
        TextView title = layoutScreen.findViewById(R.id.text_viewpager);

        title.setText(texts[position]);
        imgSlide.setImageResource(image[position]);
        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
// 13 Agustus 2021
// 10118331
// Devidli Setiawan
//IF-8