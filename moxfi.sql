-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2021 at 08:41 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moxfi`
--

-- --------------------------------------------------------

--
-- Table structure for table `director`
--

CREATE TABLE `director` (
  `id_director` int(11) NOT NULL,
  `nama_director` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `director`
--

INSERT INTO `director` (`id_director`, `nama_director`) VALUES
(1, 'Joss Whedon'),
(2, 'Zack Snyder'),
(3, 'John Lasseter'),
(4, 'Joko Anwar'),
(5, 'Bill Condon'),
(6, 'Daniel Espinosa'),
(7, 'Matt Reeves'),
(8, 'Matthew Vaughn'),
(9, 'Colin Trevorrow'),
(10, 'Sam Raimi');

-- --------------------------------------------------------

--
-- Table structure for table `master_genre`
--

CREATE TABLE `master_genre` (
  `id_master_genre` int(11) NOT NULL,
  `genre_movie` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `master_genre`
--

INSERT INTO `master_genre` (`id_master_genre`, `genre_movie`) VALUES
(1, 'Action'),
(2, 'Comedy'),
(3, 'Drama'),
(4, 'Fantasy'),
(5, 'Horror'),
(6, 'Mystery'),
(7, 'Romance'),
(8, 'Thriller'),
(9, 'Western'),
(10, 'Adventure');

-- --------------------------------------------------------

--
-- Table structure for table `master_user`
--

CREATE TABLE `master_user` (
  `id_master_user` int(11) NOT NULL,
  `jenis_user` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `master_user`
--

INSERT INTO `master_user` (`id_master_user`, `jenis_user`) VALUES
(1, 'admin'),
(2, 'pengguna');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id_movie` int(11) NOT NULL,
  `title` varchar(150) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(30) DEFAULT NULL,
  `genre` int(11) NOT NULL,
  `director` int(11) NOT NULL,
  `plot` text NOT NULL,
  `poster` text NOT NULL,
  `rating` varchar(5) DEFAULT NULL,
  `jenis` varchar(150) NOT NULL,
  `status` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`id_movie`, `title`, `date`, `time`, `genre`, `director`, `plot`, `poster`, `rating`, `jenis`, `status`, `id_user`) VALUES
(1, 'Cars 3', '2017-08-16', '1 Jam 49 Menit', 2, 5, 'Reputasi pebalap legendaris Lightning McQueen mulai tersaingi dengan kemunculan pebalap-pebalap muda. Bersama rekannya, Cruz Ramirez, McQueen berusaha mempertahankan gelarnya sebagai raja sirkuit.', 'https://m.media-amazon.com/images/M/MV5BMTc0NzU2OTYyN15BMl5BanBnXkFtZTgwMTkwOTg2MTI@._V1_SX300.jpg', '6.2', 'Movie', 1, 1),
(2, 'Gundala Putra Petir', '2019-08-29', '02:03:00', 1, 4, 'Indonesia\'s preeminent comic book superhero and his alter ego Sancaka enter the cinematic universe to battle the wicked Pengkor and his diabolical squad of orphan assassins.', 'https://m.media-amazon.com/images/M/MV5BYjk5MWVlMWUtZmJlYi00ZGQ0LWJkZDItOGViZjdhOTI4YWE5XkEyXkFqcGdeQXVyNDA1NDA2NTk@._V1_SX300.jpg', '6.7', 'Movie', 1, 1),
(4, 'Justice League', '2017-11-17', '02:00:00', 1, 2, 'Fueled by his restored faith in humanity and inspired by Superman\'s selfless act, Bruce Wayne enlists the help of his new-found ally, Diana Prince, to face an even greater enemy.', 'https://m.media-amazon.com/images/M/MV5BYWVhZjZkYTItOGIwYS00NmRkLWJlYjctMWM0ZjFmMDU4ZjEzXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg', '6.1', 'Movie', 1, 1),
(5, 'The Avengers', '2012-05-04', '02:23:00', 2, 1, 'Earth\'s mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.', 'https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg', '8.0', 'Movie', 1, 1),
(6, 'Cars', '2006-06-09', '01:57:00', 1, 3, 'A hot-shot race-car named Lightning McQueen gets waylaid in Radiator Springs, where he finds the true meaning of friendship and family.', 'https://m.media-amazon.com/images/M/MV5BMTg5NzY0MzA2MV5BMl5BanBnXkFtZTYwNDc3NTc2._V1_SX300.jpg', '7.1', 'Movie', 1, 1),
(7, 'Morbius', '2022-01-28', '2 jam', 6, 6, 'Biochemist Michael Morbius tries to cure himself of a rare blood disease, but when his experiment goes wrong, he inadvertently infects himself with a form of vampirism instead.', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcS2v7i1dkK4-V_kmbgEkr8-sJWLbEbQJ3t_WdHfEHFkHWusZIPb', NULL, 'Movie', 2, 1),
(8, 'The Batman', '2022-03-04', NULL, 1, 7, 'The Riddler plays a dangerous game of cat and mouse with Batman and Commissioner Gordon in Gotham City.', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRTT0pPu6d_lj_oSW5UzqJN3VNOKgWzpmpOE28LQjZsNTZXTBs6', NULL, 'Movie', 2, 1),
(9, 'Kingsman 2021', '2021-12-22', '2h 11m', 1, 8, 'One man must race against time to stop history\'s worst tyrants and criminal masterminds as they get together to plot a war that could wipe out millions of people and destroy humanity.', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRWAr1xSH9l5t1bTRmvBxMY8w9zi7Bg8BsiVIwYOSHd1CHhUXr0', NULL, 'Movie', 2, 1),
(10, 'Jurassic World: Dominion', '2022-06-10', NULL, 3, 9, 'Third instalment of the Jurassic World franchise. Worldwide release date: june 2022.', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShoIqwHIYdKDvPHXLAlLryrr1y7XkZu4XKlsyjt3ra103tv-lHWxXM9_hPucomU7cJ5II&usqp=CAU', NULL, 'Movie', 2, 1),
(11, 'Doctor Strange in the Multiverse of Madness', '2022-05-06', NULL, 1, 10, 'Sequel to the 2016 Marvel film \'Doctor Strange\'. After the events of Avengers: Endgame, Dr. Stephen Strange continues his research on the Time Stone. But an old friend turned enemy seeks to destroy every sorcerer on Earth, messing with Strange\'s plan and also causing him to unleash an unspeakable evil.', 'https://awsimages.detik.net.id/community/media/visual/2020/02/02/8bc7fa20-8ba5-4c1c-b079-f3dae96588c2.jpeg?w=700&q=90', NULL, 'Movie', 2, 1),
(12, 'Interstellar', '2014-10-06', '2h 49m', 10, 3, 'Sebuah tim penjelajah antar galaksi harus melewati lubang cacing dan terjebak di dimensi waktu ruang angkasa dalam upaya untuk menjamin kelangsungan hidup umat manusia di planet bumi.', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRZ6zThgOVkj9RFuoFIKyyyZl4E1zpxJrl-UjqRrOEV0DoRcDKY', '8.6', 'Movie', 1, 1),
(13, 'Avengers: Endgame', '2019-04-24', '3 jam 1 menit', 1, 10, 'Melanjutkan Avengers Infinity War, dimana kejadian setelah Thanos berhasil mendapatkan semua infinity stones dan memusnahkan 50% semua mahluk hidup di alam semesta. Akankah para Avengers berhasil mengalahkan Thanos?', 'https://lumiere-a.akamaihd.net/v1/images/p_avengersendgame_19751_e14a0104.jpeg?region=0%2C0%2C540%2C810', '8.4', 'Movie', 1, 1),
(14, 'Venom: Let There Be Carnage', '2021-10-17', '1 Jam 37 Menit', 1, 2, 'Venom kembali beraksi ketika seorang pembunuh berantai, Cletus Kasady bertransformasi menjadi sosok jahat Carnage.', 'http://assets.kompasiana.com/items/album/2021/11/17/mv5bntfinzblymetmtcxzs00zteylwjmymqtmjyzyjaxngqwodazxkeyxkfqcgdeqxvymteymjm2ndc2-v1-6194ab66c26b771c3b7468c2.jpg?t=o&v=770', '6.0', 'Movie', 1, 1),
(15, 'Venom', '2018-10-03', '2 Jam 20 Menit', 1, 7, 'Seorang jurnalis, Eddie Brock (Tom Hardy) ingin melakukan sebuah investasi kasus terhadap penemuan yang dipimpin oleh Dr. Carlton Drake (Riz Ahmed). Karena investigasinya, Eddie mengunjungi lab milik Dr. Calrlton Drake. Semuanya ditujukan untuk membuktikan bahwa Dr. Carlton Drake sedang sedang melakukan tindakan jahat menggunakan Symbiote.', 'https://m.media-amazon.com/images/M/MV5BNzAwNzUzNjY4MV5BMl5BanBnXkFtZTgwMTQ5MzM0NjM@._V1_UY1200_CR90,0,630,1200_AL_.jpg', '6.7', 'Movie', 1, 1),
(16, 'Avengers: Infinity War', '2018-04-25', '2 Jam 29 Menit', 4, 5, 'The Avengers dan sekutu mereka harus bersedia mengorbankan segalanya dalam upaya untuk mengalahkan Thanos yang kuat sebelum ia berhasil menghancurkan alam semesta.', 'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_.jpg', '8.4', 'Movie', 1, 1),
(17, 'Black Panther', '2018-02-12', '2 Jam 15 Menit', 1, 7, 'Sebagai Raja baru dari Wakanda, T’Challa (Chadwick Boseman) masih bergumul mengenai perasaannya atas meninggalnya sang ayah, T’Chaka (John Kani). Namun ia kemudian memutuskan untuk meneruskan perjuangan sang ayah. Ketika Wakanda berada dalam ancaman dua musuh berbahaya yang dapat mengancam keselamatan negara, Black Panther berusaha membuktikan diri sebagai raja sejati Wakanda. Ia harus menggunakan kostum barunya serta kekuatannya untuk membela Wakanda dan negara lainnya', 'https://img-z.okeinfo.net/okz/500/library/images/2020/08/29/kkw0jmqk99ly4y74fdt3_13782.jpg', '7.3', 'Movie', 1, 1),
(19, 'Spider-Man 3', '2007-05-02', '2 Jam 19 Menit', 1, 10, 'Sebuah cairan hitam aneh dari dunia lain melekat ke tubuh Peter Parker dan menyebabkan kekacauan batinnya. Pada saat bersamaan, muncul sosok penjahat baru yang mengancam warga New York - Sandman.', 'https://upload.wikimedia.org/wikipedia/id/7/7a/Spider-Man_3%2C_International_Poster.jpg', '6.2', 'Movie', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `movie_status`
--

CREATE TABLE `movie_status` (
  `id_movie_status` int(11) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie_status`
--

INSERT INTO `movie_status` (`id_movie_status`, `status`) VALUES
(1, 'Aired'),
(2, 'Coming Soon');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id_schedule` int(11) NOT NULL,
  `id_trailer` int(11) NOT NULL,
  `id_movie` int(11) NOT NULL,
  `date_trailer` date NOT NULL,
  `date_movie` date NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `trailer`
--

CREATE TABLE `trailer` (
  `id_trailer` int(11) NOT NULL,
  `upload_trailer` varchar(225) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trailer`
--

INSERT INTO `trailer` (`id_trailer`, `upload_trailer`, `date`) VALUES
(1, 'Marvel The Avengers', '2011-10-11'),
(2, 'Pengabdi Setan', '2017-07-21'),
(3, 'Gundala Putra Petir', '2019-07-27'),
(4, 'Cars 3', '2017-04-26'),
(5, 'Justice League', '2021-02-04');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `id_master_user` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `id_master_user`, `nama`, `email`, `username`, `password`) VALUES
(1, 1, 'Rangga Raditya', 'rangga@gmail.com', 'serangga', '123'),
(3, 2, 'John Doe', 'john.doe@gmail.com', 'jdoe', 'jd123'),
(4, 2, 'Misaki', 'misaki@gmail.com', 'saki', 'saki123'),
(5, 1, 'Bobby', 'bobby@gmail.com', 'ybob', 'bob123'),
(6, 1, 'rangrang', 'rang@gmail.com', 'rang123', '123'),
(7, 2, 'userbiasa', 'user@gmail.com', 'user2', '123');

-- --------------------------------------------------------

--
-- Table structure for table `user_bookmark`
--

CREATE TABLE `user_bookmark` (
  `id_bookmark` int(11) NOT NULL,
  `id_movie` int(11) NOT NULL,
  `user_username` varchar(100) NOT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_bookmark`
--

INSERT INTO `user_bookmark` (`id_bookmark`, `id_movie`, `user_username`, `status`) VALUES
(1, 13, 'jdoe', 'None'),
(2, 16, 'jdoe', 'None'),
(4, 14, 'jdoe', 'Bookmarked'),
(6, 2, 'jdoe', 'Bookmarked'),
(7, 12, 'jdoe', 'Bookmarked'),
(8, 15, 'jdoe', 'Bookmarked'),
(9, 17, 'jdoe', 'Bookmarked'),
(10, 7, 'jdoe', 'None'),
(11, 10, 'jdoe', 'None');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`id_director`);

--
-- Indexes for table `master_genre`
--
ALTER TABLE `master_genre`
  ADD PRIMARY KEY (`id_master_genre`);

--
-- Indexes for table `master_user`
--
ALTER TABLE `master_user`
  ADD PRIMARY KEY (`id_master_user`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id_movie`);

--
-- Indexes for table `movie_status`
--
ALTER TABLE `movie_status`
  ADD PRIMARY KEY (`id_movie_status`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id_schedule`);

--
-- Indexes for table `trailer`
--
ALTER TABLE `trailer`
  ADD PRIMARY KEY (`id_trailer`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `user_bookmark`
--
ALTER TABLE `user_bookmark`
  ADD PRIMARY KEY (`id_bookmark`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `director`
--
ALTER TABLE `director`
  MODIFY `id_director` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `master_genre`
--
ALTER TABLE `master_genre`
  MODIFY `id_master_genre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `master_user`
--
ALTER TABLE `master_user`
  MODIFY `id_master_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `id_movie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `movie_status`
--
ALTER TABLE `movie_status`
  MODIFY `id_movie_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id_schedule` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `trailer`
--
ALTER TABLE `trailer`
  MODIFY `id_trailer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user_bookmark`
--
ALTER TABLE `user_bookmark`
  MODIFY `id_bookmark` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
