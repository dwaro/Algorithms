"""
Your task is to write a function that does just what the title suggests (so,
fair warning, be aware that you are not getting out of it just throwing a lame
bas sorting method there) with an array/list/vector of integers and the expected
number n of smallest elements to return.

Also:

the number of elements to be returned cannot be higher than the
array/list/vector length;

elements can be duplicated;
in case of duplicates, just return them according to the original order (see
third example for more clarity).

"""

def first_n_smallest(arr, n):
    # copy of arr that we can sort
    t = arr.copy()
    t.sort()

    smallest = t[:n] # first n smallest nums

    new = []
    for num in arr:
        if num in smallest:
            new.append(num)
            smallest[smallest.index(num)] = None

    return new

"""
Tests

first_n_smallest([1,2,3,4,5],3) == [1,2,3]
first_n_smallest([5,4,3,2,1],3) == [3,2,1]
first_n_smallest([1,2,3,4,1],3) == [1,2,1]
first_n_smallest([1,2,3,-4,0],3) == [1,-4,0]
first_n_smallest([1,2,3,4,5],0) == []

"""
