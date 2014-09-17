package com.mct.myscrollviewmenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {
	private HorizontalScrollView mScroll;
	private LinearLayout mLinear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mScroll = (HorizontalScrollView) findViewById(R.id.m_scroll);
		mLinear = (LinearLayout) findViewById(R.id.m_linear);
		init();
	}

	private void init() {
		int size = mLinear.getChildCount();
		for (int i = 0; i < size; i++) {
			mLinear.getChildAt(i).setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// Log.e("m_tag",
		// "left:" + v.getLeft() + " scroll_x:" + mScroll.getScrollX()
		// + " linear width:" + mLinear.getWidth() + " "
		// + mScroll.getMaxScrollAmount());
		//滚动视图中LinearLayout的宽度
		int width = mLinear.getWidth();
		//滚动总长度
		int scrollXSize = width - mScroll.getWidth();
		//平均每个item宽度
//		int itemWidth = width/mLinear.getChildCount();
		int itemLeft = v.getLeft();
		//每个item对应的滚动
		int scrollX = scrollXSize * itemLeft / (width - itemLeft);
		mScroll.scrollTo(scrollX, 0);
	}

}
