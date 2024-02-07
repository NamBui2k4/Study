# Lỗi khi dùng fileWriter

## Lỗi mất dữ liệu ghi vào file .txt do không có close
Khi bạn sử dụng FileWriter trong Java, việc không gọi phương thức close() có thể gây ra một số vấn đề, bao gồm:

__Dữ liệu chưa được ghi đầy đủ__

Khi bạn gọi các phương thức ghi (ví dụ: write()), dữ liệu thường được đẩy vào bộ đệm. Để đảm bảo rằng tất cả dữ liệu đã được ghi vào file, bạn cần gọi close() hoặc flush() để đẩy toàn bộ nội dung từ bộ đệm vào file.

__Tài nguyên không được giải phóng__

Khi bạn không gọi close(), tài nguyên hệ thống mà FileWriter đang sử dụng để ghi vào file không được giải phóng. Điều này có thể dẫn đến việc không thể ghi vào file một lần nữa, và cũng có thể tạo ra vấn đề liên quan đến hiệu suất.
Mất dữ liệu:

Một số hệ thống hoặc trường hợp cụ thể có thể không đảm bảo rằng tất cả dữ liệu đã được ghi vào file cho đến khi chương trình kết thúc. Gọi close() đảm bảo rằng toàn bộ nội dung đã được ghi và tài nguyên được giải phóng.



# Lỗi gặp ngoại lệ NullPointerException khi thực thi với thuộc tính Object
