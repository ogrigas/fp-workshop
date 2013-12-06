package movies.fp.utils;

import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Iterables.skip;

public class Reducers {

    public static <T> T reduce(Iterable<T> items, Reducer<T, T> reducer) {
        T initialValue = getFirst(items, null);
        return reduce(skip(items, 1), initialValue, reducer);
    }

    public static <A, T> A reduce(Iterable<T> items, A initialValue, Reducer<A, T> reducer) {
        A accumulator = initialValue;
        for (T item : items) {
            accumulator = reducer.apply(accumulator, item);
        }
        return accumulator;
    }
}
