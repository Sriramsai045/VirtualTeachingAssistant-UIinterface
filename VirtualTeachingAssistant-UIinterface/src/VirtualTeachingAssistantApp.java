import javax.swing.*;
import java.awt.*;

public class VirtualTeachingAssistantApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainContainer;
    private JPanel loginPanel, dashboardPanel, chatPanel, faqPanel, remainderPanel, profilePanel;

    public VirtualTeachingAssistantApp() {
        setTitle("Virtual Teaching Assistant");
        setSize(1080, 768); // Match Figma design size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        // Screens
        loginPanel = createLoginPanel();
        dashboardPanel = createDashboardPanel();

        mainContainer.add(loginPanel, "LOGIN");
        mainContainer.add(dashboardPanel, "DASHBOARD");

        add(mainContainer);
    }

    // Login Screen
    private JPanel createLoginPanel() {
        JPanel login = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        login.setLayout(null);

        JPanel box = new JPanel();
        box.setLayout(null);
        box.setBackground(new Color(210, 210, 210)); // grey
        box.setBounds(340, 180, 400, 300);
        box.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0, true));
        box.setOpaque(true);

        JLabel title = new JLabel("VIRTUAL TEACHING ASSISTANT", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 16));
        title.setBounds(60, 25, 280, 30);

        JLabel userLbl = new JLabel("User id");
        userLbl.setFont(new Font("Monospaced", Font.BOLD, 16));
        userLbl.setBounds(40, 65, 100, 30);

        JTextField userField = new JTextField();
        userField.setBounds(150, 65, 180, 30);

        JLabel passLbl = new JLabel("Password");
        passLbl.setFont(new Font("Monospaced", Font.BOLD, 16));
        passLbl.setBounds(40, 105, 100, 30);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 105, 180, 30);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Monospaced", Font.BOLD, 24));
        loginBtn.setBounds(120, 190, 160, 40);

        // Login Action
        loginBtn.addActionListener(e -> cardLayout.show(mainContainer, "DASHBOARD"));

        box.add(title);
        box.add(userLbl);
        box.add(userField);
        box.add(passLbl);
        box.add(passField);
        box.add(loginBtn);
        login.add(box);
        return login;
    }

    // Dashboard Screen (left menu + card layout center)
    private JPanel createDashboardPanel() {
        JPanel dash = new JPanel(new BorderLayout());

        // Left panel (menu)
        JPanel menu = new JPanel();
        menu.setBackground(new Color(60, 55, 55));
        menu.setPreferredSize(new Dimension(250, 768));
        menu.setLayout(null);

        JLabel appTitle = new JLabel("<html><div style='text-align:center;'>VIRTUAL<br>TEACHING<br>ASSISTANT</div></html>", SwingConstants.CENTER);
        appTitle.setFont(new Font("Serif", Font.BOLD, 18));
        appTitle.setForeground(Color.WHITE);
        appTitle.setBounds(30, 20, 180, 70);
        menu.add(appTitle);

        JButton chatBtn = new JButton("Chat");
        JButton faqBtn = new JButton("FAQ's");
        JButton remainderBtn = new JButton("Remainders");
        chatBtn.setBounds(30, 130, 180, 45);
        faqBtn.setBounds(30, 200, 180, 45);
        remainderBtn.setBounds(30, 270, 180, 45);

        styleMenuButton(chatBtn);
        styleMenuButton(faqBtn);
        styleMenuButton(remainderBtn);

        menu.add(chatBtn);
        menu.add(faqBtn);
        menu.add(remainderBtn);

        // Profile icon
        JButton profileBtn = new JButton("\uD83D\uDC64"); // Unicode user icon
        profileBtn.setBounds(200, 20, 40, 40);
        profileBtn.setBorderPainted(false);
        profileBtn.setBackground(Color.LIGHT_GRAY);
        menu.add(profileBtn);

        // Center panel (cards)
        JPanel centerCards = new JPanel(new CardLayout());
        chatPanel = createChatPanel();
        faqPanel = createFaqPanel();
        remainderPanel = createRemainderPanel();
        profilePanel = createProfilePanel(centerCards);

        centerCards.add(chatPanel, "CHAT");
        centerCards.add(faqPanel, "FAQS");
        centerCards.add(remainderPanel, "REMAINDERS");
        centerCards.add(profilePanel, "PROFILE");

        // Menu button actions
        chatBtn.addActionListener(e -> ((CardLayout) centerCards.getLayout()).show(centerCards, "CHAT"));
        faqBtn.addActionListener(e -> ((CardLayout) centerCards.getLayout()).show(centerCards, "FAQS"));
        remainderBtn.addActionListener(e -> ((CardLayout) centerCards.getLayout()).show(centerCards, "REMAINDERS"));

        // Profile icon action
        profileBtn.addActionListener(e -> ((CardLayout) centerCards.getLayout()).show(centerCards, "PROFILE"));

        dash.add(menu, BorderLayout.WEST);
        dash.add(centerCards, BorderLayout.CENTER);
        return dash;
    }

    // Styles for menu buttons
    private void styleMenuButton(JButton btn) {
        btn.setBackground(new Color(190,190,190));
        btn.setFont(new Font("Monospaced", Font.BOLD, 18));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    // Chat panel
    private JPanel createChatPanel() {
        JPanel chat = new JPanel(null);
        chat.setBackground(Color.BLACK);

        JPanel chatBox = new JPanel();
        chatBox.setBackground(new Color(105, 104, 104));
        chatBox.setBounds(90, 70, 800, 480);
        chatBox.setLayout(null);

        JTextField chatInput = new JTextField("type here...");
        chatInput.setBounds(90, 565, 640, 40);
        chatInput.setBackground(new Color(60, 59, 59));
        chatInput.setForeground(Color.LIGHT_GRAY);
        chatInput.setFont(new Font("Monospaced", Font.PLAIN, 16));

        JButton askBtn = new JButton("Ask ↑");
        askBtn.setBackground(new Color(210, 210, 210));
        askBtn.setBounds(740, 565, 100, 40);

        chat.add(chatBox);
        chat.add(chatInput);
        chat.add(askBtn);

        return chat;
    }

    // FAQ panel
    private JPanel createFaqPanel() {
        JPanel faq = new JPanel(null);
        faq.setBackground(Color.BLACK);

        JPanel faqBox = new JPanel();
        faqBox.setBackground(new Color(105, 104, 104));
        faqBox.setBounds(90, 70, 800, 580);
        faqBox.setLayout(null);

        JLabel faqTitle = new JLabel("FAQ's", SwingConstants.CENTER);
        faqTitle.setFont(new Font("Monospaced", Font.BOLD, 34));
        faqTitle.setForeground(Color.WHITE);
        faqTitle.setBounds(290, 10, 220, 40);
        faqBox.add(faqTitle);

        // FAQ rectangles (mockup)
        for (int i = 0; i < 3; i++) {
            JPanel block = new JPanel();
            block.setBackground(new Color(190, 190, 190));
            block.setBounds(50, 60 + i*140, 700, 100);
            faqBox.add(block);
        }
        faq.add(faqBox);
        return faq;
    }

    // Remainder panel
    private JPanel createRemainderPanel() {
        JPanel rem = new JPanel(null);
        rem.setBackground(Color.BLACK);

        JPanel remBox = new JPanel();
        remBox.setBackground(new Color(105, 104, 104));
        remBox.setBounds(90, 70, 800, 480);
        remBox.setLayout(null);

        String[] remainders = {"Remainder1", "Remainder2", "Remainder3", "Remainder4", "Remainder5"};
        for (int i = 0; i < remainders.length; i++) {
            JLabel label = new JLabel(remainders[i]);
            label.setFont(new Font("Monospaced", Font.BOLD, 22));
            label.setForeground(Color.WHITE);
            label.setBounds(60, 40 + i*65, 700, 40);
            remBox.add(label);
        }

        JButton addBtn = new JButton("Add ↑");
        addBtn.setBackground(new Color(210, 210, 210));
        addBtn.setBounds(740, 565, 100, 40);

        rem.add(remBox);
        rem.add(addBtn);
        return rem;
    }

    // Profile panel (popup style)
    private JPanel createProfilePanel(JPanel parentCards) {
        JPanel prof = new JPanel(null);
        prof.setBackground(Color.BLACK);

        // Profile popup
        JPanel popup = new JPanel();
        popup.setLayout(null);
        popup.setBackground(new Color(110,110,110));
        popup.setBounds(670,60, 330, 400);
        popup.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));

        JLabel icon = new JLabel("\uD83D\uDC64", SwingConstants.CENTER);
        icon.setFont(new Font("Serif", Font.BOLD, 90));
        icon.setForeground(Color.LIGHT_GRAY);
        icon.setBounds(85,10,150,80);
        popup.add(icon);

        JLabel uname = new JLabel("UserName:", SwingConstants.LEFT);
        JLabel email = new JLabel("Email id:", SwingConstants.LEFT);
        JLabel dob = new JLabel("DOB:", SwingConstants.LEFT);
        uname.setFont(new Font("Monospaced", Font.BOLD, 18));
        email.setFont(new Font("Monospaced", Font.BOLD, 18));
        dob.setFont(new Font("Monospaced", Font.BOLD, 18));
        uname.setForeground(Color.WHITE);
        email.setForeground(Color.WHITE);
        dob.setForeground(Color.WHITE);
        uname.setBounds(25, 100, 280, 40);
        email.setBounds(25, 140, 280, 40);
        dob.setBounds(25, 180, 280, 40);

        popup.add(uname); popup.add(email); popup.add(dob);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBackground(new Color(210, 210, 210));
        logoutBtn.setFont(new Font("Monospaced", Font.BOLD, 20));
        logoutBtn.setBounds(80, 320, 170, 45);
        // Logout action
        logoutBtn.addActionListener(e -> cardLayout.show(mainContainer, "LOGIN"));

        popup.add(logoutBtn);
        prof.add(popup);
        return prof;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VirtualTeachingAssistantApp().setVisible(true);
        });
    }
}