package mox_form;

import db.database;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class UserDashboard extends javax.swing.JFrame {

    public UserDashboard(String username) {
        initComponents();
        setTitle("MOXFI.ID");
        setExtendedState(MAXIMIZED_BOTH);
        load_latest_movie();
        load_top_movies();
        load_coming_soon_movie();
        tf_username.setText(username);
    }
    
    public ImageIcon getPoster(String url) {
        ImageIcon resizedImg = null;
        try {
            URL imgUrl = new URL(url);
            ImageIcon icon = new ImageIcon(imgUrl);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(200, 283, java.awt.Image.SCALE_SMOOTH);
            resizedImg = new ImageIcon(newImg);
        } catch (MalformedURLException e) {
        }
        
        return resizedImg;
    }
    
    public void getDetailMovie(String title) {
        String username = tf_username.getText();
        new DetailMovie(title, username).setVisible(true);
        this.setVisible(false);
    }
    
    public void load_latest_movie() {
        try {
            String sql = "SELECT movie.title, movie.poster "
                       + "FROM movie "
                       + "INNER JOIN movie_status "
                       + "ON movie.status = movie_status.id_movie_status "
                       + "WHERE movie_status.status = 'Aired' "
                       + "ORDER BY date DESC";
            Connection conn = (Connection) database.getConn();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            ArrayList<String> posters = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            
            while(res.next()) {
                posters.add(res.getString("poster"));
                titles.add(res.getString("title"));
            }
            
            // Poster Latest Movie
            
            String[] posterArr = new String[posters.size()];
            posterArr = posters.toArray(posterArr);
            JLabel[] latestPoster = {poster1, poster2, poster3, poster4, poster5};
            
            for(int i = 0; i < 5; i++) {
                latestPoster[i].setIcon(getPoster(posterArr[i]));
            }
            
            // Title Latest Movie
            
            String[] titleArr = new String[titles.size()];
            titleArr = titles.toArray(titleArr);
            JLabel[] latestTitle = {lt_title1, lt_title2, lt_title3, lt_title4, lt_title5};
            
            for(int i = 0; i < 5; i++) {
                latestTitle[i].setText(titleArr[i]);
            }
            
        } catch (SQLException e) {
        }
    }
    
    public void load_top_movies() {
        try {
            String sql = "SELECT * FROM movie ORDER BY rating DESC";
            Connection conn = (Connection) database.getConn();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            ArrayList<String> posters = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            
            while(res.next()) {
                posters.add(res.getString("poster"));
                titles.add(res.getString("title"));
            }
            
            // Poster Top Movie
            
            String[] posterArr = new String[posters.size()];
            posterArr = posters.toArray(posterArr);
            JLabel[] topPoster = {topPoster1, topPoster2, topPoster3, topPoster4, topPoster5};
            
            for(int i = 0; i < 5; i++) {
                topPoster[i].setIcon(getPoster(posterArr[i]));
            }
            
            // Title Top Movie
            
            String[] titleArr = new String[titles.size()];
            titleArr = titles.toArray(titleArr);
            JLabel[] topTitle = {topTitle1, topTitle2, topTitle3, topTitle4, topTitle5};
            
            for(int i = 0; i < 5; i++) {
                topTitle[i].setText(titleArr[i]);
            }
            
        } catch (Exception e) {
        }
    }
    
    public void load_coming_soon_movie() {
        try {
            String sql = "SELECT movie.title, movie.poster "
                       + "FROM movie "
                       + "INNER JOIN movie_status "
                       + "ON movie.status = movie_status.id_movie_status "
                       + "WHERE movie_status.status = 'Coming Soon'";
            Connection conn = (Connection) database.getConn();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            ArrayList<String> posters = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            
            while(res.next()) {
                posters.add(res.getString("poster"));
                titles.add(res.getString("title"));
            }
            
            // Poster Coming Soon Movie
            
            String[] posterArr = new String[posters.size()];
            posterArr = posters.toArray(posterArr);
            JLabel[] soonPoster = {soonPoster1, soonPoster2, soonPoster3, soonPoster4, soonPoster5};
            
            for(int i = 0; i < 5; i++) {
                soonPoster[i].setIcon(getPoster(posterArr[i]));
            }
            
            // Title Coming Soon Movie
            
            String[] titleArr = new String[titles.size()];
            titleArr = titles.toArray(titleArr);
            JLabel[] soonTitle = {soon1, soon2, soon3, soon4, soon5};
            
            for(int i = 0; i < 5; i++) {
                soonTitle[i].setText(titleArr[i]);
            }
            
        } catch (SQLException e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Navbar = new javax.swing.JPanel();
        navTitle = new javax.swing.JLabel();
        hidePane = new javax.swing.JPanel();
        hide = new javax.swing.JLabel();
        soonPane = new javax.swing.JPanel();
        la_soonMov = new javax.swing.JLabel();
        latestPane = new javax.swing.JPanel();
        la_latestMov = new javax.swing.JLabel();
        genrePane = new javax.swing.JPanel();
        cbx_genre = new javax.swing.JComboBox<>();
        searchForm = new javax.swing.JTextField();
        SideBar = new javax.swing.JPanel();
        homePane = new javax.swing.JPanel();
        HomeIcon = new javax.swing.JLabel();
        streamPane = new javax.swing.JPanel();
        StreamIcon = new javax.swing.JLabel();
        bookmarkPane = new javax.swing.JPanel();
        BmarkIcon = new javax.swing.JLabel();
        logoutPane = new javax.swing.JPanel();
        logoutIcon = new javax.swing.JLabel();
        hHomePane = new javax.swing.JPanel();
        hHomeText = new javax.swing.JLabel();
        hBookPane = new javax.swing.JPanel();
        hBmarkText = new javax.swing.JLabel();
        hStreamPane = new javax.swing.JPanel();
        hStreamText = new javax.swing.JLabel();
        hLogoutPane = new javax.swing.JPanel();
        hLogoutText = new javax.swing.JLabel();
        Dasbor = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        poster2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        poster4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        poster3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        poster5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        soonPoster5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        topPoster2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        topPoster3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        topPoster4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        topPoster5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        poster1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        topPoster1 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        soonPoster1 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        soonPoster2 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        soonPoster3 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        soonPoster4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        morePane = new javax.swing.JPanel();
        moreSoonMov = new javax.swing.JLabel();
        morePane1 = new javax.swing.JPanel();
        moreLatest = new javax.swing.JLabel();
        morePane2 = new javax.swing.JPanel();
        moreTopMov = new javax.swing.JLabel();
        lt_title1 = new javax.swing.JLabel();
        lt_title2 = new javax.swing.JLabel();
        lt_title3 = new javax.swing.JLabel();
        lt_title4 = new javax.swing.JLabel();
        lt_title5 = new javax.swing.JLabel();
        topTitle5 = new javax.swing.JLabel();
        topTitle4 = new javax.swing.JLabel();
        topTitle3 = new javax.swing.JLabel();
        topTitle2 = new javax.swing.JLabel();
        topTitle1 = new javax.swing.JLabel();
        soon5 = new javax.swing.JLabel();
        soon4 = new javax.swing.JLabel();
        soon3 = new javax.swing.JLabel();
        soon2 = new javax.swing.JLabel();
        soon1 = new javax.swing.JLabel();
        tf_username = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Navbar.setBackground(new java.awt.Color(81, 196, 211));
        Navbar.setPreferredSize(new java.awt.Dimension(1366, 60));

        navTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/nav-branding.png"))); // NOI18N

        hidePane.setBackground(new java.awt.Color(81, 196, 211));

        hide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/Vector.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hideMouseExited(evt);
            }
        });

        javax.swing.GroupLayout hidePaneLayout = new javax.swing.GroupLayout(hidePane);
        hidePane.setLayout(hidePaneLayout);
        hidePaneLayout.setHorizontalGroup(
            hidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );
        hidePaneLayout.setVerticalGroup(
            hidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        soonPane.setBackground(new java.awt.Color(81, 196, 211));

        la_soonMov.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        la_soonMov.setText("Coming Soon");
        la_soonMov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                la_soonMovMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                la_soonMovMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                la_soonMovMouseExited(evt);
            }
        });

        javax.swing.GroupLayout soonPaneLayout = new javax.swing.GroupLayout(soonPane);
        soonPane.setLayout(soonPaneLayout);
        soonPaneLayout.setHorizontalGroup(
            soonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soonPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(la_soonMov)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        soonPaneLayout.setVerticalGroup(
            soonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soonPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(la_soonMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        latestPane.setBackground(new java.awt.Color(81, 196, 211));

        la_latestMov.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        la_latestMov.setText("Latest Movies");
        la_latestMov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                la_latestMovMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                la_latestMovMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                la_latestMovMouseExited(evt);
            }
        });

        javax.swing.GroupLayout latestPaneLayout = new javax.swing.GroupLayout(latestPane);
        latestPane.setLayout(latestPaneLayout);
        latestPaneLayout.setHorizontalGroup(
            latestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(latestPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(la_latestMov)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        latestPaneLayout.setVerticalGroup(
            latestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, latestPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(la_latestMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        genrePane.setBackground(new java.awt.Color(81, 196, 211));

        cbx_genre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbx_genre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Genre", "Action", "Horror", "Romance", "Thriller" }));
        cbx_genre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbx_genreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbx_genreMouseExited(evt);
            }
        });

        javax.swing.GroupLayout genrePaneLayout = new javax.swing.GroupLayout(genrePane);
        genrePane.setLayout(genrePaneLayout);
        genrePaneLayout.setHorizontalGroup(
            genrePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genrePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbx_genre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        genrePaneLayout.setVerticalGroup(
            genrePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genrePaneLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(cbx_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        searchForm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchForm.setText("Search here");
        searchForm.setPreferredSize(new java.awt.Dimension(69, 30));
        searchForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFormMouseClicked(evt);
            }
        });
        searchForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFormActionPerformed(evt);
            }
        });
        searchForm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFormKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout NavbarLayout = new javax.swing.GroupLayout(Navbar);
        Navbar.setLayout(NavbarLayout);
        NavbarLayout.setHorizontalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addComponent(hidePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navTitle)
                .addGap(18, 18, 18)
                .addComponent(searchForm, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(genrePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(latestPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(soonPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        NavbarLayout.setVerticalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hidePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(soonPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(latestPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addComponent(genrePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(NavbarLayout.createSequentialGroup()
                .addGroup(NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(NavbarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(Navbar, java.awt.BorderLayout.PAGE_START);

        SideBar.setBackground(new java.awt.Color(81, 196, 211));
        SideBar.setPreferredSize(new java.awt.Dimension(60, 708));

        homePane.setBackground(new java.awt.Color(81, 196, 211));

        HomeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/home page (1).png"))); // NOI18N
        HomeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeIconMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout homePaneLayout = new javax.swing.GroupLayout(homePane);
        homePane.setLayout(homePaneLayout);
        homePaneLayout.setHorizontalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        homePaneLayout.setVerticalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        streamPane.setBackground(new java.awt.Color(81, 196, 211));

        StreamIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StreamIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/Group 2.png"))); // NOI18N

        javax.swing.GroupLayout streamPaneLayout = new javax.swing.GroupLayout(streamPane);
        streamPane.setLayout(streamPaneLayout);
        streamPaneLayout.setHorizontalGroup(
            streamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StreamIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        streamPaneLayout.setVerticalGroup(
            streamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(streamPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StreamIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        bookmarkPane.setBackground(new java.awt.Color(81, 196, 211));

        BmarkIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BmarkIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/Group 1.png"))); // NOI18N

        javax.swing.GroupLayout bookmarkPaneLayout = new javax.swing.GroupLayout(bookmarkPane);
        bookmarkPane.setLayout(bookmarkPaneLayout);
        bookmarkPaneLayout.setHorizontalGroup(
            bookmarkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BmarkIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        bookmarkPaneLayout.setVerticalGroup(
            bookmarkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookmarkPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BmarkIcon)
                .addContainerGap())
        );

        logoutPane.setBackground(new java.awt.Color(81, 196, 211));

        logoutIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/log out.png"))); // NOI18N

        javax.swing.GroupLayout logoutPaneLayout = new javax.swing.GroupLayout(logoutPane);
        logoutPane.setLayout(logoutPaneLayout);
        logoutPaneLayout.setHorizontalGroup(
            logoutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        logoutPaneLayout.setVerticalGroup(
            logoutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        hHomePane.setBackground(new java.awt.Color(81, 196, 211));

        hHomeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hHomeText.setForeground(new java.awt.Color(102, 102, 102));
        hHomeText.setText("Home");
        hHomeText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hHomeTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hHomeTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hHomeTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout hHomePaneLayout = new javax.swing.GroupLayout(hHomePane);
        hHomePane.setLayout(hHomePaneLayout);
        hHomePaneLayout.setHorizontalGroup(
            hHomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hHomePaneLayout.createSequentialGroup()
                .addComponent(hHomeText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        hHomePaneLayout.setVerticalGroup(
            hHomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hHomeText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        hBookPane.setBackground(new java.awt.Color(81, 196, 211));

        hBmarkText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hBmarkText.setForeground(new java.awt.Color(102, 102, 102));
        hBmarkText.setText("Bookmark");
        hBmarkText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hBmarkTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hBmarkTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hBmarkTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout hBookPaneLayout = new javax.swing.GroupLayout(hBookPane);
        hBookPane.setLayout(hBookPaneLayout);
        hBookPaneLayout.setHorizontalGroup(
            hBookPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hBookPaneLayout.createSequentialGroup()
                .addComponent(hBmarkText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        hBookPaneLayout.setVerticalGroup(
            hBookPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hBmarkText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        hStreamPane.setBackground(new java.awt.Color(81, 196, 211));

        hStreamText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hStreamText.setForeground(new java.awt.Color(102, 102, 102));
        hStreamText.setText("Stream");
        hStreamText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hStreamTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hStreamTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hStreamTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout hStreamPaneLayout = new javax.swing.GroupLayout(hStreamPane);
        hStreamPane.setLayout(hStreamPaneLayout);
        hStreamPaneLayout.setHorizontalGroup(
            hStreamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hStreamPaneLayout.createSequentialGroup()
                .addComponent(hStreamText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        hStreamPaneLayout.setVerticalGroup(
            hStreamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hStreamText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        hLogoutPane.setBackground(new java.awt.Color(81, 196, 211));

        hLogoutText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hLogoutText.setForeground(new java.awt.Color(102, 102, 102));
        hLogoutText.setText("Log Out");
        hLogoutText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hLogoutTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hLogoutTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hLogoutTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout hLogoutPaneLayout = new javax.swing.GroupLayout(hLogoutPane);
        hLogoutPane.setLayout(hLogoutPaneLayout);
        hLogoutPaneLayout.setHorizontalGroup(
            hLogoutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hLogoutPaneLayout.createSequentialGroup()
                .addComponent(hLogoutText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        hLogoutPaneLayout.setVerticalGroup(
            hLogoutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hLogoutText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout SideBarLayout = new javax.swing.GroupLayout(SideBar);
        SideBar.setLayout(SideBarLayout);
        SideBarLayout.setHorizontalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarLayout.createSequentialGroup()
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookmarkPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hBookPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hHomePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(SideBarLayout.createSequentialGroup()
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SideBarLayout.createSequentialGroup()
                        .addComponent(streamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hStreamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SideBarLayout.createSequentialGroup()
                        .addComponent(logoutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hLogoutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SideBarLayout.setVerticalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarLayout.createSequentialGroup()
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SideBarLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(hHomePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookmarkPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SideBarLayout.createSequentialGroup()
                        .addComponent(hBookPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SideBarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(streamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SideBarLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(hStreamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SideBarLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(hLogoutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1046, Short.MAX_VALUE))
        );

        getContentPane().add(SideBar, java.awt.BorderLayout.LINE_START);

        jPanel8.setPreferredSize(new java.awt.Dimension(1260, 1350));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Coming Soon");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 870, -1, -1));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 283));

        poster2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                poster2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                poster2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 283));

        poster4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                poster4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                poster4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster4, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, -1, -1));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 283));

        poster3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                poster3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                poster3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 283));

        poster5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                poster5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                poster5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster5, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, -1, -1));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setPreferredSize(new java.awt.Dimension(200, 283));

        soonPoster5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soonPoster5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soonPoster5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soonPoster5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster5, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 910, -1, -1));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 283));

        topPoster2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topPoster2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topPoster2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topPoster2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, -1, -1));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setPreferredSize(new java.awt.Dimension(200, 283));

        topPoster3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topPoster3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topPoster3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topPoster3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, -1, -1));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 283));

        topPoster4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topPoster4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topPoster4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topPoster4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster4, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, -1, -1));

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setPreferredSize(new java.awt.Dimension(200, 283));

        topPoster5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topPoster5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topPoster5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topPoster5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster5, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 490, -1, -1));

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));
        jPanel15.setPreferredSize(new java.awt.Dimension(200, 283));

        poster1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                poster1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                poster1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Latest Movies");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));
        jPanel16.setPreferredSize(new java.awt.Dimension(200, 283));

        topPoster1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topPoster1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topPoster1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topPoster1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPoster1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        jPanel17.setBackground(new java.awt.Color(204, 204, 204));
        jPanel17.setPreferredSize(new java.awt.Dimension(200, 283));

        soonPoster1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soonPoster1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soonPoster1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soonPoster1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 910, -1, -1));

        jPanel18.setBackground(new java.awt.Color(204, 204, 204));
        jPanel18.setPreferredSize(new java.awt.Dimension(200, 283));

        soonPoster2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soonPoster2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soonPoster2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soonPoster2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 910, -1, -1));

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));
        jPanel19.setPreferredSize(new java.awt.Dimension(200, 283));

        soonPoster3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soonPoster3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soonPoster3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soonPoster3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 910, -1, -1));

        jPanel20.setBackground(new java.awt.Color(204, 204, 204));
        jPanel20.setPreferredSize(new java.awt.Dimension(200, 283));

        soonPoster4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soonPoster4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soonPoster4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soonPoster4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soonPoster4, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 910, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Top Movies");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        morePane.setBackground(new java.awt.Color(18, 110, 130));
        morePane.setPreferredSize(new java.awt.Dimension(60, 2));

        javax.swing.GroupLayout morePaneLayout = new javax.swing.GroupLayout(morePane);
        morePane.setLayout(morePaneLayout);
        morePaneLayout.setHorizontalGroup(
            morePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        morePaneLayout.setVerticalGroup(
            morePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel8.add(morePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 430, -1, -1));

        moreSoonMov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        moreSoonMov.setForeground(new java.awt.Color(18, 110, 130));
        moreSoonMov.setText("More...");
        moreSoonMov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moreSoonMovMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                moreSoonMovMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moreSoonMovMouseExited(evt);
            }
        });
        jPanel8.add(moreSoonMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 1240, -1, 20));

        morePane1.setBackground(new java.awt.Color(18, 110, 130));
        morePane1.setPreferredSize(new java.awt.Dimension(60, 2));

        javax.swing.GroupLayout morePane1Layout = new javax.swing.GroupLayout(morePane1);
        morePane1.setLayout(morePane1Layout);
        morePane1Layout.setHorizontalGroup(
            morePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        morePane1Layout.setVerticalGroup(
            morePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel8.add(morePane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 850, -1, -1));

        moreLatest.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        moreLatest.setForeground(new java.awt.Color(18, 110, 130));
        moreLatest.setText("More...");
        moreLatest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moreLatestMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                moreLatestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moreLatestMouseExited(evt);
            }
        });
        jPanel8.add(moreLatest, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 410, -1, 20));

        morePane2.setBackground(new java.awt.Color(18, 110, 130));
        morePane2.setPreferredSize(new java.awt.Dimension(60, 2));

        javax.swing.GroupLayout morePane2Layout = new javax.swing.GroupLayout(morePane2);
        morePane2.setLayout(morePane2Layout);
        morePane2Layout.setHorizontalGroup(
            morePane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        morePane2Layout.setVerticalGroup(
            morePane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel8.add(morePane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 1260, -1, -1));

        moreTopMov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        moreTopMov.setForeground(new java.awt.Color(18, 110, 130));
        moreTopMov.setText("More...");
        moreTopMov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moreTopMovMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                moreTopMovMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moreTopMovMouseExited(evt);
            }
        });
        jPanel8.add(moreTopMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 830, -1, 20));

        lt_title1.setText("Latest1");
        lt_title1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_title1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lt_title1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lt_title1MouseExited(evt);
            }
        });
        jPanel8.add(lt_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 200, 30));

        lt_title2.setText("Latest2");
        lt_title2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_title2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lt_title2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lt_title2MouseExited(evt);
            }
        });
        jPanel8.add(lt_title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 200, 30));

        lt_title3.setText("Latest1");
        lt_title3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_title3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lt_title3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lt_title3MouseExited(evt);
            }
        });
        jPanel8.add(lt_title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 200, 30));

        lt_title4.setText("Latest1");
        lt_title4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_title4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lt_title4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lt_title4MouseExited(evt);
            }
        });
        jPanel8.add(lt_title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 200, 30));

        lt_title5.setText("Latest5");
        lt_title5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_title5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lt_title5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lt_title5MouseExited(evt);
            }
        });
        jPanel8.add(lt_title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 360, 200, 30));

        topTitle5.setText("TopMovie5");
        topTitle5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topTitle5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topTitle5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topTitle5MouseExited(evt);
            }
        });
        jPanel8.add(topTitle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 780, 200, 30));

        topTitle4.setText("TopMovie4");
        topTitle4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topTitle4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topTitle4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topTitle4MouseExited(evt);
            }
        });
        jPanel8.add(topTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 780, 200, 30));

        topTitle3.setText("TopMovie3");
        topTitle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topTitle3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topTitle3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topTitle3MouseExited(evt);
            }
        });
        jPanel8.add(topTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 780, 200, 30));

        topTitle2.setText("TopMovie2");
        topTitle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topTitle2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topTitle2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topTitle2MouseExited(evt);
            }
        });
        jPanel8.add(topTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 780, 200, 30));

        topTitle1.setText("TopMovie1");
        topTitle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topTitle1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topTitle1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topTitle1MouseExited(evt);
            }
        });
        jPanel8.add(topTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 780, 200, 30));

        soon5.setText("Soon5");
        soon5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soon5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soon5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soon5MouseExited(evt);
            }
        });
        jPanel8.add(soon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 1200, 200, 30));

        soon4.setText("Soon4");
        soon4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soon4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soon4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soon4MouseExited(evt);
            }
        });
        jPanel8.add(soon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1200, 200, 30));

        soon3.setText("Soon3");
        soon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soon3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soon3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soon3MouseExited(evt);
            }
        });
        jPanel8.add(soon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1200, 200, 30));

        soon2.setText("Soon2");
        soon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soon2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soon2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soon2MouseExited(evt);
            }
        });
        jPanel8.add(soon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1200, 200, 30));

        soon1.setText("Soon1");
        soon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                soon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                soon1MouseExited(evt);
            }
        });
        jPanel8.add(soon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1200, 200, 30));

        tf_username.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_username.setText("username");
        jPanel8.add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, 90, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Login As:");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, -1, 30));

        Dasbor.setViewportView(jPanel8);

        getContentPane().add(Dasbor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // jlabel
    public void changecolor(JLabel hoover, Color asu){
        hoover.setBackground(asu);
    }
    // fungsi hover
    public void changeColor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    
    // hide and show sidebar
    public void hideshow(JPanel menuhideandshow, boolean sidebarOn){
        if (sidebarOn == true){
            menuhideandshow.setPreferredSize(new Dimension(60, menuhideandshow.getHeight()));
        }else {
            menuhideandshow.setPreferredSize(new Dimension(195, menuhideandshow.getHeight()));
        }
    }
    boolean a;
    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        // HIDE SIDEBAR CLICK
        
        if (a == true){
            hideshow(SideBar, a);
            SwingUtilities.updateComponentTreeUI(this);
            a = false;
        }else {
            hideshow(SideBar, a);
            SwingUtilities.updateComponentTreeUI(this);
            a = true;
        }
        

    }//GEN-LAST:event_hideMouseClicked

    private void hideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseEntered
        // HIDE SIDEBAR ENTER - Salah anjing!
        changeColor(hidePane, new Color(216, 227, 231));
    }//GEN-LAST:event_hideMouseEntered

    private void hideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseExited
        // HIDE SIDEBAR EXIT
        changeColor(hidePane, new Color(81, 196, 211));

    }//GEN-LAST:event_hideMouseExited

    private void la_soonMovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_soonMovMouseClicked
        // BUTTON COMING SOON ACTION ANJAY
        new SoonMovies(tf_username.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_la_soonMovMouseClicked

    private void la_soonMovMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_soonMovMouseEntered
        // BUTTON COMING SOON
        changeColor(soonPane, new Color(216, 227, 231));
    }//GEN-LAST:event_la_soonMovMouseEntered

    private void la_soonMovMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_soonMovMouseExited
        // BUTTON COMING SOON
        changeColor(soonPane, new Color(81, 196, 211));
    }//GEN-LAST:event_la_soonMovMouseExited

    private void la_latestMovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_latestMovMouseClicked
        // btn latest mov navbar
        new LatestMovies(tf_username.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_la_latestMovMouseClicked

    private void la_latestMovMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_latestMovMouseEntered
        // BUTTON LATEST
        changeColor(latestPane, new Color(216, 227, 231));
    }//GEN-LAST:event_la_latestMovMouseEntered

    private void la_latestMovMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_latestMovMouseExited
        // BUTTON LATEST
        changeColor(latestPane, new Color(81, 196, 211));
    }//GEN-LAST:event_la_latestMovMouseExited

    private void cbx_genreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_genreMouseExited
        // BUTTON COMBO BOX

    }//GEN-LAST:event_cbx_genreMouseExited

    private void cbx_genreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_genreMouseEntered
        // BUTTON COMBO BOX

    }//GEN-LAST:event_cbx_genreMouseEntered

    private void moreSoonMovMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreSoonMovMouseEntered
        // BUTTON MORE
        changeColor(morePane2, new Color(18, 110, 130));
    }//GEN-LAST:event_moreSoonMovMouseEntered

    private void moreSoonMovMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreSoonMovMouseExited
        // BUTTON MORE
        changeColor(morePane2,new Color(216, 227, 231));
    }//GEN-LAST:event_moreSoonMovMouseExited

    private void moreLatestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreLatestMouseEntered
        // TODO add your handling code here:
        changeColor(morePane, new Color(18, 110, 130));
    }//GEN-LAST:event_moreLatestMouseEntered

    private void moreLatestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreLatestMouseExited
        // TODO add your handling code here:
        changeColor(morePane, new Color(216, 227, 231));
    }//GEN-LAST:event_moreLatestMouseExited

    private void moreTopMovMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreTopMovMouseEntered
        // TODO add your handling code here:
        changeColor(morePane1, new Color(18, 110, 130));
    }//GEN-LAST:event_moreTopMovMouseEntered

    private void moreTopMovMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreTopMovMouseExited
        // TODO add your handling code here:
        changeColor(morePane1, new Color(216, 227, 231));
    }//GEN-LAST:event_moreTopMovMouseExited

    private void HomeIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeIconMouseEntered

    }//GEN-LAST:event_HomeIconMouseEntered

    private void hHomeTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hHomeTextMouseEntered
        // BUTTON BOOKMARK NEW
        changeColor(hHomePane, new Color(216, 227, 231));
    }//GEN-LAST:event_hHomeTextMouseEntered

    private void hHomeTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hHomeTextMouseExited
        // BUTTON BOOKMARK NEW
        changeColor(hHomePane, new Color(81, 196, 211));
    }//GEN-LAST:event_hHomeTextMouseExited

    private void hStreamTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hStreamTextMouseEntered
        // BUTTON LOGIN NEW
        changeColor(hStreamPane, new Color(216, 227, 231));
    }//GEN-LAST:event_hStreamTextMouseEntered

    private void hStreamTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hStreamTextMouseExited
        // TODO add your handling code here:
        changeColor(hStreamPane, new Color(81, 196, 211));
    }//GEN-LAST:event_hStreamTextMouseExited

    private void hStreamTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hStreamTextMouseClicked
        // btn hidden stream
        this.dispose();
        new StreamPage(tf_username.getText()).setVisible(true);
    }//GEN-LAST:event_hStreamTextMouseClicked

    private void moreLatestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreLatestMouseClicked
        // btn more latest mov
        new LatestMovies(tf_username.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_moreLatestMouseClicked

    private void moreTopMovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreTopMovMouseClicked
        // btn more top movies
        new TopMovies(tf_username.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_moreTopMovMouseClicked

    private void moreSoonMovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreSoonMovMouseClicked
        // btn more soon movies
        new SoonMovies(tf_username.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_moreSoonMovMouseClicked

    private void hBmarkTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hBmarkTextMouseEntered
        // TODO add your handling code here:
        changeColor(hBookPane, new Color(216, 227, 231));
    }//GEN-LAST:event_hBmarkTextMouseEntered

    private void hBmarkTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hBmarkTextMouseExited
        // TODO add your handling code here:
        changeColor(hBookPane, new Color(81, 196, 211));
    }//GEN-LAST:event_hBmarkTextMouseExited

    private void hBmarkTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hBmarkTextMouseClicked
        // btn bookmark
        String username = tf_username.getText();
        new UserBookmark(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hBmarkTextMouseClicked

    private void hLogoutTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hLogoutTextMouseClicked
        // btn logout
        new AppLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hLogoutTextMouseClicked

    private void hLogoutTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hLogoutTextMouseEntered
        // TODO add your handling code here:
        changeColor(hLogoutPane, new Color(216, 227, 231));
    }//GEN-LAST:event_hLogoutTextMouseEntered

    private void hLogoutTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hLogoutTextMouseExited
        // TODO add your handling code here:
        changeColor(hLogoutPane, new Color(81, 196, 211));
    }//GEN-LAST:event_hLogoutTextMouseExited

    private void hHomeTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hHomeTextMouseClicked
        // btn home
        new UserDashboard(tf_username.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hHomeTextMouseClicked

    private void poster1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster1MouseEntered
        // TODO add your handling code here:
        changeColor(jPanel15, new Color(81,196,211));
    }//GEN-LAST:event_poster1MouseEntered

    private void poster1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster1MouseExited
        // TODO add your handling code here:
        changeColor(jPanel15, new Color(204,204,204));
    }//GEN-LAST:event_poster1MouseExited

    private void poster1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster1MouseClicked
        // Redirect ke Detail Movie
        String title = lt_title1.getText();
        getDetailMovie(title);
    }//GEN-LAST:event_poster1MouseClicked

    private void lt_title1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title1MouseClicked
        // TODO add your handling code here:
        String title = lt_title1.getText();
        getDetailMovie(title);
    }//GEN-LAST:event_lt_title1MouseClicked

    private void lt_title1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title1MouseEntered
        // TODO add your handling code here:
        changecolor(lt_title1, new Color(81, 196, 211));
    }//GEN-LAST:event_lt_title1MouseEntered

    private void lt_title1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title1MouseExited
        // TODO add your handling code here:
        changecolor(lt_title1, new Color(19, 44, 51));
    }//GEN-LAST:event_lt_title1MouseExited

    private void poster2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster2MouseClicked
        // TODO add your handling code here:
        getDetailMovie(lt_title2.getText());
    }//GEN-LAST:event_poster2MouseClicked

    private void poster2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_poster2MouseEntered

    private void poster2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_poster2MouseExited

    private void poster3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster3MouseClicked
        // Latest Poster3
        getDetailMovie(lt_title3.getText());
    }//GEN-LAST:event_poster3MouseClicked

    private void poster3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_poster3MouseEntered

    private void poster3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_poster3MouseExited

    private void poster4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster4MouseClicked
        // Poster 4 Latest
        getDetailMovie(lt_title4.getText());
    }//GEN-LAST:event_poster4MouseClicked

    private void poster4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_poster4MouseEntered

    private void poster4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_poster4MouseExited

    private void poster5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster5MouseClicked
        // Poster Latest 5
        getDetailMovie(lt_title5.getText());
    }//GEN-LAST:event_poster5MouseClicked

    private void poster5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_poster5MouseEntered

    private void poster5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_poster5MouseExited

    private void lt_title2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title2MouseClicked
        // Latest2 Title
        getDetailMovie(lt_title2.getText());
    }//GEN-LAST:event_lt_title2MouseClicked

    private void lt_title2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title2MouseEntered

    private void lt_title2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title2MouseExited

    private void lt_title3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title3MouseClicked
        // Latest Title 3
        getDetailMovie(lt_title3.getText());
    }//GEN-LAST:event_lt_title3MouseClicked

    private void lt_title3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title3MouseEntered

    private void lt_title3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title3MouseExited

    private void lt_title4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title4MouseClicked
        // Title Latest 4
        getDetailMovie(lt_title4.getText());
    }//GEN-LAST:event_lt_title4MouseClicked

    private void lt_title4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title4MouseEntered

    private void lt_title4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title4MouseExited

    private void lt_title5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title5MouseClicked
        // Latest Title 5
        getDetailMovie(lt_title5.getText());
    }//GEN-LAST:event_lt_title5MouseClicked

    private void lt_title5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title5MouseEntered

    private void lt_title5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title5MouseExited

    private void topPoster1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster1MouseClicked
        // TopMov1
        getDetailMovie(topTitle1.getText());
    }//GEN-LAST:event_topPoster1MouseClicked

    private void topPoster1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster1MouseEntered

    private void topPoster1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster1MouseExited

    private void topPoster2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster2MouseClicked
        // TopPoster2
        getDetailMovie(topTitle2.getText());
    }//GEN-LAST:event_topPoster2MouseClicked

    private void topPoster2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster2MouseEntered

    private void topPoster2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster2MouseExited

    private void topPoster3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster3MouseClicked
        // TopPoster3
        getDetailMovie(topTitle3.getText());
    }//GEN-LAST:event_topPoster3MouseClicked

    private void topPoster3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster3MouseEntered

    private void topPoster3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster3MouseExited

    private void topPoster4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster4MouseClicked
        // TopPoster4
        getDetailMovie(topTitle4.getText());
    }//GEN-LAST:event_topPoster4MouseClicked

    private void topPoster4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster4MouseEntered

    private void topPoster4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster4MouseExited

    private void topPoster5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster5MouseClicked
        // TopPoster5
        getDetailMovie(topTitle5.getText());
    }//GEN-LAST:event_topPoster5MouseClicked

    private void topPoster5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster5MouseEntered

    private void topPoster5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPoster5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topPoster5MouseExited

    private void topTitle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle1MouseClicked
        // topmov1
        getDetailMovie(topTitle1.getText());
    }//GEN-LAST:event_topTitle1MouseClicked

    private void topTitle1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle1MouseEntered

    private void topTitle1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle1MouseExited

    private void topTitle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle2MouseClicked
        // TopTitle2
        getDetailMovie(topTitle2.getText());
    }//GEN-LAST:event_topTitle2MouseClicked

    private void topTitle2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle2MouseEntered

    private void topTitle2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle2MouseExited

    private void topTitle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle3MouseClicked
        // TopTitle3
        getDetailMovie(topTitle3.getText());
    }//GEN-LAST:event_topTitle3MouseClicked

    private void topTitle3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle3MouseEntered

    private void topTitle3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle3MouseExited

    private void topTitle4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle4MouseClicked
        // TopTitle4
        getDetailMovie(topTitle4.getText());
    }//GEN-LAST:event_topTitle4MouseClicked

    private void topTitle4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle4MouseEntered

    private void topTitle4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle4MouseExited

    private void topTitle5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle5MouseClicked
        // TopTItle5
        getDetailMovie(topTitle5.getText());
    }//GEN-LAST:event_topTitle5MouseClicked

    private void topTitle5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle5MouseEntered

    private void topTitle5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topTitle5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topTitle5MouseExited

    private void soon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon1MouseClicked
        // SoonTitle11
        getDetailMovie(soon1.getText());
    }//GEN-LAST:event_soon1MouseClicked

    private void soon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soon1MouseEntered

    private void soon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soon1MouseExited

    private void soon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon2MouseClicked
        // SoonTitle2
        getDetailMovie(soon2.getText());
    }//GEN-LAST:event_soon2MouseClicked

    private void soon2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soon2MouseEntered

    private void soon2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soon2MouseExited

    private void soon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon3MouseClicked
        // SoonTitle3
        getDetailMovie(soon3.getText());
    }//GEN-LAST:event_soon3MouseClicked

    private void soon3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soon3MouseEntered

    private void soon3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soon3MouseExited

    private void soon4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon4MouseClicked
        // SoonTitle4
        getDetailMovie(soon4.getText());
    }//GEN-LAST:event_soon4MouseClicked

    private void soon4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soon4MouseEntered

    private void soon4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soon4MouseExited

    private void soon5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon5MouseClicked
        // SoonTitle5
        getDetailMovie(soon5.getText());
    }//GEN-LAST:event_soon5MouseClicked

    private void soon5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soon5MouseEntered

    private void soon5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soon5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soon5MouseExited

    private void soonPoster1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster1MouseClicked
        // SoonPoster1
        getDetailMovie(soon1.getText());
    }//GEN-LAST:event_soonPoster1MouseClicked

    private void soonPoster1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster1MouseEntered

    private void soonPoster1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster1MouseExited

    private void soonPoster2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster2MouseClicked
        // SoonPoster2
        getDetailMovie(soon2.getText());
    }//GEN-LAST:event_soonPoster2MouseClicked

    private void soonPoster2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster2MouseEntered

    private void soonPoster2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster2MouseExited

    private void soonPoster3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster3MouseClicked
        // SoonPoster3
        getDetailMovie(soon3.getText());
    }//GEN-LAST:event_soonPoster3MouseClicked

    private void soonPoster3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster3MouseEntered

    private void soonPoster3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster3MouseExited

    private void soonPoster4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster4MouseClicked
        // SoonPoster4
        getDetailMovie(soon4.getText());
    }//GEN-LAST:event_soonPoster4MouseClicked

    private void soonPoster4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster4MouseEntered

    private void soonPoster4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster4MouseExited

    private void soonPoster5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster5MouseClicked
        // SoonPoster5
        getDetailMovie(soon5.getText());
    }//GEN-LAST:event_soonPoster5MouseClicked

    private void soonPoster5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster5MouseEntered

    private void soonPoster5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soonPoster5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_soonPoster5MouseExited

    private void searchFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFormActionPerformed
        // 
    }//GEN-LAST:event_searchFormActionPerformed

    private void searchFormKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFormKeyPressed
        // Hit Enter = Search Movie
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String query = searchForm.getText();
            this.dispose();
            new SearchedMovie(tf_username.getText(), query).setVisible(true);
        }
    }//GEN-LAST:event_searchFormKeyPressed

    private void searchFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFormMouseClicked
        // Clear The Form
        searchForm.setText("");
    }//GEN-LAST:event_searchFormMouseClicked
    int x = 175;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BmarkIcon;
    private javax.swing.JScrollPane Dasbor;
    private javax.swing.JLabel HomeIcon;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel SideBar;
    private javax.swing.JLabel StreamIcon;
    private javax.swing.JPanel bookmarkPane;
    private javax.swing.JComboBox<String> cbx_genre;
    private javax.swing.JPanel genrePane;
    private javax.swing.JLabel hBmarkText;
    private javax.swing.JPanel hBookPane;
    private javax.swing.JPanel hHomePane;
    private javax.swing.JLabel hHomeText;
    private javax.swing.JPanel hLogoutPane;
    private javax.swing.JLabel hLogoutText;
    private javax.swing.JPanel hStreamPane;
    private javax.swing.JLabel hStreamText;
    private javax.swing.JLabel hide;
    private javax.swing.JPanel hidePane;
    private javax.swing.JPanel homePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel la_latestMov;
    private javax.swing.JLabel la_soonMov;
    private javax.swing.JPanel latestPane;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JPanel logoutPane;
    private javax.swing.JLabel lt_title1;
    private javax.swing.JLabel lt_title2;
    private javax.swing.JLabel lt_title3;
    private javax.swing.JLabel lt_title4;
    private javax.swing.JLabel lt_title5;
    private javax.swing.JLabel moreLatest;
    private javax.swing.JPanel morePane;
    private javax.swing.JPanel morePane1;
    private javax.swing.JPanel morePane2;
    private javax.swing.JLabel moreSoonMov;
    private javax.swing.JLabel moreTopMov;
    private javax.swing.JLabel navTitle;
    private javax.swing.JLabel poster1;
    private javax.swing.JLabel poster2;
    private javax.swing.JLabel poster3;
    private javax.swing.JLabel poster4;
    private javax.swing.JLabel poster5;
    private javax.swing.JTextField searchForm;
    private javax.swing.JLabel soon1;
    private javax.swing.JLabel soon2;
    private javax.swing.JLabel soon3;
    private javax.swing.JLabel soon4;
    private javax.swing.JLabel soon5;
    private javax.swing.JPanel soonPane;
    private javax.swing.JLabel soonPoster1;
    private javax.swing.JLabel soonPoster2;
    private javax.swing.JLabel soonPoster3;
    private javax.swing.JLabel soonPoster4;
    private javax.swing.JLabel soonPoster5;
    private javax.swing.JPanel streamPane;
    private javax.swing.JLabel tf_username;
    private javax.swing.JLabel topPoster1;
    private javax.swing.JLabel topPoster2;
    private javax.swing.JLabel topPoster3;
    private javax.swing.JLabel topPoster4;
    private javax.swing.JLabel topPoster5;
    private javax.swing.JLabel topTitle1;
    private javax.swing.JLabel topTitle2;
    private javax.swing.JLabel topTitle3;
    private javax.swing.JLabel topTitle4;
    private javax.swing.JLabel topTitle5;
    // End of variables declaration//GEN-END:variables

private void labelColor(JLabel label){
    label.setBackground(new java.awt.Color(19, 44, 51));
}

private void resetlabelColor(JLabel label){
    label.setBackground(new java.awt.Color(19, 44, 51));
}

}
