package zip.hyeon.lgtm.application.member.required;

import java.util.Optional;
import org.springframework.data.repository.Repository;
import zip.hyeon.lgtm.domain.member.Member;

public interface MemberRepository extends Repository<Member, Long> {

    Member save(Member member);

    Optional<Member> findById(Long memberId);
}
