## Node: Ctrl + Shift + V to read the file easily
--------------------------------
|        English                |
--------------------------------

# Problem A
# A Game with Cows
## Time Limit: 1 second
## Memory Limit: 512 megabytes

Hieu and RR are two cowherd boys working in a barn. This barn has 109 stalls, numbered 1 to 109 from the left to the right. Each stall can hold at most one cow. There are 𝑁 cows numbered from 1 to 𝑁 (𝑁 ≤ 106). Every day at 3PM, the cows come back to the stalls from the lawn. Each cow will take a random stall. 

The 𝑖'𝑡ℎ cow will take stall 𝑎<sub>𝑖</sub> and all 𝑎<sub>𝑖</sub> are pairwise distinct. To make the feeding process easier, Hieu and RR want to move all 𝑁 cows 
to the left (occupied stall 1 to stall 𝑁). They decided to make a game, taking 
alternative turns:

• Hieu is the first to move.
• In each turn, the player must move the rightmost cow (the cow in the stall max(𝑎<sub>𝑖</sub>)) to any empty stall on its left.
• If a player can not make a move, he loses.

Given the initial positions of 𝑁 cows, your task is to determine who wins if they both play optimally.
### Input:

The input contains multiple test cases, starting with an integer 𝑇 (1 ≤ 𝑇 ≤ 105) – the number of test cases. The following lines contain the description of each test case. Each test case starts with a single integer 𝑁 – the number of cows. (1 ≤ 𝑁 ≤ 106). The second line consists of 𝑁 distinct integers 𝑎1, 𝑎2, … , 𝑎𝑁. (1 ≤ 𝑎<sub>𝑖</sub> ≤ 109). It is guaranteed that the sum of 𝑁 over all test cases does not exceed 106.

### Output:
For each test case, output “Hieu” (without the quotes) if Hieu wins or “RR” (without the quotes) if RR wins, given that they both play optimally.
| Sample Input | Sample Output |
|--------------|---------------|
| 4            |               |
| 2            |               |
| 3 4          | RR            |
| 3            |               |
| 1 2 4        | Hieu          |
| 3            |               |
| 1 3 5        | Hieu          |
| 5            |               |
| 1 2 3 4 5    | RR

--------------------------------
|        Tiếng Việt            |
--------------------------------
# Bài toán A
# Trò chơi với bò
## Giới hạn thời gian: 1 giây
## Giới hạn bộ nhớ: 512 megabyte

Hiếu và RR là hai cậu bé chăn bò làm việc trong một chuồng bò. Chuồng trại này có 109 chuồng, được đánh số từ 1 đến 109 từ trái qua phải. Mỗi chuồng có thể chứa tối đa một con bò. Có 𝑁 con bò được đánh số từ 1 đến 𝑁 (𝑁 ≤ 106).Hàng ngày vào lúc 3 giờ chiều, những con bò từ bãi cỏ trở về chuồng. Mỗi con bò sẽ chọn một chuồng ngẫu nhiên.

Con bò 𝑖'𝑡ℎ sẽ vào chuồng 𝑎<sub>𝑖</sub> và tất cả 𝑎<sub>𝑖</sub> đều được phân biệt theo từng cặp. Để quá trình cho ăn dễ dàng hơn, Hiếu và RR muốn di chuyển tất cả 𝑁 con bò ở bên trái (chiếm gian hàng 1 đến gian hàng 𝑁).Họ quyết định chơi một trò chơi, lấy
lượt thay thế:

• Hiếu là người hành động đầu tiên.
• Trong mỗi lượt, người chơi phải di chuyển con bò ngoài cùng bên phải (con bò trong chuồng max(𝑎<sub>𝑖</sub>)) sang bất kỳ chuồng trống nào ở bên trái nó.
• Nếu người chơi không thể di chuyển thì sẽ thua.

Với vị trí ban đầu của 𝑁 con bò, nhiệm vụ của bạn là xác định xem ai thắng nếu cả hai đều chơi tối ưu.
### Đầu vào:

Dữ liệu đầu vào chứa nhiều ca kiểm thử, bắt đầu bằng số nguyên 𝑇 (1 ≤ 𝑇 ≤ 105) – số ca kiểm thử. Các dòng sau chứa mô tả của từng ca kiểm thử. Mỗi ca kiểm thử bắt đầu bằng một số nguyên 𝑁 – số lượng ca kiểm thử bò.(1 ≤ 𝑁 ≤ 106).Dòng thứ hai gồm 𝑁 số nguyên phân biệt 𝑎1, 𝑎2, … , 𝑎𝑁.(1 ≤ 𝑎<sub>𝑖</sub> ≤ 109). Đảm bảo rằng tổng của 𝑁 trên tất cả các trường hợp thử nghiệm không vượt quá 106.

### Đầu ra:
Với mỗi test, in ra “Hieu” (không có dấu ngoặc kép) nếu Hiếu thắng hoặc “RR” (không có dấu ngoặc kép) nếu RR thắng, với điều kiện là cả hai đều chơi tối ưu.
|Đầu vào mẫu |Đầu ra mẫu |
|--------------|--------------|
|4 ||
|2 ||
|3 4 |RR |
|3 ||
|1 2 4 |Hiếu |
|3 ||
|1 3 5 |Hiếu |
|5 ||
|1 2 3 4 5 |RR


## Node: Ctrl + Shift + V để đọc file dễ dàng