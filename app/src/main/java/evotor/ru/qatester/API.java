package evotor.ru.qatester;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by nixan on 17.06.16.
 */

public interface API {

	@GET("/latest")
	Observable<Rates> getRates(@Query("base") String currency);
}
