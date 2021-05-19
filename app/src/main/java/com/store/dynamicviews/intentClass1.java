package com.store.dynamicviews;

import android.content.Context;
import android.content.Intent;

public class intentClass1 extends Intent {

    String[] names;
    int[] images;
    Class className;
    public intentClass1(Context context, Class className,String[] names,int[] images ) {
        this.images = images;
        this.names = names;
        this.className=className;
    }
    public void intentMethod(Context context, int position){
        Intent intent = new Intent(context,className);
        intent.putExtra("names",names[position]);
        intent.putExtra("images",images[position]);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
