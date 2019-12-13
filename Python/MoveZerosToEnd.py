"""
Write an algorithm that takes an array and moves all of the zeros to the end,
preserving the order of the other elements.

move_zeros([false,1,0,1,2,0,1,3,"a"]) # returns[false,1,1,2,1,3,"a",0,0]

"""
def move_zeros(array):
    count = 0
    zeros = ["0","0.0"]
    for i in range(len(array)):
        if str(array[i-count]) in zeros and type(array[i-count])!=str:
            del array[i-count]
            array.append(0)
            count += 1
    return array
