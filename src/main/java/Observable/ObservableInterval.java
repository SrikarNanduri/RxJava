package Observable;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by Srikar on Mar, 2019
 */
/*Interval
This operator creates an Observable that emits a sequence of integers spaced by a particular time interval.

Sample Implementation: The below sample creates an Observable using Observable.interval() method.
The below code will print values from 0 after every second.*/
public class ObservableInterval {
    public static void main(String [] args){
        Observable.interval(200, TimeUnit.MILLISECONDS).subscribe(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
