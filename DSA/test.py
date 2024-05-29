user_input = input('please enter two words: ')
words = user_input.split()
word1, word2 = words

file = open('wordsEn.txt', 'r')
lines = file.readlines()

stack = [word1]
result = [word1, word2]
    

for line in lines:
    line = line.strip()
    if len(line) > 3:
        if line[:2] == result[-1][-2:]:
            result.append(line)
    
            
        
      
        
file.close

print(result)
