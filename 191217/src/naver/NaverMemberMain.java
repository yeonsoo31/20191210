package naver;

import java.util.ArrayList;
import java.util.List;

public class NaverMemberMain {

	public static void main(String[] args) {
		NaverMember member = new NaverMember("yys","aa","aa","aa","aa","aa","aa");
		// id 필드에 저장된 값 getter 메소드 이용하여 출력하기
		System.out.println(member.getId());
		// id 필드값을 bb로 저장
		member.setId("bb");
		System.out.println(member.getId());
		/* NaverMember 클래스에 기본생성자를 선언하여
		 * 기본 생성자를 이용해 member1 객체를 선언한 뒤 모든 필드 값을 본인 옆사람의
		 * 정보로 지정해보세요
		 */
		
//		id pw name birth gender email phone

		NaverMember member1 = new NaverMember();
		NaverMember member2 = new NaverMember();
		
		member1.setId("nan_babo");
		member1.setPw("sksqkqh");
		member1.setName("김현");
		member1.setBirth("970405-2121212");
		member1.setGender("남자");
		member1.setEmail("nan_babo@kimhyun.com");
		member1.setPhone("010-7347-5797");
	
		
		NaverMember[] members = new NaverMember[100];
		members[0] = member;
		members[1] = member1;
		members[2] = member2;
		System.out.println(members[0].getId());
		
		
		
		
		
		List<NaverMember> memberList = new ArrayList<NaverMember>();
		memberList.add(member);
		memberList.add(member1);
		
		for(int i=0; i<memberList.size(); i++) {
			System.out.println(memberList.get(i).getId());
		}
		
		
		
		
//	NaverMember members[] = new NaverMember[2];
//	members[0] = member;
//	members[1] = member1;
//	System.out.println(members[0].getId());
	
	
	
	
	
//	for ( int i=0; i<members.length; i++) {
//		System.out.println(members[i]);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
}
