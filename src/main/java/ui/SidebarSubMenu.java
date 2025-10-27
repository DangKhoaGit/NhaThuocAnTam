package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import jiconfont.swing.IconFontSwing;
import jiconfont.icons.font_awesome.FontAwesome;

public class SidebarSubMenu extends JPanel {
    private JButton mainButton;
    private JPanel subMenuPanel;
    private boolean expanded = false;
    private ArrayList<JButton> subItems = new ArrayList<>();
    private boolean isActive = false;

    public SidebarSubMenu(String title, FontAwesome icon) {
        setLayout(new BorderLayout());
        setBackground(new Color(248, 250, 252)); // #f8fafc

        Icon iconObj = IconFontSwing.buildIcon(icon, 20, new Color(51, 51, 51)); // #333
        mainButton = new JButton("   " + title, iconObj);
        mainButton.setFont(new Font("Arial", Font.BOLD, 15));
        mainButton.setHorizontalAlignment(SwingConstants.LEFT);
        mainButton.setFocusPainted(false);
        mainButton.setBackground(new Color(248, 250, 252));
        mainButton.setForeground(new Color(51, 51, 51));
        mainButton.setPreferredSize(new Dimension(250, 50)); // chiều rộng bằng submenu
        mainButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); // để co giãn tốt
        mainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mainButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(229, 231, 235)), // #e5e7eb
                BorderFactory.createEmptyBorder(10, 20, 10, 10)
        ));

        // Hover
        mainButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!expanded) mainButton.setBackground(new Color(241, 245, 249));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!expanded) mainButton.setBackground(new Color(248, 250, 252));
            }
        });

        // Toggle submenu
        mainButton.addActionListener(e -> toggleMenu());
        add(mainButton, BorderLayout.NORTH);

        subMenuPanel = new JPanel();
        subMenuPanel.setLayout(new BoxLayout(subMenuPanel, BoxLayout.Y_AXIS));
        subMenuPanel.setBackground(Color.WHITE);
        subMenuPanel.setVisible(false);
        add(subMenuPanel, BorderLayout.CENTER);
    }

    public void addSubItem(String name, FontAwesome icon, ActionListener listener) {
        Icon iconObj = IconFontSwing.buildIcon(icon, 18, new Color(55, 65, 81)); // #374151
        JButton subBtn = new JButton("   " + name, iconObj);
        subBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        subBtn.setHorizontalAlignment(SwingConstants.LEFT);
        subBtn.setFocusPainted(false);
        subBtn.setBackground(Color.WHITE);
        subBtn.setForeground(new Color(51, 51, 51));
        subBtn.setPreferredSize(new Dimension(250, 45));
        subBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        subBtn.setBorder(BorderFactory.createEmptyBorder(8, 55, 8, 15));
        subBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        subBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isSubItemActive(subBtn)) {
                    subBtn.setBackground(new Color(241, 245, 249));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSubItemActive(subBtn)) {
                    subBtn.setBackground(Color.WHITE);
                }
            }
        });

        // Khi click, active subBtn và gọi listener
        subBtn.addActionListener(e -> {
            setSubItemActive(subBtn);
            if (listener != null) listener.actionPerformed(e);
        });

        subMenuPanel.add(subBtn);
        subItems.add(subBtn);

        subMenuPanel.revalidate();
        subMenuPanel.repaint();
    }

    // Đặt subBtn là active, các subItem khác không active
    private void setSubItemActive(JButton activeBtn) {
        for (JButton btn : subItems) {
            if (btn == activeBtn) {
                btn.setBackground(new Color(217, 234, 249)); // màu active
                btn.setForeground(new Color(0, 102, 204)); // màu chữ active
                btn.setFont(btn.getFont().deriveFont(Font.BOLD));
            } else {
                btn.setBackground(Color.WHITE);
                btn.setForeground(new Color(51, 51, 51));
                btn.setFont(btn.getFont().deriveFont(Font.PLAIN));
            }
        }
    }

    // Kiểm tra subBtn có đang active không
    private boolean isSubItemActive(JButton btn) {
        Color activeBg = new Color(217, 234, 249);
        return btn.getBackground().equals(activeBg);
    }

    private void toggleMenu() {
        expanded = !expanded;
        mainButton.setBackground(expanded ? new Color(224, 231, 255) : new Color(248, 250, 252));
        mainButton.setForeground(expanded ? new Color(37, 99, 235) : new Color(51, 51, 51));
        mainButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, expanded ? 3 : 0, new Color(37, 99, 235)),
                BorderFactory.createEmptyBorder(10, 20, 10, 10)
        ));

        subMenuPanel.setVisible(expanded);
        revalidate();
        repaint();
    }

    public void setActive(boolean active) {
        this.isActive = active;
        if (active) {
            mainButton.setBackground(new Color(217, 234, 249));
            mainButton.setForeground(new Color(0, 102, 204));
            mainButton.setFont(mainButton.getFont().deriveFont(Font.BOLD));
        } else {
            mainButton.setBackground(new Color(248, 250, 252));
            mainButton.setForeground(new Color(51, 51, 51));
            mainButton.setFont(mainButton.getFont().deriveFont(Font.BOLD));
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public JButton getMainButton() {
        return mainButton;
    }
}
