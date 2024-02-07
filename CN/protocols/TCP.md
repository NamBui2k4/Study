# TCP (Transmission Control Protocol - "Giao thức điều khiển truyền vận")

TCP là một trong những giao thức quan trọng và đáng tin cậy có chức năng đảm bảo rằng các gói tin được gửi đi sẽ luôn theo thứ tự và không bị mất. Giao thức này nằm giữa tầng ứng dụng và tầng mạng (ở tầng giao vận).

![](/pictures/layers-protocols.png)

__Đặc điểm của giao thức__

- kết nối điểm-điểm (point-to-point): mỗi segment chỉ được gửi từ một bên (sender) đến một bên duy nhất (reciever)

- Có hướng kết nối (connection-oriented): thiết lập kết nối giữa sender và reciever thông qua cơ chế bắt tay (handshake)

- Truyền dữ liệu đáng tin cậy nhờ cơ chế truyền theo byte có thứ tự (reliable, in-order byte  stream)

- Cải thiện hiệu suất nhờ cơ chế pipelined: cho phép gửi gói tin đi trước khi nhận lại một kết quả phản hồi, giúp giảm thời gian chờ đợi các lệnh đang xử lý

- Hỗ trợ full duplex data: Cho phép sender và reciever có thể gửi cho nhau cùng một lúc. Nghĩa là dữ liệu có thể đi qua cả 2 hướng (trái ngược với half duplex - chỉ cho phép dữ liệu đi theo một hướng) 

- kiểm soát luồng (flow controlled): đảm bảo rằng sender không gửi quá nhiều dữ liệu cho receiver

## Cấu trúc của một segment trong TCP

_Nhắc lại: ở tầng giao vận, dữ liệu tồn tại dưới dạng các đơn vị (PDU) gọi là segment hoặc datagram tùy thuộc vào việc truyền trên liên kết của giao thức nào (TCP hoặc UDP). Đối với giao thức TCP thì PDU sẽ là segment_

Ở trên, ta đã nói rằng TCP rất mạnh về khoảng kết nối tin cậy cũng như toàn vẹn dữ liệu gửi đi. Vậy hãy tự hỏi rằng làm thế nào mà nó mạnh mẽ như vậy? Đó chính là nhờ các tính chất cấu trúc của segment

![](/pictures/TCP-segment-structure.png)

Một segment là một đối tượng chứa các trường header và body. Tuy nhiên, ta tạm thời bỏ qua body và sẽ chỉ nghiên cứu đến header mà thôi vì body đơn giản là nội dung mà segment cần gửi đi. Thứ mà ta quan tâm lúc này là nó được gửi đi như thế nào

Header chứa các thông tin cần thiết để định tuyến và xử lý segment, bao gồm:

- Source port: cổng nguồn của ứng dụng gửi segment (kích thước là 16 bit).
- Destination port: cổng đích của ứng dụng nhận segment (kích thước là 16 bit).

⟹ định tuyến chính xác, kết nối giữa sender và receiver

- Sequence number: số thứ tự của segment trong luồng dữ liệu 
- Acknowledgement number: số thứ tự của segment tiếp theo mà sender cần gửi.

⟹ quyết định tính toàn vẹn của dữ liệu nhờ ổn định thứ tự của chúng

- Danh sách các cờ (flag): SYN P,ACK ,RST ,FIN, PSH ,URG với những ý nghĩa đặc biệt:

    + SYN (synchronize sequence numbers): cờ này được sử dụng để bắt đầu một kết nối TCP mới. Khi sender muốn kết nối với receiver, nó sẽ gửi tới receiver một segment chứa cờ SYN nhằm ra hiệu là "hãy kết nối với tôi".  

    + ACK (acknowledgement): Sau Khi receiver nhận được segment ở trên, sẽ gửi lại sender một segment với cờ ACK nhằm xác nhận đã gửi thành công. Nói cách khác, nó sẽ ra hiệu với sender là "Tôi hiểu rồi, tôi sẽ kết nối với bạn"

    + RST (reset): cờ này được sử dụng để hủy bỏ một kết nối TCP. Giả sử sender muốn hủy bỏ kết nối với receiver, nó sẽ gửi một segment với cờ RST nhằm ra hiệu  "hủy kết nối".

    + FIN (finish): cờ này được sử dụng để ra hiệu rằng sender đã gửi tất cả dữ liệu mà nó cần gửi. Cờ này giống với cờ RST vì nó sẽ kết thúc kết nối giữa sender và receiver nhưng chỉ khi đã hoàn thành xong công việc. 

    + PSH (push): cờ này dùng để yêu cầu receiver đẩy dữ liệu lên ứng dụng. Khi sender gửi segment mang cờ PSH, reciever sẽ đẩy dữ liệu lên ứng dụng ngay lập tức mà không đợi cho đến khi nó nhận được tất cả segment.

    + URG (urgent): cờ này được sử dụng để chỉ ra rằng một số dữ liệu trong gói tin là dữ liệu khẩn cấp. Khi trường URG được thiết lập, receiver sẽ phải xử lý dữ liệu khẩn cấp trước bất kỳ dữ liệu nào khác trong gói tin.

⟹ khả năng kiểm soát kết nối giữa sender và reciever đáng tin cậy 

![](/pictures/TCP-sender-reciever.png)

Tuy nhiên, lưu ý rằng không phải bất kỳ segment nào cũng có đầy đủ các cờ SYN, ACK, RST, FIN, PSH, URG trên. Một số cờ được sử dụng để điều khiển chức năng của segment và chỉ được bật khi cần thiết

Ta có thể mô tả quá trình hoạt động gửi segment giữa sender và receiver như sau:

![](/pictures/sender-receiver-gif-converter.gif)

Như vậy là ta đã hiểu rõ bản chất của vấn đề rồi. Giờ hãy tóm tắt lại nội dung các cờ mà ta đã nghiên cứu qua bảng sau

Cờ |	Ý nghĩa
---|--------------------
SYN|	Bắt đầu kết nối
ACK|	Xác nhận
RST|	Hủy bỏ kết nối
FIN|	Kết thúc kết nối
PSH|	Đẩy dữ liệu lên ứng dụng
URG|	Dữ liệu khẩn cấp

__Sequence number và Acknowledgement number__

Đây là hai trường dữ liệu quan trọng. Cả 2 đều là số thứ tự của segment nhưng đôi khi chúng dễ gây nhầm lẫn với một số người không có chuyên môn.

Sequence number là số thứ tự của một segment, bắt đầu từ 0 và tăng dần khi sender gửi một segment cho receiver. 

Acknowledgement number lại là số thứ tự của segment mà receiver gửi lại cho sender và nó bằng chính Sequence number + 1

Ví dụ, nếu sender gửi một segment với số thứ tự là 100, thì receiver sẽ nhận nó và gửi lại một segment khác với số thứ tự là 101 cho sender. Điều này cũng có nghĩa là receiver đã nhận được 100 segment và mong đợi nhận segment thứ 101 tiếp theo

Ta có bảng so sánh 2 trường này như sau:

Đặc điểm	|Sequence number	                                |Acknowledgement number
------------|---------------------------------------------------|----------------
Chức năng	|Đảm bảo tính toàn vẹn và thứ tự của dữ liệu	    | Xác nhận việc nhận thành công của các gói dữ liệu
Giá trị	    |Số thứ tự của gói dữ liệu được gửi	                |Số thứ tự của gói dữ liệu tiếp theo cần gửi
Ví dụ	    |Gói dữ liệu với số thứ tự 100 sẽ có sequence number là 100|	Gói dữ liệu với số thứ tự 100 sẽ có acknowledgement number là 101

__Window size__

là số lượng segment mà receiver có thể lưu trữ trong bộ đệm của mình mà không cần phải gửi ACK ngay lập tức. 

Window size có đặc điểm:
- Window size phải là một số nguyên dương.
- Giá trị tối đa của Window size là 65535.
- Window size không được thay đổi trong khi một gói tin đang được truyền.



Ví dụ, nếu Window size là 1024, thì receiver có thể nhận được tối đa 1024 segment mà không cần phải gửi ACK. Điều này giúp tăng hiệu quả của việc truyền dữ liệu, vì sender không cần phải đợi nhận được ACK trước khi gửi gói tin tiếp theo.

Window size có thể được thay đổi trong quá trình kết nối TCP. Receiver có thể gửi ACK với Window size mới để thông báo cho sender về kích thước cửa sổ nhận mới của mình.

Window size có vai trò:
- Tăng hiệu quả của việc truyền dữ liệu: Window size cho phép sender gửi nhiều segment mà không cần phải đợi nhận được ACK cho mỗi segment. Điều này giúp tăng tốc độ truyền dữ liệu, vì sender không cần phải đợi để nhận được phản hồi từ receiver trước khi gửi gói tin tiếp theo.
- Giảm thiểu tắc nghẽn mạng: Window size giúp giảm thiểu tắc nghẽn mạng bằng cách cho phép sender gửi nhiều segment mà không cần phải đợi nhận được ACK cho mỗi segment. Điều này giúp giảm thiểu số lượng gói tin bị giữ lại trong mạng do tắc nghẽn.
- Tăng khả năng phục hồi: Window size giúp tăng khả năng phục hồi của giao thức TCP bằng cách cho phép sender gửi nhiều segment mà không cần phải đợi nhận được ACK cho mỗi segment. Điều này giúp giảm thiểu tác động của việc mất gói tin, vì sender vẫn có thể gửi các segment tiếp theo ngay cả khi một số segment bị mất.

# Khái niệm TCP round trip time, timeout (thời gian khứ hồi,  thời gian chờ)
 
__round trip time (Thời gian khứ hồi - RTT)__

_Round trip time trong TCP được hiểu là thời gian từ lúc sender gửi các segment tới reveiver đến khi nó nhận lại toàn bộ segment phản hồi từ reveiver đó._

![](/pictures/round-trip-time.png)

RTT là một chỉ số quan trọng để xác định độ mạnh khỏe của kết nối trên một mạng cục bộ hoặc hệ thống lớn Internet, và đây thường là công cụ để người quản trị mạng chẩn đoán tốc độ và mức độ đáng tin cậy của các kết nối mạng.

Ví dụ, Khi người dùng ở New York thực hiện yêu cầu, lưu lượng mạng sẽ được truyền qua nhiều routers (bộ định tuyến) khác nhau ở nhiều vị trí địa lý cụ thể trước khi kết thúc ở máy chủ tại Singapore.

Còn máy chủ ở Singapore sau đó gửi một phản hồi quay trở lại thông qua Internet để đến vị trí ở New York. 

Như vậy, 1 RTT lúc này = thời gian từ lúc yêu cầu được gửi từ New York đến Singapore + thời gian phản hồi từ Singapore đến New York

![](/pictures/1-RTT.png)

Chúng ta cần phải nhớ rằng, round-trip time là ước tính và không phải là cái gì chắc chắn kiểu như đinh đóng cột. Một trong những cách ước lượng RTT trong giao thức TCP là ứng cụng công thức: 

    RTT = (1- a)*RTT + a*SampleRTT

Trong đó:

- RTT là thời gian (ước lượng) hiện tại
- a là một tham số điều chỉnh, thường nằm trong khoảng từ 0,8 đến 0,9
- SampleRTT là thời gian vòng lặp thực tế được đo được

Công thức trên giống như sử dụng đệ quy trong lập trình. Đây là điều có vẻ kỳ lạ khi ta lại lấy cái chưa biết để tính toán cho chính nó. Thực tế thì điều này hoàn toàn có thể xảy ra vì RTT sẽ thay đổi theo thời gian bởi yếu tố khác chẳng hạn như tắc nghẽn mạng

Ví dụ:

Giả sử rằng ước lượng hiện tại của 1 RTT là 100 mili giây. Sau đó, một gói dữ liệu được gửi và nhận lại phản hồi với thời gian thực tế là 120 mili giây.

Sử dụng công thức trên, ta có thể ước lượng lại giá trị mới của RTT:

    RTT = (1- 0,8)*100 + 0,8*120 = 176 mili seconds

__Time out(Thời gian chờ)__

_Timeout trong TCP là một khoảng thời gian mà phía sender sẽ chờ đợi phản hồi từ phía receiver trước khi bị cho rằng dữ liệu đã bị mất hoặc bị lỗi ở một bit nào đó._

Trong giao thức TCP, có hai loại timeout:

- Retransmission timeout (RTO): là khoảng thời gian mà một thiết bị sẽ chờ đợi phản hồi từ một thiết bị khác trước khi gửi lại gói dữ liệu bị mất.

![](/pictures/TCP-RTO-Retransmission-Timeout-Diagram.jpg)

Retransmission timeout được sử dụng để đảm bảo rằng các gói dữ liệu không bị mất. Khi một thiết bị trong quá trình gửi một gói tin, nó sẽ tính toán thời gian gửi lại (timer retransmission). Nếu thiết bị không nhận được phản hồi trong thời gian chờ, nó sẽ gửi lại với từng ấy thời gian. Thời gian gửi lại được tính toán tùy thuộc vào độ trễ của kết nối và số lần gửi lại.

Điều này giống như việc bạn gửi tin nhắn "Em ăn cơm chưa" cho người yêu trên Messenger nhưng phải mãi một lúc sau họ mới seen, là vì họ chưa nhận được từng đoạn segment 'E', 'm' , 'ă',.... trong tin nhắn của bạn và trả lại cho bạn một kết quả ACK tương ứng ("đã seen")


Nếu bạn gửi tin nhắn nhiều lần mà không nhận được phản hồi, thời gian gửi lại sẽ tăng lên và có thể dẫn đến việc kết nối bị hủy. Điều này có thể là do nhiều nguyên nhân, như đường truyền kém, thiết bị bị lỗi, hoặc cô ấy sủi bạn cmnr. 😅

Đối với Retransmission timeout, thời gian càng kéo dài thì càng ít khả năng gói dữ liệu bị mất, nhưng cũng có nghĩa là dữ liệu sẽ được truyền chậm hơn.

- Idle timeout là khoảng thời gian mà một thiết bị sẽ chờ đợi hoạt động từ một thiết bị khác trước khi đóng kết nối.

dle timeout được sử dụng để đảm bảo rằng các kết nối không bị bỏ ngỏ. Khi một thiết bị không nhận được hoạt động từ một thiết bị khác trong thời gian chờ, nó sẽ đóng kết nối.

Một ví dụ điển hình đối với loại thời gian chờ này đó là, khi chúng ta truy cập một trang web và đăng nhập vào một account của trang web đó (chẳng hạn như account elearning). Trang web sẽ gán một mã nhận dạng duy nhất (session ID) để xác thực danh tính của chúng ta. Và sau một thời gian sử dụng các tác vụ trên web thì hệ thống sẽ tự động đăng xuất tài khoản. Khoảng thời gian đó chính là dle timeout 

![](/pictures/idle-timeout.png)

Đối với dle timeout, thời gian càng kéo dài thì càng có ít khả năng kết nối bị đóng, nhưng cũng có nghĩa là kết nối sẽ không bị đóng ngay cả khi một trong hai phía bị ngắt kết nối. (Giống như việc đăng nhập vào account trên web mà lại tắt máy đi thì phiên đăng nhập vẫn sẽ giữ nguyên cho đến khi hết thời gian chờ)

Nguồn: 
[_Kiên Đinh_](https://viblo.asia/p/so-sanh-chi-tiet-tcp-va-udp-tai-sao-udp-lai-nhanh-hon-tcp-zOQJw05xLMP)

[_kiencang_](https://kiencang.net/round-trip-time/)