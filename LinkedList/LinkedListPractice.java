
public class LinkedListPractice {

	public static void main(String[] args) {
		LinkedList L = new LinkedList();
		System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
		L.insertLastNode("월");
		L.insertLastNode("수");
		L.insertLastNode("일");
		L.printList(); 
		
		System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
		ListNode pre = L.searchNode("수");
		if( pre == null) {
			System.out.println("검색실패>> 찾는 데이터가 없습니다.");
			
		} else {
			L.insertMiddleNode(pre, "금");
			L.printList();
		}
		
		System.out.println("(3) 리스트의 노드를 역순으로 바꾸기");
		L.reverseList();
		L.printList();
		
		System.out.println("(4) 리스트의 마지막 노드 삭제하기");
		L.deleteLastNode();
		L.printList();
	}

}

/*
 *  연결 리스트를 정의하는 클래스 
 */
class LinkedList {	
	// 연결 리스트의 첫번째 노드를 가르키는 head 참조 변수  
	private ListNode head; 
	
	/*
	 * 연결 리스트의 head 참조 변수를 null로 초기화 하는 생성자 
	 */
	public LinkedList() { 
		head = null;
		
	}
	
	/*
	 *	연결 리스트의 중간에 노드를 삽입하는 메서드 
	 */
	public void insertMiddleNode(ListNode pre, String data) {
		// 매개변수 data를 데이터 필드 값으로 가지는 새로운 노드를 생성 
		ListNode newNode = new ListNode(data); 
		
		// 새로운 노드의 이전 위치에 있는 노드의 다음 노드를 새로운 노드의 다음 노드로 지정 
		newNode.link = pre.link;
		
		// 이전 노드의 다음 노드로 새로운 노드를 지정 
		pre.link = newNode; 
		
	}
	
	/*
	 *	연결 리스트의 마지막에 노드를 삽입하는 메서드 
	 */
	public void insertLastNode(String data) {
		// 매개변수 data를 데이터 필드 값으로 가지는 새로운 노드를 생성
		ListNode newNode = new ListNode(data);  
		
		// 리스트 head가 공백 리스트라면 
		if(head == null) { 
			
			// 새로운 노드를 리스트의 head로 저장 
			this.head = newNode; 
			
		}
		// 리스트 head가 공백 리스트가 아니라면
		else { 
			// 임시 변수 temp를 생성하고 head의 메모리 참조값을 저장 
			ListNode temp = head; 
			
			// temp의 다음 노드가 존재하면 계속해서 이동 
			while(temp.link != null) temp = temp.link; 
			
			// temp의 다음 노드가 없을 경우, 새로 생성한 노드를 temp의 다음 노드로 지정
			temp.link = newNode; 
			
		}
		
	}
	
	/*
	 * 마지막 노드를 삭제하는 메서드 
	 */
	public void deleteLastNode() {
		// 이전 노드와 임시 노드를 선언 
		ListNode pre, temp;
		
		// 공백 리스트라면 메서드 종료 
		if(head == null) return;
		
		// 첫 노드가 없으면 공백 리스트로 지정 
		if(head.link == null) {
			head = null;
			
			// 공백 리스트가 아니면 
		} else {
			// 이전 노드를 선언 
			pre = head; 
			// 이전 노드의 다음 노드 선언 
			temp = head.link; 
			
			// 다음 노드가 존재하면 
			while(temp.link != null) { 
				// 이전 노드와 
				pre = temp; 
				
				// 삭제할 노드를 계속 이동 
				temp = temp.link; 
			}
			
			// 다음 노드가 존재하지 않으면 이전 노드가 가르키는 노드가 없도록 지정 
			pre.link = null; 
			
		}
	}
	
	/*
	 * 매개 변수와 일치하는 데이터 필드값을 가지는 노드를 탐색하는 메서드 
	 */
	public ListNode searchNode(String data) {
		// head를 임시 노드로 지정 
		ListNode temp = this.head;
		
		// 노드가 존재하지 않을 때 까지 반복 
		while(temp != null) {
			
			// 노드의 데이터 필드값과 매개 변수 data의 값이 일치하면 노드 반환 
			if(data == temp.getData()) {
				return temp;
				
				// 노드의 데이터 필드값과 매개 변수 data의 값이 일치하지 않으면 
			} else {
				// 노드를 계속 이동 
				temp = temp.link; 
				
			}
		}
		// 노드가 존재하지 않으면 null 반환 
		return temp;
	}
	
	/*
	 *  리스트를 역순으로 만드는 메서드 
	 */
	public void reverseList() {
		// 다음 노드를 head로 지정 
		ListNode next = head;
		
		// 현재 노드와 이전 노드를 null로 지정 
		ListNode current = null;
		ListNode pre = null;
		
		// TODO
		// 다음 노드가 null이 아니면 반복 
		while(next != null) {
			
			// 이전 노드를 현재 노드로 지정 
			pre = current;
			
			// 현재 노드를 다음 노드로 지정 
			current = next;
			
			// 다음 노드는 그 다음 노드로 이동 
			next = next.link;
			
			// 현재 노드가 
			current.link = pre;
		}
		
		head = current;
	}
	
	/*
	 *  리스트를 출력하는 메서드 
	 */
	public void printList() {
		ListNode temp = this.head;
		System.out.printf("L = (");
		
		// 노드가 존재하면 
		while(temp != null) {
			
			// 노드의 데이터 출력 
			System.out.printf(temp.getData());
			
			// 노드 이동 
			temp = temp.link;
			
			// 노드가 존재하면 , 출력  
			if(temp != null) {
				System.out.printf(", ");
				
			}
		}
		// 노드가 없으면 ) 출력 
		System.out.println(")");
	}
}

/*
 * Node를 정의하는 클래스 
 */
class ListNode {
	private String data; // 노드의 데이터 필드 변수 
	public ListNode link; // 노드의 링크 필드 변수 
	
	/*
	 * 노드의 데이터 필드와 링크 필드를 null로 초기화하는 생성자 
	 */
	public ListNode() { 
		this.data = null;
		this.link = null;
		}
	
	/*
	 * 노드의 데이터 필드에 매개변수 data값을  저장하고, 링크 필드는 null로 초기화 하는 생성자
	 */
	public ListNode(String data) {  
		this.data = data;
		this.link = null;
	}
	
	/*
	 * 노드의 데이터 필드에 매개변수 data값을 저장하고, 링크필드에 link의 메모리 참조값을 저장하는 생성자 
	 */
	public ListNode(String data, ListNode link) {
		this.data = data;
		this.link = link;
	}
	
	/*
	 * 노드의 데이터 필드값을 String형태로 반환하는 메서드 
	 */
	public String getData() {
		return this.data;
	}
 }
