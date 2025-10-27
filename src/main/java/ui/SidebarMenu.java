package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import ui.HoaDon.TimHoaDon;
import ui.PhieuNhap.TimPhieuNhap;
import ui.Thuoc.TimThuoc;

public class SidebarMenu extends JPanel {
    private GiaoDienChinh parent;
    private ArrayList<SidebarSubMenu> subMenus = new ArrayList<>();
    private ArrayList<JButton> mainMenuButtons = new ArrayList<>(); // Lưu các nút menu chính
    private JButton activeMainMenuButton = null;
    private SidebarSubMenu activeSidebarSubMenu = null;

    public SidebarMenu(GiaoDienChinh parent) {
        this.parent = parent;
        setPreferredSize(new Dimension(250, 700));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        IconFontSwing.register(FontAwesome.getIconFont());

        addMenu("Trang chính", FontAwesome.HOME, e -> parent.setContent(new TimThuoc()));
        // Đặt mặc định active cho menu đầu tiên (Trang chính)
        if (!mainMenuButtons.isEmpty()) {
            setActiveMainMenuButton(mainMenuButtons.get(0));
        }

        SidebarSubMenu hoaDonMenu = new SidebarSubMenu("Hoá đơn", FontAwesome.FILE);
        hoaDonMenu.addSubItem("Tìm hoá đơn", FontAwesome.SEARCH, e -> parent.setContent(new TimHoaDon()));
        hoaDonMenu.addSubItem("Thêm hoá đơn", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        hoaDonMenu.addSubItem("Cập nhật hoá đơn", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        hoaDonMenu.addSubItem("Thống kê doanh thu", FontAwesome.BAR_CHART, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(hoaDonMenu);

        SidebarSubMenu phieuDatMenu = new SidebarSubMenu("Phiếu đặt", FontAwesome.FILE);
        phieuDatMenu.addSubItem("Tìm phiếu đặt", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        phieuDatMenu.addSubItem("Thêm phiếu đặt", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        phieuDatMenu.addSubItem("Cập nhật phiếu đặt", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(phieuDatMenu);

        SidebarSubMenu thuocMenu = new SidebarSubMenu("Thuốc", FontAwesome.FILE);
        thuocMenu.addSubItem("Tìm thuốc", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        thuocMenu.addSubItem("Thêm thuốc", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        thuocMenu.addSubItem("Cập thuốc", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(thuocMenu);

        SidebarSubMenu dangDieuCheMenu = new SidebarSubMenu("Dạng điều chế", FontAwesome.FILE);
        dangDieuCheMenu.addSubItem("Tìm dạng điều chế", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        dangDieuCheMenu.addSubItem("Thêm dạng điều chế", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        dangDieuCheMenu.addSubItem("Cập dạng điều chế", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(dangDieuCheMenu);

        SidebarSubMenu donViTinhMenu = new SidebarSubMenu("Đơn vị tính", FontAwesome.FILE);
        donViTinhMenu.addSubItem("Tìm đơn vị tính", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        donViTinhMenu.addSubItem("Thêm đơn vị tính", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        donViTinhMenu.addSubItem("Cập đơn vị tính", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(donViTinhMenu);

        SidebarSubMenu khuyenMaiMenu = new SidebarSubMenu("Khuyến mãi", FontAwesome.FILE);
        khuyenMaiMenu.addSubItem("Tìm khuyến mãi", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        khuyenMaiMenu.addSubItem("Thêm khuyến mãi", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        khuyenMaiMenu.addSubItem("Cập khuyến mãi", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(khuyenMaiMenu);

        SidebarSubMenu phieuNhapMenu = new SidebarSubMenu("Phiếu nhập", FontAwesome.FILE);
        phieuNhapMenu.addSubItem("Tìm phiếu nhập", FontAwesome.SEARCH, e -> parent.setContent(new TimPhieuNhap()));
        phieuNhapMenu.addSubItem("Thêm phiếu nhập", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        phieuNhapMenu.addSubItem("Cập phiếu nhập", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(phieuNhapMenu);

        SidebarSubMenu khachHangMenu = new SidebarSubMenu("Khách hàng", FontAwesome.FILE);
        khachHangMenu.addSubItem("Tìm khách hàng", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        khachHangMenu.addSubItem("Thêm khách hàng", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        khachHangMenu.addSubItem("Cập khách hàng", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(khachHangMenu);

        SidebarSubMenu nhanVienMenu = new SidebarSubMenu("Nhân viên", FontAwesome.FILE);
        nhanVienMenu.addSubItem("Tìm nhân viên", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        nhanVienMenu.addSubItem("Thêm nhân viên", FontAwesome.PLUS, e -> parent.setContent(new TimThuoc()));
        nhanVienMenu.addSubItem("Cập nhân viên", FontAwesome.REFRESH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(nhanVienMenu);

        SidebarSubMenu caiDatMenu = new SidebarSubMenu("Cài đặt", FontAwesome.FILE);
        caiDatMenu.addSubItem("Cài đặt tài khoản", FontAwesome.SEARCH, e -> parent.setContent(new TimThuoc()));
        addSidebarSubMenu(caiDatMenu);
    }

    private void addMenu(String name, FontAwesome icon, ActionListener listener) {
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        Icon iconObj = IconFontSwing.buildIcon(icon, 24, new Color(51, 51, 51));
        JButton btn = new JButton(name, iconObj);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setBackground(Color.WHITE);
        btn.setPreferredSize(new Dimension(250, 50));
        btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 10));
        mainMenuButtons.add(btn);
        btn.addActionListener(e -> {
            setActiveMainMenuButton(btn);
            // Bỏ active tất cả SidebarSubMenu
            for (SidebarSubMenu sm : subMenus) {
                sm.setActive(false);
            }
            activeSidebarSubMenu = null;
            if (listener != null) listener.actionPerformed(e);
        });
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn != activeMainMenuButton) btn.setBackground(new Color(241, 245, 249));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (btn != activeMainMenuButton) btn.setBackground(Color.WHITE);
            }
        });
        menuPanel.add(btn, BorderLayout.CENTER);
        add(menuPanel);
    }

    // Đặt trạng thái active cho menu chính
    private void setActiveMainMenuButton(JButton btn) {
        for (JButton b : mainMenuButtons) {
            if (b == btn) {
                b.setBackground(new Color(217, 234, 249)); // màu active
                b.setForeground(new Color(0, 102, 204));
                b.setFont(b.getFont().deriveFont(Font.BOLD));
                activeMainMenuButton = b;
            } else {
                b.setBackground(Color.WHITE);
                b.setForeground(new Color(51, 51, 51));
                b.setFont(b.getFont().deriveFont(Font.BOLD));
            }
        }
    }

    private void addSidebarSubMenu(SidebarSubMenu subMenu) {
        add(subMenu);
        subMenus.add(subMenu);
        // Thêm sự kiện cho mainButton của SidebarSubMenu
        subMenu.getMainButton().addActionListener(e -> {
            // Bỏ active tất cả mainMenuButton
            for (JButton b : mainMenuButtons) {
                b.setBackground(Color.WHITE);
                b.setForeground(new Color(51, 51, 51));
                b.setFont(b.getFont().deriveFont(Font.BOLD));
            }
            // Bỏ active các SidebarSubMenu khác
            for (SidebarSubMenu sm : subMenus) {
                if (sm != subMenu) sm.setActive(false);
            }
            subMenu.setActive(true);
            activeSidebarSubMenu = subMenu;
        });
    }

}
