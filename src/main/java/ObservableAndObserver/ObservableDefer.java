package ObservableAndObserver;

import io.reactivex.Observable;


/**
 * Created by Srikar on Mar, 2019
 */

/*
* Defer
This operator does not create the ObservableAndObserver until the Observer subscribes.
The only downside to defer() is that it creates a new ObservableAndObserver each time you get a new Observer.
create() can use the same function for each subscriber, so it’s more efficient.

Sample Implementation: The below sample creates an ObservableAndObserver using ObservableAndObserver.defer() method.
The below code creates an ObservableAndObserver that emits a value.

So sometimes we have state changes then the observable once used it wont keep track of state changes



*/
public class ObservableDefer {

    public static int a =0, b =10;

    public static void main(String [] args){
        Observable<String> source = Observable.defer(() -> Observable.just("First", "Second", "Third"));
        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("operation complete"));
        stateChange();
        deferFactory();
    }


    public static void stateChange(){

        // So here you can see that we are changing the value of b
        // before we are subscribing to another observer and we expect
        // to print till 15 but it won't that's because it didn't catch the state changes
        // because it is created before with the values. so in these cases we use defer
        // because it creates the observable only when it is subscribes.
        int a = 0, b = 10;

        Observable<Integer> source = Observable.range(a, b);

        source.subscribe(System.out::println);
        b =15;
        source.subscribe(e -> System.out.println("Observer 2: " + e));
    }

    private static void deferFactory(){
        // Here it works as the observable is getting created only after it is subscribed by an observer.
        Observable<Integer> source = Observable.defer(() -> Observable.range(a, b));
        source.subscribe(System.out::println);
        b =15;
        source.subscribe(e -> System.out.println("Observer 2 : " + e));

    }
}
