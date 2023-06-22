package hello.core.member;


import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // HashMap 을 사용하면 동시성 이슈가 발생할 수 있음.
    // 그래서 실무에서는 concurrent hashmap을 사용함
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
