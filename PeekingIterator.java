// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

// Brute force O(n) time, O(n) space
// class PeekingIterator implements Iterator<Integer> {

//     List<Integer> list;
//     int idx;

// 	public PeekingIterator(Iterator<Integer> iterator) {
// 	    // initialize any member here.
// 	    this.list = new ArrayList<>();
//         this.idx = 0;

//         while (iterator.hasNext()) {
//             list.add(iterator.next());
//         }
// 	}
	
//     // Returns the next element in the iteration without advancing the iterator.
// 	public Integer peek() {
//         return list.get(idx);
// 	}
	
// 	// hasNext() and next() should behave the same as in the Iterator interface.
// 	// Override them if needed.
// 	@Override
// 	public Integer next() {
//         int val = list.get(idx);
//         idx++;
// 	    return val;
// 	}
	
// 	@Override
// 	public boolean hasNext() {
// 	    return idx < list.size();
// 	}
// }


// O(1) time, O(1) space

import java.util.*;

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> itr;
    Integer nextVal;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
        if (itr.hasNext()) {
            nextVal = itr.next();
        }
        else {
            nextVal = null;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer temp = nextVal;
        if (itr.hasNext()) {
            nextVal = itr.next();
        }
        else {
            nextVal = null;
        }
        return temp;
	}
	
	@Override
	public boolean hasNext() {
	    return nextVal != null;
	}
}