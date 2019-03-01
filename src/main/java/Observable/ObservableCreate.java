package Observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Srikar on Mar, 2019
 */


// This is an example for observable.create()

    /*Create
     This operator creates an Observable from scratch by calling observer methods programmatically.
     An emitter is provided through which we can call the respective interface methods when needed.

     Sample Implementation: The below sample creates an Observable using Observable.create() method.
     The create() method does not have an option to pass values. So we have to create the list beforehand and perform operations on the list inside the onNext() method.
     The below code will print each item from the list.
     */

public class ObservableCreate {
    public static void main(String [] args) {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("first");
                emitter.onNext("Second");
                emitter.onNext("third");
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });


        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext: " + o);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        source.subscribe(observer);

        // using lambda expressions
        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Operation completed"));
    }
}
