from itertools import combinations,permutations
# Ex 1
A = [1, 2, 3, 4, 5]
permute_k = list(permutations(A,3))
result = []
for i in permute_k:
    temp = ''
    for j in i: 
        temp += str(j)
    result.append(temp)
print(' Ex1: there are %i of 3-digit numbers can be formed from the digits in set 𝐴 without repetition' %len(result))
print(result)

# # Ex2
white_ball = ['W1', 'W2', 'W3', 'W4', 'W5', 'W6', 'W7', 'W8']
black_ball = ['B1', 'B2', 'B3', 'B4', 'B5', 'B6']
red_ball =  ['R1', 'R2', 'R3', 'R4','R5', 'R6', 'R7','R8', 'R9']
# solution for (a)
from itertools import product

result = list(combinations(white_ball + black_ball + red_ball, 3))
print(len(result))
# solution for (b)
combine_white = list(permutations(white_ball,1))
combine_black = list(permutations(black_ball,1))
combine_red = list(permutations(red_ball,1))
result =list(product( combine_white,combine_black,combine_red))
result = [tuple(item for sublist in tpl for item in sublist) for tpl in result]
print(result)


# Ex 3 
from itertools import combinations,permutations
mathematics = ['Math1', 'Math2', 'Math3', 'Math4']
mathematics = list(combinations((mathematics),len(mathematics)))

physics = ['Physics1', 'Physics2', 'Physics3']
physics = list(combinations((physics),len(physics)))

chemistry = ['Chemistry1', 'Chemistry2']
chemistry = list(combinations((chemistry),len(chemistry)))

language = ['Language1']
language = list(combinations((language),len(language)))

subject = [language,physics,chemistry,mathematics]
subject = permutations(subject)
for i in subject:
    for x in i:
        print(x)
    print()
    
# Ex 4

men = ['man1','man2','man3','man4','man5','man6']
women = ['woman1','woman2','woman3','woman4','woman5','woman6','woman7','woman8','woman9']

men = list(combinations(men,3))
women = list(combinations(women,2))
people = len(men) * len(women)
print(people)
people = list(women + men)
list_people = list(combinations(people,len(people)))
for i in list_people:
    print(i)
    
# Ex05
# spades (♠), clubs (♣), diamonds (♦) and hearts (♥)
suits = ['♠', '♣', '♦', '♥']
numbers = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K ']
def cross(A, B):
    return {a + b for a in A for b in B}

space =list(cross(suits,numbers))


# solution for (a)
permute_a = list(permutations(space,3))
print('a) there are %d way to take possible 5 card from 52 card 𝑝𝑜𝑘𝑒r' % len(permute_a))

# solution for (b)
permute_3_card = list(permutations(space,3))
permute_3_same_number = []
for a,b,c in permute_3_card:
    if a[1] == b[1] and c[1] == b[1]:
        permute_3_same_number.append((a,b,c))

print('take three cards with the same number: %i ways'%len(permute_3_same_number))

for a,b,c in permute_3_card:
    the_other_Card = set(space) - set((a,b,c))
permute_2_in_the_other = list(permutations(the_other_Card,2))

get_three_kind = len(permute_3_same_number)*len(permute_2_in_the_other)

print('there are %i ways to find of “three of a kind”' %get_three_kind)


