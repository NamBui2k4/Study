1. Di chuyển tác vụ từ nhân CPU quá tải sang các nhân khác có thể dẫn đến hậu quả gì?
Nội dung bộ nhớ cache bị vô hiệu, thời gian truy cập bộ nhớ sẽ kéo dài thêm.

2. Mục đích của việc sử dụng Semaphore là gì?Thông tin của Semaphore phục vụ cho bài toán đồng bộ tiến trình.

3. Vai trò của bộ điều phối (Dispatcher) là gì?
Trao quyền sử dụng CPU cho tiến trình được chọn bởi bộ lập lịch ngắn hạn.

4. Đồng bộ hoá (Process Synchronization) là công việc cần phải áp dụng cho loại tiến trình nào?
Tiến trình cộng tác (Cooperating process).

5. Các lợi điểm của chương trình đa luồng so với đơn luồng thể hiện ở đâu?
Tận dụng kiến trúc đa nhân, Tính đáp ứng nhanh, Tài nguyên dùng riêng.

6. Lập lịch thời gian thực mềm (Soft real-time) làm việc như thế nào?
Ưu tiên các tác vụ thời gian thực hơn các tác vụ thông thường.

7. Các hàng đợi dành cho các tiến trình được xây dựng bằng cấu trúc dữ liệu nào?
Danh sách liên kết của các PCB.

8. Giữ quyền ưu tiên (Preemptive) là khả năng gì của bộ điều phối?
Chuyển một tiến trình sang trạng thái Ready mặc dù tiến trình vẫn còn thời gian sử dụng CPU.

9. Đồng bộ hoá (Process Synchronization) là công việc cần phải áp dụng cho loại tiến trình nào?
Tiến trình cộng tác (Cooperating process).

10. Thư viện lập trình đa luồng trên Linux là gì?
Pthread và POSIX11. 

11. Bước chuyển trạng thái nào sau đây là không tồn tại?
Từ Ready chuyển sang Waiting.

12. Cấp phát bộ nhớ theo phương pháp “Phân trang” có đặc trưng nào sau đây?
Kích thước một trang (page) và một khung trang (frame) bằng nhau.

13. Thông tin chứa trong Bảng phân trang là dùng để làm gì?
Lưu thông tin vị trí nạp các trang của tiến trình trong bộ nhớ chính.14. Ngoài các tài nguyên chia sẻ, tiểu trình có dữ liệu nào riêng?PC, Thanh ghi, Stack15. Mục tiêu của giải thuật “Nhà băng” (Banker) là gì?Chỉ ra một thứ tự thực thi của các tiến trình sao cho hệ thống luôn an toàn, Cho biết hệ thống có đáp ứng ngay một yêu cầu cấp phát hay không.16. Chọn các giải thuật định thời có yếu tố "Preemptive" (giữ quyền ưu tiên)
Shortest Remaining Time First, Round Robin

17. Đồ thị RAG của một hệ thống mô tả cho n tiến trình và m tài nguyên thì có bao nhiêu đỉnh (lực lượng của tập đỉnh V)?
n + m18. 

18. Mục tiêu và hạn chế của chuyển ngữ cảnh là gì?
Tăng tính đáp ứng của hệ thống, tuy nhiên chuyển ngữ cảnh quá nhiều làm giảm hiệu suất hệ thống

19. Giải thuật Peterson sử dụng các biến số điều khiển nào để giải quyết bài toán đồng bộ giữa hai tiến trình?

boolean flag[2] và int turn;

20. Đoạn mã nào trong các tiến trình có thể gây ra lỗi khi được thực thi đồng thời?
Critical Section.

21. Hệ điều hành cần chuyển CPU đang xử lý tiến trình B sang xử lý cho tiến trình A. Hệ điều hành phải làm công việc nào trước tiên?
Lưu ngữ cảnh tiến trình B.

22. Thách thức cho lập trình viên trong viết các chương trình đa luồng bao gồm những gì?
Đáp ứng nhanh, Chia sk tài nguyên, Tính kinh tế, Khả năng mở rộng.23. Trạng thái mà một hệ thống máy tính có các tiến trình vẫn hoạt động nhưng thời gian đáp ứng rất lâu là gì?Starvation24. Hệ điều hành Windows sử dụng bao nhiêu cấp độ ưu tiên trong lập lịch CPU?3225. Bài toán sắp xếp trộn (Merge Sort) trên một mảng số nguyên có thể cải tiến hiệu suất bằng cách nào hay không?Tiến trình đa luồng với dữ liệu có thể không cân bằng.26. Biến số đơn nguyên (atomic varible) là gì?Các thao tác lên biến số này tuần tự được thực thi trong CPU27. Với thanh ghi tái định vị (base) và thanh ghi giới hạn (limit), mỗi địa chỉ luận lý (logical address) phải có giá trị như thế nào với giá trị thanh ghi limit?nhỏ hơn28. Nguyên tắc thay thế trang địa phương (Local Replacement) là gì?Khi thay thế trang, trang nạn nhân được tìm trong phạm vi các khung đã cấp chotiến trình đó.29. API của Linux là thư viện nào?POSIX.30. Thứ tự của quy trình yêu cầu cấp phát tài nguyên là:request – use – release.31. Thời điểm nào có thể “ánh xạ” địa chỉ chương trình vào địa chỉ bộ nhớ vật lý?
