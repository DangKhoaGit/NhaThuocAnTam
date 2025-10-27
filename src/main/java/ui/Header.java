/*
 * @ (#) Header.java   1.0 10/27/2025
 *
 * Copyright (c) 2025 IUH. All rights reserved.
 */

package ui;

/*
 * @description
 * @author: Duong Nguyen
 * @date: 10/27/2025
 * version: 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jiconfont.swing.IconFontSwing;
import jiconfont.icons.font_awesome.FontAwesome;

public class Header extends JPanel {
    public Header() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(1200, 70));
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Logo placeholder
        ImageIcon icon = new ImageIcon("image/logo.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(65, 55, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel logo = new JLabel(scaledIcon);
        logo.setPreferredSize(new Dimension(65, 55));

        this.add(logo, BorderLayout.WEST);

        // Title
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("NHÀ THUỐC AN TÂM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(30, 58, 138)); // #1e3a8a
        JLabel subtitleLabel = new JLabel("Hệ Thống Quản Lý");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitleLabel.setForeground(new Color(30, 58, 138));
        titlePanel.add(titleLabel);
        titlePanel.add(subtitleLabel);
        this.add(titlePanel, BorderLayout.CENTER);

        // User info and logout button
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        userPanel.setBackground(new Color(241, 245, 249)); // #f1f5f9
        userPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        Icon userIcon = IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE, 30, new Color(55, 65, 81)); // #374151

        JLabel userLabel = new JLabel("  Admin", userIcon, JLabel.LEFT);
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userLabel.setForeground(new Color(55, 65, 81));
        userLabel.setHorizontalAlignment(SwingConstants.LEFT);
        userLabel.setIconTextGap(10);

        userLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        userLabel.setForeground(new Color(55, 65, 81)); // #374151
        userPanel.add(userLabel);

        JButton logoutButton = new JButton("Đăng xuất");
        logoutButton.setBackground(new Color(220, 38, 38)); // #dc2626
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setPreferredSize(new Dimension(100, 30));
        logoutButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 38, 38), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        logoutButton.setFocusPainted(false);
        logoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                logoutButton.setBackground(Color.WHITE);
                logoutButton.setForeground(new Color(220, 38, 38));
                logoutButton.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(220, 38, 38), 1),
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoutButton.setBackground(new Color(220, 38, 38));
                logoutButton.setForeground(Color.WHITE);
            }
        });
        userPanel.add(logoutButton);

        this.add(userPanel, BorderLayout.EAST);
    }
}