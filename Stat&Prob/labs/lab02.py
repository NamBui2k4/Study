import random
import math

#Ex01
def simulator_dice1(n):
    count_even = 0 

    for _ in range(n):
        dice1 = random.randint(1, 6) 
        dice2 = random.randint(1, 6)  

        if dice1 % 2 == 0 and dice2 % 2 == 0: 
            count_even += 1

    probability = count_even / n  

    return probability

#Ex02
def simulator_dice2(n):
    count_even_odd = 0  

    for _ in range(n):
        dice1 = random.randint(1, 6)  
        dice2 = random.randint(1, 6)  

        if (dice1 % 2 == 0 and dice2 % 2 != 0) or (dice1 % 2 != 0 and dice2 % 2 == 0):
            count_even_odd += 1

    probability = count_even_odd / n

    return probability

#Ex03
def simulator_dice3(n):
    count_same = 0  

    for _ in range(n):
        dice1 = random.randint(1, 6)  
        dice2 = random.randint(1, 6)  

        if dice1 == dice2:
            count_same += 1

    probability = count_same / n  
    return probability

#Ex04
def simulator_dice4(n):
    count_same = 0  

    for _ in range(n):
        dice1 = random.randint(1, 6)  
        dice2 = random.randint(1, 6) 

        if dice1 == 1 and dice2 == 6:
            count_same += 1

    probability = count_same / n 
    return probability

#Ex05
def simulator_dice5(n):
    count_same = 0 
    for _ in range(n):
        dice1 = random.randint(1, 6)  
        dice2 = random.randint(1, 6)  

        if (dice1 + dice2) > 6:
            count_same += 1

    probability = count_same / n 
    return probability

#Ex06
def simulator_poker1(n):
    count_all_hearts = 0  

    for _ in range(n):
        deck = ['♥A', '♥2', '♥3', '♥4', '♥5', '♥6', '♥7', '♥8', '♥9', '♥10', '♥J', '♥Q', '♥K',
                '♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♠8', '♠9', '♠10', '♠J', '♠Q', '♠K',
                '♦A', '♦2', '♦3', '♦4', '♦5', '♦6', '♦7', '♦8', '♦9', '♦10', '♦J', '♦Q', '♦K',
                '♣A', '♣2', '♣3', '♣4', '♣5', '♣6', '♣7', '♣8', '♣9', '♣10', '♣J', '♣Q', '♣K']

        hand = random.sample(deck, 5) 
        if all(card[0] == '♥' for card in hand): 
            count_all_hearts += 1

    probability = count_all_hearts / n  
    return probability

#Ex07
def simulator_poker2(n):
    count_all_different = 0 

    for _ in range(n):
        deck = ['♥A', '♥2', '♥3', '♥4', '♥5', '♥6', '♥7', '♥8', '♥9', '♥10', '♥J', '♥Q', '♥K',
                '♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♠8', '♠9', '♠10', '♠J', '♠Q', '♠K',
                '♦A', '♦2', '♦3', '♦4', '♦5', '♦6', '♦7', '♦8', '♦9', '♦10', '♦J', '♦Q', '♦K',
                '♣A', '♣2', '♣3', '♣4', '♣5', '♣6', '♣7', '♣8', '♣9', '♣10', '♣J', '♣Q', '♣K']

        hand = random.sample(deck, 4) 
        suits = [card[0] for card in hand]  

        if len(set(suits)) == 4:  
            count_all_different += 1

    probability = count_all_different / n  
    return probability

#Ex08
def Ex08():
    white_balls = 8
    blue_balls = 6
    red_balls = 9

    total_balls = white_balls + blue_balls + red_balls
    selected_balls = 6
    return (math.comb(white_balls, 2) * math.comb(blue_balls, 2) * math.comb(red_balls, 2)) / math.comb(total_balls, selected_balls)

n = 100000  

print("ex01:",simulator_dice1(n))
print("ex02:",simulator_dice2(n))
print("ex03:",simulator_dice3(n))
print("ex04:",simulator_dice4(n))
print("ex05:",simulator_dice5(n))
print("ex06:",simulator_poker1(n))
print("ex07:",simulator_poker2(n))
print("ex08:",Ex08())