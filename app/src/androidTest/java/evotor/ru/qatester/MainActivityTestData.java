package evotor.ru.qatester;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by User on 25.06.2016.
 */

//Не успел разобраться, как подключить Retrofit mocking, поэтому пока
// Копипаста для получения эталонного текста:

public class MainActivityTestData {
    private String testdata;
     MainActivityTestData() { // Вместе с созданием экземпляра получаем текст
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
                testdata = data;

            }

        });

    }
    public String getTestdata (){
        return testdata;
    }



}
