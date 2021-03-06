package ObservableAndObserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by Srikar on Mar, 2019
 */


/*Just
This operator takes a list of arguments (maximum 10) and converts the items into ObservableAndObserver items.
just() makes only 1 emission. For instance, If an array is passed as a parameter to the just() method, the array is emitted as single item instead of individual numbers.
Note that if you pass null to just(), it will return an ObservableAndObserver that emits null as an item.

Sample Implementation: The below sample creates an ObservableAndObserver using ObservableAndObserver.just() method.
The below code will print the entire list in a single emission.

Difference between ObservableAndObserver.from() and ObservableAndObserver.just() —  ObservableAndObserver.just() emits only once whereas ObservableAndObserver.from()emits n times i.e. the length of the array.
*/

public class ObservableJust {
    public static void main(String [] args){
        Observable<String> source = Observable.just("first", "second", "third", "four");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String strings) {
                System.out.println("onNext: " + strings);

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Complete");
            }
        };

        source.subscribe(observer);

        // Another method with lambda expressions, this is easy but this cannot be used when the code gets complex
        // We can use it for simple operations like this.
        source.subscribe(System.out::println, Throwable::printStackTrace,() -> System.out.println("Operation Completed"));

    }
}
