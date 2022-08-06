package com.day06;

public class FamilyAccount {

    public static void Start(){
        System.out.println("----------------家庭收支记账软件----------------");
        System.out.println();
        System.out.println("                1 收支明细                ");
        System.out.println("                2 登记收入                ");
        System.out.println("                3 登记支出                ");
        System.out.println("                4 退   出                ");
        System.out.println();
        System.out.print("                请选择（1-4）:");

    }

    public static void main(String[] args) {
        int balance = 10000;
        boolean isFlag = true;
        String details = "";
        while(isFlag) {
            Start();
            char menuSelection = Utility.readMenuSelection();
            switch (menuSelection) {
                case '1':
                    //收支明细
                    System.out.println("----------------当前收支明细记录----------------");
                    System.out.println("收支\t账户金额\t\t收支金额\t\t说   明\n");
                    System.out.println(details);
                    System.out.println("---------------------------------------------");
                    break;
                case '2':
                    //登记收入
                    System.out.print("本次收入金额：");
                    int money = Utility.readNumber();
                    balance += money;
                    System.out.print("本次收入说明：");
                    String info = Utility.readString();
                    details += ("收入\t" + balance + "\t\t" + money + "\t\t\t" + info + "\n");
                    break;
                case '3':
                    //登记支出
                    System.out.print("本次支出金额：");
                    int pay = Utility.readNumber();
                    if(balance >= pay) {
                        balance -= pay;
                        System.out.print("本次支出说明：");
                        String payInfo = Utility.readString();
                        details += ("支出\t" + balance + "\t\t" + pay + "\t\t\t" + payInfo + "\n");
                    }else {
                        System.out.println("支出超出账户额度，支出失败");
                    }
                    break;
                case '4':
                    //退出
                    System.out.print("确认是否退出(Y/N)：");
                    char isExit = Utility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }
                    break;


            }
        }
    }
}
