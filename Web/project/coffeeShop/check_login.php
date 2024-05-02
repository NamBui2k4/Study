<?php
session_start();
if (!isset($_SESSION['username'])) {
    // Chưa đăng nhập
    echo "<p>Bạn chưa đăng nhập. <a href='login_form.php'>Đăng nhập</a></p>";
} else {
    // Đã đăng nhập
    echo "<p>Xin chào, " . $_SESSION['username'] . "!</p>";
    echo "<p><a href='logout.php'>Đăng xuất</a></p>";
}
?>
