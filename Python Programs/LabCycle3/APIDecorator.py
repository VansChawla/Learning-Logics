import time
import random

def retry(max_attempts=3, delay=1):
    def decorator(func):
        def wrapper(*args, **kwargs):
            current_delay = delay
            for attempt in range(1, max_attempts + 1):
                try:
                    return func(*args, **kwargs)
                except Exception as e:
                    print(f"[Log] Attempt {attempt} failed: {e}")
                    if attempt == max_attempts:
                        raise  # Re-raise exception after last attempt
                    
                    print(f"[Log] Retrying in {current_delay}s...")
                    time.sleep(current_delay)
                    current_delay *= 2  # Exponential backoff
        return wrapper
    return decorator

# --- Test ---
@retry(max_attempts=3, delay=1)
def connect_api():
    if random.random() < 0.7:  # 70% chance to fail
        raise ConnectionError("Network timeout")
    return "Status: 200 OK"

try:
    print(connect_api())
except Exception as e:
    print(f"Final Error: {e}")