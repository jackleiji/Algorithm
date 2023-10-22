package interview.threadTest;

import java.util.Objects;

public class threadQ3 {
    public static void main(String[] args) {
        Account account = new Account("zhj",10000);
        Person husband = new Person(account,2000);
        Person wife = new Person(account,1500);

        Thread t1 = new Thread(husband);
        Thread t2 = new Thread(wife);

        t1.start();
        t2.start();
    }
}

class Person implements Runnable{
    Account account;
    double money;
    public Person(Account account,double money) {
        this.account = account;
        this.money = money;
    }


    @Override
    public void run() {
        for(int i=0;i<5;i++){
            account.getMoney(money);
            try {
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class Account{
    String accountNumb;
    double rest;

    public Account() {
    }

    public Account(String accountNumb, double rest) {
        this.accountNumb = accountNumb;
        this.rest = rest;
    }

    public String getAccountNumb() {
        return accountNumb;
    }

    public double getRest() {
        return rest;
    }

    public void setAccountNumb(String accountNumb) {
        this.accountNumb = accountNumb;
    }

    public void setRest(double rest) {
        this.rest = rest;
    }

    public synchronized void getMoney(double money){
        if(rest>0){
            if(rest-money>=0){
                rest -= money;
                System.out.println("成功取款"+money+"元");
            }else {
                System.out.println("余额不足,取款失败");
            }
        }else {
            System.out.println("余额不足,取款失败");
        }
        System.out.println("账户余额为："+rest);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.rest, rest) == 0 &&
                Objects.equals(accountNumb, account.accountNumb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumb, rest);
    }
}