# Tiến trình - Process

Tất cả các nhà phát triển phần mềm đều viết ứng dụng để đạt được mục tiêu hoàn thành các tác vụ của người dùng (ví dụ mua sắm, xem video, chơi game,...). Chúng ta đều biết các tác vụ đó được chuyển xuống hệ điều hành và hệ điều hành có trách nhiệm xử lý hết chỗ đó bằng cách thao tác với phần cứng như bộ xử lý và bộ nhớ. Khi một nhà phát triển tạo một mã nguồn trong một tệp thực thi thì nó là một chương trình. Nó không phải là thứ running, mà đúng hơn là một thực thể tĩnh nằm trong đĩa cứng hoặc ổ đĩa flash. Khi ứng dụng được khởi chạy, nó sẽ tải vào bộ nhớ chính và bộ xử lý bắt đầu thực hiện lệnh theo lệnh.

Vì vậy, một tiến trình là một thực thể hoạt động. Khi ứng dụng khởi chạy, sẽ có nhiều tiến trình xuất phát từ cùng một ứng dụng, nhưng chúng ở các thời điểm chạy khác nhau, chẳng hạn như phát hai bộ phim Star-Wars và Avengers: Infinity war trên hai trình phát VLC.

## tiến trình trông như thế nào

Khi một tiến trình tải vào bộ nhớ chính, nó sẽ chiếm một lượng bộ nhớ và chúng ta gọi nó là không gian địa chỉ. Mọi tiến trình đều có không gian địa chỉ ảo của riêng nó và nhiệm vụ của hệ điều hành là ánh xạ không gian địa chỉ ảo đó với không gian địa chỉ vật lý.

Có bốn phần chính trong không gian địa chỉ này:

1. Văn bản (Code) - Phần Văn bản được tạo thành từ mã chương trình đã biên dịch, được đọc từ bộ lưu trữ không bay hơi khi chương trình được khởi chạy.

2. Dữ liệu - Phần Dữ liệu được tạo thành từ các biến toàn cục và biến tĩnh, được cấp phát và khởi tạo trước khi thực thi main.

3. Heap - Heap được sử dụng để cấp phát bộ nhớ động và được quản lý thông qua các lệnh gọi tới new, delete, malloc, free, v.v.

4. Ngăn xếp - Ngăn xếp được sử dụng cho các biến cục bộ. Không gian trên ngăn xếp được dành riêng cho các biến cục bộ khi chúng được khai báo.

## làm thế nào một tiến trình thực hiện một tác vụ ?
Điều gì xảy ra khi một chương trình đang được thực thi, được cung cấp lệnh bởi bộ xử lý và khi bộ xử lý bắt đầu thực hiện các lệnh này?

Khi một chương trình được khởi chạy, hệ điều hành sẽ đưa các lệnh vào từng dòng của bộ xử lý để thực thi và có một thanh ghi gọi là bộ đếm chương trình chịu trách nhiệm lưu dòng nào sẽ được nạp tiếp theo. Khi thực hiện các lệnh đó, dữ liệu trong không gian địa chỉ tiến trình sẽ bị thay đổi.

## đa chế biến

Hãy tưởng tượng bạn đang đọc một cuốn sách và bạn mất hứng thú với nó. Thay vào đó, bây giờ bạn muốn đọc một cuốn sách khác. Bạn sẽ làm gì? Bạn sẽ đánh dấu nơi bạn đã ngừng đọc và chuyển sang cuốn sách tiếp theo. Bằng cách này, bạn có thể tìm thấy nơi bạn đã dừng lại khi muốn đọc lại cuốn sách đó. 

Hệ điều hành tương tự như thế này. Nếu một tiến trình khác đến và có mức độ ưu tiên cao hơn tiến trình hiện đang thực thi, thì hệ điều hành phải dừng tiến trình hiện tại và bắt đầu thực hiện tiến trình tiếp theo. Nhưng hệ điều hành nên giữ lại một bản chụp tiến trình cũ để thực thi sau này. Vì vậy, hệ điều hành có một khối điều khiển tiến trình - PCB. Khối điều khiển tiến trình bao gồm tất cả các chi tiết về tiến trình. PCB được tạo ra khi tiến trình này được tạo ra. Một số dữ liệu của PCB thay đổi khi trạng thái của tiến trình thay đổi. Một số dữ liệu thay đổi thường xuyên trong khi tiến trình đang thực thi.

![](/pictures/PCB.PNG)

Các phần tử của một khối điều khiển tiến trình:

· Trạng thái tiến trình - Trạng thái của tiến trình (running, Đang chờ, ready, đã kết thúc, v.v.)

· Process-Id và Parent process ID

· Thanh ghi CPU và bộ đếm chương trình - Bộ đếm chương trình giữ địa chỉ của lệnh tiếp theo sẽ được thực thi cho tiến trình đó.

· Thông tin lập lịch CPU - Chẳng hạn như thông tin ưu tiên và con trỏ đến hàng đợi lập lịch.

· Thông tin quản lý bộ nhớ - Ví dụ, bảng trang hoặc bảng phân đoạn.

· Thông tin kế toán - Người dùng và thời gian sử dụng CPU hạt nhân, số tài khoản, giới hạn, v.v.

Thông tin trạng thái I / O - Thiết bị được cấp phát, mở bảng tệp, v.v.

## Các trạng thái của một tiến trình

Trạng thái của tiến trình tại một thời điểm được xác định bởi hoạt động hiện thời của tiến trình tại thời điếm đó. Trong quá trình sống một tiến trình thay đổi trạng thái do nhiều nguyên nhân như: phải chờ một sự kiện nào đó xảy ra ,hay đợi một thao tác nhập xuất hoàn tất, buộc phải dừng hoạt động do hết thời gian xử lý…… 

Tại một thời điểm một tiến trình có thể nhận một trong các trạng thái sau đây: 

* new: tiến trình đang được tạo lập 
* Running: các chỉ thị lệnh của tiến trình đang được xử lý. 
* Blocked: tiến trình chờ được cấp phát tài nguyên,hay chờ một sự kiện xảy ra. 
* Ready: tiến trình chờ được cấp phát CPU để xử lý. 
* Waiting: tiến trình phải dừng vì thiếu tài nguyên hoặc chờ một sự kiện nào đó. 
* terminated: tiến trình hoàn tất xử lý và được giải phóng khỏi bộ nhớ của máy tính

Các trạng thái của tiến trình được biểu diễn qua sơ đồ sau:

![](/pictures/process.png)

## chuyển đổi ngữ cảnh (context switch)

Hãy tưởng tượng rằng bạn là một đầu bếp trong một nhà hàng rất bận rộn trong thành phố. Giả sử bạn nhận được 3 đơn hàng cho khách gồm: hai quả trứng luộc, súp rau và một chiếc bánh mì kẹp thịt (Đây có thể là 3 món ăn tệ nhất từ ​​trước đến nay). Bây giờ, bạn sẽ làm thế nào để hoàn thành ba món ăn này? Đầu tiên bạn sẽ luộc trứng, sau đó nấu súp và sau đó làm bánh mì kẹp thịt? Hãy tin tôi. Nếu tôi là đầu bếp, tôi sẽ không làm vậy. Tôi sẽ nấu cả ba món ăn cùng một lúc.

Làm thế nào để làm điều đó? Tôi sẽ luộc trứng trước, trong lúc chờ thì sẽ nấu súp, khi súp chưa sôi thì tôi lại chuyển sang làm burger. Cuối cùng, tôi có thể phục vụ cả 3 món ăn cùng một lúc.

Hệ thống máy tính không khác gì ẩn dụ trên. Bây giờ, hệ điều hành thực hiện nhiệm vụ này như thế nào? Như chúng ta đã thảo luận, chúng ta biết rằng hệ điều hành sử dụng PCB (Khối điều khiển tiến trình) để lưu giữ ngữ cảnh (trạng thái) của một tiến trình. Tham khảo hình ảnh sau.

![](/pictures/context-switch.png)

Có hai tiến trình là P0 và P1. Mỗi tiến trình đều có một PCB riêng. Như tôi đã đề cập trước, PCB sẽ được khởi tạo khi tiến trình được khởi tạo. Lúc đầu, PCB đang hoạt động là của P0. Khi P0 thay đổi trạng thái của nó, hệ điều hành sẽ lưu trạng thái đó trong PCB0 và tải lại PCB1. PCB1 chứa một trạng thái đã được lưu lại khi P1 dừng trước đó. Khi P1 thay đổi trạng thái, hệ điều hành cũng sẽ lưu lại bản ghi tương tự trong PCB1 và ​​tải lại PCB0. Phải mất một thời gian để tải lại và lưu PCB vào bộ nhớ. Vì vậy, trong thời gian đó cả tiến trình P0 và P1 phải chờ ở chế độ không tải.

Tuy nhiên, cần lưu ý rằng context switch không giống thuật toán swapping. Context switch chỉ lưu giữ trạng thái của một tiến trình để chuyển sang xử lý một tiến trình khác, đồng thời chúng vẫn luôn nằm ở trong RAM kể từ khi bắt đầu. Trong khi đó,swapping sẽ hoán đổi vị trí của các tiến trình từ CPU đến RAM và ngược lại, đảm bảo rằng những tiến trình nào chưa được xử lý thì sẽ chiếm dụng vị trí của những tiến trình đã được xử lý. Nói cách khác, context switch sẽ làm cho một tiến trình bị "giang dở", còn swapping thì không. Điều này giống như 2 ẩn dụ một đầu bếp nấu nhiều món ăn cùng lúc và một đầu bếp nấu các món ăn một cách tuần tự.

Cả Swapping lẫn context switch chính là cách hệ điều hành đa tiến trình và đa luồng ra đời.

Nguồn: [](https://ichi.pro/vi/chuyen-doi-ngu-canh-theo-chieu-sau-32355302615858)