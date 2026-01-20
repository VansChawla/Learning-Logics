import time
import atexit

class Timer:
    # Class-level list to store logs across all instances
    logs = []

    def __init__(self, func):
        self.func = func
        # Register the save_logs method to run when the script ends
        atexit.register(self.save_logs)

    def __call__(self, *args, **kwargs):
        start_time = time.time()
        result = self.func(*args, **kwargs)
        end_time = time.time()
        
        duration = end_time - start_time
        log_entry = f"Function '{self.func.__name__}' executed in {duration:.6f} seconds."
        
        # Store log in the class variable
        Timer.logs.append(log_entry)
        print(f"[Console] {log_entry}")
        
        return result

    @classmethod
    def save_logs(cls):
        """Writes all collected logs to a file on exit."""
        if cls.logs:
            with open("execution_log.txt", "w") as f:
                for entry in cls.logs:
                    f.write(entry + "\n")
            print("-> Logs saved to 'execution_log.txt'")

class Matrix:
    def __init__(self, data):
        self.data = data

    @Timer
    def multiply(self, other):
        # 10x10 Matrix Multiplication (List of Lists)
        result = [[0 for _ in range(10)] for _ in range(10)]
        
        for i in range(10):
            for j in range(10):
                for k in range(10):
                    result[i][j] += self.data[i][k] * other.data[k][j]
        return Matrix(result)

# --- Driver Code ---
if __name__ == "__main__":
    # Create two 10x10 matrices with dummy values (e.g., all 2s and all 3s)
    mat_a = Matrix([[2 for _ in range(10)] for _ in range(10)])
    mat_b = Matrix([[3 for _ in range(10)] for _ in range(10)])

    print("--- Starting Matrix Multiplication ---")
    
    # Perform multiplication (Triggers the Timer)
    mat_c = mat_a.multiply(mat_b)
    
    # Perform a second time to show multiple logs
    mat_d = mat_a.multiply(mat_b)

    print("--- Program Finishing (Check file after exit) ---")