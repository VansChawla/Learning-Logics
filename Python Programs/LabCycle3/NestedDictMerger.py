def merge_dicts(d1, d2):
    for k, v in d2.items():
        if k in d1:
            # merge for nested dicts
            if isinstance(d1[k], dict) and isinstance(v, dict):
                merge_dicts(d1[k], v)
            # Sum numeric values
            elif isinstance(d1[k], (int, float)) and isinstance(v, (int, float)):
                d1[k] += v
            # Raise error for type mismatches
            else:
                raise KeyError(f"Type conflict at '{k}': {type(d1[k])} vs {type(v)}")
        else:
            d1[k] = v
    return d1

try:
    dict1 = {'a': 1}
    dict2 = {'a': 2, 'b': {'c': 3}}
    print(merge_dicts(dict1, dict2))
except KeyError as e:
    print(f"Log: {e}")