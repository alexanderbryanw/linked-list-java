package id.web.alexanderbryanw;

public class Prak12_1 {
	Node head;
	
	static class Node {
		int angka;
		Node next;
		
		Node(int angka){
			this.angka = angka;
		}
	}
	
	public void printNode() {
		Node node = head;
		while (node != null) {
			System.out.print(node.angka + " ");
			node = node.next;
		}
	}
	
	public void insertNode(int newAngka) {
		// ini insert front
		// 1 3 4 5 6 7
		Node newNode = new Node(newAngka);
		
		newNode.next = head;
		
		head= newNode;
	}
	
	void deleteNode(int key) {
		//Cara kerja
		//Head diset menjadi temp, dan sebelum head adalah null/ kosong
		Node temp = head, prev = null;
		//kalau temp berisikan angka dan ternyata angkanya merupakan angka yang ingin di delete, head digeser menjadi node setelah head
		if(temp != null && temp.angka == key) {
			head = temp.next;
			return;
		}
		//kalau temp berisikan angka namun angkanya bukan angka yang dicari
		while(temp != null && temp.angka != key) {
			//temp tadi diset menjadi prev
			prev = temp;
			//temp adalah node setelah temp sebelumnya yang sekarang menjadi prev
			temp = temp.next;
		}
		//return apabila temp kosong
		if(temp == null) return;
		
		prev.next = temp.next;
		
	}
	
	public static void main(String[] args) {
		Prak12_1 llist = new Prak12_1();
		
		//insert 3 data
		llist.insertNode(1);
		llist.insertNode(7);
		llist.insertNode(1);
		
		llist.printNode();
	}
}

// Hasil yang muncul adalah "1 7 3"
// karena ketiga angka tersebut akan masuk ke fungsi insertNode dan menjadi newNode, dengan head yaitu 1 yang diinsert pertama kali

