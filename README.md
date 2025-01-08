# Test Automation API for reqres.in

Proyek ini adalah test automation API yang dirancang untuk menguji berbagai endpoint dari `reqres.in`. Proyek ini menggunakan Katalon Studio sebagai alat untuk membuat dan menjalankan test case.

## Daftar Isi
- [Fitur yang Diuji](#fitur-yang-diuji)
- [Prasyarat](#prasyarat)
- [Instalasi](#instalasi)
- [Menjalankan Test](#menjalankan-test)
- [Struktur Proyek](#struktur-proyek)
- [Laporan Test](#laporan-test)
- [Kontribusi](#kontribusi)


## Fitur yang Diuji
Proyek ini mencakup test case untuk beberapa skenario berikut:
1. **Login** - Menguji endpoint login yang berhasil.
2. **Login Failed** - Menguji endpoint login yang gagal.
3. **Register** - Menguji endpoint registrasi yang berhasil.
4. **Register Failed** - Menguji endpoint registrasi yang gagal.
5. **Get Single User** - Menguji endpoint untuk mendapatkan data satu pengguna.
6. **Get List User** - Menguji endpoint untuk mendapatkan daftar pengguna.

## Prasyarat
Sebelum memulai, pastikan Anda telah menginstal:
- [Katalon Studio](https://katalon.com/download) (versi terbaru disarankan).
- Java JDK (versi yang kompatibel dengan Katalon Studio).

## Instalasi
1. Clone repositori ini ke lokal mesin Anda:
   ```bash
   git clone https://github.com/username/repo-name.git

1. Buka Katalon Studio.

2. Pilih File > Open Project dan arahkan ke folder proyek yang telah di-clone.

## Menjalankan Test
1. Buka Katalon Studio dan pastikan proyek sudah terbuka.

2. Navigasikan ke Test Cases di panel Test Explorer.

3. Pilih test case yang ingin dijalankan, lalu klik tombol Run.

4. Anda juga dapat menjalankan seluruh test suite dengan memilih Test Suites dan menjalankan suite yang tersedia.

## Struktur Proyek
Berikut adalah struktur dasar proyek:
```
/project-name
│
├── /Test Cases
│   ├── Get List User
│   ├── Get Single User
│   ├── Login Successful
│   ├── Login Unsuccessful
│   ├── Register Successful
│   └── Register Unsuccessful
│
├── /Test Suites
│   ├── AllTest
│
├── /Object Repository
│   ├── Get User
│   ├── Register User
│   ├── Login User
│
│
└── /Reports
    ├── HTML Reports
    └── JUnit Reports
```

## Laporan Test
Setelah menjalankan test, laporan akan otomatis di-generate dan disimpan di folder `/Reports`. Anda dapat melihat laporan dalam format HTML atau JUnit untuk analisis lebih lanjut.

## Kontribusi
Jika Anda ingin berkontribusi pada proyek ini, silakan ikuti langkah-langkah berikut:
1. Fork repositori ini.
2. Buat branch baru (`git checkout -b fitur-baru`).
3. Commit perubahan Anda (`git commit -m 'Menambahkan fitur baru'`).
4. Push ke branch (`git push origin fitur-baru`).
5. Buat Pull Request


### Penjelasan:
- **Fitur yang Diuji**: Menjelaskan skenario test yang diimplementasikan.
- **Prasyarat**: Daftar software yang diperlukan sebelum menjalankan proyek.
- **Instalasi**: Langkah-langkah untuk mengatur proyek di mesin lokal.
- **Menjalankan Test**: Cara menjalankan test case atau test suite.
- **Struktur Proyek**: Gambaran struktur folder proyek.
- **Laporan Test**: Informasi tentang laporan yang dihasilkan setelah test dijalankan.
- **Kontribusi**: Panduan untuk berkontribusi pada proyek.
