import random
import time

def find_longest_unique_sublist(data):
    max_sublist = []
    max_len = 0
    n = len(data)

    # Outer loop: Start of the sublist
    for i in range(n):
        seen = set()
        current_sublist = []
        
        # Inner loop: End of the sublist
        for j in range(i, n):
            element = data[j]
            
            # If duplicate found, stop this inner sequence
            if element in seen:
                break
            
            # Add to set and current sublist
            seen.add(element)
            current_sublist.append(element)
            
            # Update maximum found so far
            if len(current_sublist) > max_len:
                max_len = len(current_sublist)
                max_sublist = current_sublist

    return max_sublist, max_len

# --- Driver Code ---
if __name__ == "__main__":
    # 1. Generate large list with duplicates (Range 0-50 ensures frequent duplicates)
    large_list = [random.randint(0, 50) for _ in range(1000)]
    
    print(f"List size: {len(large_list)}")
    print("Finding longest unique sublist...")

    # 2. Measure efficiency
    start_time = time.time()
    result_list, length = find_longest_unique_sublist(large_list)
    end_time = time.time()

    # 3. Output results
    print(f"-> Execution Time: {end_time - start_time:.4f} seconds")
    print(f"-> Max Length: {length}")
    # Printing the first 20 items of the result to avoid clutter
    print(f"-> Sublist (preview): {result_list[:20]} ...")