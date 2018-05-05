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
> Tomcat là một ứng dụng chủ Appplication Server hỗ trợ chúng ta trong việc triển khai các ứng dụng web trên chính máy tính của mình. Thông thường các website chúng ta sử dụng trong cuộc sống hằng ngày được lưu trữ lại một server cố định, các server này có kiến trúc vô cùng phức tạp, dung lượng cực kì lớn, hoạt động liên tục. Để đẩy được website của chúng ta lên server, cần phải trải qua một số bước khá là phức tạp + phải có chi phí. Tomcat là công cụ giúp chúng ta chạy các website của mình ngay trên máy tính cá nhân mà không nhất thiết phải thuê server, hỗ trợ trong quá trình kiểm tra và chạy thử.
-	JDK >=8: Công cụ hỗ trợ phát triển ứng dụng Java, [download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

----

## Tải mã nguồn tại [Jlickr](https://github.com/JCIA-K61CLC/jlickr)

<img src="https://lh3.googleusercontent.com/jScgeXgMzOQNygGyrmCW9SwP6ljc2fgybbr5sixcNqnqPmFkuYkYkNnDxfv3ZeQtq0P7DhziI1b77V4KgIK5SE4gB3uVyikosdYesw3zxjsHBlq94S2bcYxauFuQCHAcTsc761Nh2YzlrNUcpcnEYE-yQcblIr59jYCcj05Tu4tUAvcCEb2fN2HsSq0dYmlhk8A3fyJowIlAvU9jzK8L60ssQxr-u3d6KJmEyaB5cXBYydt1NvBD_ACgZonGClcNavE2OZibvJxicV0kTmpIbBXNyVqMj8A1TTUNTqI4q8hbuEt8Oo4i6yegxcoszRsDOPcSW8cJLsYQ8_1uvQxdQYm5tPDEfs9-Y3humPVxEInHhsLA0Re_CIT9YY_A_qvvj9Rr67PLRAJogOvzuMgSZT_hPj-DJe4diWBdgNhAxyA8-WfwouUAv2Gqd3czv6xTErDYvp5Y8xRwIiFHWBU8nn0GHEOxiKaxk1WjHORgEkkrfYASuB4rHr8qq-ElJG08uTiDIZ33JwDe2Izu8-ZhPaO_yfqNmHxEi8eSrrzsYJkmjsGXpjsa6nBumO8bNtdLIsMeAWDvOxZQvk4DuVe7dNDG4uhNRmG_0tglbw9n5JTvkp0zXMp5-ogJ7s-rUKiHOJcOsGUKXd5LMJt4uoxuQwqgKt1GhIXq=w1495-h733-no">

## Sau khi tải về và giải nén, ta được thư mục có các file như sau :

<img src="https://lh3.googleusercontent.com/dkzDRpoe5RJpNOvu33Tg0AqEr1maQCbwyXamb4nUXENTW2eZxo5tQLFSePYwd7ygOqGHJQYXMMjjxHftNh45CZy8F0zOpX7V3yicQqinu4YOBS3vVSaXnzPbDLciyzU0tZU_VWGPzd_7budgEhNFBBg-u2AX5F5ES9ShQzyMNLQ9qhnLPWmHbyDtNyzeTuSU5HRctluVMHzmy-8cQ8pX3t3peADTpXN4qFcGEgH0Ov1uMugylMqUfmU7DyB9vwUuAKiatQaweI-uopJVwdzPuHHi2c-0zrz-RiOLWjUIrhLLf6gYEgJob110RuqyQJ74kU_cBFoDgUK-0kol-lBwVom4tpOWryOhYfISMZK4PzvKcAQQ9ODAcYhv0r8hlxoKfkgYOvo8yNk7439W8SS6pfmNcNEaOAeehem872AZD_zfC3LUi5Ky9eHH0KZwZDHST8BMfTbjAfoMX3pMxq4HeQlpjDJklZyYzaSs_KE1EPAypXvDlBRCYdaz9B_OsX2d2JKcODdaGol6zqPGDMUFCayFm93NUH_m01jkdtGTKjmWFBDY5Mfue85HgEJgF33gQXuw1shSmMjXzlELuuv8jH2e8PHkdMHLbIQSha8=w1058-h400-no">

----

# Các bước thực hiện

1) Trong Intellij, mở project bằng cách File -> Open -> Thư mục mã nguồn vừa tải về
Trong cấu trúc thư mục, chú ý đến file src/main/resoures/app.properties.sample. Trong file là một số
thông số máy tính của bạn liên quan đến cấu hình máy :

<img src="https://lh3.googleusercontent.com/kjN2GFeOEqTPcvREKgGYqU4yxG-2aNst2yrS_RcEr5p87NWTnLRDqOPgc2KeDJcvsspdnYsHzRTyf3OC1Q2yY7Xr4WdCWVm6hMdBQsZVL0RXTZ3FxFrObvaZof5-NY0QkPIvuqKr9HJkT0aI2MKNlus3osiP-t3jv7hzrHZwyhqQoZpdynqlHfmyUi9rcjTn1NeuUZe_mLlZAx9mkO6WcmfZeP3SYeOPIgh1v2JLH9IYkTtpmAmI5xT0Yc3N6EEOwPr1DhTxBuJx54bTANBQUAh8ipYXKdQK9pyJCJr6UrjJmlEWzMOd2XkSTeTB212FKr0BXl2s8Bb0ScBg87B_7wwsrXH_oPOqdaJwqPgojdk8meM7O3XLRhw4eaY_Dm33OYGA-s-IBzRrnc8UqFyqp2Ott29gOf9DCPZTRG1xe7tZowSSHPQAhacwNYB0Ys6oOFkQU8e7Exv0pogBrIXO3yf69QYO3gwzCd92LeJnYzBxD0n9-WZS-xiOQsjmWVKw8QPxHHwYx4WXX9BnLFRsh_DpqmjoCGlDJgjhbjoEmhkFT5rWJjruqDJjuvFQxwpyPdryACwtoNqoZOd60_P7qzEnScZH7_X0AVSe_FM=w1908-h604-no">


2) Để app có thể lấy được các thông số này, tạo một file mới có tên là “app.properties” bằng cách nháy chuột phải vào thư mục resoures->New->File. Nhập chính xác tên file là app.properties. Một file trống được hiện ra, lần lượt điền các thông số của máy tính vào sau dấu “=”, không cần cho trong ngoặc kép “”.

    - db.user: username tài khoản quản trị cơ sở dữ liệu.
    - db.password: password tải khoản quản trị cơ sở dữ liệu.
    - db.url: đường dẫn liên kết tới database. Tài liệu hướng dẫn này sử dụng Hệ quản trị cơ sở dữ liệu mysql và chạy trên localhost, database lưu trữ thông tin tài khoản của người dùng là "data", nên có thể điền mặc định là  “db.url=jdbc:mysql://localhost:3306/data”.
    - webappURL: đường dẫn tới thư mục webapp của project. Tại folder của project->src->main->webapp, copy đường dẫn trên thanh địa chỉ, đây chính là webappURL. (Chú ý, webappURL tùy từng máy mà có thể khác khau, không nhất thiết là giống hệt như ví dụ minh họa).
    
<img src="https://lh3.googleusercontent.com/XyfRpoGBD4EKb3nkfX6cKAgWnfR7phKVkix374n7Qgws9WIP3qVpFsMQdQvruKOzrmJdZFHDkEwNQQmsqSijyOPza69fnHIQUrIdJaS6myLBW7vmc9x5b0BL58vpHpZQFEcy9cZTyk6Qxr5xdUybsJpbQ_NdfPvg_EMjk-BA6rzjMEquGVo6kuflE90lnydh62sfeepIJZuw804uJEATPGBu7NTDRpSV42kaRseJmdy8rUSIli-yz0tONgXWde2ikSJOi__LDcdBHVr7TvZWnJQTdCNmfnVsYCNtR_tWKRw8Q8LfiYYa7F48Kpj89AR6rdXmflMQNU0vFHiYvKo7N0JXLYIJDlGiNfoxma1BhzSr1LwWdVJ526vi5FNI8CLimCKXp29boqX6CnLbn2_D78JmHOEqmkqBtgcYTx46EMYQPNJfTZdIWHvvCInrI3XLx0e_Z2r-aCzWbuePdhm15ZiLikGigaX6rf1hoPQtU9gdbznp_SnZPHczwbA8RnM3ucmKDHs0ACK8YOqo4VJHBp5Vi2YeKCOv7ekavoGxE_FWaZ2tuhqGRrBtuRMsrOotj7dtbwnLDAt60uvQ2vEymLHS6lHDDGHHG70w3Mg=w1606-h498-no">


3) Tạo database để chạy thử chương trình  bằng cách thực thi file "db/{schema,datadample}.sql". CÓ thể chạy bằng Command Prompt hoặc công cụ quản lý dữ liệu như Workbench, SQL Workshop,... Cách nhanh và đơn giản nhất là copy toàn bộ các dòng code trong 2 file "schema.sql" và "datasample.sql" và chạy nó trong command prompt. (Chú ý: các dòng code trong file "schema.sql" phải được thực thi trước "datasample.sql"). Việc khởi tạo database này chỉ cần thiết khi lần đầu tiên chạy thử app này.

<img src="https://lh3.googleusercontent.com/XdnPKRqAuhCxdnIzkwQjXdCmd6gAusDoqoJtkkL_xrlUVyIzOaeTQjqcbRgCGOw-oNeBs6jzeLqqQeL-dFR1JTUNBI1tV2pBLErwRMfVayi8FPa7Md6UBf0yai9LyJx4YgpfJ23TnAPLFJ-QL7Ty2Oz9_W4_tvhYQSxygmJURmTAwxEwzS2e3-Co4Wh5DKHYw4QS1w0adAHpHrFrPWU2FJS2G2_xXEdFf2ZuJWdic3j2D3LdbBgcIlV__khXMQTb_67PZtNlnlB3RmBubSDIlZ1sc9vWafuBQWvQFuxnZqkPUisAxvlGJhyS85s9K5walz7qrwk_bvUoHtjtm_LZRJMZXvraQL4i7d3g3clXxswxritUL4DxQDvPDgVXsMr7QgJZCnrakW_UVYUmwKj7V-qe2SGMQXS58xpr8zQoVckzLeY_e921ATuCpDmsVj9tzs7KZDbUPSOwk8ewuCX5kVmk4rYnsFPfGKB0YU2_dpeHjZBusRLUXDW-GJycfd30vDJQ--g0QwRt7epgbNxlBI6LgsYZkm2Snbisvr0RLV-efw9SgBoKyHTSGqDxZwieidEcQuIdUj-K2rqX58T4j0v3Qz_AX2vZJWvYIoU=w1672-h651-no">

4) Gán quyền truy cập database cho tài khoản quản trị MySQL Server. Việc này không cần thực hiện nếu truy cập bằng tài khoản "root".
Để Intellij có thể chạy được project, cần cài đặt cấu hình trong phần  Edit Configuration:

<img src="https://lh3.googleusercontent.com/bIin-5R1iJOo8cwEClLhF9Sqn5DDOflJchCYLW7lAQynqWfdxB8rVOEKbcATJgtmgfMWEoD2IRw5BezX_KVHxmt2S7ecOIgW4zdCQAP2rrpV3GGZy4WwXyofG1NMFxCgGmVEnpDboG2WQ79x2qgG_H6bADH7qhphLnzgkqxHu2jBZU6H9hnQjWQ_aRmBD-gJgt6YWFnB_6wPkHvZOShOws-f-v40Qf-ulccXynvX2LZUGRUKFFzxe_ix6ByEmqPxHr0aSHl9oNDwGjTgCu0hY-8V9HSLTtupJ-ibq4iP69LLDGUeI8JfEtMhdF3IYnsW5YaHhQ7KzYpRE9hIPbYPzSN7haBO7rMeAmPYq0RVScZzlnHWNVaZbUc4O8Dxe-Gj6nSdLN7bDHrFY6GUoJHvK2XfCRyY5KJe7Q5o_nmQoQVHPXV7Ouxmuj3PWeIf2yrmXnySY3M5BXon-ZxbLaM7wkshsZxm45_5LSCQvhCWjV4zIXDg500Zeorl_nll9KZVkZ9xVq9qNBhqqb0QzqLp-fJM0C6soZuI8vKtaN2RQSIF_0MOUpm2u-kS0-rJ34tVvmjmqZFRq-aB9ixFEmO8gew3gl7_-xRPDs3Jh5s=w1088-h243-no">

5) Trong cửa sổ Run/Debug Configuaration->+->Tomcat Server->Local

<img src="https://lh3.googleusercontent.com/46NAtwNzbY1Xk-iXb-sCc3j-ZcNPpJh7HEzSwvqEg9S63AbhpU4Ux4FOsk0DIKRU71vUGyaJORTRbA2mv48YSENrCYyOFA_OS03e8DiAI3QYlgs0RvAcxLOPNOu4RlW_za2qcJyaYJk2NwaK1FPzwlC0Zq1bs0mGypb-pW-DTkzcUEvQ228g-KD5Lsrq-tljfRYe2Kt7kRB_BwAfasZfxm89mWzHIvMbshBeEawkYmdYYLnLjpUBPoWgTn6_iRy65VcYivzlOO-ZhG3AKndX5tWcAxgujnC1PhRSlyqAeWp0vXgxu2KKTr21EunzEeitk83e1kuKFGIgvzqe_eGFaPLFxc-nUU4-DhhmHdycMJqLc75pG6DV_3_lPBsny7yEK7u7MmshBZvO_FX7km5D9_mz-po-p228B7BVZsEX4p1tLCqktZwOrGkubEATcskNra2_t9qvTlEwy5QRpSraQcGBFct3U5Gp1zQAYOlYwO_8InzLw5u3NHVJ2O-ahnvyzH6H2IWgXopgNZboyVVVTWRCI5dp4LqFg_J24_zrALMlsNk4WDN3_Vg49BXWUjl8jZv51CTwCVz3rAIfv_GoMIa2IKq0vnBOiWd9-Pc=w1509-h936-no">

6) Trong hộp thoại Server, phần  Application server, chọn phiên bản Tomcat Server vừa tải về.
<img src="https://lh3.googleusercontent.com/LjleqWh3WFfoDbIuOQ8r6bDWT2bGqE7XPFbDgf1LI8Qrqc7PndbpzQitpWVa_0VYhkBqLBjmwiwB5g_gqD1wQXMqy92DGyKbYVPF-WTNA-EM8TyQ5G6ZTL7WKietOIZgQBhUV2eDim8QUJCRSRvQZG-MpFEJNIgMepFWon0Qdg9sQXQI6xrFodh7rBBqm-CHedOm2jMEZDX63lEqjRkNzn9aGi1UASSmaudlOmIy0TwwlGqhK2LrpSOg0e0IevaKU17VXS0B2pur_6PpAR-T89TqvrppjqTKun2Dr4dRlodtQ2HG4XqRvh46bFPUgzPWDgasXNZeu7vIG074-Ng8k7i2Ba0GQIlRdogohVH8iBP7Nq4WPa-evK0abt6ELIRfZGuuuDgkwVgqFdQxlwPevh25rSTx4DEqazlsduhFAvzy6yWSbiKmBE4DG3FTREVt_yOl7zV_vsLuDzREkORRwZf6YJqksmhZvQNnkCVwCRnEa2PkZ5NezmmWuO4OlW3BXagkto2ZGJkoYq0fdKX2_wO8p6PApUdDr8dCDd_pYKh3T61Fkm4beCRSuYdCrtEoTJ1XudTiS_uOGOkaYhW79px_82jNq0muWd18Ebw=w1095-h936-no">

7) Trong hộp thoại  Deployment, Chọn dấu cộng -> Artifact -> Chọn kiểu exploded -> OK
<img src="https://lh3.googleusercontent.com/Iivc4pBHm0kvUezwaFQTxSPt04Thh3n9-NFB9mEkHjGLNhg4djfTpERpe59UjOXaLeSkbjofV7PLm2x9nd6-QRKE3grMWUcxhmKfTRfl4XkMaxNBcReKr7xNoaoE9mDv9w8NgRcJ0HxXrKJKPDMlZ30xuOrsPF_ZfD0wEsZpy_bx8YKMixa5W9_3v0DE72R2ZMBsOXsZkS286BJGtbVDWVufSPVPeaZrUgMpUPlEa3hgB78yXAgL2sbWTbLhYk90cbvW_ex6hkkJNYUyaVT-V4P5muV9BfH4VaHHH7SAAnjwD29KIg2vk1YjHySvRcms0IvbLfQcTpsLkDe1n9rAULZ_hGZzU1NRbePub59h5m5tb7mvsOcdjB_YRiElZOFEUpzPGXpvJeFhmp6OtACF1bHcCg9IK2NU4vL-0e1tqqGp-OoCL6fcRkKH9Q-pS4UL0bLTUBWYzHI88N75UjCF1z3agG5D0HiPTTmN-Vvocr3pliLpJcZdqbM8DdyLCcZcgsEB2TpWOlu2jhQWDp-3PcBWsx2Ypgnj5pn6M2noKz_RU9q6cRL9-ZQqcfwgvLuLXaYmhZFW0Q19E__x1E4emPd4IK4wosH3J_FJ0RA=w1195-h928-no">

<img src="https://lh3.googleusercontent.com/Uf3y5fceGiCCLF8BV4KMKHrERBcECrlGaAmJAtnai3g8q89M0xzgVTMa9Eh6HF89xMy9lLVfm8w9I4H_j0ZhJV4rwI1ByfjFwNal0ELQp76n615u0nKFr_L9SsAmAYSRGepa7O3VJwDxp9_8gJWOjEKelv-P9ASNY9oAlAfDTwX6MJ5Huvhp-osMG92vpCmGTY_tCsOR_t-sT6eF54NqHAdD7OQYxcKPYSGVl4PbEeRumlcr8zjQHmn0LsO4Cg1uqEXzOzOXSAOPH6dKze9MfReAo01E8D0KBwTpQ-31Gf9iiHB2-5cMrSLMJZvI1BS0Ca0o4ValfM01dtg2Wcx4gpwhe6mZ-tOucjlBtK8vFfKidyqg3qJn4crUgzlEIMNpCA_QfJ810wCpHFRoKhFaQZtcWefxLOLq-otKKs-OU0Us11hWCf56MCNq0iZqPfYx8rhZVSaG0isjlm2FCtVQdAe-s2-pa7M0K2-tFbp9YYG20kFlS84XED8-3JImmbqeuPSv6tmPbYQK_YzzzmeCkHTGB5pAVsW7ROZFberGhG8UtwUIrdd9PFMKgufwN850f62cMOyRdZabpZ-DYKTqYUXq7qX7ZzW7plBtxww=w715-h740-no">

8) Sau bước này, tại cửa sổ chính của Intelij, bên phải ô Edit Configuration có hình tam giác  đã được chuyển sang màu xanh, bấm vào nó để chạy thử app

<img src="https://lh3.googleusercontent.com/0oA3Bjw7rFcmlMnLqTZlTlSiO618iKkWqw5tHoF8HqNHu6R_TCWv0Ky2sf17crA5MOBOALA1hMAdokEanwob6K1L-ioOcivXSl4L_5Gfkun5uSEAuQ_pGXjsYBM3wPhbiB9HpyiCgeYEnIz0ywSB14-lD1SlTxrRVR2dzZ9B7R_CiKfy6QSRN6x3dkEQHYmt2mtvKxhtrkKN3CT0qCbpYxfH_aejSjHxCyuiIXCLErh2YxY5-dD6uBJs-RiTRn9jN1TTpxsP8kUY3RbvB3Qmp0ZsO4cUmApM5gCnGDDjWqZicUNcI6jN9Vbks1fPZZEfx07fFxK6J6xMmS9Y5Ix90W-y6QEbetvWuweE4sp5tMN_fgomimcmw3zZZB2nH26sm10iMAwLEnzvSQ7le8ivSojJwnMANHIOT-iAjDIoADr69PHSA3ofUYd2zqA13FPCX2jQPRvEvy-egqLlsgT0pSwU25qwtorHz5hFlNu3axhCjWL1EUqvXhxwPkPURyqYE1SMif0BbD8ZTGnGvDsjs8R-oq2HGSlDo_lN_af3U10JeSrpE7UJg0jTx7W52zmj4-xVxcpq2xlgbfV6flEoW_5MTCl2VRqrqAQgBTc=w1284-h217-no">

9) Đăng ký tài khoản để đăng nhập vào hệ thống.






