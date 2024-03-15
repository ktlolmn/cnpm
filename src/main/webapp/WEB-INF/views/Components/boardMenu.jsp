<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<style>
    main {
        menu {
            max-width: 30%;
            height: 100%;
            background: var(--bg-color);
            display: flex;
            flex-direction: column;
            border: .2rem solid var(--main-box-color);
            border-radius: 2rem;
            box-shadow: 1px 1px 2px black;
            padding: 1.5rem;
            overflow: hidden;

            li {
                display: flex;
                margin: .5rem;
                border: .5rem solid var(--content-box-color);
                border-radius: 2rem;
                justify-content: center;
            }

            a {
                margin: 1.5rem;
                font-weight: 500;
                color: var(--text-color);
                text-align: center;
            }

            li.menu-home {
                border: none;
            }

            li.menu-home a {
                font-weight: 700;
            }

            li.menu-admin {
                background: var(--admin-menu-color);
            }

            li.menu-manager {
                background: var(--manager-menu-color);
            }

            li.menu-regular {
                background: var(--regular-menu-color);
            }
        }
    }

    @media only screen and (width <=992px) {

        /* Small devices (portrait tablets and large phones, 600px and up) */
        main menu li a {
            font-size: 2rem;
        }
    }

    @media only screen and (992px < width) {

        /* Medium devices (landscape tablets, 992px and up) */
        main menu li a {
            font-size: 3rem;
        }
</style>
<menu class="board-menu">
    <li class="menu-home">
        <a class="" href="../GioiThieu/index.html" target="board-content">
            Về ứng dụng
        </a>
    </li>
    <li class="menu-manager">
        <a class="" href="../DsMuonPhongHoc/index.html?UC=DsMPH&Display=DsMPH&UIDManager=${UIDManager}"
            target="board-content">
            Danh sách mượn phòng học
        </a>
    </li>
    <li class="menu-manager">
        <a class="" href="../DsGiangVien/index.html?UC=DsGV&Display=DsGV&UIDManager=${UIDManager}"
            target="board-content">
            Danh sách giảng viên
        </a>
    </li>
    <li class="menu-manager">
        <a class="" href="../DsLopHoc/index.html?UC=DsLH&Display=DsLH&UIDManager=${UIDManager}"
            target="board-content">
            Danh sách lớp học
        </a>
    </li>
    <li class="menu-regular">
        <a class="" href="../DsMuonPhongHoc/index.html?UC=MPH&Display=YCMPH&UIDRegular=${UIDRegular}"
            target="board-content">
            <span>Mượn phòng học</span>
        </a>
    </li>
    <li class="menu-regular">
        <a class="" href="../DsLopHoc/index.html?UC=DBH&Display=DsLH&UIDRegular=${UIDRegular}"
            target="board-content">
            Đổi buổi học
        </a>
    </li>
    <li class="menu-admin">
        <a class="" href="#" target="board-content">
            <span>Quản lý tài khoản</span>
        </a>
    </li>
    <li class="menu-admin">
        <a class="" href="#" target="board-content">
            <span>Lịch sử hoạt động</span>
        </a>
    </li>
</menu>
