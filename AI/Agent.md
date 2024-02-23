# Tác tử (Agent)
Để bắt đầu với trí tuệ nhân tạo, ta cần biết về cái gì trước tiên, đó là tác tử.

## tác tử là gì?

    Tác tử là bất cứ cái gì có khả năng nhận thức
    môi trường xung quanh (environment) thông qua 
    các cảm biến (sensors) và đưa ra một hành động 
    phù hợp bằng các bộ phận hành động (actuators) 
    để đạt được được hiệu quả cao (performance)
\
Như vậy, khi nhắc đến tác tử, chúng ta luôn nghĩ tới 4 cụm từ khóa:
- environment
- sensors
- actuators (hoặc là Effectors)
- performance

Nếu như không có 4 yếu tố trên, sẽ không có khái niệm tác tử.

Ví dụ:

Con người: sensor bao gồm mắt, tai, tay, chân; actuator bao gồm việc di chuyển, nói chuyện, và thực hiện các hành động khác. Evironment là môi trường xung quanh, còn performance là hiệu quả công việc thực hiện từ actuator

Người máy Aishimo: Cảm biến bao gồm camera, các bộ dò đường hồng ngoại; bộ kích hoạt bao gồm việc điều khiển mô tơ.

Hệ chuyên gia MYCIN, Google search, cửa tự động đóng mở cũng đều là các tác tử thông minhi. Đơn giản hơn thì là programs chúng ta viết ra.

![](https://images.viblo.asia/e422bee2-2e61-4ec1-810c-47c6a60c06f7.jpg)

Được rồi, bài viết này chúng ta sẽ nói nhiều 1 chút về tác tử và môi trường của tác tử nhé, vì nói cho cùng, mọi thứ đều là tác tử, kể cả phần mềm cũng vậy.

## Hàm tác tử (Agent function)

Hàm tác tử là hàm ánh xạ từ lịch sử kiến thức cho tới hành động:

    **f: P* -> A**
\
Trong đó:
 - Mỗi dấu `*` đại diện cho một thời điểm. Ví dụ, `*` có nghĩa là 1s, `**` có nghĩa là 2s, hoặc `***` nghĩa là 3s,vv...
 -  `P*` là kiến thức mà tác tử có được ở thời điểm thứ  `*`
 - `A**` là hành động ở thời điểm thứ `**` dựa trên `P*`

Hiểu đơn giản là khi ta có 1 lượng kiến thức nhất định trong lịch sử thì điều đó sẽ quyết định hành động của ta ở hiện tại (và tương lại). 

Một ví dụ đơn giản là tác tử hút bụi thông minh:

- Kiến thức lịch sử (`P*`): Vị trí (A hoặc B), trạng thái (sạch hoặc bẩn).

- Hành động (`A**`): Qua trái, qua phải, hút bụi, 

Ta có:

| `P*`	        |   `A**`
|---------------|---------
| [A, sạch]	    |Qua phải
| [A, bẩn]	    |Hút bụi
| [B, sạch]	    |Qua trái
| [B, bẩn]	    |Hút bụi
| [A, sạch]	    |Qua phải
| [A, sạch]	    |Qua phải

Ngoài ra, ta có 1 định nghĩa nưa: __Tác tử là một chương trình được chạy dựa trên kiến trúc vật lý để tạo ra hàm (f).__

    Tác tử = kiến trúc + chương trình



Ta có thể xây dựng 1 cấu trúc hàm f đơn giản cho tác tử máy hút bụi như sau:

```
def react-vacuum-cleaner location, status
    return if all_map_clean()
    if status == dirty
        clean(location, status)
    else
        move(location)
    end
end

def move location
    self.location = new_location(location)
    update_map location, new_location(location)
end

def update_map current_location, new_location
    draw a map to memory
end

def new_location current_location
    check available location robot can move on
end

```
\
Đại khái là như vậy, nhìn vào những cấu trúc hàm trên, ta có thể hình dung ra được tác tử sẽ làm gì khi nó có được 2 thông tin về location và state, và việc mình cần làm là làm sao cho tác tử sẽ phấn đấu làm đúng công việc dựa trên những gì nó nhận thức được và dựa trên hành động nó có thể thực hiện. 

Ví dụ như, khi đi tìm 1 địa chỉ mới thì robot lau nhà gặp chướng ngại vật khiến nó ko thể đi thẳng. Ta ko thể bắt nó nhảy qua chường ngại vật, mà thay vào đó, việc tìm kiếm các địa chỉ xung quanh lần lượt theo chiều kim đồng hồ hoặc đi ngược trở lại có thể là giải pháp. Việc đưa ra phải giúp cho tác tử có 1 hành động đúng, giúp tác tử đạt được thành công cao nhất với mục tiêu đặt ra (lau sạch nhà).

![](https://i.pinimg.com/564x/6f/0e/8a/6f0e8a98877ae3fd62547f662b27fefd.jpg)

Vậy trí tuệ nhân tạo có ích gì ở đây ? Với mỗi lần robot đi qua 1 địa điểm, nó sẽ có được kiến thức ( được lưu trong bộ nhớ ) và với kiến thức đó, ta có thể linh hoạt  trong mỗi quyết định hành động của robot (vẫn tuân theo cấu trúc hàm f) hoặc sau mỗi lần lau sạch nhà, tri thức sẽ được vận dụng cho những lần lau tiếp theo để đảm bảo hiệu suất cao nhất (tốn ít thời gian, lau sạch hơn, tiết kiệm điện bla blo).

Mọi kiến thức của tác tử được tự thu nạp bởi chính tác tử đó, hành động của tác tử được quyết định bởi kinh nghiệm của tác tử đó (khả năng học và thích nghi). Đây là cách mà hầu hết các ứng dụng trí tuệ nhân tạo ngày nay đang làm.

# Tác tử hợp lý (rational Agent)

    Tác tử hợp lý (Rational Agent) là tác tử 
    có khả năng lựa chọn ra những actuator trong
    kho tùy chọn sao cho tối đa hóa chỉ số 
    performance nhất có thể
\
Thực tế, thuật ngữ “Rational Agent” không chỉ áp dụng riêng cho một hệ thống, mà thuật ngữ cũng dùng để đề cập đến một người, một công ty, hay một ứng dụng, hay bất cứ thứ gì hoặc bất kỳ ai đưa ra quyết định hợp lý.

Rational Agent là thuật ngữ bắt nguồn từ kinh tế học và hiện được sử dụng trong lĩnh vực AI để chỉ những ứng dụng nhằm đạt được các mục tiêu.

Trong AI, Rational Agent có liên quan chặt chẽ với các tác tử thông minh (Intelligent Agent) hoặc các chương trình tự động bắt chước trí thông minh của con người.

![](https://www.researchgate.net/profile/Diane_Cook2/publication/2435158/figure/fig1/AS:394723362656269@1471120791582/Rational-agent-design.png)

### Rational Agent hoạt động như thế nào?

Về cơ bản, một Rational Agent là một tác tử hoạt động dựa trên thông tin. Tác tử này sẽ lấy thông tin thu được từ sensor tiếp xúc với environment và đánh giá environment đó, sau đó xem xét từng actuator có sẵn trong kho tuỳ chọn, rồi xác định xem một effector nào đó sẽ ảnh hưởng đến environment như thế nào và có đạt được mục tiêu hay không. Rational Agent sẽ thử trong tất cả các state có thể cho đến khi chọn ra được state tốt nhất.

![](/pictures/rational-agent(2).png)

Sensor có thể là máy ảnh, thiết bị hồng ngoại, sonar, siêu âm hoặc radar… những thiết bị giúp robot AI xác định kích thước của vật thể hoặc môi trường xung quanh, xác định vật thể và xác định khoảng cách. 

Trong khi đó, effector là bất kỳ thiết bị nào ảnh hưởng đến một môi trường cụ thể (tức là hành động), có thể là chân, bánh xe, cánh tay, ngón tay, cánh… của robot. Effectors còn được gọi với cái tên khác là bộ truyền động.

## Điều gì làm cho Rational Agent hiệu quả?

Rational Agent hoạt động tốt nếu bạn đo lường được hiệu suất của nó. Thước đo hiệu suất càng cao thì tác tử càng hợp lý, được đánh giá bằng các tiêu chí sau:

- Rational Agent đạt được mục tiêu tốt như thế nào?
- Rational Agent đánh giá môi trường tốt như thế nào?
- Có bao nhiêu hành động Rational Agent có thể thực hiện?

Ví dụ, một chiếc ô tô tự lái sẽ hợp lý nếu nó có thể đưa bạn đến nơi bạn cần một cách an toàn và thoải mái trong khoảng thời gian ngắn nhất. Ô tô cần tuân theo các biển báo và hướng dẫn trên đường và tránh các phương tiện, người và các chướng ngại vật khác.

Xe tự hành có các sensor bao gồm máy ảnh, sonar, thiết bị định vị toàn cầu (GPS), đồng hồ tốc độ, đồng hồ đo quãng đường, gia tốc kế và bàn phím. Chúng cũng có các bộ truyền động (effector) bao gồm vô lăng, chân ga, phanh, tín hiệu và còi.

Một rational agent có thể trở thành intelligence agen nếu như nó chọn ra được một effector tốt nhất để tối đa hóa hiệu suất trong quá trình làm việc
## Phân loại tác tử

- Tác tử phản xạ đơn giản (Simple Reflex Agents)
- Tác tử phản xạ dựa trên mô hình (Model-Based Reflex Agents)
- Tác tử dựa trên mục tiêu (Goal-Based Agents)
- Tác tử dựa trên lợi ích (Utility-Based Agents)

Nguồn kham khảo: 

[viblo.asia](https://viblo.asia/p/artificial-intelligence-introduction-ai-to-ml-beginner-part-1-NbmebAdpGYO)

[meeyland.com](https://meeyland.com/tin-tuc/rational-agent-la-gi-cac-ung-dung-cua-trong-thuc-te-378177491)



Survivable systems analysis is a four-stage process that analyzes the current or proposed system requirements and architecture, identifies critical services, attack scenarios, and system “softspots,” and proposes changes to improve the survivability of a system. The key activities in each of these stages are as follows: