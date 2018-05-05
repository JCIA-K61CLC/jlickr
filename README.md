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

<img src="https://lh3.googleusercontent.com/bLaAqx4DlrGG1OLU_49N5ELEt3E0sUmsOU_p-tcuaf26eBjWFCOkP9a-U5zQu8YMjNMwTF--sbIq_s7YK4d1PGguMVjfMclfBSlIUHvOsyDB_SwxYgh-aFK_qS7wVuUDHMzvjqCcKD5C3mcBTWop74hooXFfj7xPv3zQJf_E9LDJbpIyRgLQudV3LPBe5-YzD9mmhFHXVoC2GE_dR8g265XmK8lFv9dbCw3ml4Z9oR9uDpctYQHVhdNGUOthaRHWJoIKkhf7FX0gakRaeqGlHHoEW3_tsI6LhOXuHkHqsGLFcYPdLjmg3AjeCiocSoKzq8UngzobC7_dj8hxJGpz7Fj8isWmbTGm4SC4Oih8Er7FB1ogjny4x-xTZuGPAbLhJwK4LMGCLgn6aZcmFjhhU_XwDzjvoh6aCDGwsbg7KQptRlFl-c4sPP99t5yad5xRje2RQ3x-jBNZkE_L1NoRHltmEso3wf-kwUu3niuM2TrsUQwLscuv6pZCd2hClMXhFmiND4f7klSOohFIGw0XdXHT0CeftpG9MWx4Tudd8Zy2I7cqBuCy_ue2ZI0dmm21lRR66n5OL0OtpbFpPxc4BEmDZarTUCnpk4ba7V-OGOlsEX1BMN24taq_JIpzJQJ5-Q6rF-8NLOeqYD-UzE32mr3CrCeeyQKW=w1058-h400-no">

----

# Các bước thực hiện

1) Trong Intellij, mở project bằng cách File -> Open -> Thư mục mã nguồn vừa tải về
Trong cấu trúc thư mục, chú ý đến file src/main/resoures/app.properties.sample. Trong file là một số
thông số máy tính của bạn liên quan đến cấu hình máy :

<img src="https://lh3.googleusercontent.com/TVis8hOB4PImiJaIcYllWEe1G-DrFA0NpaRyYSRJJx142VZnvLqpZwxwFONIJNHMZetuOkMfhV1-PEIak7QELFnP0xK6k1YJYAJv5Dt3kXQjZNcPr3niSBRlQzVRWqschOxmQO3_Qhs0r72o-oRvi3m3MQiDeDM73fMDWmxR-vPwl04X6mYjUc42rCf4GkCTOy1EPeIP7JUFTMOGAtRL-kf7tQXywwxBIJoDIYV0IJLRACbsaYaQGGE_jtrmcDn_SrPsMn57R4zgtyhs0u7_mZyxe1eKUParwjJVS-AAOg7_EVTyT4_mYI7f_lrF_P-fkX3ZvKsYTg5DjwrCi_3W3C689F4TZ8_1qkQk1BgmGoPnhCPOx1s2YV862rptk6pT52jVBdp3AhCxXeCoBmdk0jePLtya-jyUwIkZTMH0KmJ8zQfwhNmFqu_Cze_ORcutTaZ7G4onO6Ws53NpCyDmnmMUvckcIjgPiOfniyu8Qliw3ed3CE_JGFd6HuA0n8_rR--djo6gfO04CJ8PoJbjpPQ_Y9n6gl-0cTbnJ8kb3zTIo-Ra9g2rtHiXXqmegMtq4dhH_CqGC_cwSWSibjf735bzeJd6X8LdmUAncFB65QxdTR0U-cicvDPRgVO5o4ypNilabiZE1CX-OPoxjNWjaQtk40_CdQQJ=w1908-h604-no">


2) Để app có thể lấy được các thông số này, tạo một file mới có tên là “app.properties” bằng cách nháy chuột phải vào thư mục resoures->New->File. Nhập chính xác tên file là app.properties. Một file trống được hiện ra, lần lượt điền các thông số của máy tính vào sau dấu “=”, không cần cho trong ngoặc kép “”.

    - db.user: username tài khoản quản trị cơ sở dữ liệu.
    - db.password: password tải khoản quản trị cơ sở dữ liệu.
    - db.url: đường dẫn liên kết tới database. Tài liệu hướng dẫn này sử dụng Hệ quản trị cơ sở dữ liệu mysql và chạy trên localhost, database lưu trữ thông tin tài khoản của người dùng là "data", nên có thể điền mặc định là  “db.url=jdbc:mysql://localhost:3306/data”.
    - webappURL: đường dẫn tới thư mục webapp của project. Tại folder của project->src->main->webapp, copy đường dẫn trên thanh địa chỉ, đây chính là webappURL. (Chú ý, webappURL tùy từng máy mà có thể khác khau, không nhất thiết là giống hệt như ví dụ minh họa).
    
<img src="https://lh3.googleusercontent.com/uj8iSu3QnXp_gEs4E_HBzLSvxDN2FDB5d8biuUeN2J72_ywaf7xj1NbKwaVnVPGslSARKHwvdXO3TT7GySpZsKEjVheIaNzewnfwzobVBAy0FfJxkkbr4uDGwjH9m-6-G6maClvpU-rq7A66xiTg9NEd5QehX2Ht2pFwv-Vp88RLXHoe1RQi1shBkxrMPl4cSnAvA06z5V2Th1d4-Lv7rdG5zDC8OoW8T_aUIaLcRKy-j4yMdXBjOIixlw0aJBB-GrbIkK0hUIHNbYhtxaYrVAv8D99tOUdeguOMUwM4VBuO8em8THxoQECmguac2xIIq_8O5soEaL-MAKLFA13ecemiPuSz4La5ABnvHkS7Q3ystf49vtG82gq0tnDanS2-JFj7ODNNx64JYjO2G8Vlz2W_El9G-ZPxhH9fTuR7ZpG7veg9w8FdZcqJ2eR_0zOxU34Zf7lWN5iGsUmib5mNiOVRqRYVrMedU3UjvQVh7bdE5j6QGaXcn5Db4UK2OB6Gs7r113GTIEFh_HxAKjxT3DyBcwJk494_Qckx5RrrINvOYqySXgyHZns7gy5T9keqCUCCstxJJm4lOoM5l1XDBGTGJAlf_LWfT5zeSyM=w1606-h498-no">


3) Tạo database để chạy thử chương trình  bằng cách thực thi file "db/{schema,datadample}.sql". CÓ thể chạy bằng Command Prompt hoặc công cụ quản lý dữ liệu như Workbench, SQL Workshop,... Cách nhanh và đơn giản nhất là copy toàn bộ các dòng code trong 2 file "schema.sql" và "datasample.sql" và chạy nó trong command prompt. (Chú ý: các dòng code trong file "schema.sql" phải được thực thi trước "datasample.sql"). Việc khởi tạo database này chỉ cần thiết khi lần đầu tiên chạy thử app này.

<img src="https://lh3.googleusercontent.com/btARzpBZcCf9D_f2vrUn_VHhZLyFIPs6M7fYSZGG7S3zAAGkvQbZvXSG-K9EFmfvvuMJa25XpQ1AGTy5B3Tj7GPIeffry4RLPh0WxZ6ELGs53vN_z0uAqvbzqSQQCWLk91lOmaQfzEz32v53xYZ2Yl32AFp2vYqAklv8pPspUEKc--yfB7NuiMqFlxX8A1Tj555BnBSe-ccJD3436od0gnFK71WMn57PY3zCScykggXxOBzs3vn0qIOd4WeHkTEY9QK_Clrn8PU3tfTDcU7PT3vI2riHP1vaIbtqHPk3y7uWLvYLX6r9nrI1i26766JtIje46pa9KBLhtVZP8vyUsZwrBpnJXP7w_I8qBBqs8UvV6CYIhwX3XbXP_XXekZmAAdpVyV1CcoZKxoEzB44x_OSwJj2fLcqZRR7u5ybvPZ_pf1KxH3lywIsuL90ffLbEKc3ocG6GHempS_rSLm4XD30QEhoaClfSc4wi1X0fbHbit9aSL7dPZ9TxPgsuS4ZuVFudox-NYzetPdkfY0EQX7qiZNmJJBqZsu17MPHGVD_RStBshdvSRAhh0ThW4HQuK2NoQi6EAhC5IZJOTPkMqG7iMRIHuH-k3iR_3Gc=w1672-h651-no">

4) Gán quyền truy cập database cho tài khoản quản trị MySQL Server. Việc này không cần thực hiện nếu truy cập bằng tài khoản "root".
Để Intellij có thể chạy được project, cần cài đặt cấu hình trong phần  Edit Configuration:

<img src="https://lh3.googleusercontent.com/q2cf5u8gK_pn-qDvV_EqwFjt-6GJu1oNEr73_U8HQNdA6tjO5VyDecqY5QqOvcCjtV69zydeiOBsast-VBO7QE5fEzV0MenaWg7q0wDQgR3-lKMa5Mk32toYjiFhzPhIYZ6wkJIbqBOlP1PgfvH8IDmr9ToKQlCyGSAjLwdHaoPmuXW2sTtDI0fW7Ts675XnRSV1OSPJyYxepaLT9S0WykkghFT08xCCBJunjZZdokOfjSfnJdf4eFQp0TvWSd2U-ACUqeiaZvfJfl_msHOSri8i855h6W3xGCXxo8HitYljBZigh8Ov5NctqP3Pu1DbqVd6sqqBwMf_qBNEj3uPnCxsaPRDWVgG2ZGykAsSumMM0SnBYvihprWou4wE8xb7Iph4p67dKRA9OnNMQUnX6So0NdE_Se7Fci703SRycrqgHC9JNw9ivsqr3TtkKQiTvnsXXn70IH2sO2ok-CC9E7npUecr9zC8ldg2h73WRLCZWXieaAHeBq9-Ox5dQK4RL7Wphn61it4a5G2Dvwnd6v8R8PJ505WNJDXEvqObvygIik43O_hEmd37kVIuNbvwiEH1aYlF58sC1qy2sxuBH_kMIBSe6oc0aLNAzWo=w1916-h428-no">

5) Trong cửa sổ Run/Debug Configuaration->+->Tomcat Server->Local

<img src="https://lh3.googleusercontent.com/RSZdnhiV28rV9hMnrxnNLLXzB5sIi32qT-rcs6D5kMixEh7L7dLWiJSUwjspU6inRyepTH5SafeirzOyf2WxCr5QfH9t3hYG2MeGs4Qdkm_qVmcrHrmK5dhoXhZOYTSQiZ3r3o34UdpX0oXBvG079-kWUycUkzfErMgkzotI4zvNsDjsfBy9ZHP_nAV86-m45Gnzt3zIyuFGwKmDGDE-y_4etUgb3XZ3x8rEHzxLTrJqde-M_DqvumX_TWa4-NVp2CSnesneL1MYvexaMFjGPnnY2nuIJeoJY8hPGbmB9gIUvewB28j9p6QZVF-aAR1o7rUMBlFoUPJzkvDEXQ6pFqQgCe8ycq9-N77BJM_5EW2Sb90zB5zVxWZrxKl1geWFGHSYKOqEXZ5UI-uHAaJ1Gj-iE73Ai-r_-5B8b51K8-o74pOLKJ068rjBgTAfGUeiDYft9fwBHLbS7ET5FZxFJYJT-IUexd6MNF_iuKxQTkYd_OWdmj9_JyPPgapPD6AFqskZzWZksIj1635di-g54Sbz79RQ0yK7ol8KrjkmH6SQWRqWwt5X9XeoHc_t47cPTcny-YLLa3vDZ4RKbNh5SYBmT6lMwTzdG8evDgU=w1509-h936-no">

6) Trong hộp thoại Server, phần  Application server, chọn phiên bản Tomcat Server vừa tải về.
<img src="https://lh3.googleusercontent.com/EIPKq7JSkJ5NLC_sJMSToXg5rfSGj_jvAqmRTfWzR6EMgWDPbdA-elbuVDu1VBeBHz83rZivMwyoQPQqzdrq43tfZguJuI9a__GAEdHs2PUvVDJveiG4RpqUMLKqmf122s4ahjfSkQUxKr58GdU07Q1zO0FB85Pz2kS1iBxf8D_xhmrAkWJ7wOCTI2ywMup6aUFyKxgG2FAIEKbedia88zKHlOt7c0_b1Y59t4JGgMj0Nw3aUV7JWqrdh8JuzJGIXxu6hEqd3XAMP5qRFZW2a9BFc8Y-oq3qV49U_1Kq7LQWyBFBzTUUfbr0VDIuuD8uh8D6f4ec_9WM6IOlYZNVm4ZsT-W4Y70Vxe7ZrkaJG5rYigKXFuKxorbnq7QADhDAOgbkUEx3PV-QY08G-Xr2wW5OUEXhQmc-FMC8kn8U8ygMASsqcrtkc4Tvl-LwakzcvnBuj7fyhaRrfWjAvVC-JAW1hxxqVswUckDtCwkOkJF3EOEb675SJIzknSfwvHNqbZmzdkziZDCgiPf0djSU4kLxj-A_3shA54xJrSByIos4bkKzBHhdCojgV7Wi0Nfmff1zC7sCxFR8bhpYD3kGbog8IFrpdhR8sGBk_p7hMIV3xFvUzGGlJl3midzgM_eh73A0U9LpYctRIWRJTBe9-9sD3BYOcaYX=w1095-h936-no">

7) Trong hộp thoại  Deployment, Chọn dấu cộng -> Artifact -> Chọn kiểu exploded -> OK
<img src="https://lh3.googleusercontent.com/DvElGKTZp7uj9kW3Bkk-oXRQx4753DaNxs1JqV6ZdnvJt57gMpgYKZPrrsA1lHthr_TSnwUgCL3mS6B4-oJHQ3QEWn82P6xjI_1VBAWZ_aTGdhU_1D2HW2AqkhpSayv7xTV3CoPDIVbSlMdgtgnMVFfcQjsm5LGPwJr_7WyHjK_Rgi77YQjrw1zqCTIFgxOn6SQy-yQyHokFYMRTWdwRfhksiPnlwlCTC91ixyuOWIhGf30_n5gOj-tvlnQHSEHB_en1mZQzFgUNC3YqrpcLUGt3CAMcFPGamS5dEyMnBrlPI7XrXcvRpoiecI_rhNmEJzpzIupzkrCglR6sPPNR_CKa4wv-zbM6zeUivR_InHUhdu0oAw_Yd5EoHL2Q1IOkBIKNPXuqRM4c2RBrLFWCcfzVWX5ycSyjIIU8xEmgtAR9c1LeCuPwO_kKmKK14pfuIqkb3VSnj0CCsJDnY8vVm7WMY-zfEdYOfGGVZjW4y2yD1Z8-0RY9gnKab_O6R4mSpp6rb2bJkN8zfyYut4WXky7RZmGlqd9CEJM_7L1r3fu4RUeIEQOWZlstR8Sta6HQ--J7nWvslOsxk1U-Kujw-mBCboedcgtroclT-Ho=w1195-h928-no">

<img src="https://lh3.googleusercontent.com/IE7KrT0u5jL_duf0uwK0H-vhIVOkT7wc7yvsJTNOrKwgvCgfSAEoycDthB_Ad3fFKeqhPM5nlvU1TlIA2reowt2R_18TPo9reajiZG4ZI0Kee7BiE2ec5iv73mV_x4t2sCxgE5MaI26KEVuDGcUjNGYWz1VjkbRT2Vqa6kbQEQKpdvtdXCSEFsd_7um9A0HGnCWk-VYI2NSN8q-c8iaQdsmBXfskfK9V-VDNQ5zHiZm1L5BQkBVk5EnF6BRzBV5w9kFMnl-jod8KJkaGrpgasKWqqeCe9pQMwT5VYVio2Z0yuPP6dzF04slSsqJ-TVaFPgCKGEuIenlsCzlvAljuaaRl4GfmCUffs-qBSuVpFBXNdwXqlaJ62crsctLdsFJG2Hv81XnXrDFmW5Ds0YKQ0ybfXiEVFBLvH009oifkTgkXdV4xNi0obLaPpypR8R86jIWmVcGpy0pTyl8rXqTbR2Tv0hgEoYDi_dVGdcByrYzl2bi09RRmbw-J_zMwuCjxdwypg0r9knEUHG7-RESE-wzoEqRMOi-LTszWT3CqOS43t3_MhvZACJJIB6ll9WN3W64dCN3MjJxZ5beyWHBdqXDF4YiRmnsT3jKFBvM=w715-h740-no">

8) Sau bước này, tại cửa sổ chính của Intelij, bên phải ô Edit Configuration có hình tam giác  đã được chuyển sang màu xanh, bấm vào nó để chạy thử app

<img src="https://lh3.googleusercontent.com/zgz408vyzPKZ-qz6KQqgrgdM6ZSY7MU1icejv9PRsxqDAjmPmRGWlkPl5T722XAN8cbcu4sDx8aza3mdJrahZirNr66ZH6tfdXawCntuAvUhm_ieoDEyDuu9MVhHz1gadYWlESn256yU_S2gcNsRX2boDVU2Ph4_rqr-uirxpZO9GFTYV3kLNI7H6RSUpR9roSFsbJSbG8ApBWJoL_PZGJ2XX0eCB8uvuPoM_uKy3JDIlC3hwzNmRLdV1VYUVoJMKOwoUFkh8m6lc83aUe7dhx9E-KXPN8OJcs45OvZ1brkhCRC_d1L7sBM53vudtrSZAZR3-O3qlR_AKC8K0n4LdDSnVwQBI7a_jv6kJyZxwQHiRjO6SwdNwfr8gPyzluXiKr1CC7GbQCna6w9AOSXH0W0FQqBjskvRTg7R6pM5_8ODHLIhR7J3aBe0vGRXhoBSFeg5Z0GoDmUrQI5291owZNsADNNpEglXNVg0bHijsED0wY6AVq4eekDUyA0y7WfjLtgO0-FDK245WK9h88VmgldY10P-kJfKzvhD0DsiNlRxfhDfS8JXRaaLEsLWYDTrboJi8B6FhLwdmSxPv6B8Jtzgz8WTgtuI2PLPZ4Fsf6VPo1EoRdN8rno8I-WByxeezy8hO_ImS50_MEB6Ci1CBoeZPNlrHelN=w1284-h217-no">

9) Đăng ký tài khoản để đăng nhập vào hệ thống.






