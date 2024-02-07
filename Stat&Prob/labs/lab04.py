# Ex 01
import random
# a) same dices
def simulate_same_dice(n):
    count_same = 0
    for i in range(n):
        dice1 = random.randint(1, 6)
        dice2 = random.randint(1,6)
        
        if (dice1 == dice2):
            count_same += 1
    return count_same/n

# b) different dices
def simulate_diff_dice(n):
    count_diff = 0
    for i in range(n):
        dice1 = random.randint(1, 6)
        dice2 = random.randint(1,6)
        
        if (dice1 != dice2):
            count_diff += 1
    return count_diff/n
# c) both even dices
def simulate_even_dice(n):
    count_even = 0
    for i in range(n):
        dice1 = random.randint(1, 6)
        dice2 = random.randint(1,6)
        
        if dice1 % 2==0 and dice2 % 2==0:
            count_even += 1
    return count_even/n

# d)  both odd dices
def simulate_odd_dice(n):
    count_odd = 0
    for i in range(n):
        dice1 = random.randint(1, 6)
        dice2 = random.randint(1,6)
        
        if (dice1%2 != 0 and  dice2%2!=0):
            count_odd += 1
    return count_odd/n

# e) one even one odd
def simulate_even_odd(n):
    count_even_odd = 0
    for i in range(n):
        dice1 = random.randint(1, 6)
        dice2 = random.randint(1,6)
        
        if (dice1%2 == 0 and  dice2%2!=0) or (dice1%2 != 0 and  dice2%2==0):
            count_even_odd += 1
    return count_even_odd/n

# f) both dices are 6
def simulate_both_six(n):
    count_six = 0
    for i in range(n):
        dice1 = random.randint(1, 6)
        dice2 = random.randint(1,6)
        
        if (dice1 == 6 and  dice2%2==6):
            count_odd += 1
    return count_odd/n
# g) sum of dice more than 10
def simulate_sum_more_than_ten(n):
    count_sum= 0
    for i in range(n):
        dice1 = random.randint(1, 6)
        dice2 = random.randint(1,6)
        
        if (dice1 + dice2 > 10):
            count_sum += 1
    return count_sum/n


# Ex02
from itertools import combinations
def cross(A,B):
    return {a + b for a in A for b in B}
Blue = cross('B','12')
Red = cross('R','123')
White = cross('W','12345')
urn = Blue | Red  | White


# a) 3 ball are the same color
def simulate_the_same(n):
    count = 0
    c
        
    return count/n

# b) 3 balls are different color
def simulate_diff(n):
    count = 0
    for i in range(n):
        space = list(combinations(urn,3))
        index = random.randint(1,len(space)-1)
        random_balls =  space[index]
        color = [a[0] for a in random_balls ]
        if (len(set(color)) == 3):
            count += 1
        
    return count/n

# c) 2 ball are the same color
def simulate_2_same(n):
    count = 0
    for i in range(n):
        space = list(combinations(urn,3))
        index = random.randint(1,len(space)-1)
        random_balls =  space[index]
        color = [a[0] for a in random_balls ]
        if (len(set(color)) == 2):
            count += 1
        
    return count/n                                

# are 2 red balls and 1 white ball

def simulate_2_red_1_white(n):
    count = 0
    for i in range(n):
        space = list(combinations(urn,3))
        index = random.randint(1,len(space)-1)
        random_balls =  space[index]
        color = [a[0] for a in random_balls ]
        if set(color).__contains__('R') and set(color).__contains__('W'):
            count += 1
        
    return count/n 

# 3 bi đều màu trắng. 
def simulate_3_white(n):
    count = 0
    for i in range(n):
        space = list(combinations(urn,3))
        index = random.randint(1,len(space)-1)
        random_balls =  space[index]
        color = [a[0] for a in random_balls ]
        if set(color).__contains__('W') and len(set(color)) == 1:
            count += 1
    return count/n

# Ex 04
# a) 4 lá cùng chất
def simulator_poker2(n):
    count = 0 

    for _ in range(n):
        deck = ['♥A', '♥2', '♥3', '♥4', '♥5', '♥6', '♥7', '♥8', '♥9', '♥10', '♥J', '♥Q', '♥K',
                '♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♠8', '♠9', '♠10', '♠J', '♠Q', '♠K',
                '♦A', '♦2', '♦3', '♦4', '♦5', '♦6', '♦7', '♦8', '♦9', '♦10', '♦J', '♦Q', '♦K',
                '♣A', '♣2', '♣3', '♣4', '♣5', '♣6', '♣7', '♣8', '♣9', '♣10', '♣J', '♣Q', '♣K']

        hand = random.sample(deck, 4) 
        suits = [card[0] for card in hand]  

        if len(set(suits)) == 1:  
            count += 1

    probability = count / n  
    return probability

# b) 4 lá khác chất
def simulator_poker2(n):
    count = 0 

    for _ in range(n):
        deck = ['♥A', '♥2', '♥3', '♥4', '♥5', '♥6', '♥7', '♥8', '♥9', '♥10', '♥J', '♥Q', '♥K',
                '♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♠8', '♠9', '♠10', '♠J', '♠Q', '♠K',
                '♦A', '♦2', '♦3', '♦4', '♦5', '♦6', '♦7', '♦8', '♦9', '♦10', '♦J', '♦Q', '♦K',
                '♣A', '♣2', '♣3', '♣4', '♣5', '♣6', '♣7', '♣8', '♣9', '♣10', '♣J', '♣Q', '♣K']

        hand = random.sample(deck, 4) 
        suits = [card[0] for card in hand]  

        if len(set(suits)) == 4:  
            count += 1

    probability = count / n  
    return probability

# c) 4 lá cùng màu
def simulator_poker2(n):
    count = 0 

    for _ in range(n):
        deck = ['♥A', '♥2', '♥3', '♥4', '♥5', '♥6', '♥7', '♥8', '♥9', '♥10', '♥J', '♥Q', '♥K',
                '♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♠8', '♠9', '♠10', '♠J', '♠Q', '♠K',
                '♦A', '♦2', '♦3', '♦4', '♦5', '♦6', '♦7', '♦8', '♦9', '♦10', '♦J', '♦Q', '♦K',
                '♣A', '♣2', '♣3', '♣4', '♣5', '♣6', '♣7', '♣8', '♣9', '♣10', '♣J', '♣Q', '♣K']

        hand = random.sample(deck, 4) 
        color = [card[0] for card in hand]  

        if len(set(color)) == 1:  
            count += 1

    probability = count / n  
    return probability    

# d) 4 lá cùng chỉ số
def simulator_poker2(n):
    count = 0 

    for _ in range(n):
        deck = ['♥A', '♥2', '♥3', '♥4', '♥5', '♥6', '♥7', '♥8', '♥9', '♥10', '♥J', '♥Q', '♥K',
                '♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♠8', '♠9', '♠10', '♠J', '♠Q', '♠K',
                '♦A', '♦2', '♦3', '♦4', '♦5', '♦6', '♦7', '♦8', '♦9', '♦10', '♦J', '♦Q', '♦K',
                '♣A', '♣2', '♣3', '♣4', '♣5', '♣6', '♣7', '♣8', '♣9', '♣10', '♣J', '♣Q', '♣K']
        hand = random.sample(deck,4)        
        number = [card[1] for card in hand]  

        if len(set(number)) == 1:  
            count += 1

    probability = count / n  
    return probability 

# Ex04
from itertools import combinations
# a)
def cross(A,B):
    return {a + b for a in A for b in B}
Blue = cross('B','123')
Red = cross('R','1234')
White = cross('W','12')
urn = Blue | Red  | White

# b) / Tìm tập con gồm 3 quả banh từ tập hợp URN trên (không phân biệt thứ tự). Lưu kết quả của tập con đó vào biến U3. 
U3 = list(combinations(urn,3))
# c) / Liệt kê các trường hợp 3 quả banh được chọn ở câu (b) có một quả banh màu trắng, 
# một quả banh màu xanh dương và một quả banh màu đỏ, kết quả lưu vào biến white1blue1red1. 
from collections import Counter
white1blue1red1 = []
for i in U3:
    colors = [card[0] for card in i]
    color_counts = Counter(colors)
    if color_counts['W'] == 1 and color_counts['B'] == 1 and color_counts['R'] == 1:
        white1blue1red1.append(i)
# d) Tính xác suất chọn ngẫu nhiên 3 quả banh trong đó có một quả banh màu trắng,
# một quả banh màu xanh dương và một quả banh màu đỏ, kết quả lưu vào biến P. 
P = len(white1blue1red1)/len(U3)



