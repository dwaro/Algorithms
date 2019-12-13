"""
In this kata, you've to count lowercase letters in a given string and return
the letter count in a hash with 'letter' as key and count as 'value'.
"""

def letter_count(s):
    track = {}
    for x in s:
        if x in track: track[x] += 1
        else: track[x] = 1
    return track

"""
Tests

Test.describe("Basic Test")
Test.assert_equals(letter_count("codewars"), {"a": 1, "c": 1, "d": 1, "e": 1, "o": 1, "r": 1, "s": 1, "w": 1})
Test.assert_equals(letter_count("activity"), {"a": 1, "c": 1, "i": 2, "t": 2, "v": 1, "y": 1})
Test.assert_equals(letter_count("arithmetics"), {"a": 1, "c": 1, "e": 1, "h": 1, "i": 2, "m": 1, "r": 1, "s": 1, "t": 2})
Test.assert_equals(letter_count("traveller"), {"a": 1, "e": 2, "l": 2, "r": 2, "t": 1, "v": 1})
Test.assert_equals(letter_count("daydreamer"), {"a": 2, "d": 2, "e": 2, "m": 1, "r": 2, "y": 1})

"""
