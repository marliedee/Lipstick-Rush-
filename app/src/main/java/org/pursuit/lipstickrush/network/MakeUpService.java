package org.pursuit.lipstickrush.network;

import org.pursuit.lipstickrush.model.MakeupPOJO;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MakeUpService {
    String END_POINT_URL = "/marliedee/b803e0f40320500352f5982dc9e59326/raw/f31250dfe7da50e94cf507967e3b3e843a4147a8/gistfile1.txt";

    @GET(END_POINT_URL)
    Observable<List<MakeupPOJO>> getMakeUpDetails();
}
