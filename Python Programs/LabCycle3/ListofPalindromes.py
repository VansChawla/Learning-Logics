inputs = ['Racecar', 'abc', 'lEvel']

def palindrome(inputs):
    output = []
    for input in inputs:
        input_l = input.lower()

        reverse = ""
        for char in input_l:
            reverse = char + reverse
            
        if reverse == input_l:
            output.append(input)
        
    return output

print(palindrome(inputs))

