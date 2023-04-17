package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        //OrderService orderService = appConfig.orderService();

        MemberService memberService = ac.getBean("memberService",MemberService.class);
        OrderService orderService = ac.getBean("orderService",OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"itemA",50000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
