package chapter04.item15.class_and_interfaces.item;

import chapter04.item15.class_and_interfaces.member.MemberService;

public class ItemService {

    MemberService memberService;

    boolean onSale;

    protected int saleRate;

    public ItemService(MemberService memberService) {
        if(memberService == null) {
            throw new IllegalArgumentException("MemberService should not be null");
        }
        this.memberService = memberService;
    }

    // memberService를 private으로 유지하고싶다면, getter를 package-private로 제공해주는 방법도 있다
//    MemberService getMemberService() {
//        return memberService;
//    }

}
