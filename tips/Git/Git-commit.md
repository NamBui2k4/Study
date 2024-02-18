# Một số tính năng commit của Git

Ở phần [Git-basic](/Git-basic.md), chúng ta đã thảo luận nhiều kiến thức cơ bản trong đó có phần commit, hôm nay chúng ta sẽ thảo luận thêm về commit một lần nữa nhưng sẽ đa dạng tính năng hơn. Một tính năng khá quan trọng chính là lệnh `Git commit –amend` -  “thay đổi commit cuối cùng”.

## “commit –amend” sử dụng khi nào?

`git commit –amend` được sử dụng khi chúng ta muốn sửa đổi commit cuối cùng.

Thường là do chúng ta đã add thiếu file hoặc dư file hoặc quên sửa file khi commit, hoặc đơn giản hơn chỉ là thay đổi lại message cho commit cuối cùng.

Sửa đổi commit cuối cùng giúp chúng ta không cần phải tạo ra một commit khác cho việc sữa chữa những sai lầm lúc commit.

![](/pictures/Git-commit-amend.png)

Cấu trúc lệnh

    git commit --amend -m "Thông tin về commit"

## Áp dụng thay đổi lên remote repository
Để áp dụng thay đổi commit trên remote repository ta thực hiện lệnh sau

    git push -f
    
Chúng ta cần push force mới áp dụng được thay đổi này lên remote repositoryg