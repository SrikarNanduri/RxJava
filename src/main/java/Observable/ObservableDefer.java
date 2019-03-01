package Observable;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by Srikar on Mar, 2019
 */

/*
* Defer
This operator does not create the Observable until the Observer subscribes.
The only downside to defer() is that it creates a new Observable each time you get a new Observer.
create() can use the same function for each subscriber, so it’s more efficient.

Sample Implementation: The below sample creates an Observable using Observable.defer() method.
The below code creates an Observable that emits a value.
*/
public class ObservableDefer {
    public static void main(String [] args){
        Observable<String> source = Observable.defer(() -> Observable.just("First", "Second"));
        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("operation complete"));
    }
}
