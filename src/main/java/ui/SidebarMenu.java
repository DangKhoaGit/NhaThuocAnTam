package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import ui.Thuoc.TimThuoc;

public class SidebarMenu extends JPanel {
    private GiaoDienChinh parent;
    private ArrayList<SidebarSubMenu> subMenus = new ArrayList<>();

    public SidebarMenu(GiaoDienChinh parent) {
        this.parent = parent;
        setPreferredSize(new Dimension(250, 700));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        IconFontSwing.register(FontAwesome.getIconFont());

        addMenu("Trang chính", FontAwesome.HOME, e -> parent.setContent(new TimThuoc()));

        SidebarSubMenu hoaDonMenu = new SidebarSubMenu("Hoá đơn", FontAwesome.FILE);
        hoaDonMenu.addSubItem("Tìm hoá đơn", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        hoaDonMenu.addSubItem("Thêm hoá đơn", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        hoaDonMenu.addSubItem("Cập nhật hoá đơn", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        hoaDonMenu.addSubItem("Thống kê doanh thu", FontAwesome.BAR_CHART, e -> parent.setContent(new TimThuoc()));
        add(hoaDonMenu);
        subMenus.add(hoaDonMenu);

        SidebarSubMenu phieuDatMenu = new SidebarSubMenu("Phiếu đặt", FontAwesome.FILE);
        phieuDatMenu.addSubItem("Tìm phiếu đặt", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        phieuDatMenu.addSubItem("Thêm phiếu đặt", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        phieuDatMenu.addSubItem("Cập nhật phiếu đặt", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        add(phieuDatMenu);
        subMenus.add(phieuDatMenu);

        SidebarSubMenu thuocMenu = new SidebarSubMenu("Thuốc", FontAwesome.FILE);
        thuocMenu.addSubItem("Tìm thuốc", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        thuocMenu.addSubItem("Thêm thuốc", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        thuocMenu.addSubItem("Cập thuốc", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        add(thuocMenu);
        subMenus.add(thuocMenu);

        SidebarSubMenu dangDieuCheMenu = new SidebarSubMenu("Dạng điều chế", FontAwesome.FILE);
        dangDieuCheMenu.addSubItem("Tìm dạng điều chế", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        dangDieuCheMenu.addSubItem("Thêm dạng điều chế", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        dangDieuCheMenu.addSubItem("Cập dạng điều chế", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        add(dangDieuCheMenu);
        subMenus.add(dangDieuCheMenu);

        SidebarSubMenu donViTinhMenu = new SidebarSubMenu("Đơn vị tính", FontAwesome.FILE);
        donViTinhMenu.addSubItem("Tìm đơn vị tính", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        donViTinhMenu.addSubItem("Thêm đơn vị tính", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        donViTinhMenu.addSubItem("Cập đơn vị tính", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        add(donViTinhMenu);
        subMenus.add(donViTinhMenu);

        SidebarSubMenu khuyenMaiMenu = new SidebarSubMenu("Khuyến mãi", FontAwesome.FILE);
        khuyenMaiMenu.addSubItem("Tìm khuyến mãi", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        khuyenMaiMenu.addSubItem("Thêm khuyến mãi", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        khuyenMaiMenu.addSubItem("Cập khuyến mãi", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        add(khuyenMaiMenu);
        subMenus.add(khuyenMaiMenu);

        SidebarSubMenu phieuNhapMenu = new SidebarSubMenu("Phiếu nhập", FontAwesome.FILE);
        phieuNhapMenu.addSubItem("Tìm phiếu nhập", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        phieuNhapMenu.addSubItem("Thêm phiếu nhập", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        phieuNhapMenu.addSubItem("Cập phiếu nhập", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        add(phieuNhapMenu);
        subMenus.add(phieuNhapMenu);

        SidebarSubMenu khachHangMenu = new SidebarSubMenu("Khách hàng", FontAwesome.FILE);
        khachHangMenu.addSubItem("Tìm khách hàng", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        khachHangMenu.addSubItem("Thêm khách hàng", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        khachHangMenu.addSubItem("Cập khách hàng", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        add(khachHangMenu);
        subMenus.add(khachHangMenu);

        SidebarSubMenu nhanVienMenu = new SidebarSubMenu("Nhân viên", FontAwesome.FILE);
        nhanVienMenu.addSubItem("Tìm nhân viên", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        nhanVienMenu.addSubItem("Thêm nhân viên", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        nhanVienMenu.addSubItem("Cập nhân viên", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        add(nhanVienMenu);
        subMenus.add(nhanVienMenu);

        SidebarSubMenu caiDatMenu = new SidebarSubMenu("Cài đặt", FontAwesome.FILE);
        caiDatMenu.addSubItem("Cài đặt tài khoản", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        add(caiDatMenu);
        subMenus.add(caiDatMenu);
    }

    private void addMenu(String name, FontAwesome icon, ActionListener listener) {
        // Panel chứa toàn bộ nút chính
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        // Icon
        Icon iconObj = IconFontSwing.buildIcon(icon, 24, new Color(51, 51, 51));

        // Nút chính
        JButton btn = new JButton(name, iconObj);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(250, 50));
        btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 10));
        btn.addActionListener(listener);

        // Hiệu ứng hover
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(241, 245, 249));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.WHITE);
            }
        });

        // Thêm nút vào panel
        menuPanel.add(btn, BorderLayout.CENTER);

        // Add vào sidebar
        add(menuPanel);
    }

}
