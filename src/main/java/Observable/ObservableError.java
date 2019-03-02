package Observable;

import io.reactivex.Observable;

/**
 * Created by Srikar on Mar, 2019
 */

/*This will call onError function right away, we use this to throw error.*/
public class ObservableError {
    public static void main(String [] args){
        Observable.error(new Exception("Crash")).subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));
    }

}
