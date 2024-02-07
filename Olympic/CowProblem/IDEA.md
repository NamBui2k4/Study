# Ctrl + shift + V
--------------------------------
|        Tiếng Việt            |
--------------------------------
# Vấn đề bài toán
## Input:
1. số lượng test case 
2. số lượng bò mỗi test case
3. vị trí mỗi con bò

Mỗi con bò sẽ có vị trí ngẫu nhiên.
Mục tiêu của Hieu và RR là di chuyển các con bò từ bên phải về bên trái nhiều nhất có thể, mỗi người chỉ có một lượt đi. Khi bên trái không còn chỗ trống, người nào đi tiếp sẽ thua (vì không di chuyển được nữa). 
    
## Output: tên người thắng
# Ý tưởng
Ta sẽ đưa các con bò vào một mảng, mảng này sẽ có kích thước lớn, nó bao gồm vị trí ngẫu nhiên của các con bò và còn lại là các vị trí trống. Ta sẽ tiến hành swap các vị trí trống ở bên trái và các con bò ở bên phải bên trong mảng đó.
    vd: 
    ban đầu   | bò |------|------|  bò  |------|  bò  |  bò  |

    kết thúc  | bò |  bò  |  bò  |  bò  |------|------|------|

để làm được điều đó, ta giả định rằng vị trí nhập vào của mỗi con bò có thứ tự, vị trí cuối cùng sẽ là con số lớn nhất
    vd: 
        ví trí các con bò: 1, 4, 5, 7 => max  = 7

khi đó, ta sẽ tạo một mảng trống có kích thước là con số lớn nhất. Sau đó, ta sẽ đưa vị trí của các con bò vào mảng 
    vd: 
        danh sách vị trí các con bò [1, 4, 5, 7]
        ta sẽ tạo một mảng trống có 7 phần tử: [ 0,0,0,0,0,0,0 ]
        đưa vị trí con bò vào mảng: [ 1,0,0,4,5,0,7 ] 

Như vậy, có thể thấy, những con số 0 đại diện cho vị trí trống mà Hieu và RR sẽ đưa các con bò ở các ô 1, 4, 5, 7 vào đó. 

Tuy nhiên, cần lưu ý rằng: Mảng luôn có thứ tự bắt đầu từ 0 và kết thúc ở n - 1 , trong khi vị trí con bò luôn bắt đầu từ 1 và kết thúc ở n , nên ta sẽ cần một giải thuật thích hợp đưa các con bò vào vị trí trống.
s
Vì mục tiêu là chỉ ra người thắng cuộc, nên nếu chỉ swap các con bò là chưa đủ. Lượt chơi bắt đầu từ Hieu rồi đến RR, khi đó ta sẽ cho Hieu và RR swap các con bò thep lượt. Mỗi lần swap thành công thì người chơi sẽ trả về true. Nếu một trong 2 người trả về false thì chắc chắn người đó thua. 


--------------------------------
|       English               |
--------------------------------
# Math problem
## Input:
1. number of test cases
2. number of cows per test case
3. Position each cow

Each cow will have a random position.
Hieu and RR's goal is to move the cows from the right to the left as much as possible, each person only has one turn. When the left side has no more space, the person who continues to move will lose (because of not moving)
    
## Output: winner name
# Idea
We will put the cows into an array, this array will have a large size, it includes random positions of the cows and the remaining empty positions. We will proceed to swap the empty positions on the left and the cows are on the right inside that array.
    Ex:
    original |cow |-----|-----|cow |------|cow |cow |

    end |cow |cow |cow |cow |-------|-------|-------|

To do that, we assume that the input position of each cow is in order, the last position will be the largest number.
    Ex:
        Position of cows: 1, 4, 5, 7 => max = 7

Then, we will create an empty array whose size is the largest number. Then, we will put the positions of the cows into the array.
    Ex:
        list of cow locations [1, 4, 5, 7]
        We will create an empty array with 7 elements: [ 0,0,0,0,0,0,0 ]
        put the cow's position into the array: [ 1,0,0,4,5,0,7 ]

Thus, it can be seen that the numbers 0 represent empty positions into which Hieu and RR will put the cows in cells 1, 4, 5, 7.

However, it should be noted that: The array always has an order starting from 0 and ending at n - 1, while the position of the cow always starts from 1 and ends at n, so we will need an appropriate algorithm. Put the cows in the empty position.
S
Since the goal is to determine the winner, just swapping the cows is not enough. The turn starts from Hieu and then RR, then we will let Hieu and RR swap the cows in turn. Each time the swap becomes If successful, the player will return true. If one of the two players returns false, that person will definitely lose.




