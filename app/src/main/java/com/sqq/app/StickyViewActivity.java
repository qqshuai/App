package com.sqq.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/9/4
 * @since JDK 1.7
 */
public class StickyViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sticky_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Sticky> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Sticky sticky = new Sticky();
            sticky.setName("城市" + (i + 1));
            List<String> subList = new ArrayList<>();
            sticky.setList(subList);
            for (int j = 0; j < 10; j++) {
                subList.add("客户" + (j + 1));
            }
            list.add(sticky);
        }
        StickyAdapter stickyAdapter = new StickyAdapter(this, list);
        recyclerView.setAdapter(stickyAdapter);
    }
}
