<?php
session_start();
session_destroy();
header("Location: index.html"); // Chuyển hướng đến trang chính
exit();
?>