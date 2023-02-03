package bus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bus bus = new Bus(1);
        System.out.println("------승객탑승------");
        bus.setPassenger(sc.nextInt());
        System.out.println("------주유량------");
        bus.setOil(sc.nextInt());       //  - 기준으로 입력
        System.out.println("------상태변경 차고지행------");
        bus.setstart(sc.nextLine());
    }

}

class Transport {
    private int carNum;
    private int Oil=100;
    private int speed=0;
    private String  start;
    private int People_num;

    Transport(int n) {
        setCarNum(n);
    }

    void setPassenger(int people) {
        People_num += people;
    }

    public int getOil() {
        return Oil;
    }
    public String getstart() {
        return start;
    }
    public int getPeople_num() {
        return People_num;
    }
    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }
    public void setOil(int Oil) {
        this.Oil += Oil;
    }
    public void getspeed(int speed) {
        this.speed += speed;
        System.out.println("현재 속도는 "+this.speed+"입니다.");
    }
    public void setstart(String start) {
        this.start = start;
    }
    public void setPeople_num(int People_num) {
        this.People_num = People_num;
    }
}
class Bus extends Transport {
    private final int busPrice = 1000;

    Bus(int n) {
        super(n);
        super.setstart("운행");
        System.out.println(n + "번 버스객체 만들어짐!");
    }

    @Override
    void setPassenger(int people) {
        if (people + getPeople_num() > 30) {
            System.out.println("최대 승객 수를 초과했습니다.");
        } else if (!getstart().equals("운행")) {
            System.out.println("운행중이 아닙니다.");
        } else {
            super.setPassenger(people);
            System.out.println("탑승 승객 수 = " + people);
            System.out.println("잔여 승객 수 = " + (30 - getPeople_num()));
            System.out.println("요금 확인 = " + (busPrice * people));
        }
    }

    @Override
    public void setOil(int Oil) {
        super.setOil(Oil);
        if (getOil() >= 10) {
            if (getstart().equals("운행")) {
                System.out.println("주유량 = " + super.getOil());
            } else if (getstart().equals("차고지행")) {
                System.out.println("상태 = " + getstart());
                System.out.println("주유량 = " + super.getOil());
            }
        } else {
            System.out.println("주유량 = " + getOil());
            System.out.println("주유가 필요합니다.");
            setstart("차고지행");
            System.out.println("상태 = " + getstart());
        }
    }
}
