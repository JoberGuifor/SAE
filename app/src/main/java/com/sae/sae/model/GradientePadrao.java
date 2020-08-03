package com.sae.sae.model;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class GradientePadrao {

    public static GradientDrawable getGradiente() {
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.BR_TL,
                new int[]{Color.rgb(172, 218, 230),
                        Color.rgb(124, 198, 228)
                        });

        //Color.rgb(157, 211, 175)}
        //Color.rgb(197, 234, 250)
        //Color.rgb(157, 211, 235)
        //Color.rgb(206, 230, 214)

        return gradientDrawable;
    }
}
