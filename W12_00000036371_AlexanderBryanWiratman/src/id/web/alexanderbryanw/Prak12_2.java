package id.web.alexanderbryanw;

import java.util.Scanner;

import id.web.alexanderbryanw.Prak12_1.Node;

public class Prak12_2 {
	static Mahasiswa headMahasiswa;

	static class Mahasiswa {
		String nim;
		String nama;
		float ipk;
		Mahasiswa nextMahasiswa;

		public Mahasiswa(String nim, String nama, float ipk) {
			this.nim = nim;
			this.nama = nama;
			this.ipk = ipk;
		}
	}

	public void insertMahasiswa(String nim, String nama, float ipk) {
		Mahasiswa newMahasiswa = new Mahasiswa(nim, nama, ipk);

		if (headMahasiswa == null) {
			headMahasiswa = newMahasiswa;
		} else {
			Mahasiswa temp = headMahasiswa;
			while (temp.nextMahasiswa != null) {
				temp = temp.nextMahasiswa;
			}
			temp.nextMahasiswa = newMahasiswa;
		}
	}

	public int searchMahasiswa(Mahasiswa headMahasiswa, String key) {
		Mahasiswa current = headMahasiswa; // Initialize current
		while (current != null) {
			if (current.nim.equalsIgnoreCase(key)) {
				System.out.println("Terdapat mahasiswa dengan NIM " + current.nim + " dengan nama " + current.nama);
				return 1; // data found
			}
			current = current.nextMahasiswa;
		}
		return -1; // data not found
	}

	void deleteMahasiswa(String key) {
		Mahasiswa temp = headMahasiswa, prev = null;
		if (temp != null && temp.nim.equalsIgnoreCase(key)) {
			headMahasiswa = temp.nextMahasiswa;
			return;
		}
		while (temp != null && !temp.nim.equalsIgnoreCase(key)) {
			prev = temp;
			temp = temp.nextMahasiswa;
			if (temp == null)
				return;
			prev.nextMahasiswa = temp.nextMahasiswa;
		}
	}

	void orderMahasiswa() {

		if (headMahasiswa!= null) {
			boolean telahdiubah;

			do {
				Mahasiswa temp = headMahasiswa, prev = null;
				Mahasiswa nextTo = temp.nextMahasiswa;
				telahdiubah = false;

				while (nextTo != null) {
					if (temp.nama.compareToIgnoreCase(nextTo.nama) > 0) {
						telahdiubah = true;

						if (prev != null) {
							Mahasiswa sig = nextTo.nextMahasiswa;
							prev.nextMahasiswa = nextTo;
							nextTo.nextMahasiswa = temp;
							temp.nextMahasiswa = sig;
						} else {
							Mahasiswa sig = nextTo.nextMahasiswa;
							headMahasiswa = nextTo;
							nextTo.nextMahasiswa = temp;
							temp.nextMahasiswa = sig;
						}

						prev = nextTo;
						nextTo = temp.nextMahasiswa;
					} else {
						prev = temp;
						temp = nextTo;
						nextTo = nextTo.nextMahasiswa;
					}
				}
			} while (telahdiubah);
		}
	}

	static void printList() {
		Mahasiswa mahasiswa = headMahasiswa;
		System.out.println("----- Data Mahasiswa -----");
		System.out.println("NIM          	     Nama Mahasiswa		IPK");
		while (mahasiswa != null) {
			System.out.printf("%-20s %-25s %-3.2f\n", mahasiswa.nim, mahasiswa.nama, mahasiswa.ipk);
			mahasiswa = mahasiswa.nextMahasiswa;
		}
	}

	public static void main(String[] args) {
		headMahasiswa = new Mahasiswa("00000036371", "Bryan", 4);
		printList();
		System.out.println();
		Prak12_2 llist = new Prak12_2();
		System.out.println("PROGRAM MAHASISWA");
		Scanner scan = new Scanner(System.in);
		boolean ulang;
		while (ulang = true) {
			System.out.println("Pilih menu : ");
			System.out.println("1. Tambah Mahasiswa");
			System.out.println("2. Cari Mahasiswa");
			System.out.println("3. Delete Mahasiswa");
			System.out.println("4. Order Mahasiswa");
			System.out.println("5. Keluar");
			System.out.println("----------------------------");
			System.out.print("Pilihan : ");
			int pilihan = scan.nextInt();
			if (pilihan == 1) {
				System.out.println("Tambah Mahasiswa ----------");
				System.out.print("NIM : ");
				String nim = scan.next();
				System.out.print("Nama : ");
				String nama = scan.next();
				System.out.print("IPK : ");
				float ipk = scan.nextFloat();
				llist.insertMahasiswa(nim, nama, ipk);
				printList();
			} else if (pilihan == 2) {
				System.out.println("Search Mahasiswa ----------");
				System.out.print("NIM : ");
				String key = scan.next();
				int hasilCari = llist.searchMahasiswa(headMahasiswa, key);
				if (hasilCari > 0) {
					System.out.println("Data mahasiswa ditemukan");
				} else if (hasilCari < 0) {
					System.out.println("Data mahasiswa tidak ditemukan");
				}
			} else if (pilihan == 3) {
				System.out.println("Delete Mahasiswa ----------");
				System.out.print("NIM : ");
				String key = scan.next();
				llist.deleteMahasiswa(key);
				printList();
			} else if (pilihan == 4) {
				llist.orderMahasiswa();
				printList();
			} else if (pilihan == 5) {
				ulang = false;
				break;
			}
		}
		System.out.println("Terima kasih telah menggunakan program Alexander Bryan");

	}

}
