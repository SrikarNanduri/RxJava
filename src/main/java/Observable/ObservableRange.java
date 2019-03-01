package Observable;

import io.reactivex.Observable;

/**
 * Created by Srikar on Mar, 2019
 */
/*Range
This operator creates an Observable that emits a range of sequential integers. The function takes two arguments: the starting number and length.

Sample Implementation: The below sample creates an Observable using Observable.range() method.
The below has a starting number of 0 and a range of 10 numbers, so it will print values from 0 to 9.*/
public class ObservableRange {
    public static void main(String[]  args){
        Observable.range(0, 10).subscribe(System.out::println);
        Observable.range(2, 5).subscribe(System.out::println);
    }
}
