package com.fanxl.fananimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanxl.fananimator.entity.MainBean;
import com.fanxl.fananimator.property.ValueActivity;
import com.fanxl.fananimator.view.ScaleActivity;
import com.fanxl.fananimator.view.TranslateActivity;

import java.util.ArrayList;
import java.util.List;
/*
 * 在Android动画中，总共有两种类型的动画View Animation(视图动画)和Property Animator(属性动画)；
 * 其中 View Animation包括Tween Animation（补间动画）和Frame Animation(逐帧动画)；
 * Property Animator包括ValueAnimator和ObjectAnimation；
 */
public class MainActivity extends AppCompatActivity {

	private List<MainBean> datas;
	private RecyclerView main_rv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		datas = new ArrayList<>();
		datas.add(new MainBean(ScaleActivity.class));
		datas.add(new MainBean(TranslateActivity.class));
		datas.add(new MainBean(ValueActivity.class));

		main_rv = (RecyclerView) findViewById(R.id.main_rv);
		main_rv.setLayoutManager(new LinearLayoutManager(this));
		main_rv.setAdapter(new MyAdapter());
	}

	public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
			return new MyViewHolder(view);
		}

		@Override
		public void onBindViewHolder(MyViewHolder holder, final int position) {
			holder.item_tv_name.setText(datas.get(position).getName());
			holder.item_tv_name.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					startActivity(new Intent(MainActivity.this, datas.get(position).getmClass()));
				}
			});
		}

		@Override
		public int getItemCount() {
			return datas.size();
		}

		class MyViewHolder extends RecyclerView.ViewHolder{

			private TextView item_tv_name;

			public MyViewHolder(View itemView) {
				super(itemView);
				item_tv_name = (TextView)itemView.findViewById(R.id.item_tv_name);
			}
		}

	}
}
