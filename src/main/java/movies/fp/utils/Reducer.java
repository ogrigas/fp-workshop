package movies.fp.utils;

public interface Reducer<A, T> {

    A apply(A accumulator, T item);

}
