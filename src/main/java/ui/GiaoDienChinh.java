package ui;/*
 * @description
 * @author: Pham Dang Khoa
 * @date: 27/10/2025
 * @version: 1.0
 */

import javax.swing.*;
import java.awt.*;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class GiaoDienChinh extends JFrame {
    private SidebarMenu sidebar;
    private JPanel contentPanel;
    private Header header;

    public GiaoDienChinh() {
        IconFontSwing.register(FontAwesome.getIconFont()); // Register FontAwesome

        setTitle("Quản lý Hiệu thuốc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        header = new Header();
        add(header, BorderLayout.NORTH);

        sidebar = new SidebarMenu(this);
        add(sidebar, BorderLayout.WEST);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
    }

    public void setContent(JPanel newContent) {
        contentPanel.removeAll();
        contentPanel.add(newContent, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GiaoDienChinh().setVisible(true));
    }
}
