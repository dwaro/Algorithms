"""
You need to write a function, that returns the first non-repeated character in the given string.

For example for string "test" function should return 'e'.
For string "teeter" function should return 'r'.

If a string contains all unique characters, then return just the first character of the string.
Example: for input "trend" function should return 't'

You can assume, that the input string has always non-zero length.

If there is no repeating character, return null in JS or Java, and None in Python.

"""

def first_non_repeated(s):
    # Edge case
    if len(s) == 1:
        return None

    try:
        d = [string.count(l) for l in s]
        return s[d.index(1)]
    except ValueError:
        return "All letters in string are repeated."

    # Edge case
    # if len(s) == 1:
    #     return None
    #
    # # Build dictionary
    # tracker = {}
    # for letter in s:
    #     if letter in tracker:
    #         tracker[letter] += 1
    #     else:
    #         tracker[letter] = 1
    #
    # # Catch first character with only one value in the string
    # for letter in s:
    #     if tracker[letter] == 1: return letter
