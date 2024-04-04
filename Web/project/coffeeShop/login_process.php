<?php
// Kết nối với cơ sở dữ liệu
$conn = new mysqli('localhost', 'username', 'password', 'database_name');

// Kiểm tra kết nối
if ($conn->connect_error) {
    die("Kết nối thất bại: " . $conn->connect_error);
}

// Lấy dữ liệu từ form
$username = $_POST['username'];
$password = $_POST['password'];

// Truy vấn cơ sở dữ liệu để kiểm tra tên đăng nhập và mật khẩu
$sql = "SELECT * FROM users WHERE username='$username' AND password='$password'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Đăng nhập thành công
    session_start();
    $_SESSION['username'] = $username;
    header("Location: index.html"); // Chuyển hướng đến trang chính
    exit();
} else {
    // Đăng nhập thất bại
    echo "Tên đăng nhập hoặc mật khẩu không đúng.";
}

$conn->close();
?>