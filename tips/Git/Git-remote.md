# remote repository trên Github

Ở chủ đề  [Git-basic](Git-basic.md), chúng ta đã thảo luận một số kiến thức cơ bản của git, bao gồm cấu trúc và các lệnh của Git. Tuy nhiên, đó mới chỉ là thao tác trên local repository, nghĩa là trên kho lưu trữ của máy tính cá nhân. Bây giờ nếu vào đặt trường hợp làm việc nhóm ở công ty thì làm sao để share kho lưu trữ ấy cho đồng nghiệp ? Đó là lúc giải pháp remote repository ra đời.

Để làm việc với remote thì ban phải có server và cài đặt git remote trên đó. Rất ít bạn có điều kiện làm, may ra công ty lớn thì mới có. Tuy nhiên hiện nay có một số server cung cấp dịch vụ miễn phí (có phí) như github, gitlab ... nên bạn có thể sử dụng dịch vụ này để học và quản lý dự án của riêng mình.

Trong bài này chúng ta sẽ bắt đầu thao tác với Github, và bài đầu tiên này mình sẽ hướng dẫn các bạn thao tác với một remote repository trên Github.

## Điều kiện tiên quyết

Để bắt đầu học series này thì mình khuyên bạn nên tìm hiểu qua series [Git-basic](Git-basic.md) bản trước nhé, bởi đó là nền tảng, nó sẽ giúp bạn có thể học bất kì một dịch vụ remote trực tuyến nào như github, gitlab ... Ban phải hiểu khái niệm git là gì, phân biệt giữa remote repo và local repo thì mới học github được 

## Đăng kí và đăng nhập tài khoản Github
Nếu bạn chưa có tài khoản thì hãy thực hiện đăng ký thông qua [link này](https://github.com/), sau đó nhập đầy đủ thông tin của cả từng step rồi click nút Create an account. Cơ mà ở thời điểm hiện tại, Github sẽ làm khó bạn một chút khi bạn phải xác thực tài khoản bằng mấy trò giải đố (làm toán ,  nghe audio tiếng mèo kêu) để nhận diện người dùng,... nên là hãy chịu khó một chút. còn nếu bạn đã có tài khoản thì hãy thực hiện đăng nhập bình thường nhé. 

![](/pictures/sign-in-github.png)

## Tạo mới một repositpry trên Github
Mình xin nhắc lại là từ nay mình sẽ sử dụng từ repo để thay thế cho repository nhé

Màn hình chính của chúng ta sau khi đăng ký tài khoản xong sẽ có dạng như sau:

![](/pictures/home.png)
\
Bước 1: Bạn click vào nút có dấu cộng ở góc bên phải màn hình, sau đó chọn `New repository`.

![](/pictures/new-Repository.png)
\
Nhập đầy đủ thông tin mà nó yêu cầu bao gồm: Repo name, description, status (private or public). nếu bạn tick vào nút initialize this repository with a README thì nó sẽ tạo một file README nằm trong repo mới tạo.

Giả sử tài khoản Github của tôi có tên đăng nhập là PhuongNam2k4, khi tôi khởi tạo một repo có tên là MyProject thì đường dẫn đến repo ấy sẽ là

 `https://github.com/PhuongNam2k4/MyProject`

Minh họa dưới hình sau:

![](/pictures/MyProject.png)

## Liên kết local repo với github

Chúng ta sẽ nhắc lại chủ đề [Git-basic](Git-basic.md) một chút. Ta đã biết một local repo được tạo bởi lệnh `git init` thực thi trên folder dự án ở máy cá nhân. Khi chúng ta liên kết local repo với remote repo, điều này có nghĩa là local sẽ là nơi làm việc của bạn và remote chính là nơi lưu trữ mã nguồn chính của dự án. Tại remote, các thành viên sẽ thực hiện các thao tác pull và push để đưa code và lấy code về local. 

1. thêm một remote repo vào local repo

Mục đích của việc "thêm" là đánh dấu đường link của remote cho local biết đâu là nơi để nơi lưu trữ.

Cú pháp: `git remote add [tên remote] [đường link của nó]`



![](/pictures/git-remote-add.png)

Trường hợp bạn đặt tên remote đã tồn tại thì sẽ bị thông báo lỗi là `fatal: remote origin already exists.` Để giải quyết vấn đề này, bạn có 3 lựa chọn:

- Chọn một cái tên khác. 
- Đổi tên của remote đã tồn tại đó sang tên khác.
    Cú pháp: `git remote rename [tên cũ] [tên mới]`
- Xóa remote đã tồn tại đó.
    Cú pháp `git remote rm [tên remote]`

2. Xem remote repo đã thêm

Để xem remote mà bạn đã thêm thì sử dụng lệnh  `git remote` hoặc  `git remote -v`.

- Chỉ xem tên: `git remote`
- Xem chi tiết hơn `git remote -v`

3. Thay đổi link của remote repository

Giả sử khi thêm remote vào local, bạn gõ nhầm link của remote. Khi đó, bạn cần phải thay đổi lại link, lúc này bạn hãy sử dụng lệnh sau.

`git remote set-url [shortname] [link]`

## Các tính năng bổ sung của github

###  Issues

![](/pictures/navigation-highlight.png)

Github issue là 1 cách vô cùng tuyệt vời để theo dõi tasks và bugs của bạn. Chúng khá giống với email ngoại trừ việc có thể chia sẻ và trao đổi với những thành viên còn lại trong repo.

![](/pictures/listing-screen.png)
\
Với Github issue bạn có thể miêu tả được toàn bộ vấn đề với:

- Issue title và description mô tả về vấn đề
- Các labels để đánh nhãn dễ dàng phân loại và lọc
- Milestone đưa các issue vào 1 phase của project hay 1 sprint
- Sau đó là assign cho thành viên trong repo
- Comment cũng như feedback

### Pull Request

![](/pictures/Screen-Shot-2021-06-27-at-22.54.07.png)

Pull request hay gọi tắt là PR có nghĩa là bạn thông báo với những người khác rằng bạn đã đẩy những thay đổi của Branch lên Repository tổng (master respository). Các cộng tác viên của repository này sẽ approved hoặc comment trong PR này.

Các bước để tạo PR trong GitHub là:

- Trong GitHub, di chuyển tới repository của bạn
- Chọn Pull Request và New Pull Request trong Repo (hoặc chọn compare & pull request)

Nguồn kham khảo: [freetuts](https://freetuts.net/git-them-remote-repository-1098.html)
