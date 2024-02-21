# Sử Dụng Git Cơ Bản

Các bạn làm việc liên quan đến lập trình đều được nghe rất nhiều về Git hay Github nhưng không hiểu nó là gì, nó thần thánh ra sao, hỗ trợ các bạn trong công việc thế nào. Trong loạt bài viết này mình sẽ hướng dẫn cho các bạn những hiểu biết cơ bản nhất về Git và Github.

## Tại sao nên dùng Git/GitHub?

Hầu hết khi hỏi các bạn sinh viên làm bài tập lớn theo nhóm, mỗi bạn code 1 phần vậy khi ghép lại thành 1 project hoàn chỉnh thì sẽ làm như thế nào?

Phần lớn các bạn đều trả lời rằng: "Bọn em sẽ lên thư viện hoặc hẹn nhau ở chỗ nào đó cùng nhau ghép hoặc copy gửi cho nhau" cũng có trường hợp "Có thằng nó gánh team rồi, em chỉ cần làm tài liệu thôi :D"

Thực trạng trên cho thấy rằng đa số các bạn sinh viên mới ra trường, chưa có kinh nghiệm làm việc nhiều nên hầu hết các bạn này rất lúng túng khi làm việc với Git hoặc thậm chí có bạn còn chưa biết Git là gì, chưa biết làm việc với nó như thế nào. Về cơ bản, việc này không phải lỗi của bạn ấy, chẳng qua các bạn ấy chưa có cơ hội để sử dụng Git, nên chưa tìm hiểu. Nhưng, sẽ là lỗi của các bạn ấy, nếu trong dự án sử dụng Git mà lại không tìm hiểu.

Mặt khác, việc sử dụng Git và Github thực sự rất quan trọng khi các bạn phải giải quyết những dự án lớn chứa hàng trăm file source code. Đấy là chưa kể chúng còn được hệ thống sắp xếp theo tên và theo ngày/tháng/năm. Hãy tưởng tượng một nhóm có hơn 10 developers cùng xúm lại chỉnh sửa từng ngóc ngách của một dự án xem, sự cố xung đột source code giữa các developer là điều thường xuyên xảy ra. Đó là lý do Git ra đời để giải quyết những khó khăn này.

![](/pictures/git-advantage.png)
\
Bài viết này sẽ tóm tắt các kiến thức cơ bản về Git

## Git là gì?

Git là một hệ thống quản lý phiên bản phân tán (Distributed Version Control System). Hiểu nôm na là 1 hệ thống giúp cho việc quản lý tài liệu, source code... của 1 nhóm các developer cùng làm chung dự án. Git sẽ ghi nhớ lại toàn bộ lịch sử thay đổi của source code trong dự án. Bạn sửa file nào, thêm dòng code nào, xóa dòng code nào, bỏ thừa dấu ở đâu... tất cả các hành động đều được Git ghi lại. Qua đó giúp dự án có thể điều tra nguyên nhân gây lỗi hệ thống, tổng hợp code trở nên dễ dàng hơn

## Git hoạt động như thế nào ?

Git ghi lại trạng thái hiện tại của dự án bằng cách tạo một biểu đồ cây từ chỉ mục. Nó thường ở dạng Đồ thị chu kỳ có hướng (Directed Acyclic Graph - DAG).

![](/pictures/so-do-cay-thoi-gian-git.png)

Mục tiêu chính của Git là quản lý một dự án hoặc một tập hợp các tệp khi chúng được người dùng thay đổi theo thời gian. Git lưu trữ thông tin này trong cấu trúc dữ liệu gọi là kho Git. Kho lưu trữ là cốt lõi của Git. Bạn có thể hiểu rằng kho lưu trữ Git là thư mục chứa tất cả các file dự án của bạn và các kiểu dữ liệu khác liên quan. Git ghi nhận tất cả các thay đổi của dự án (các hành động thêm, xóa, sửa), mỗi khi có bất kỳ sự thay đổi nào Git sẽ tự động ghi vào kho lưu trữ của mình dưới dạng các thông tin theo cây thời gian thời gian đối với mỗi file và đánh dấu cho mỗi thay đổi là một phiên bản. Từ đó bạn có thể quản lý các phiên bản code của mình, có thể chuyển đổi giữa các phiên bản theo nhu cầu

## Hướng dẫn sử dụng Git

Trước khi đi vào sử dụng git ta cần hiểu một số khái niệm liên quan đến Git như sau:

- Repository: Repository hiểu đơn giản nó chính là cái kho lưu trữ tất cả những thông tin cần thiết để quản lý các sửa đổi và lịch sử của toàn bộ project. Repository của Git được phân thành 2 loại là remote repository và local repository.
\
- Local Repository: là repository nằm trên chính máy tính của chúng ta, repository này sẽ đồng bộ hóa với remote repository bằng các lệnh của git.
\
- Remote Repository: là repository được cài đặt trên server chuyên dụng. Ví dụ: GitHub, GitLab, Bitbucket,...

![](/pictures/Local-Remote.png)

⟹ GitHub chính là 1 Remote Repository lưu trữ tất cả những thông tin cần thiết để quản lý các sửa đổi và lịch sử của toàn bộ project.

- Working directory và staging area: Là những tệp tin và thư mục được đặt trong sự quản lý của Git. Trong đó:

    + Working directory là hệ thống các tệp tin và thư mục, nơi bạn thực hiện các thao tác chỉnh sửa với project và source code của mình
    + Giữa repository và working directory tồn tại một nơi gọi là staging area hoặc index (vùng chờ) . staging area là nơi để chuẩn bị cho việc commit vào repository, giống như bạn ấn Save trong một file notepad.

![](/pictures/git%201.png)

Bắt tay vào cài đặt nào!!!

Để cài đặt Git, các bạn chỉ cần download Git về và Next => Next =>... => Finish là xong (Đối với máy windows). Chi tiết các bạn có thể tham khảo thêm ở link sau: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git

Sau khi cài đặt xong chúng ta bắt tay vào làm thôi. Trong phần 1 này mình sẽ trình bày một số câu lệnh cơ bản, thao tác với local repository trước (chưa cần tạo tài khoản github vội) để chúng ta vừa hiểu lý thuyết lại làm thực hành luôn cho nhớ nha :D. Lưu ý là khi chúng ta làm việc với git thì hầu hết là thao tác với command line thay vì giao diện khung cửa sổ thông thường.

## Một số lệnh cơ bản của Git

### 1. Lệnh tạo file cơ bản 

Nếu bạn đã từng sử dụng linux thì sẽ thấy cơ chế quản lý file và folder thông qua command line của nó giống hệt Git. Điều đó thể hiện qua 2 cú pháp:

- `mkdir` + tên folder: Tạo một folder mới 
- `touch` + tên file: Tạo một file mới

### 2. lệnh khởi tạo: `git init`

Tác dụng : Khởi tạo một local repository lưu trữ dự án mới hoặc đã có trên máy tỉnh của bạn.

Cách dùng: Tạo 1 folder mới ⟹ vào trong folder đó  ⟹ click chuột phải chọn Git Bash Here như hình dưới

![](/pictures/git%202.png)
\
Cửa sổ console git bash hiện lên => các bạn gõ lệnh `git init`

![](/pictures/git%203.png)
\
Khi chúng ta chạy lệnh `git init` thì một thư mục ẩn được tạo ra trong folder đó là `.git`, thư mục này sẽ chứa toàn bộ database và các thao tác của dự án, nó có một số thư mục con và một số file quan trọng gồm: HEAD, branches/, config, description, hooks/ index, info/, objects/, refs/. 

Trong đó bạn cần chú ý đến thư mục objects vì đây là thư mục chứa toàn bộ database, nó có 4 objects như sau:

- tree: là directory
- blob: là file
- commit
- tag

Nếu bạn đã từng tìm hiểu qua Linux thì sẽ thấy cách lưu trữ của Git gần giống như Linux bởi vì tiền thân Git được tạo ra là sử dụng trên Linux. Mỗi object sẽ được định danh bởi một Unique Id có chiều dài là 40 kí tự dựa vào thuật toán băm SHA-1. Ví dụ: 73b41f9f027614a0417edc7cca83ea5065eb36

¬

### 3. lệnh thêm: `git add`

Tác dụng : Thêm thay đổi của Working directory vào staging area.

Cách dùng: Tại thư mục làm việc, có thể chọn `git add .`

Khi add thành công

![](/pictures/git%204.png)
\
_Giải thích thêm: Trong lệnh `git add .` , dấu `.` là một tham số đặc biệt để chỉ đến tất cả các tệp và thư mục hiện tại. Khi bạn sử dụng `.` như một đối số cho `git add`, Git sẽ thêm tất cả các thay đổi trong Working directory vào staging area để chuẩn bị cho một commit._

Ví dụ: giả sử working directory của bạn có tên là "my_project", dạng như sau:

```
my_project
   |-- src
         |-- file1.py
         |-- file2.py
   |-- docs
         |-- document.txt
   |-- README.md

```
\
Khi đó, lệnh `git add .` sẽ đi vào từng folder (src, docs) và từng file (README.md) trong đó để lấy các thay đổi của thành phần con trong chúng đưa vào staging area (trường hợp này là lấy file1.py, file2.py và document.txt)

Ngoài `git add .` thì còn một số lệnh add hữu dụng khác như:
- `git add <đường dẫn file>`: chỉ thêm các thay đổi của một file nào đó.

- `git add <đường dẫn thư mục>`: chỉ thêm các thay đổi của một thư mục nào đó.

### 4. lệnh cam kết: `git commit`

Tác dụng: commit là một action để Git lưu lại những thay đổi của dự án vào repository. Khi commit, chúng ta cần gửi một thông điệp mô tả ngắn gọn về những thay đổi của dự án đến những người cùng làm chung dự án đó.

Cách dùng: `git commit -m` + tên thông điệpV

Ví dụ: `git commit -m "add source nhaaaaaa" `

![](/pictures/git%205.png)
\
Sau khi commit thành công, những thay đổi mà chúng ta commit lên file sẽ được hiển thị theo thứ tự thời gian mới nhất trong Local Repository
\
![](/pictures/commit-git.png)
\
_Lưu ý: Tên thông điệp nên được viết ngắn gọn, súc tích, dễ hiểu. Cụ thể, bạn có thể kham khảo mẫu thông điệp sau:_

- _Tiêu đề ngắn gọn_
- _Lý do thay đổi: ....._

Kiểm tra lịch sử commit: `git log --all --oneline`

Tuy nhiên, Nếu bạn là người đầu tiên commit một dự án, bạn sẽ gặp phải trường hợp sau:

```
$ git commit -m "first commit"
Author identity unknown

*** Please tell me who you are.

Run

  git config --global user.email "you@example.com"
  git config --global user.name "Your Name"

to set your account's default identity.
Omit --global to set the identity only in this repository.
```
\
Lúc này, để có thể commit được thì Git sẽ yêu cầu người dùng phải cung cấp thông tin bao gồm tên và email để xác định xem ai là tác giả của mỗi commit. Những người làm chung dự án sẽ nhìn vào đó mà biết bạn là ai, commit vào lúc nào, nội dung gì,vv. Thông tin này sẽ được cung cấp bởi lệnh `git config`.

### 5. Lệnh cung cấp thông tin: `git config`

Đây là một lệnh được sử dụng rộng rãi ở nhiều ngữ cảnh nhưng chúng ta chỉ xét ngữ cảnh cung cấp thông tin cho Git. Ta có:

- `git config` + `--global user.name` + tên: cung cấp tên người dùng cho Git
- `git config` + `--global user.email` + email: cung cấp email cho Git


### 6. Lệnh hoàn tác thay đổi

Git có cơ chế giúp chúng ta hoàn tác những thay đổi lên dự án nếu có mắc sai lầm nào đó. Cơ chế đó thực thi thông qua 2 lệnh:

- `git revert` 
- `git reset`

Khi chúng ta commit, Git sẽ lưu lại lịch sử của dự án, cho phép chúng ta quay trở lại lịch sử đó khi cần thiết.

Hai lệnh trên đều có cùng chức năng như vậy nhưng cũng có những điểm khác nhau

- `git revert` :  Thay vì xóa commit hiện tại thì Git sẽ tạo một commit mới chứa các thay đổi ngược lại so với commit đó. Lệnh này tương đối an toàn

![](/pictures/revert.png)

- `git reset`: Git xóa luôn commit hiện tại và trỏ đến commit trước đó. Lệnh này có thể dẫn đến mất mát lịch sử nếu không sử dụng cẩn thận

![](/pictures/reset.png)

### 7. Lệnh kiểm tra trạng thái: `git status`

Tác dụng: kiểm tra trạng thái của Working directory và staging area xem đã commit hay chưa. 

Khởi đầu, khi chúng ta tạo mới một local repository mới mà chưa có một commit nào dành cho Working directory và staging area thì mặc định lệnh trả về kết quả:
```
On branch master

No commits yet

nothing to commit (create/copy files and use "git add" to track)
```
\
Giả sử chúng ta có một đường dẫn của Working directory là  "MINGW64 ~/MyProject" với trạng thái như trên. Hãy thử khởi tạo một file và đưa vào staging xem kết quả như nào nhé:
```
$ touch newfile.txt
$ git add new.txt
```
\
Kết quả:
```
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   new.txt

```
\
Có thể thấy, new.txt đã được thêm vào staging nhưng vẫn chưa được commit để đưa vào local repository. 


# Tổng kết 
Có thể nói rằng biết và sử dụng Git và GitHub là một kỹ năng rất hữu ích và phổ biến cho lập trình viên, vì nó giúp quản lý và cộng tác dự án một cách hiệu quả. Trên đây là những kiến thưc cơ bản nhất về git, nếu muốn nâng cao hơn thì hãy sang Git-advanced.md

Nguồn: 

[_codelearn_](https://codelearn.io/sharing/git-github-tu-co-ban-den-nang-cao-p1)

[_github.com_](https://github.com/hocchudong/git-github-for-sysadmin?tab=readme-ov-file#ngonngumarkdown)

[_nulab_](https://nulab.com/learn/software-development/git-tutorial/git-basics/undoing-changes/removing-commits/)

[freetuts](https://freetuts.net/git-mo-hinh-du-lieu-kho-chua-1081.html)

