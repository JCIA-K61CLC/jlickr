# Jlickr application- Ứng dụng lưu trữ và chia sẻ ảnh

----
* Xây dựng dựa theo Flickr Application.
* Tác giả:
- Đoàn Thị Hoài Thu - K61CLC - Đại học Công Nghệ ĐHQGHN
- Nguyễn Hữu Thị Hiếu - K61CLC - Đại học Công Nghệ ĐHQGHN
----
## Hướng dẫn chạy thử Jlick trên localhost bằng Intellij

----

## Yêu cầu cho máy tính:
-	Cài đặt Intellij IDE [download](https://www.jetbrains.com/idea/download)
-	Cài đặt hệ quản trị cơ sở dữ liệu MySql  [download](https://dev.mysql.com/downloads/mysql)
-	Cài đặt Tomcat Server [download](https://tomcat.apache.org/download-80.cgi)
-	JDK >=8: Công cụ hỗ trợ phát triển ứng dụng Java, [download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

----

Tải mã nguồn tại [Jlickr](https://github.com/JCIA-K61CLC/jlickr)

<img src="https://www.dropbox.com/s/9oycbudq55y19jt/27661537_753292451547135_537898783_n.jpg">

Sau khi tải về và giải nén, ta được thư mục có các file như sau :

<img src="https://imgur.com/CH1emKg">

----

## Các bước thực hiện

1) Trong Intellij, mở project bằng cách File -> Open -> Thư mục mã nguồn vừa tải về
Trong cấu trúc thư mục, chú ý đến file src/main/resoures/app.properties.sample. Trong file là một số
thông số máy tính của bạn liên quan đến cấu hình máy :


2) Để app có thể lấy được các thông số này, tạo một file mới có tên là “app.properties” bằng cách nháy chuột phải vào thư mục resoures->New->File. Nhập chính xác tên file là app.properties. Một file trống được hiện ra, lần lượt điền các thông số của máy tính vào sau dấu “=”, không cần cho trong ngoặc kép “”.
'''
Trong đó, “db.user” và “db.password” lần lượt là username và password tải khoản quản trị cơ sở dữ liệu của bạn trên máy tính. “db.url” là đường dẫn liên kết tới database. Tài liệu hướng dẫn này sử dụng Hệ quản trị cơ sở dữ liệu mysql và chạy trên localhost, database lưu trữ thông tin tài khoản của người dùng là "data", nên có thể điền mặc định là  “db.url=jdbc:mysql://localhost:3306/data”
webappURL là đường dẫn tới thư mục webapp của project. Tại folder của project->src->main->webapp, copy đường dẫn trên thanh địa chỉ, đây chính là webappURL. (Chú ý, webappURL tùy từng máy mà có thể khác khau, không nhất thiết là giống hệt như ví dụ minh họa).
'''

ảnh

3) Tạo database để chạy thử chương trình  bằng cách thực thi file "db/{schema,datadample}.sql". CÓ thể chạy bằng Command Prompt hoặc công cụ quản lý dữ liệu như Workbench, SQL Workshop,... Cách nhanh và đơn giản nhất là copy toàn bộ các dòng code trong 2 file "schema.sql" và "datasample.sql" và chạy nó trong command prompt. (Chú ý: các dòng code trong file "schema.sql" phải được thực thi trước "datasample.sql"). Việc khởi tạo database này chỉ cần thiết khi lần đầu tiên chạy thử app này.

ảnh

4) Gán quyền truy cập database cho tài khoản quản trị MySQL Server. Việc này không cần thực hiện nếu truy cập bằng tài khoản "root".
Để Intellij có thể chạy được project, cần cài đặt cấu hình trong phần  Edit Configuration:

ảnh 

5) Trong cửa sổ Run/Debug Configuaration->+->Tomcat Server->Local

ảnh

6) Trong hộp thoại Server, phần  Application server, chọn phiên bản Tomcat Server vừa tải về.
'''
Tomcat là một ứng dụng chủ Appplication Server hỗ trợ chúng ta trong việc triển khai các ứng dụng web trên chính máy tính của mình. Thông thường các website chúng ta sử dụng trong cuộc sống hằng ngày được lưu trữ lại một server cố định, các server này có kiến trúc vô cùng phức tạp, dung lượng cực kì lớn, hoạt động liên tục. Để đẩy được website của chúng ta lên server, cần phải trải qua một số bước khá là phức tạp + phải có chi phí. Tomcat là công cụ giúp chúng ta chạy các website của mình ngay trên máy tính cá nhân mà không nhất thiết phải thuê server, hỗ trợ trong quá trình kiểm tra và chạy thử.
'''







