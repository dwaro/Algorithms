"""
Write a function that when given a number >= 0, returns an Array of ascending
length subarrays.
"""

def pyramid(n):
    return [[1]*(i+1) for i in range(n)]

"""
Tests

Test.assert_equals(pyramid(0), [])
Test.assert_equals(pyramid(1), [[1]])
Test.assert_equals(pyramid(2), [[1], [1, 1]])
Test.assert_equals(pyramid(3), [[1], [1, 1], [1, 1, 1]])

"""
