package Observable;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.Arrays;

/**
 * Created by Srikar on Mar, 2019
 */

/*
* There are 2 types of Observables
* Hot and
* Cold
* For example we have 2 observers and a cold Observable will first emits data and then goes to secons observer and then starts emitting data again
 * A hot Observer will start emitting data to all the observers and then i.e, it emits the first item to all the observer then the second then the third and so on
  * this code demonstrates a hot Observable. For a hot Observable we use ConnectableObservable   */
public class ConnectableObservableExample {

    public static void main(String [] args){

        Observable<String> source = Observable.fromIterable(Arrays.asList("jack", "Tim", "steve"));

        ConnectableObservable<String> hot = source.publish();

        hot.subscribe(e -> System.out.println("Observer1: " + e), Throwable::printStackTrace,() -> System.out.println("operation complete1"));
        hot.subscribe(e -> System.out.println("Observer2: " + e), Throwable::printStackTrace,() -> System.out.println("operation complete2"));

        hot.connect();
    }

}
