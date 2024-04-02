# Sử dụng Git - Phần Nâng cao

Ở những phần trước, chúng ta đã đi qua những phần cơ bản của Git bao gồm các tập lệnh cơ bản, khái niệm remote,branch, origin, và mục đích sử dụng của Git. Đặc biệt, các khái niệm liên quan đến [Git-branch](/Git-branch.md) và [Git-remote](/Git-remote.md) thực sự rất quan trọng và hãy chắc chắn rằng bạn đã tìm hiểu kỹ chúng để có kiến thức nền vững chắc trước rồi tới phần nâng cao này.

Còn nếu đã vững kiến thức rồi, hãy tiếp tục nghiên cứu những gì Git đang có nhé. Sau đây là một số vấn đề cần thảo luận:

### 7. Vấn đề với submodule

Thông thường, khi cập nhật repo ở local, chúng ta thường có xu hướng đi từ add rồi mới tới commit đúng không ? 

Tuy nhiên, sẽ có một khả năng xảy ra là bạn add không thành công. Khi đó, bạn cũng không thể commit được. Để dễ hiểu hơn, hãy xét tình huống sau:

Trong dự án của bạn có một đường dẫn `C:\Users\ASUS\OneDrive\laptrinh`, và folder `laptrinh` được biểu diễn bằng sơ đồ hệ thống file như sau:

```
laptrinh
|───tips
│   ├───Git
│   │   └───pictures
|   |   └─── Git-basic.md
|   |   └─── Git-advanced.md
.............................
```

Giả định thêm rằng bạn đã chỉnh sửa hai file `Git-basic.md` và `Git-advanced.md`. Bạn kiểm tra tình trạng của chúng bằng cú pháp `git status`. Kết quả sẽ là:

```
$ git status
On branch main
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
  (commit or discard the untracked or modified content in submodules)
        modified:   tips/Git (modified content)

no changes added to commit (use "git add" and/or "git commit -a")
```

Bạn có thể thấy, Git quăng ra thông báo `modified:   tips/Git (modified content)`, nghĩa là một file nào đó ở `tips/Git` đã được chỉnh sửa nhưng chưa được đưa vào staging area cũng như chưa commit. 

Lúc này bạn sẽ add những thay đổi đó, với câu lệnh muốn thở: `git add tips/Git`. Tuy nhiên, git sẽ không thông báo gì cả, tưởng chừng đã thành công nhưng khi kiểm tra lần nữa thì... Bùm ! Không có gì thay đổi ! Lỗi vẫn xảy ra ! Thế là coi như add thất bại ! 

Lý giải: đây là một vấn đề về submodule trong Git. 

Submodule là một repo con được nhúng  vào trong một repo hiện tại. Có thể trong quá trình làm việc, chúng ta vô tình tick lệnh `git init` ở trong chính dự án đang chỉnh sửa. Khi đó, git sẽ tự tạo một file `.git` đại diện cho submodule đó. Bạn cứ lần mò theo đường dẫn của `tips/Git` là sẽ thấy file `.git`  thôi.

Lúc này, cách giải quyết là bạn xử lý từng submodule rồi mới đến dự án chính :

```
# Xử lý submodule
  $ cd tips/Git
  $ git add Git-basic.md
  $ git add Git-advanced.md
  $ git commit -m "added Git-advanced + Git-basic"

# xử lý dự án chính
    $ cd ..
    $ cd ..
    $ git add tips/Git
    $ git commit -m "update file in tips/Git"
```

Nếu bạn không làm như vậy, Git sẽ không nhận ra sự thay đổi của file Git-branch.md, mà chỉ thấy submodule `tips/Git` có nội dung bị thay đổi (modified content).

Do đó, vấn đề về quản lý submodule thực sự rất nhức nhối. Đó là chưa kể branch của submodule trùng tên với branch của dự án chính thì còn khùng đin hơn nữa :(

## 8. Các lệnh đẩy lên và tải xuống trong Git

Mục đích của các lệnh này là thiết lập tương tác giữa remote và local. Nếu vẫn chưa biết remote là gì thì hãy kham khảo tại [Git-remote](/Git-remote.md) nhé. Có hai lệnh chính cho tương tác này là: `git pull` và `git push`. Hai lệnh này giống như việc chúng ta tải ảnh từ facebook về máy và đăng lên story. Chỉ có điều, nơi mà chúng chúng ta sẽ tải xuống là local, còn nơi đăng lên là remote (Github).

![](/pictures/cafedev-git-push-1.png)

### 8.1 Lệnh ``git pull``

Tác dụng: tải xuống (fetch) và kết hợp (merge) dữ liệu từ remote vào local  của bạn..

Khi bạn chạy lệnh `git pull`, Git sẽ thực hiện hai bước chính:

1. Tìm nạp (fetch): Git sẽ tải về toàn bộ các thay đổi mới nhất từ remote  của bạn. Điều này giúp bạn có dữ liệu cập nhật mới nhất của dự án.
|
2. Kết hợp (merge): Sau khi tìm nạp xong, Git sẽ tự động kết hợp các dữ liệu đó vào local  của bạn. Nếu có xung đột (conflict) xảy ra giữa các file, Git sẽ cung cấp thông báo cho bạn để giải quyết.

Để làm được điều này, ta cần qua 3 bước:
 
 - Thiết lập liên kết giữa remote  và local  (Kham khảo tại [Git-remote](Git-remote.md))

- Dùng lệnh `git remote -v` để kiểm tra tình trạng hiện tại của remote

- Sau khi đã làm xong các bước chuẩn bị, bây giờ chỉ việc sử dụng dòng lệnh ``git pull``

Lệnh `git pull` rất hữu ích trong một dự án có nhiều dev cùng thay đổi source code. Nó đảm bảo rằng bất cứ dev nào cũng dc share dữ liệu và luôn là phiên bản update mới nhất.

_Lưu ý rằng trong quá trình sử dụng lệnh `git pull`, bạn cần đảm bảo có kết nối mạng và có quyền truy cập vào kho chứa từ xa. Bạn cũng nên kiểm tra và giải quyết xung đột (nếu có) để đảm bảo rằng dự án của bạn không gặp vấn đề sau khi cập nhật._

### 8.2 lệnh đẩy lên remote:  `git push`

Ok, vậy là chúng ta sẽ bước qua một kiến thức được cho là khó nhất nhưng cũng quan trọng nhất về Git nhé '-'

Thuật ngữ push đề cập đến việc tải nội dung kho lưu trữ cục bộ lên một kho lưu trữ từ xa. push là một hành động đẩy toàn bộ dự án từ local của bạn đến một remote. Hiểu đơn giản thì push chính là upload.

![](/pictures/push.png)

Trước khi tìm hiểu `git push`, ta cần hiểu rõ một số khái niệm sau:

#### Các trạng thái của một file trong Git

Trong tiến trình làm việc của Git, một file source code luôn tồn tại ở một trong 4 trạng thái:

- Untracked (chưa theo dõi): mới lần đầu xuất hiện ở dự án nhưng chưa được thêm vào Staging area

- Modified (đã chỉnh sửa): đã được sửa đổi trong Working Directory, nhưng chưa được thêm vào Staging Area.

- Added (đang chờ): đã được thêm vào Staging Area để chuẩn bị cho một commit.

- Committed (Đã commit): đã được commit 

Những trạng thái này sẽ quyết định xem trong tiến trình làm việc, bạn có được phép push file lên remote hay không. Chỉ khi file ở trạng thái commited thì bạn mới được push lên remote nhé ;). Và để biết một file nằm ở trạng thái nào, bạn cần hiểu nằm lòng tiến trình 3 bước sau

_Tiến trình làm việc của Git:_

_1. Bạn sửa file trong Working Directory (Modified). Hoặc là bạn thêm một file mới vào đó (Untracked)_
_2. Sau đó, bạn sử dụng lệnh `git add` để đưa những thay đổi đó vào Staging Area (Added)._
_3. Cuối cùng, bạn sử dụng lệnh `git commit` để tạo một commit và lưu trữ các thay đổi đó trong  (Committed)._

Như vậy, chỉ cần hoàn thành 3 trước trên là có thể push được rồi :v

Cú pháp lệnh push:

    git push origin <tên branch>


Lưu ý, 

- trước khi push thì hãy commit nhé, không thì git sẽ báo lỗi "error: src refspec main does not match any"

- Push có khả năng ghi đè các thay đổi; cần thận trọng khi push.

- Trong trường hợp bạn vừa tạo mới một branch và push nó lên git, có thể bạn sẽ gặp phải lỗi này:

      fatal: The current branch my-new-branch has 
      no upstream branch.
      To push the current branch and set the remote 
      as upstream, use

Lúc này chỉ cần bổ sung tham số `--set-upstream` là được

    git push --set-upstream origin <tên branch>



\
![](/pictures/three-stage.png)
\
__Chế độ của lệnh `git reset`__

Trong phần trước, chúng ta đã nói rằng lệnh `git reset` có chức năng hoàn tác những commit nếu có sai lầm khi chỉnh sửa dự án. Tuy nhiên, để tăng tính linh hoạt cho công việc, giả sử nếu có sai đến 2 lần vẫn có cơ hội gỡ gạc lại, thì Git đã cung cấp 3 chế độ cho lệnh này. Cụ thể:

- `git reset --mixed` (mặc định):  không làm thay đổi Working Directory mà chỉ làm thay đổi Staging Area (Index)

Chế độ này được sử dụng trong các tình huống khi ta muốn bổ sung một vài thông tin phát sinh lên dự án. Working Directory

[aptechbmt](https://aptechbmt.edu.vn/hoc-lap-trinh/git-github/bai-4-huong-dan-su-dung-git-cac-lenh-co-ban-can-phai-biet-6.html)

[cafedev](https://cafedev.vn/tu-hoc-git-lenh-git-push/)