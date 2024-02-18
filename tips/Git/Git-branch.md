# Git - Branch là gì? Branch main

Khi làm việc với Git bắt buộc chúng ta phải thông qua branch, nhưng chúng ta chưa tìm hiểu khái niệm branch là gì nên trong bài này mình sẽ giới thiệu khái niệm của nó.

## Branch là gì?

Đối với những dự án có nhiều thành viên tham gia thì mỗi thành viên sẽ nhận được rất nhiều task từ leader, vì vậy việc xử lý các task này trên cùng một thời gian là rất khó vì dễ bị đụng code. Để giải quyết vấn đề này thì chúng ta sẽ sử dụng branch của Git, tương ứng với mỗi nhiệm vụ chúng ta sẽ tạo một branch và làm việc trên đó, các branch này sẽ hoạt động riêng lẻ và không ảnh hưởng lẫn nhau.

Vậy branch là những phân nhánh ghi lại luồng thay đổi của lịch sử, các hoạt động trên mỗi branch sẽ không ảnh hưởng lên các branch khác nên có thể tiến hành nhiều thay đổi đồng thời trên một repository, giúp giải quyết được nhiều nhiệm vụ cùng lúc.

![](/pictures/branch.png)
\
Sau khi các branch riêng lẻ đã được chỉnh sửa xong xuôi, leader sẽ yêu cầu cả team phải gom toàn bộ chúng lại  về chung một dự án ban đầu. Đó là lúc chúng ta sử dụng tính năng merge, hợp nhất các branch thành 1 branch duy nhất của dự án gọi là branch main

![](/pictures/branch-merge.png)

## Branch `main`
Khi bạn tạo một repository thì Git sẽ thiết lập branch mặc định là `main`. Trước đây branch này có tên mặc định là `master` nhưng git đã đổi sang `main`. Đây chính là phiên bản nguồn của dự án mà mọi hoạt động của các dev trong team đều có thể ảnh hưởng. Nó đóng vai trò cập nhật dữ liệu và đồng bộ với remote repository.

Giả sử leader giao cho các dev 10 tasks. Lúc này, các dev không nên làm việc trực tiếp trên branch main mà hãy khởi tạo 10 branch từ branch main. Nếu bạn làm cùng công ty với các dev đó thì leader có thể chỉ định mỗi dev làm bao nhiêu task tương ứng với bấy nhiêu branch. Branch main chỉ nên dùng để pull code từ remote đến cách branch khác nhằm mục đích share dự án cho tất cả các dev trong công ty, hoặc là để merge các branch lại cho main khi mà các dev đã hoàn thành chỉnh chu công việc.

Mỗi branch làm việc sẽ được ghi lại lịch sử trong quá trình làm việc và bạn hoàn toàn có thể rollback lại lịch sử đó dựa vào staging area mà Git đã lưu

Nói chung, việc tạo branch sẽ giúp bạn phân chia và quản lý công việc được dễ dàng hơn. Thay vì, phải tạo một kho lưu trữ mới để phát triển một tính năng mới cho dự án đã có thì bạn có thể phân nhánh ngay trong kho lưu trữ dự án để thực hiện công việc này mà không ảnh hưởng gì tới nhánh chính main.

## Tạo branch


Nếu là lần đầu tiên sử dụng Git cho dự án thì sau khi tạo repository, bạn phải thực hiện hai thao tác:

- Thêm một file/ folder nào đó vào staged: `git adđ`
- thêm commit lên branch main: `git commit`

thì lúc này mới có branch `main` để làm việc. Nếu không có 2 thao tác trên trong lần đầu tiên, việc tạo branch sẽ gây ra lỗi `fatal: not a valid object name: 'main'`

Để tạo một branch mới, bạn có lệnh:

-  `git branch [tên branch]`


Lệnh đầu tiên chỉ có chức năng tạo branch. Hai lệnh cuối dùng ngoài chức năng tạo branch còn dùng để chuyển đổi giữa các branch để thực thi xử lý.

Kiểm tra xem có bao nhiêu branch đã được tạo: `git branch`

Tuy nhiên, nhớ rằng những branch đã được khởi tạo trên vẫn còn ở local repo thôi vì vẫn chưa được push lên github đâu nên dù bạn có lên kiểm tra trên web bao nhiêu lần đi nữa cũng không có tác dụng gì cả

_Lưu ý: không được phép có nhiều branch trùng tên với nhau. Ví dụ, nếu bạn khởi tạo một branch mới tên là `new_branch` nhưng đã tồn tại trong repo thì git sẽ thông báo lỗi `a branch named 'new_branch' already exists`_

## Chuyển đổi giữa các branch

Đây là một kỹ năng cần thiết khi làm việc với các dự án phức tạp. Việc chuyển đổi giữa các branch sẽ giúp ta thêm các tính năng mới, sửa lỗi, hoặc thử nghiệm các ý tưởng lên một branch mà không ảnh hưởng đến main. Khi hài lòng với kết quả, ta có thể hợp nhất branch đó vào main. Điều này giúp cho quá trình phát triển phần mềm trở nên linh hoạt và hiệu quả hơn

Sẽ có 2 trường hợp:

### 1. branch có sẵn trên local
Cú pháp:

-  `git checkout [tên branch]`
-  `git switch [tên branch]`

Hai lệnh này sẽ trỏ đến branch cần di chuyển tới. 

### 2. branch chưa tồn tại 

Nếu branch đó chưa tồn tại, bạn sẽ tạo ra một branch mới và di chuyển đến branch đó. Nhưng thay vì dùng lại lệnh `git branch` thì đôi khi, bạn sẽ thêm option cho 2 lệnh trên. Cụ thể:

-  `git checkout -b [tên branch]`
-  `git switch -c [tên branch]`


Ví dụ: 

Trước khi chuyển đổi branch, bạn cần kiểm tra xem hiện tại mình có bao nhiêu branch bằng lệnh `git branch`. chẳng hạn như:

```
ASUS@LAPTOP-ANKJ95OH MINGW64 ~/OneDrive/laptrinh (main)
$ git branch
  Laptrinh
* main
```

Kết quả trên cho ta thấy, bạn đang ở branch `main`. Muốn chuyển đổi qua `Laptrinh` thì chỉ cần gõ `git switch Laptrinh`. Nếu `Laptrinh` không có sẵn, thì thêm option `-c` vào.


## Xóa branch

Xuyên xuốt quá trình của dự án thì sẽ có rất nhiều branch không cần thiết được tạo ra, việc lưu trữ các branch đó có thể gây rối trong quá trình quản lý git. Vậy nên, sau khi đã merge code thành công vào main thì chúng ta nên xoá các nhánh đó đi.

Tuy nhiên, GIT không cho phép bạn xoá nhánh hiện tại bạn đang truy cập, vậy nên bạn cần checkout qua một nhánh khác với nhánh bạn muốn xoá

```
# Cần checkout qua nhánh chính main
git checkout main

# Dùng lệnh xoá branch.
git branch -d [tên nhánh]
```
\
Sẽ có một số trường hợp GIT sẽ không cho phép bạn xoá nhánh một cách thông thường, bởi vì nhánh bạn muốn xoá có một số thay đổi chưa được hợp nhất (unmerge changes). Nhưng nếu bạn nhất quyết muốn xoá nó thì có thể dùng option -D thay cho -d để ép buộc git phải xoá nó theo mong muốn của bạn như sau

    git branch -D [tên nhánh]

### Làm thế nào để xóa toàn bộ branch ?

Công việc này diễn ra khi dự án đã hoàn thành và chúng ta muốn thanh toán kho lưu trữ để làm trống cho một dự án sắp tới. 

 Sử dụng lệnh: 

    git branch | xargs git branch -D
\
Lưu ý rằng lệnh này sẽ xóa các nhánh một cách mạnh mẽ mà không quan tâm đến việc chúng đã được merge hay chưa. Hãy chắc chắn rằng bạn không cần giữ lại bất kỳ thay đổi nào trước khi thực hiện lệnh này

### Làm thế nào để xoá branch trên REMOTE ?

Branch trên remote tức là những nhánh đã được pushed lên remote, khi bạn dùng thao tác xoá nhánh ở local thì nhánh đó chỉ mất đi trên local của bạn, nhưng trên remote vẫn tồn tại. Nếu bạn muốn xoá một nhánh trên github, bạn cần dùng lệnh sau:

    git push [tên remote] --delete [tên nhánh]
\
Ví dụ:
```
$ git push MyProject --delete main
To https://github.com/PhuongNam2k4/MyProject
 - [deleted]         main

```
\
_Chú ý: không thể xóa branch được thiết lập mặc định (default) trên remote. Nó sẽ quăng ra lỗi `! [remote rejected] main (refusing to delete the current branch)`_

Ví dụ: 

Github của tôi là `https://github.com/PhuongNam2k4/Git`. Giả sử nhánh `main` là branch mặc định thì nếu tôi cố xóa nó thì sẽ có lỗi:

```
bui@bui-nam:~/Documents/MyProject/tips/Git$ git push origin --delete main
To https://github.com/PhuongNam2k4/Git
 ! [remote rejected] main (refusing to delete the current branch: refs/heads/main)
error: failed to push some refs to 'https://github.com/PhuongNam2k4/Git'
```

Hãy thiết lập chế độ mặc định cho branch khác trước khi xóa

Bên cạnh đó, thường thì các dev sẽ clone remote về local để việc xóa dễ hơn vì chỉ cần thay thế `[tên remote]` bằng `origin` là đủ. Nếu bạn chưa biết clone và origin là gì thì có thể kham khảo tại [Git-clone](/Git-clone.md).
    
    git push origin --delete [tên nhánh]
\
Cách này sẽ tiện hơn rất nhiều vì các dev sẽ không cần phải nhớ chính xác `[tên remote]`, chỉ cần clone về và thực thi trên origin là mọi chuyện vô cùng dễ dàng.

Hoặc có thể dùng câu lệnh ngắn gọn hơn:

    git push origin :fix/authentication

## Rename branch 

Khi làm việc với Git, đôi khi bạn đặt tên branch không hay nhưn muốn dự án được gọn gàng hơn. Vấn đề này kha đơn giản xử lý, vì vậy hãy xem chúng ta làm thế nào để rename branch git trên cả local và remote Git nhé. 

## Cách Rename Branch Git trên máy local
Trước khi bắt đầu, hãy đảm bảo bạn đã chọn branch bạn muốn rename:

    git checkout old-name

Nếu bạn muốn xem danh sách local branchs, nhập lệnh sau:

    git branch --list

Khi đã xong, làm theo các bước sau:

Sử dụng lệnh rename branch Git với option -m:
    
    git branch -m new-name

Bạn có thể đổi tên local branch từ một branch khác bằng lệnh sau:

    git checkout master
    git branch -m old-name new-name
Cuối cùng, lệnh sau sẽ liệt kê tất cả – local và remote – branch để xác nhận tên đã được đổi:

    git branch -a
## Cách rename branch git từ xa

Thực chất, git không cho phép đổi trên trực tiếp remote branch mà là gián tiếp đi qua 3 bước: xóa đi > pull lên > đặt tên mới:

1. Để bắt đầu, bạn cần rename local branch bằng các bước trước.

2-3. Sau đó xóa branch cũ branch rồi push branch mới lên. Bạn làm vậy bằng lệnh:

        git push origin --delete old-name

        git push origin old-name new-name

Cài lại upstream branch cho tên local branch mới là xong:

    git push origin -u new-nam

Tuy nhiên, chính vì phải xóa đi tạo lại branch nên sẽ có một số trường hợp không thể đổi tên. Chẳng hạn không thể đổi tên branch mặc định vì bạn không thể xóa nó. 

Nguồn: [hostinger.vn](https://www.hostinger.vn/huong-dan/cach-rename-branch-git)

Nguồn: [freetuts.net](https://freetuts.net/git-branch-la-gi-branch-main-1072.html)

[hoangphiit](https://hoangphiit.com/post/cach-xoa-mot-nhanh-local-va-nhanh-remote-trong-git#:~:text=C%C3%A1ch%20xo%C3%A1%20nh%C3%A1nh%20Local%20v%C3%A0%20nh%C3%A1nh%20Remote%20trong,2.%20Xo%C3%A1%20nh%C3%A1nh%20git%20%E1%BB%9F%20server%20%28remote%20branch%29%3A)