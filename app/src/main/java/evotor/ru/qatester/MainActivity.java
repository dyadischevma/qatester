package evotor.ru.qatester;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		APIService.getInstance().getRates("RUB").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers
				.mainThread()).subscribe(new Action1<Rates>() {
			@Override
			public void call(Rates rates) {
				Map<String, BigDecimal> values = rates.getValues();
				Iterator<String> iterator = values.keySet().iterator();
				String data = "";
				while (iterator.hasNext()) {
					String key = iterator.next();
					data = data + key + ": " + String.valueOf(values.get(key)) + "\n";
				}
				((TextView) findViewById(R.id.textView)).setText(data);
			}
		});
	}
}
