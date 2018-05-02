================================================================================
===        Jlick application  - Được xây dựng dựa theo Flick application     ===
================================================================================

Tác giả:
 Đoàn Thị Hoài Thu - K61CLC - Đại học Công Nghệ ĐHQGHN
 Nguyễn Hữu Thị Hiếu - K61CLC - Đại học Công Nghệ ĐHQGHN


--------------------------------------------------------------------------------
   Hướng dẫn chạy thử  app trên localhost:

1) Tải và cài đặt MySQL Server. Nếu bạn mới bắt đầu và gặp khó khăn trong việc cài đặt  MySQL Server, bạn có thể
    tham khảo tài liệu tại link sau "https://www.dropbox.com/s/ngbkiyfbfu1mglf/TH_CSDL_Sept_2017.docx?dl=0" mục 1,2,3,4
    phần Cài đặt. Các mục khác bạn có thể đọc thêm, việc chạy thử application không yêu cầu điều đó.
2) Tạo database để chạy thử chương trình  bằng cách thực thi file "db/{schema,datadample}.sql".
    CÓ thể chạy bằng Command Prompt hoặc công cụ quản lý dữ liệu như Workbench, SQL Workshop,...
    Cách nhanh và đơn giản nhất là  bạn có thể copy toàn bộ các dòng code trong 2 file "schema.sql" và "datasample.sql"
    và chạy nó trong command prompt. (Chú ý: các dòng code trong file "schema.sql" phải được thực thi trước "datasample.sql")
    Việc khởi tạo database này chỉ cần thiết khi lần đầu tiên bạn chạy thử app này.
3) Gán quyền truy cập database cho tài khoản quản trị MySQL Server của bạn. Công việc này rất đơn giản, bạn có thể tìm
    hiểu trên Google hoặc xem trực tiếp tại link "https://www.hostinger.vn/huong-dan/lam-the-nao-de-tao-user-trong-mysql-database-gan-quyen"
    Việc này không cần thực hiện nếu bạn chạy thử bằng tài khoản "root"
4) Phần mềm yêu cầu thông tin về tài khoản quản trị MySQL Server, url kết nối tới database, url thư mục webapp của project trên máy tính của bạn. Các thông số cần thiết được liệt kê trong file
    "app.properties.sample" tại đường dẫn "main/resoures". Để phần mềm có thể lấy được các thông tin này, trong thư mục resoures,
    bạn tạo 1 file txt mới với tên là "app.properties", copy toàn bộ thông số từ file "app.properties.sample" và điền
    thông tin về tài khoản quản trị MySQL Server, link url nối tới database. Thông tin bạn thêm vào để sau dấu bằng "="
    và không cần đặt trong dấu ngoặc kép "". Nếu bạn chạy thử app trên localhost thì thông số db.url
    có thể điền mặc định  là "jdbc:mysql://localhost:3306/data".
5) Để máy tính của bạn trở thành localhost, chạy thử được app thì cần cài đặt Tomcat server, bạn có thể download Tomcat Server
    phiên bản 8.0.50 tại link "http://tomcat.apache.org/download-80.cgi"