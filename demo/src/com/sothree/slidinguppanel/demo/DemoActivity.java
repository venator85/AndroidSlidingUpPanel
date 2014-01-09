package com.sothree.slidinguppanel.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;

public class DemoActivity extends Activity {
	private static final String TAG = "DemoActivity";

	public static final String SAVED_STATE_ACTION_BAR_HIDDEN = "saved_state_action_bar_hidden";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		View dragme = findViewById(R.id.dragme);

		SlidingUpPanelLayout layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
		layout.setShadowDrawable(getResources().getDrawable(R.drawable.above_shadow));
		layout.setAnchorPoint(0.3f);
		layout.setDragView(dragme);
		layout.setCoveredFadeColor(Color.TRANSPARENT);
		layout.setPanelSlideListener(new PanelSlideListener() {
			@Override
			public void onPanelSlide(View panel, float slideOffset) {
				Log.i(TAG, "onPanelSlide, offset " + slideOffset);
			}

			@Override
			public void onPanelExpanded(View panel) {
				Log.i(TAG, "onPanelExpanded");

			}

			@Override
			public void onPanelCollapsed(View panel) {
				Log.i(TAG, "onPanelCollapsed");

			}

			@Override
			public void onPanelAnchored(View panel) {
				Log.i(TAG, "onPanelAnchored");

			}
		});

		ListView list = (ListView) findViewById(R.id.main);
		ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				String s = (String) arg0.getAdapter().getItem(arg2);
				Toast.makeText(arg0.getContext(), s, Toast.LENGTH_SHORT).show();
			}
		});

		list = (ListView) findViewById(R.id.list2);
		List<String> l = Arrays.asList(Cheeses.sCheeseStrings);
		Collections.reverse(l);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, l);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				String s = (String) arg0.getAdapter().getItem(arg2);
				Toast.makeText(arg0.getContext(), s, Toast.LENGTH_SHORT).show();
			}
		});
	}

}
