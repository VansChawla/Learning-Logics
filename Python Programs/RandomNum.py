import random

randNum = random.randint(1, 20)
guess = None

while guess != randNum:
    
    guess = int(input("Guess a number: "))
    
    if(randNum == guess):
        print("Correct!")
    elif(randNum < guess):
        print("Too High")
    else:
        print("Too Low")
        


