package ObservableAndObserver;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import model.User;

/**
 * Created by Srikar on Mar, 2019
 */

/*
* Single
Single is an Observable that always emit only one value or throws an error.
A typical use case of Single observable would be when we make a network call in Android and receive a response.

Sample Implementation: The below code always emits a Single user object.
We use a Single Observable and a Single Observer. The Single Observer always emits only once so there is no onNext().
*/
public class SingleObservable {
    private static int a =0, b =10;
    public static void main(String[] args){
        Observable.just("a", "b").first("lif")
                .subscribe(System.out::println);
        single();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void single(){
        Single.create(new SingleOnSubscribe<User>() {
            @Override
            public void subscribe(SingleEmitter<User> emitter) throws Exception {
                User user = new User("Anitaa");
                emitter.onSuccess(user);
            }
        })
                .observeOn(Schedulers.io())
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(User user) {
                        System.out.println(String.format("User with name %s successfully created: ", user.getName()));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
