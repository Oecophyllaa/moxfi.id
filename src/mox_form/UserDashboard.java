package mox_form;

import db.database;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
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

    public UserDashboard() {
        initComponents();
        setTitle("MOXFI.ID");
        setExtendedState(MAXIMIZED_BOTH);
        load_latest_movie();
        load_top_movies();
        load_coming_soon_movie();
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
        new DetailMovie(title).setVisible(true);
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
            
            poster1.setIcon(getPoster(posterArr[0]));
            poster2.setIcon(getPoster(posterArr[1]));
            poster3.setIcon(getPoster(posterArr[2]));
            poster4.setIcon(getPoster(posterArr[3]));
            poster5.setIcon(getPoster(posterArr[4]));
            
            // Title Latest Movie
            
            String[] titleArr = new String[titles.size()];
            titleArr = titles.toArray(titleArr);
            
            lt_title1.setText(titleArr[0]);
            lt_title2.setText(titleArr[1]);
            lt_title3.setText(titleArr[2]);
            lt_title4.setText(titleArr[3]);
            lt_title5.setText(titleArr[4]);
            
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
            
            topPoster1.setIcon(getPoster(posterArr[0]));
            topPoster2.setIcon(getPoster(posterArr[1]));
            topPoster3.setIcon(getPoster(posterArr[2]));
            topPoster4.setIcon(getPoster(posterArr[3]));
            topPoster5.setIcon(getPoster(posterArr[4]));
            
            // Title Top Movie
            
            String[] titleArr = new String[titles.size()];
            titleArr = titles.toArray(titleArr);
            
            topTitle1.setText(titleArr[0]);
            topTitle2.setText(titleArr[1]);
            topTitle3.setText(titleArr[2]);
            topTitle4.setText(titleArr[3]);
            topTitle5.setText(titleArr[4]);
        } catch (Exception e) {
            e.printStackTrace();
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
            
            soonPoster1.setIcon(getPoster(posterArr[0]));
            soonPoster2.setIcon(getPoster(posterArr[1]));
            soonPoster3.setIcon(getPoster(posterArr[2]));
            soonPoster4.setIcon(getPoster(posterArr[3]));
            soonPoster5.setIcon(getPoster(posterArr[4]));
            
            // Title Coming Soon Movie
            
            String[] titleArr = new String[titles.size()];
            titleArr = titles.toArray(titleArr);
            
            soon1.setText(titleArr[0]);
            soon2.setText(titleArr[1]);
            soon3.setText(titleArr[2]);
            soon4.setText(titleArr[3]);
            soon5.setText(titleArr[4]);
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        hidePane = new javax.swing.JPanel();
        hide = new javax.swing.JLabel();
        coomingPane = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        latestPane = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        genrePane = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        sidebarIcon = new javax.swing.JPanel();
        bookmarkPane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        loginPane = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        streamPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        loginPane1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
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
        jLabel10 = new javax.swing.JLabel();
        morePane1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        morePane2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(81, 196, 211));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/nav-branding.png"))); // NOI18N

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

        coomingPane.setBackground(new java.awt.Color(81, 196, 211));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Coming Soon");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout coomingPaneLayout = new javax.swing.GroupLayout(coomingPane);
        coomingPane.setLayout(coomingPaneLayout);
        coomingPaneLayout.setHorizontalGroup(
            coomingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coomingPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        coomingPaneLayout.setVerticalGroup(
            coomingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coomingPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        latestPane.setBackground(new java.awt.Color(81, 196, 211));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Latest Movies");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout latestPaneLayout = new javax.swing.GroupLayout(latestPane);
        latestPane.setLayout(latestPaneLayout);
        latestPaneLayout.setHorizontalGroup(
            latestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(latestPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        latestPaneLayout.setVerticalGroup(
            latestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, latestPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        genrePane.setBackground(new java.awt.Color(81, 196, 211));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Genre", "Action", "Horror", "Romance", "Thriller" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout genrePaneLayout = new javax.swing.GroupLayout(genrePane);
        genrePane.setLayout(genrePaneLayout);
        genrePaneLayout.setHorizontalGroup(
            genrePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genrePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        genrePaneLayout.setVerticalGroup(
            genrePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genrePaneLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setText("Search here");
        jTextField1.setPreferredSize(new java.awt.Dimension(69, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(hidePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(genrePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(latestPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(coomingPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hidePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(coomingPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(latestPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(genrePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        sidebarIcon.setBackground(new java.awt.Color(81, 196, 211));
        sidebarIcon.setPreferredSize(new java.awt.Dimension(60, 708));

        bookmarkPane.setBackground(new java.awt.Color(81, 196, 211));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/home page (1).png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout bookmarkPaneLayout = new javax.swing.GroupLayout(bookmarkPane);
        bookmarkPane.setLayout(bookmarkPaneLayout);
        bookmarkPaneLayout.setHorizontalGroup(
            bookmarkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        bookmarkPaneLayout.setVerticalGroup(
            bookmarkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookmarkPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        loginPane.setBackground(new java.awt.Color(81, 196, 211));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/Group 2.png"))); // NOI18N

        javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
        loginPane.setLayout(loginPaneLayout);
        loginPaneLayout.setHorizontalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        loginPaneLayout.setVerticalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        streamPane.setBackground(new java.awt.Color(81, 196, 211));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/Group 1.png"))); // NOI18N

        javax.swing.GroupLayout streamPaneLayout = new javax.swing.GroupLayout(streamPane);
        streamPane.setLayout(streamPaneLayout);
        streamPaneLayout.setHorizontalGroup(
            streamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        streamPaneLayout.setVerticalGroup(
            streamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, streamPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(81, 196, 211));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Home");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(81, 196, 211));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Bookmark");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(81, 196, 211));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Stream");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        loginPane1.setBackground(new java.awt.Color(81, 196, 211));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/log out.png"))); // NOI18N

        javax.swing.GroupLayout loginPane1Layout = new javax.swing.GroupLayout(loginPane1);
        loginPane1.setLayout(loginPane1Layout);
        loginPane1Layout.setHorizontalGroup(
            loginPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        loginPane1Layout.setVerticalGroup(
            loginPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel21.setBackground(new java.awt.Color(81, 196, 211));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Log Out");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout sidebarIconLayout = new javax.swing.GroupLayout(sidebarIcon);
        sidebarIcon.setLayout(sidebarIconLayout);
        sidebarIconLayout.setHorizontalGroup(
            sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarIconLayout.createSequentialGroup()
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookmarkPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sidebarIconLayout.createSequentialGroup()
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addComponent(loginPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidebarIconLayout.setVerticalGroup(
            sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarIconLayout.createSequentialGroup()
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookmarkPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(streamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarIconLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(989, Short.MAX_VALUE))
        );

        getContentPane().add(sidebarIcon, java.awt.BorderLayout.LINE_START);

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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(18, 110, 130));
        jLabel10.setText("More...");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 1240, -1, 20));

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(18, 110, 130));
        jLabel11.setText("More...");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 410, -1, 20));

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(18, 110, 130));
        jLabel12.setText("More...");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 830, -1, 20));

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

        jScrollPane1.setViewportView(jPanel8);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

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
            hideshow(sidebarIcon, a);
            SwingUtilities.updateComponentTreeUI(this);
            a = false;
        }else {
            hideshow(sidebarIcon, a);
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

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // BUTTON COMING SOON ACTION ANJAY
        SoonMovies comingsoon = new SoonMovies();
        comingsoon.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // BUTTON COMING SOON
        changeColor(coomingPane, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // BUTTON COMING SOON
        changeColor(coomingPane, new Color(81, 196, 211));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // BUTTON LATEST ACTION CLICK ANJAY
        LatestMovies latest = new LatestMovies();
        latest.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // BUTTON LATEST
        changeColor(latestPane, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // BUTTON LATEST
        changeColor(latestPane, new Color(81, 196, 211));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jComboBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseExited
        // BUTTON COMBO BOX

    }//GEN-LAST:event_jComboBox1MouseExited

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        // BUTTON COMBO BOX

    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // BUTTON MORE
        changeColor(morePane2, new Color(18, 110, 130));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // BUTTON MORE
        changeColor(morePane2,new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
        changeColor(morePane, new Color(18, 110, 130));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
        changeColor(morePane, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
        changeColor(morePane1, new Color(18, 110, 130));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
        changeColor(morePane1, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered

    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // BUTTON BOOKMARK NEW
        changeColor(jPanel2, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // BUTTON BOOKMARK NEW
        changeColor(jPanel2, new Color(81, 196, 211));
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // BUTTON LOGIN NEW
        changeColor(jPanel4, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
        changeColor(jPanel4, new Color(81, 196, 211));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        stream_page stream = new stream_page();
        stream.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        LatestMovies latest = new LatestMovies();
        latest.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        top_movies topmovies = new top_movies();
        topmovies.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        SoonMovies comingsoon = new SoonMovies();
        comingsoon.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        changeColor(jPanel3, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        changeColor(jPanel3, new Color(81, 196, 211));
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        UserBookmark list = new UserBookmark();
        list.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        AppLogin backlogin = new AppLogin();
        backlogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
        changeColor(jPanel21, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        // TODO add your handling code here:
        changeColor(jPanel21, new Color(81, 196, 211));
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        UserDashboard refresh = new UserDashboard();
        refresh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

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
        new DetailMovie(title).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_poster1MouseClicked

    private void lt_title1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title1MouseClicked
        // TODO add your handling code here:
        String title = lt_title1.getText();
        new DetailMovie(title).setVisible(true);
        this.dispose();
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
        new DetailMovie(lt_title2.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_poster2MouseClicked

    private void poster2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_poster2MouseEntered

    private void poster2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_poster2MouseExited

    private void poster3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster3MouseClicked
        // Latest Poster3
        new DetailMovie(lt_title3.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_poster3MouseClicked

    private void poster3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_poster3MouseEntered

    private void poster3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_poster3MouseExited

    private void poster4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster4MouseClicked
        // Poster 4 Latest
        new DetailMovie(lt_title4.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_poster4MouseClicked

    private void poster4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_poster4MouseEntered

    private void poster4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_poster4MouseExited

    private void poster5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster5MouseClicked
        // Poster Latest 5
        new DetailMovie(lt_title5.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_poster5MouseClicked

    private void poster5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_poster5MouseEntered

    private void poster5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_poster5MouseExited

    private void lt_title2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title2MouseClicked
        // Latest2 Title
        new DetailMovie(lt_title2.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lt_title2MouseClicked

    private void lt_title2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title2MouseEntered

    private void lt_title2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title2MouseExited

    private void lt_title3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title3MouseClicked
        // Latest Title 3
        new DetailMovie(lt_title3.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lt_title3MouseClicked

    private void lt_title3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title3MouseEntered

    private void lt_title3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title3MouseExited

    private void lt_title4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title4MouseClicked
        // Title Latest 4
        new DetailMovie(lt_title4.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lt_title4MouseClicked

    private void lt_title4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title4MouseEntered

    private void lt_title4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lt_title4MouseExited

    private void lt_title5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_title5MouseClicked
        // Latest Title 5
        new DetailMovie(lt_title5.getText()).setVisible(true);
        this.setVisible(false);
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
                new UserDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bookmarkPane;
    private javax.swing.JPanel coomingPane;
    private javax.swing.JPanel genrePane;
    private javax.swing.JLabel hide;
    private javax.swing.JPanel hidePane;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel latestPane;
    private javax.swing.JPanel loginPane;
    private javax.swing.JPanel loginPane1;
    private javax.swing.JLabel lt_title1;
    private javax.swing.JLabel lt_title2;
    private javax.swing.JLabel lt_title3;
    private javax.swing.JLabel lt_title4;
    private javax.swing.JLabel lt_title5;
    private javax.swing.JPanel morePane;
    private javax.swing.JPanel morePane1;
    private javax.swing.JPanel morePane2;
    private javax.swing.JLabel poster1;
    private javax.swing.JLabel poster2;
    private javax.swing.JLabel poster3;
    private javax.swing.JLabel poster4;
    private javax.swing.JLabel poster5;
    private javax.swing.JPanel sidebarIcon;
    private javax.swing.JLabel soon1;
    private javax.swing.JLabel soon2;
    private javax.swing.JLabel soon3;
    private javax.swing.JLabel soon4;
    private javax.swing.JLabel soon5;
    private javax.swing.JLabel soonPoster1;
    private javax.swing.JLabel soonPoster2;
    private javax.swing.JLabel soonPoster3;
    private javax.swing.JLabel soonPoster4;
    private javax.swing.JLabel soonPoster5;
    private javax.swing.JPanel streamPane;
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
