#Create a function that takes two tuples of integers, converts them to sets, finds their symmetric difference, then converts back to a sorted tuple. Raise a custom ValueError if any element is non-integer. Test with (1,2,3) and (3,4,5). 

class NotIntError(ValueError):
    pass

def sym_diff_tuples(t1, t2):

    for item in t1+t2:
        if not isinstance(item, int):
            raise NotIntError(f"Invalid element found: '{item}'. All elements must be integers.")

    set1 = set(t1)
    set2 = set(t2)

    sym_diff = set1 ^ set2

    result = tuple(sorted(sym_diff))

    return result

if __name__ == "__main__":
    try:
        tuple_a = (1, 2, 3)
        tuple_b = (3, 4, 5)

        tuple_c = (1, 2, 3)
        tuple_d = (3, 4, "vansh")

        output1 = sym_diff_tuples(tuple_a, tuple_b)
        print(f"Symmetric Difference (Sorted Tuple): {output1}")
        
        output2 = sym_diff_tuples(tuple_c, tuple_d)
        print(f"Symmetric Difference (Sorted Tuple): {output2}")

    except NotIntError as e:
        print(e)