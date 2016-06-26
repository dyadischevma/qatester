package evotor.ru.qatester;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by nixan on 17.06.16.
 */

public class APIService {

	private static API mInstance;

	public static API getInstance() {
		if (mInstance == null) {
			mInstance = new Retrofit.Builder().baseUrl("http://api.fixer.io/").addConverterFactory
					(JacksonConverterFactory.create())
					.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(API.class);
		}
		return mInstance;
	}
}
