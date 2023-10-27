import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FilteredIterator implements Iterator<Integer> {
    private Integer next = null;
    private Predicate<Integer> predicate;
    private Iterator<Integer> iterator;

    public FilteredIterator(Iterator<Integer> iterator, Predicate<Integer> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        findNext();
    }

    private void findNext() {
        while (this.iterator.hasNext()) {
            Integer nextElem = this.iterator.next();
            if (this.predicate.test(nextElem)) {
                this.next = nextElem;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        Integer ret = this.next;
        this.next = null;
        findNext();
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        FilteredIterator filteredIterator = new FilteredIterator(list.iterator(), i -> i % 5 == 1);
        while (filteredIterator.hasNext()) {
            System.out.println(filteredIterator.next());
        }
    }
}
