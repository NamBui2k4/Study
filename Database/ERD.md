Mối liên kết 1-M:
```
    Đưa thuộc tính khóa chính của kiểu thực thể phía 1
    vào làm khoá ngoại của bảng tương ứng với kiểu thực thể phía M.
```

Với mối liên kết M-N:
```
    Tạo một bảng mới mà khoá chính của bảng
    mới bao gồm khóa chính của 2 kiểu thực thể tham
    gia vào mối liên kết. Mỗi thuộc tính khóa này cũng
    chính là khóa ngoại của bảng mới.
```


Với mối liên kết 1-1, đây là 1 trường hợp đặc biệt của 1-M.
```
    Khoá chính của 1 trong 2 bảng sẽ được đưa vào làm khoá
    ngoại của bảng kia. Nếu 1 trong 2 đầu mối liên kết là "nhiệm ý", thì nên đưa
    khoá chính của bảng "bắt buộc" vào làm khoá ngoại của bảng kia
```

Giải thích về "nhiệm ý" :

_Mối liên kết là nhiệm ý có nghĩa là một thực thể có thể có hoặc không có mối bảng với thực thể khác. Mối liên kết không làm bắt buộc sự tồn tại của thực thể ở bên kia._

Ví dụ 1:

Giả sử chúng ta có hai thực thể: Student (Sinh viên) và Address (Địa chỉ). Mối liên kết giữa chúng có thể được xem xét như một mối liên kết là nhiệm ý.

Thực thể Student (Sinh viên):
- StudentID (Mã sinh viên, khoá chính)
- FullName (Họ và tên)

Thực thể Address (Địa chỉ):
- AddressID (Mã địa chỉ, khoá chính)
- StudentID (Mã sinh viên, khoá ngoại, có thể chứa giá trị null)
- Street (Đường)
- City (Thành phố)
- Country (Quốc gia)

Trong trường hợp này, mỗi sinh viên có thể có hoặc không có một bản ghi địa chỉ tương ứng trong bảng Address. Mối liên kết giữa Student và Address là nhiệm ý vì một sinh viên có thể không có địa chỉ (ví dụ: nếu sinh viên đó chưa cung cấp thông tin địa chỉ).

Ví dụ dữ liệu:

Bảng Student:

| StudentID | FullName        |
|-----------|-----------------|
| 1         | John Doe        |
| 2         | Jane Smith      |
| 3         | Mark Johnson    |

Bảng Address:

| AddressID | StudentID | Street         | City       | Country    |
|-----------|-----------|----------------|------------|------------|
| 1         | 1         | 123 Main St    | Anytown    | USA        |
| 2         | 2         | 456 Oak Ave    | AnotherCity| Canada     |
| 3         | NULL      | 789 Pine Rd    | SomeCity   | UK         |

Trong bảng Address, có một bản ghi có StudentID là NULL, điều này đại diện cho một địa chỉ mà không liên kết với bất kỳ sinh viên cụ thể nào. Điều này phản ánh tính chất là nhiệm ý của mối liên kết giữa Student và Address.


__Câu hỏi đặt ra__ : _Tại sao nếu 1 trong 2 đầu mối liên kết là "nhiệm ý", thì nên đưa khoá chính của thực thể bắt buộc vào làm khoá ngoại của thực thể kia ?_ 

Khi một trong hai đầu mối liên kết là nhiệm ý và một trong hai thực thể là kiểu thực thể bắt buộc, việc đưa khoá chính của thực thể bắt buộc làm khoá ngoại của thực thể kia làm cho mối bảng trở nên mạnh mẽ và đảm bảo tính nhất quán trong cơ sở dữ liệu.

Ví dụ:

Giả sử có hai thực thể: Person và Passport.
Mối liên kết giữa chúng là nhiệm ý, vì không phải mọi người đều có hộ chiếu.
Nếu Person là kiểu thực thể bắt buộc (mọi người phải có thông tin trong Person), thì bạn có thể sử dụng khoá chính của Person làm khoá ngoại trong Passport.

Thực thể Person:
- PersonID (Khoá chính)
- FullName
- ...

Thực thể Passport:
- PassportID (Khoá chính)
- PersonID (Khoá ngoại tham chiếu đến Person)
- PassportNumber
- ...

Trong trường hợp này, mối liên kết giữa Person và Passport là nhiệm ý, và Person là kiểu thực thể bắt buộc.