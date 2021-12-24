/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mox_form;
import db.database;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
/**
 *
 * @author fatkh
 */
public class SortGenreMovie extends javax.swing.JFrame {

    /**
     * Creates new form soon_movies
     */
    boolean a;
    public SortGenreMovie(String username, String genre) {
        initComponents();
        setTitle("Search Movie");
        setExtendedState(MAXIMIZED_BOTH);
        tf_username.setText(username);
        //cbb_genre.setSelectedItem(genre.toString());
        SearchText.setText("You Searched '"+genre+"' Movie");
        if("All Genre".equals(genre)) {
            load_all_genre();
        } else {
            load_data(genre);
        }
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
    
    public void load_all_genre() {
        try {
            String sql = "SELECT movie.title, movie.poster "
                       + "FROM movie "
                       + "ORDER BY movie.genre ASC ";
            //System.out.println(sql);
            Connection conn = (Connection) database.getConn();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            ArrayList<String> posters = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            
            while(res.next()) {
                posters.add(res.getString("poster"));
                titles.add(res.getString("title"));
            }
            
            // Poster Searched Movies
            
            String[] posterArr = new String[posters.size()];
            posterArr = posters.toArray(posterArr);
            JLabel[] posterX = {poster1, poster2, poster3, poster4, poster5, poster6, poster7, poster8, poster9, poster10};
            
            if(posterArr.length < 10) {
                for(int i = 0; i < posterArr.length; i++) {
                    posterX[i].setIcon(getPoster(posterArr[i]));
                }
            } else {
                for(int i = 0; i < 10; i++) {
                    posterX[i].setIcon(getPoster(posterArr[i]));
                }
            }
            
            // Title Searched Movie
            
            String[] titleArr = new String[titles.size()];
            titleArr = titles.toArray(titleArr);
            JLabel[] titleX = {title1, title2, title3, title4, title5, title6, title7, title8, title9, title10};
            
            if(titleArr.length < 10) {
                for(int i = 0; i < titleArr.length; i++) {
                    titleX[i].setText(titleArr[i]);
                }
            } else {
                for(int i = 0; i < 10; i++) {
                    titleX[i].setText(titleArr[i]);
                }
            }
            
        } catch (SQLException e) {
        }
    }
    
    public void load_data(String genre) {
        try {
            String sql = "SELECT movie.title, movie.poster "
                       + "FROM movie "
                       + "INNER JOIN master_genre "
                       + "ON movie.genre = master_genre.id_master_genre "
                       + "WHERE master_genre.genre_movie = '"+genre+"' ";
            //System.out.println(sql);
            Connection conn = (Connection) database.getConn();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            ArrayList<String> posters = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            
            while(res.next()) {
                posters.add(res.getString("poster"));
                titles.add(res.getString("title"));
            }
            
            // Poster Searched Movies
            
            String[] posterArr = new String[posters.size()];
            posterArr = posters.toArray(posterArr);
            JLabel[] posterX = {poster1, poster2, poster3, poster4, poster5, poster6, poster7, poster8, poster9, poster10};
            
            if(posterArr.length < 10) {
                for(int i = 0; i < posterArr.length; i++) {
                    posterX[i].setIcon(getPoster(posterArr[i]));
                }
            } else {
                for(int i = 0; i < 10; i++) {
                    posterX[i].setIcon(getPoster(posterArr[i]));
                }
            }
            
            // Title Searched Movie
            
            String[] titleArr = new String[titles.size()];
            titleArr = titles.toArray(titleArr);
            JLabel[] titleX = {title1, title2, title3, title4, title5, title6, title7, title8, title9, title10};
            
            if(titleArr.length < 10) {
                for(int i = 0; i < titleArr.length; i++) {
                    titleX[i].setText(titleArr[i]);
                }
            } else {
                for(int i = 0; i < 10; i++) {
                    titleX[i].setText(titleArr[i]);
                }
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
        jLabel2 = new javax.swing.JLabel();
        hidePane = new javax.swing.JPanel();
        hide = new javax.swing.JLabel();
        coomingPane = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        latestPane = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        genrePane = new javax.swing.JPanel();
        cbb_genre = new javax.swing.JComboBox<>();
        SearchForm = new javax.swing.JTextField();
        DasborScroll = new javax.swing.JScrollPane();
        DasborPane = new javax.swing.JPanel();
        SearchText = new javax.swing.JLabel();
        PosterPane1 = new javax.swing.JPanel();
        poster1 = new javax.swing.JLabel();
        PosterPane2 = new javax.swing.JPanel();
        poster2 = new javax.swing.JLabel();
        PosterPane3 = new javax.swing.JPanel();
        poster3 = new javax.swing.JLabel();
        PosterPane4 = new javax.swing.JPanel();
        poster4 = new javax.swing.JLabel();
        PosterPane5 = new javax.swing.JPanel();
        poster5 = new javax.swing.JLabel();
        PosterPane6 = new javax.swing.JPanel();
        poster6 = new javax.swing.JLabel();
        PosterPane7 = new javax.swing.JPanel();
        poster7 = new javax.swing.JLabel();
        PosterPane8 = new javax.swing.JPanel();
        poster8 = new javax.swing.JLabel();
        PosterPane9 = new javax.swing.JPanel();
        poster9 = new javax.swing.JLabel();
        PosterPane10 = new javax.swing.JPanel();
        poster10 = new javax.swing.JLabel();
        title10 = new javax.swing.JLabel();
        title9 = new javax.swing.JLabel();
        title8 = new javax.swing.JLabel();
        title7 = new javax.swing.JLabel();
        title6 = new javax.swing.JLabel();
        title5 = new javax.swing.JLabel();
        title4 = new javax.swing.JLabel();
        title3 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        tf_username = new javax.swing.JLabel();
        LoginAs = new javax.swing.JLabel();
        sidebarIcon = new javax.swing.JPanel();
        HomePane = new javax.swing.JPanel();
        HomeIcon = new javax.swing.JLabel();
        BmarkPane = new javax.swing.JPanel();
        BmarkIcon = new javax.swing.JLabel();
        StreamPane = new javax.swing.JPanel();
        StreamIcon = new javax.swing.JLabel();
        LogoutPane = new javax.swing.JPanel();
        LogoutIcon = new javax.swing.JLabel();
        hHomePane = new javax.swing.JPanel();
        hHomeText = new javax.swing.JLabel();
        hBmarkPane = new javax.swing.JPanel();
        hBmarkText = new javax.swing.JLabel();
        hStreamPane = new javax.swing.JPanel();
        hStreamText = new javax.swing.JLabel();
        hLogoutPane = new javax.swing.JPanel();
        hLogoutText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Navbar.setBackground(new java.awt.Color(81, 196, 211));
        Navbar.setPreferredSize(new java.awt.Dimension(1366, 60));

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

        cbb_genre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbb_genre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Genre", "Action", "Comedy", "Mystery", "Fantasy", "Drama", "Adventure" }));
        cbb_genre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_genreItemStateChanged(evt);
            }
        });
        cbb_genre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbb_genreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbb_genreMouseExited(evt);
            }
        });

        javax.swing.GroupLayout genrePaneLayout = new javax.swing.GroupLayout(genrePane);
        genrePane.setLayout(genrePaneLayout);
        genrePaneLayout.setHorizontalGroup(
            genrePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genrePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbb_genre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        genrePaneLayout.setVerticalGroup(
            genrePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genrePaneLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(cbb_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SearchForm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchForm.setText("Search here");
        SearchForm.setPreferredSize(new java.awt.Dimension(69, 30));
        SearchForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchFormMouseClicked(evt);
            }
        });
        SearchForm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchFormKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout NavbarLayout = new javax.swing.GroupLayout(Navbar);
        Navbar.setLayout(NavbarLayout);
        NavbarLayout.setHorizontalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addComponent(hidePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(SearchForm, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(genrePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(latestPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(coomingPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        NavbarLayout.setVerticalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hidePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(coomingPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(latestPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addComponent(genrePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavbarLayout.createSequentialGroup()
                .addGroup(NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(NavbarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SearchForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(Navbar, java.awt.BorderLayout.PAGE_START);

        DasborPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SearchText.setForeground(new java.awt.Color(102, 102, 102));
        SearchText.setText("You Searched \"\"");
        DasborPane.add(SearchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        PosterPane1.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane1.setPreferredSize(new java.awt.Dimension(200, 283));

        poster1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PosterPane1Layout = new javax.swing.GroupLayout(PosterPane1);
        PosterPane1.setLayout(PosterPane1Layout);
        PosterPane1Layout.setHorizontalGroup(
            PosterPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane1Layout.setVerticalGroup(
            PosterPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        PosterPane2.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane2.setPreferredSize(new java.awt.Dimension(200, 283));

        poster2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PosterPane2Layout = new javax.swing.GroupLayout(PosterPane2);
        PosterPane2.setLayout(PosterPane2Layout);
        PosterPane2Layout.setHorizontalGroup(
            PosterPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane2Layout.setVerticalGroup(
            PosterPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        PosterPane3.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane3.setPreferredSize(new java.awt.Dimension(200, 283));

        poster3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PosterPane3Layout = new javax.swing.GroupLayout(PosterPane3);
        PosterPane3.setLayout(PosterPane3Layout);
        PosterPane3Layout.setHorizontalGroup(
            PosterPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane3Layout.setVerticalGroup(
            PosterPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));

        PosterPane4.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane4.setPreferredSize(new java.awt.Dimension(200, 283));

        poster4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PosterPane4Layout = new javax.swing.GroupLayout(PosterPane4);
        PosterPane4.setLayout(PosterPane4Layout);
        PosterPane4Layout.setHorizontalGroup(
            PosterPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane4Layout.setVerticalGroup(
            PosterPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster4, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, -1, -1));

        PosterPane5.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane5.setPreferredSize(new java.awt.Dimension(200, 283));

        poster5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poster5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PosterPane5Layout = new javax.swing.GroupLayout(PosterPane5);
        PosterPane5.setLayout(PosterPane5Layout);
        PosterPane5Layout.setHorizontalGroup(
            PosterPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane5Layout.setVerticalGroup(
            PosterPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster5, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, -1, -1));

        PosterPane6.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane6.setPreferredSize(new java.awt.Dimension(200, 283));

        javax.swing.GroupLayout PosterPane6Layout = new javax.swing.GroupLayout(PosterPane6);
        PosterPane6.setLayout(PosterPane6Layout);
        PosterPane6Layout.setHorizontalGroup(
            PosterPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane6Layout.setVerticalGroup(
            PosterPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster6, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        PosterPane7.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane7.setPreferredSize(new java.awt.Dimension(200, 283));

        javax.swing.GroupLayout PosterPane7Layout = new javax.swing.GroupLayout(PosterPane7);
        PosterPane7.setLayout(PosterPane7Layout);
        PosterPane7Layout.setHorizontalGroup(
            PosterPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane7Layout.setVerticalGroup(
            PosterPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster7, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        PosterPane8.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane8.setPreferredSize(new java.awt.Dimension(200, 283));

        javax.swing.GroupLayout PosterPane8Layout = new javax.swing.GroupLayout(PosterPane8);
        PosterPane8.setLayout(PosterPane8Layout);
        PosterPane8Layout.setHorizontalGroup(
            PosterPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane8Layout.setVerticalGroup(
            PosterPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster8, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, -1, -1));

        PosterPane9.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane9.setPreferredSize(new java.awt.Dimension(200, 283));

        javax.swing.GroupLayout PosterPane9Layout = new javax.swing.GroupLayout(PosterPane9);
        PosterPane9.setLayout(PosterPane9Layout);
        PosterPane9Layout.setHorizontalGroup(
            PosterPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane9Layout.setVerticalGroup(
            PosterPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster9, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, -1, -1));

        PosterPane10.setBackground(new java.awt.Color(204, 204, 204));
        PosterPane10.setPreferredSize(new java.awt.Dimension(200, 283));

        javax.swing.GroupLayout PosterPane10Layout = new javax.swing.GroupLayout(PosterPane10);
        PosterPane10.setLayout(PosterPane10Layout);
        PosterPane10Layout.setHorizontalGroup(
            PosterPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        PosterPane10Layout.setVerticalGroup(
            PosterPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(poster10, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        DasborPane.add(PosterPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 450, -1, -1));
        DasborPane.add(title10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 730, 200, 30));
        DasborPane.add(title9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 730, 200, 30));
        DasborPane.add(title8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 730, 200, 30));
        DasborPane.add(title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 730, 200, 30));
        DasborPane.add(title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 730, 200, 30));

        title5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                title5MouseClicked(evt);
            }
        });
        DasborPane.add(title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 350, 200, 30));

        title4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                title4MouseClicked(evt);
            }
        });
        DasborPane.add(title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 200, 30));

        title3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                title3MouseClicked(evt);
            }
        });
        DasborPane.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 200, 30));

        title2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                title2MouseClicked(evt);
            }
        });
        DasborPane.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 200, 30));

        title1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                title1MouseClicked(evt);
            }
        });
        DasborPane.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 200, 30));

        tf_username.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_username.setText("username");
        DasborPane.add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 90, 30));

        LoginAs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LoginAs.setText("Login As:");
        DasborPane.add(LoginAs, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, 30));

        DasborScroll.setViewportView(DasborPane);

        getContentPane().add(DasborScroll, java.awt.BorderLayout.CENTER);

        sidebarIcon.setBackground(new java.awt.Color(81, 196, 211));
        sidebarIcon.setPreferredSize(new java.awt.Dimension(60, 708));

        HomePane.setBackground(new java.awt.Color(81, 196, 211));

        HomeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/home page (1).png"))); // NOI18N
        HomeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeIconMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout HomePaneLayout = new javax.swing.GroupLayout(HomePane);
        HomePane.setLayout(HomePaneLayout);
        HomePaneLayout.setHorizontalGroup(
            HomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        HomePaneLayout.setVerticalGroup(
            HomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        BmarkPane.setBackground(new java.awt.Color(81, 196, 211));

        BmarkIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BmarkIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/Group 1.png"))); // NOI18N

        javax.swing.GroupLayout BmarkPaneLayout = new javax.swing.GroupLayout(BmarkPane);
        BmarkPane.setLayout(BmarkPaneLayout);
        BmarkPaneLayout.setHorizontalGroup(
            BmarkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BmarkIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        BmarkPaneLayout.setVerticalGroup(
            BmarkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BmarkPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BmarkIcon)
                .addContainerGap())
        );

        StreamPane.setBackground(new java.awt.Color(81, 196, 211));

        StreamIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StreamIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/Group 2.png"))); // NOI18N

        javax.swing.GroupLayout StreamPaneLayout = new javax.swing.GroupLayout(StreamPane);
        StreamPane.setLayout(StreamPaneLayout);
        StreamPaneLayout.setHorizontalGroup(
            StreamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StreamIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        StreamPaneLayout.setVerticalGroup(
            StreamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StreamPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StreamIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        LogoutPane.setBackground(new java.awt.Color(81, 196, 211));

        LogoutIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mox_img/log out.png"))); // NOI18N

        javax.swing.GroupLayout LogoutPaneLayout = new javax.swing.GroupLayout(LogoutPane);
        LogoutPane.setLayout(LogoutPaneLayout);
        LogoutPaneLayout.setHorizontalGroup(
            LogoutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        LogoutPaneLayout.setVerticalGroup(
            LogoutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        hBmarkPane.setBackground(new java.awt.Color(81, 196, 211));

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

        javax.swing.GroupLayout hBmarkPaneLayout = new javax.swing.GroupLayout(hBmarkPane);
        hBmarkPane.setLayout(hBmarkPaneLayout);
        hBmarkPaneLayout.setHorizontalGroup(
            hBmarkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hBmarkPaneLayout.createSequentialGroup()
                .addComponent(hBmarkText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        hBmarkPaneLayout.setVerticalGroup(
            hBmarkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        javax.swing.GroupLayout sidebarIconLayout = new javax.swing.GroupLayout(sidebarIcon);
        sidebarIcon.setLayout(sidebarIconLayout);
        sidebarIconLayout.setHorizontalGroup(
            sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarIconLayout.createSequentialGroup()
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BmarkPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hBmarkPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hHomePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sidebarIconLayout.createSequentialGroup()
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addComponent(StreamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hStreamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addComponent(LogoutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hLogoutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidebarIconLayout.setVerticalGroup(
            sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarIconLayout.createSequentialGroup()
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(hHomePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BmarkPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarIconLayout.createSequentialGroup()
                        .addComponent(hBmarkPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(StreamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(hStreamPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidebarIconLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(hLogoutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1273, Short.MAX_VALUE))
        );

        getContentPane().add(sidebarIcon, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void changeColor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    
     public void hideshow(JPanel menuhideandshow, boolean sidebarOn){
        if (sidebarOn == true){
            menuhideandshow.setPreferredSize(new Dimension(60, menuhideandshow.getHeight()));
        }else {
            menuhideandshow.setPreferredSize(new Dimension(195, menuhideandshow.getHeight()));
        }
    }
    
    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // BUTTON LATEST
        changeColor(latestPane, new Color(81, 196, 211));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // BUTTON LATEST
        changeColor(latestPane, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // BUTTON LATEST ACTION CLICK ANJAY
        new LatestMovies(tf_username.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // BUTTON COMING SOON
        changeColor(coomingPane, new Color(81, 196, 211));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // BUTTON COMING SOON
        changeColor(coomingPane, new Color(216, 227, 231));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // BUTTON COMING SOON ACTION ANJAY
    }//GEN-LAST:event_jLabel6MouseClicked

    private void hideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseExited
        // HIDE SIDEBAR EXIT
        changeColor(hidePane, new Color(81, 196, 211));
    }//GEN-LAST:event_hideMouseExited

    private void hideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseEntered
        // HIDE SIDEBAR ENTER - Salah anjing!
        changeColor(hidePane, new Color(216, 227, 231));
    }//GEN-LAST:event_hideMouseEntered

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

    private void cbb_genreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbb_genreMouseEntered
        // BUTTON COMBO BOX
    }//GEN-LAST:event_cbb_genreMouseEntered

    private void cbb_genreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbb_genreMouseExited
        // BUTTON COMBO BOX
    }//GEN-LAST:event_cbb_genreMouseExited

    private void HomeIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeIconMouseEntered

    }//GEN-LAST:event_HomeIconMouseEntered

    private void hHomeTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hHomeTextMouseClicked
        // TODO add your handling code here:
        new UserDashboard(tf_username.getText()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hHomeTextMouseClicked

    private void hHomeTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hHomeTextMouseEntered
        // BUTTON BOOKMARK NEW
        changeColor(hHomePane, new Color(216, 227, 231));
    }//GEN-LAST:event_hHomeTextMouseEntered

    private void hHomeTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hHomeTextMouseExited
        // BUTTON BOOKMARK NEW
        changeColor(hHomePane, new Color(81, 196, 211));
    }//GEN-LAST:event_hHomeTextMouseExited

    private void hBmarkTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hBmarkTextMouseClicked
        // to bookmark page
        this.dispose();
        new UserBookmark(tf_username.getText()).setVisible(true);
    }//GEN-LAST:event_hBmarkTextMouseClicked

    private void hBmarkTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hBmarkTextMouseEntered
        // TODO add your handling code here:
        changeColor(hBmarkPane, new Color(216, 227, 231));
    }//GEN-LAST:event_hBmarkTextMouseEntered

    private void hBmarkTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hBmarkTextMouseExited
        // TODO add your handling code here:
        changeColor(hBmarkPane, new Color(81, 196, 211));
    }//GEN-LAST:event_hBmarkTextMouseExited

    private void hStreamTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hStreamTextMouseClicked
        // to stream page
        this.dispose();
        new StreamPage(tf_username.getText()).setVisible(true);
    }//GEN-LAST:event_hStreamTextMouseClicked

    private void hStreamTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hStreamTextMouseEntered
        // BUTTON LOGIN NEW
        changeColor(hStreamPane, new Color(216, 227, 231));
    }//GEN-LAST:event_hStreamTextMouseEntered

    private void hStreamTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hStreamTextMouseExited
        // TODO add your handling code here:
        changeColor(hStreamPane, new Color(81, 196, 211));
    }//GEN-LAST:event_hStreamTextMouseExited

    private void hLogoutTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hLogoutTextMouseClicked
        // TODO add your handling code here:
        AppLogin backlogin = new AppLogin();
        backlogin.setVisible(true);
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

    private void SearchFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchFormMouseClicked
        // clear the form
        SearchForm.setText("");
    }//GEN-LAST:event_SearchFormMouseClicked

    private void poster1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster1MouseClicked
        // poster1
        getDetailMovie(title1.getText());
    }//GEN-LAST:event_poster1MouseClicked

    private void title1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_title1MouseClicked
        // title1
        getDetailMovie(title1.getText());
    }//GEN-LAST:event_title1MouseClicked

    private void poster2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster2MouseClicked
        // poster2
        getDetailMovie(title2.getText());
    }//GEN-LAST:event_poster2MouseClicked

    private void title2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_title2MouseClicked
        // title2
        getDetailMovie(title2.getText());
    }//GEN-LAST:event_title2MouseClicked

    private void poster3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster3MouseClicked
        // poster3
        getDetailMovie(title3.getText());
    }//GEN-LAST:event_poster3MouseClicked

    private void title3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_title3MouseClicked
        // title3
        getDetailMovie(title3.getText());
    }//GEN-LAST:event_title3MouseClicked

    private void poster4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster4MouseClicked
        // poster4
        getDetailMovie(title4.getText());
    }//GEN-LAST:event_poster4MouseClicked

    private void title4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_title4MouseClicked
        // title4
        getDetailMovie(title4.getText());
    }//GEN-LAST:event_title4MouseClicked

    private void poster5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poster5MouseClicked
        // poster5
        getDetailMovie(title5.getText());
    }//GEN-LAST:event_poster5MouseClicked

    private void title5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_title5MouseClicked
        // title5
        getDetailMovie(title5.getText());
    }//GEN-LAST:event_title5MouseClicked

    private void SearchFormKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFormKeyPressed
        // search the title
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String query = SearchForm.getText();
            this.dispose();
            new SearchedMovie(tf_username.getText(), query).setVisible(true);
        }
    }//GEN-LAST:event_SearchFormKeyPressed

    private void cbb_genreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_genreItemStateChanged
        // Sort Movie by Genre
        if(evt.getItem() == "Action" && evt.getStateChange() == 1) {
            this.dispose();
            new SortGenreMovie(tf_username.getText(), "Action").setVisible(true);
        } else if(evt.getItem() == "Comedy" && evt.getStateChange() == 1) {
            this.dispose();
            new SortGenreMovie(tf_username.getText(), "Comedy").setVisible(true);
        } else if(evt.getItem() == "Mystery" && evt.getStateChange() == 1) {
            this.dispose();
            new SortGenreMovie(tf_username.getText(), "Mystery").setVisible(true);
        } else if(evt.getItem() == "Fantasy" && evt.getStateChange() == 1) {
            this.dispose();
            new SortGenreMovie(tf_username.getText(), "Fantasy").setVisible(true);
        } else if(evt.getItem() == "Drama" && evt.getStateChange() == 1) {
            this.dispose();
            new SortGenreMovie(tf_username.getText(), "Drama").setVisible(true);
        } else if(evt.getItem() == "Adventure" && evt.getStateChange() == 1) {
            this.dispose();
            new SortGenreMovie(tf_username.getText(), "Adventure").setVisible(true);
        } else if(evt.getItem() == "All Genre" && evt.getStateChange() == 1) {
            this.dispose();
            new SortGenreMovie(tf_username.getText(), "All Genre").setVisible(true);
        }
    }//GEN-LAST:event_cbb_genreItemStateChanged

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
            java.util.logging.Logger.getLogger(SortGenreMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortGenreMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortGenreMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortGenreMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JPanel BmarkPane;
    private javax.swing.JPanel DasborPane;
    private javax.swing.JScrollPane DasborScroll;
    private javax.swing.JLabel HomeIcon;
    private javax.swing.JPanel HomePane;
    private javax.swing.JLabel LoginAs;
    private javax.swing.JLabel LogoutIcon;
    private javax.swing.JPanel LogoutPane;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel PosterPane1;
    private javax.swing.JPanel PosterPane10;
    private javax.swing.JPanel PosterPane2;
    private javax.swing.JPanel PosterPane3;
    private javax.swing.JPanel PosterPane4;
    private javax.swing.JPanel PosterPane5;
    private javax.swing.JPanel PosterPane6;
    private javax.swing.JPanel PosterPane7;
    private javax.swing.JPanel PosterPane8;
    private javax.swing.JPanel PosterPane9;
    private javax.swing.JTextField SearchForm;
    private javax.swing.JLabel SearchText;
    private javax.swing.JLabel StreamIcon;
    private javax.swing.JPanel StreamPane;
    private javax.swing.JComboBox<String> cbb_genre;
    private javax.swing.JPanel coomingPane;
    private javax.swing.JPanel genrePane;
    private javax.swing.JPanel hBmarkPane;
    private javax.swing.JLabel hBmarkText;
    private javax.swing.JPanel hHomePane;
    private javax.swing.JLabel hHomeText;
    private javax.swing.JPanel hLogoutPane;
    private javax.swing.JLabel hLogoutText;
    private javax.swing.JPanel hStreamPane;
    private javax.swing.JLabel hStreamText;
    private javax.swing.JLabel hide;
    private javax.swing.JPanel hidePane;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel latestPane;
    private javax.swing.JLabel poster1;
    private javax.swing.JLabel poster10;
    private javax.swing.JLabel poster2;
    private javax.swing.JLabel poster3;
    private javax.swing.JLabel poster4;
    private javax.swing.JLabel poster5;
    private javax.swing.JLabel poster6;
    private javax.swing.JLabel poster7;
    private javax.swing.JLabel poster8;
    private javax.swing.JLabel poster9;
    private javax.swing.JPanel sidebarIcon;
    private javax.swing.JLabel tf_username;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title10;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel title5;
    private javax.swing.JLabel title6;
    private javax.swing.JLabel title7;
    private javax.swing.JLabel title8;
    private javax.swing.JLabel title9;
    // End of variables declaration//GEN-END:variables
}